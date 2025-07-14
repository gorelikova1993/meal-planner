package com.mealplanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MealManager {
    private List<Ration> rations;
    private List<Dish> dishes;
    
    public MealManager() {
        rations = new ArrayList<>();
        dishes = new ArrayList<>();
    }
    
    public void addRation(Ration ration) {
        rations.add(ration);
    }
    
    public void addDish(Dish dish) {
        dishes.add(dish);
    }
    
    public void displayRations() {
        if (rations.isEmpty()) {
            System.out.println("Рационов пока нет.");
        } else {
            for (Ration ration : rations) {
                System.out.printf("Рацион %d: %s (КБЖУ: %.2f калории, %.2f белок, %.2f жиры, %.2f углеводы)%n",
                        ration.getId(), ration.getName(), ration.getTotalCalories(),
                        ration.getTotalProteins(), ration.getTotalFats(), ration.getTotalCarbs());
                for (Dish dish : ration.getDishes()) {
                    System.out.printf("%s: %s (КБЖУ: %.2f калории, %.2f белок, %.2f жиры, %.2f углеводы)%n",
                            dish.getType(), dish.getName(), dish.getTotalCalories(),
                            dish.getTotalProteins(), dish.getTotalFats(), dish.getTotalCarbs());
                    System.out.println("Ингредиенты:");
                    for (Ingredient ingredient : dish.getIngredients()) {
                        System.out.printf("- %s: %.2f %s%n",
                                ingredient.getName(), ingredient.getAmount(), ingredient.getUnit());
                    }
                    System.out.println("Рецепт: " + dish.getInstructions());
                }
            }
        }
    }
    
    public static void main(String[] args) {
        MealManager manager = new MealManager();
        Scanner scanner = new Scanner(System.in);
        
        // Пример данных
        Ingredient egg = new Ingredient("Яйцо С1", 1, "шт", 70, 5, 0.5, 0.1);
        Ingredient kefir = new Ingredient("Кефир 2.5%", 50, "мл", 50, 2, 2.5, 3.5);
        List<Ingredient> waffleIngredients = new ArrayList<>(Arrays.asList(egg, kefir));
        Dish waffles = new Dish("Вафли с творогом", MealType.BREAKFAST, waffleIngredients,
                "Смешиваем яйцо с кефиром...");
        
        Ration ration = new Ration(1, "Рацион 1");
        ration.addDish(waffles);
        manager.addRation(ration);
        
        ProductList productList = new ProductList(1);
        productList.generateFromRation(ration);
        
        // Консольный интерфейс
        while (true) {
            System.out.println("\n1. View rations\n2. View product list\n3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    manager.displayRations();
                    break;
                case "2":
                    productList.display();
                    break;
                case "3":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
