package com.andrerichards.hello;

import java.time.LocalDate;
import java.util.Date;

public class Hello {
    public static void main(String[] args) {
        Date aDate = new Date();
        aDate.getTime();
        LocalDate localDate = LocalDate.now();

        double val = 20;
        double val2 = 80;
        double sum = (val + val2) * 100;
        double rmdr = sum % 40;
        boolean bool = rmdr == 0;
        System.out.println(bool);
        if (!bool)
            System.out.println("Got some remainder");
    }
}
