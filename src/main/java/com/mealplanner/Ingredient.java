package com.mealplanner;

/**
 * Класс описывает ингредиенты блюд(Dish)
 */
public class Ingredient {
    private final String name; //Яйцо С0
    private final double amount; //количество гл, мл, шт
    private final String unit; //единица измерения г мл шт
    //TODO мб вынести в отдельный класс nutrition facts?
    private final double calories; //калории на 100г/мл или единицу
    private final double proteins; //белок на 100г/мл или единицу
    private final double fats; //жиры на 100г/мл или единицу
    private final double carbs; //углеводы на 100г/мл или единицу
    
    public Ingredient(String name, double amount, String unit, double calories, double proteins, double fats, double carbs) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ingredient name cannot be empty");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (unit == null || unit.isEmpty()) {
            throw new IllegalArgumentException("Unit cannot be empty");
        }
        if (calories < 0 || proteins < 0 || fats < 0 || carbs < 0) {
            throw new IllegalArgumentException("KBJU values cannot be negative");
        }
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
    }
    
    public String getName() {
        return name;
    }
    
    public String getUnit() {
        return unit;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public double getCalories() {
        return calories;
    }

    public double getProteins() {
        return proteins;
    }
    
    public double getFats() {
        return fats;
    }

    public double getCarbs() {
        return carbs;
    }
    
    public Ingredient withAmount(double newAmount) {
        return new Ingredient(name, newAmount, unit, calories, proteins, fats, carbs);
    }
}
