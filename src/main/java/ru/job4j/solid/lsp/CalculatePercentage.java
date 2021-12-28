package ru.job4j.solid.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculatePercentage {

    public double percentageOfExpiration(Food food) {
        LocalDate now = LocalDate.now();
        double date1 =  ChronoUnit.DAYS.between(food.getExpiryDate(), food.getCreateDate());
        double date2 =  ChronoUnit.DAYS.between(now, food.getCreateDate());
        return 100 - (date2 / date1 * 100);
    }
}
