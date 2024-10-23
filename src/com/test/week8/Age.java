package com.test.week8;

import java.time.LocalDate;

public class Age {

    private int year;

    public void setAge(int year) {
        this.year = year;
    }

    public int getAge() {
        int currentYear = LocalDate.now().getYear();
        return currentYear - year;
    }
}
