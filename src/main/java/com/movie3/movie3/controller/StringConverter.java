package com.movie3.movie3.controller;

import java.util.ArrayList;
import java.util.List;

public class StringConverter {
	public StringConverter() {}
	public static List<String> convertStringToList(String input) {
        List<String> resultList = new ArrayList<>();

        String[] parts = input.split(",");
        for (String part : parts) {
            char letter = part.charAt(0);
            int number = Character.toUpperCase(letter) - 'A' + 1;
            String convertedString = Integer.toString(number) + part.substring(1);
            resultList.add(convertedString);
        }

        return resultList;
    }
}
