package com.foreach.barapp.barapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foreach.barapp.barapp.models.Cocktail;
import com.foreach.barapp.barapp.models.CocktailPrice;
import com.foreach.barapp.barapp.models.Ingredient;
import com.foreach.barapp.barapp.models.OrderCocktail;
import com.foreach.barapp.barapp.models.OrderLine;
import com.foreach.barapp.barapp.services.CocktailPriceService;
import com.foreach.barapp.barapp.services.CocktailService;
import com.foreach.barapp.barapp.services.ComposedOfService;
import com.foreach.barapp.barapp.services.IngredientService;
import com.foreach.barapp.barapp.services.OrderCocktailService;
import com.foreach.barapp.barapp.services.OrderLineService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/ordercocktail")
public class OrderCoktailController {
    @Autowired
    private OrderCocktailService orderCocktailService;

    @Autowired
    private OrderLineService orderLineService;

    @Autowired
    private CocktailService cocktailService;

    @Autowired
    private ComposedOfService composedOfService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private CocktailPriceService cocktailPriceService;

    @GetMapping
    public List<OrderCocktail> getOrderCocktail() {
        return orderCocktailService.getAllOrderCocktail();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderCocktailById(@PathVariable Integer id) {
        return orderCocktailService.getOrderCocktailById(id)
            .map(orderCocktail -> {
                List<OrderLine> orderLines = orderLineService.getAllOrderLine().stream()
                    .filter(line -> String.valueOf(orderCocktail.getOrder_id()).equals(line.getOrder_id()))
                    .toList();

                List<Map<String, Object>> enrichedOrderLines = orderLines.stream().map(line -> {
                    Map<String, Object> lineMap = new HashMap<>();
                    lineMap.put("order_line_id", line.getOrder_line_id());
                    lineMap.put("quantity", line.getQuantity());
                    lineMap.put("line_cocktail_status", line.getLine_cocktail_status());
                    lineMap.put("price_size_id", line.getPrice_size_id());
                    lineMap.put("order_id", line.getOrder_id());

                    Integer priceSizeId = null;
                    try { 
                        priceSizeId = Integer.valueOf(line.getPrice_size_id()); 
                    } catch (NumberFormatException e) {}
                    CocktailPrice cocktailPrice = (priceSizeId != null) ? cocktailPriceService.getCocktailPriceById(priceSizeId).orElse(null) : null;

                    Cocktail cocktail = null;
                    final Integer cocktailId;
                    if (cocktailPrice != null) {
                        cocktailId = cocktailPrice.getCocktail_id();
                        lineMap.put("cocktail_id", cocktailId);
                        cocktail = (cocktailId != null) ? cocktailService.getCocktailById(cocktailId).orElse(null) : null;
                    } else {
                        cocktailId = null;
                    }
                    if (cocktail != null) {
                        lineMap.put("cocktail_name", cocktail.getCocktail_name());
                        List<Map<String, Object>> ingredients = composedOfService.getAllComposedOf().stream()
                            .filter(co -> cocktailId != null && cocktailId.equals(co.getCocktail_id()))
                            .map(co -> {
                                Map<String, Object> ingMap = new HashMap<>();
                                Ingredient ingredient = ingredientService.getIngredientById(Integer.valueOf(co.getIngredient_id())).orElse(null);
                                ingMap.put("ingredient_id", co.getIngredient_id());
                                ingMap.put("ingredient_name", ingredient != null ? ingredient.getIngredient_name() : "Inconnu");
                                ingMap.put("quantity", co.getQuantity());
                                return ingMap;
                            })
                            .toList();
                        lineMap.put("ingredients", ingredients);
                    } else {
                        lineMap.put("cocktail_name", "Inconnu");
                        lineMap.put("ingredients", List.of());
                    }
                    return lineMap;
                }).toList();

                Map<String, Object> response = new HashMap<>();
                response.put("order_id", orderCocktail.getOrder_id());
                response.put("order_date", orderCocktail.getOrder_date());
                response.put("order_status", orderCocktail.getOrder_status());
                response.put("customer_id", orderCocktail.getCustomer_id());
                response.put("orderLines", enrichedOrderLines);
                return ResponseEntity.ok(response);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderCocktail createOrderCocktail(@RequestBody OrderCocktail orderCocktail) {
        return orderCocktailService.createOrderCocktail(orderCocktail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderCocktail> updateOrderCocktail(@PathVariable Integer id, @RequestBody OrderCocktail orderCocktail) {
        return orderCocktailService.updateOrderCocktail(id, orderCocktail)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderCocktail(@PathVariable Integer id) {
        boolean deleted = orderCocktailService.deleteOrderCocktail(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}