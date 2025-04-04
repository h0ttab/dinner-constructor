package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Menu {
    private final Map<String, List<String>> menu;

    Menu() {
        menu = new HashMap<>();
    }

    boolean addNewDish(String dishType, String dishName) {
        List<String> dishesOfCurrentType;

        if (!menu.containsKey(dishType)) {
            menu.put(dishType, new ArrayList<>());
        }

        dishesOfCurrentType = menu.get(dishType);

        if (!dishesOfCurrentType.contains(dishName)) {
            dishesOfCurrentType.add(dishName);
            return true;
        } else {
            return false;
        }
    }

    Map<String, List<String>> getMenu() {
        return menu;
    }
}