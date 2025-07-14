package com.mealplanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для описания блюд
 */
public class Dish {
    private String name; //Вафли с творогом
    private MealType type; //тип приема пищи
    private List<Ingredient> ingredients; //список ингредиентов
    private String instructions; //инструкция по приготовлению
    private double totalCalories; //общая калорийность
    private double totalProteins;//общее количество белков
    private double totalFats; //общее количество жиров
    private double totalCarbs;//общее количество углеводов
    
    public Dish(String name, MealType type, List<Ingredient> ingredients, String instructions) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Dish name cannot be empty");
        }
        if (type == null) {
            throw new IllegalArgumentException("Meal type cannot be null");
        }
        if (ingredients == null) {
            ingredients = new ArrayList<>();
        }
        this.name = name;
        this.type = type;
        this.ingredients = ingredients;
        this.instructions = instructions;
        calculateKBJU();
    }
    
    public String getName() {
        return name;
    }
    
    public MealType getType() {
        return type;
    }
    
    public String getInstructions() {
        return instructions;
    }
    
    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    
    public double getTotalCalories() {
        return totalCalories;
    }
    
    public double getTotalProteins() {
        return totalProteins;
    }
    
    public double getTotalFats() {
        return totalFats;
    }
    
    public double getTotalCarbs() {
        return totalCarbs;
    }
    
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Dish name cannot be empty");
        }
        this.name = name;
    }
    
    public void setType(MealType type) {
        if (type == null) {
            throw new IllegalArgumentException("Meal type cannot be null");
        }
        this.type = type;
    }
    
    public void setInstructions(String instructions) {
        this.instructions = instructions != null ? instructions : "";
    }
    
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        calculateKBJU();
    }
    
    private void calculateKBJU() {
        totalCalories = 0;
        totalProteins = 0;
        totalFats = 0;
        totalCarbs = 0;
        for (Ingredient ingredient : ingredients) {
            double factor = ingredient.getAmount() / 100.0; // Предполагаем, что КБЖУ дано на 100 г/мл
            totalCalories += ingredient.getCalories() * factor;
            totalProteins += ingredient.getProteins() * factor;
            totalFats += ingredient.getFats() * factor;
            totalCarbs += ingredient.getCarbs() * factor;
        }
        // Для отладки
        System.out.println("Calculated KBJU for " + name + ": " + totalCalories + " cal, " +
                totalProteins + " P, " + totalFats + " F, " + totalCarbs + " C");
    }
}
