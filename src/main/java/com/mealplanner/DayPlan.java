package com.mealplanner;

import java.time.LocalDate;
import java.util.List;

public class DayPlan {
    private Long id;
    private LocalDate date;
    private String name;
    private List<Meal> meals;
    private double totalCalories;
    private double totalProteins;
    private double totalFats;
    private double totalCarbs;
}
