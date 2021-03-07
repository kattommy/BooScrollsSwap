package com.kttk.bookScrollsSwap.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConsoleMenu {
    private String header;
    private List<String> options = new ArrayList<>();

    ConsoleMenu(String header, List<String> options) {
        this.header = header;
        this.options = options;
    }

    public void display() {
        System.out.println(header);

        for (String option: options
             ) {
            System.out.format(Locale.ENGLISH, "  %d. %s%n", (option.indexOf(option) + 1), option.toString());
        }
        System.out.print("Choose your option: ");
    }
}
