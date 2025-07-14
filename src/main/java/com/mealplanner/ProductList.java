package com.mealplanner;

import java.util.HashMap;
import java.util.Map;

public class ProductList {
    private long rationId;
    private Map<Ingredient, Double> products;
    
    public ProductList(long rationId) {
        this.rationId = rationId;
        this.products = new HashMap<>();
    }
    
    public long getRationId() { return rationId; }
    public Map<Ingredient, Double> getProducts() { return new HashMap<>(products); }
    
    public void generateFromRation(Ration ration) {
        if (ration.getId() != rationId) {
            throw new IllegalArgumentException("Ration ID mismatch");
        }
        products.clear();
        for (Dish dish : ration.getDishes()) {
            for (Ingredient ingredient : dish.getIngredients()) {
                products.merge(ingredient, ingredient.getAmount(), Double::sum);
            }
        }
    }
    
    public void display() {
        if (products.isEmpty()) {
            System.out.println("No products in the list.");
        } else {
            System.out.println("Product List for Ration " + rationId + ":");
            for (Map.Entry<Ingredient, Double> entry : products.entrySet()) {
                Ingredient ingredient = entry.getKey();
                System.out.printf("%s: %.2f %s%n",
                        ingredient.getName(), entry.getValue(), ingredient.getUnit());
            }
        }
    }
}
