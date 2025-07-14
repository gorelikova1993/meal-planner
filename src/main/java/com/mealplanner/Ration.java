package com.mealplanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для описания рационов
 * например рацион1 хранит в себе завтрак обед ужин на 1500 калорий в день
 */

public class Ration {
    private long id;
    private String name;
    private List<Dish> dishes;
    private double totalCalories;
    private double totalProteins;
    private double totalFats;
    private double totalCarbs;
    
    public Ration(long id, String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ration name cannot be empty");
        }
        this.id = id;
        this.name = name;
        this.dishes = new ArrayList<>();
    }
    
    public long getId() { return id; }
    public String getName() { return name; }
    public List<Dish> getDishes() { return new ArrayList<>(dishes); } // Возвращаем копию списка для защиты
    
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ration name cannot be empty");
        }
        this.name = name;
    }
    
    // Добавление блюда с проверкой уникальности типа
    public void addDish(Dish dish) {
        if (dish == null) {
            throw new IllegalArgumentException("Dish cannot be null");
        }
        // Удаляем существующее блюдо того же типа, если оно есть
        dishes.removeIf(d -> d.getType() == dish.getType());
        dishes.add(dish);
        calculateKBJU();
    }
    
    // Получение блюда по типу
    public Dish getDishByType(MealType type) {
        return dishes.stream()
                .filter(dish -> dish.getType() == type)
                .findFirst()
                .orElse(null);
    }
    
    // Удаление блюда по типу
    public void removeDish(MealType type) {
        dishes.removeIf(dish -> dish.getType() == type);
        calculateKBJU();
    }
    
    // Расчет суммарного КБЖУ
    private void calculateKBJU() {
        totalCalories = 0;
        totalProteins = 0;
        totalFats = 0;
        totalCarbs = 0;
        for (Dish dish : dishes) {
            totalCalories += dish.getTotalCalories();
            totalProteins += dish.getTotalProteins();
            totalFats += dish.getTotalFats();
            totalCarbs += dish.getTotalCarbs();
        }
    }
    
    public double getTotalCalories() { return totalCalories; }
    public double getTotalProteins() { return totalProteins; }
    public double getTotalFats() { return totalFats; }
    public double getTotalCarbs() { return totalCarbs; }
}
