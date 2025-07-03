package com.mealplanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException {
        
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM dishes");
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("name");
                double calories = rs.getDouble("calories");
                double protein = rs.getDouble("protein");
                double fat = rs.getDouble("fat");
                double carbs = rs.getDouble("carbs");
                String recipe = rs.getString("recipe");
                System.out.println(name + " калории: " + calories + " белок: " + protein + " жир: " + fat + " углеводы: " + carbs + " рецепт: " + recipe);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка базы данных: " + e.getMessage());
        }
        
    }
}
