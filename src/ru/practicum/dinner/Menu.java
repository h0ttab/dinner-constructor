package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    Map<String, List<String>> menu;

    Menu() {
        menu = new HashMap<>();

        // Mock-data
        menu.put("Напиток", new ArrayList<>(List.of("Сок фруктовый", "Кола", "Морс", "Компот ягодный",
                "Квас", "Минеральная вода")));

        menu.put("Суп", new ArrayList<>(List.of("Щи", "Борщ", "Харчо", "Рассольник", "Крем-суп",
                "Суп гороховый")));

        menu.put("Горячее", new ArrayList<>(List.of("Шашлык свиной", "Плов", "Котлеты по-Киевски",
                "Бефстроганов", "Жаркое", "Гуляш")));

        menu.put("Салат", new ArrayList<>(List.of("салат Цезарь", "салат Мимоза", "салат Овощной",
                "Сельдь под шубой", "Капуста квашеная", "салат Греческий")));
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
