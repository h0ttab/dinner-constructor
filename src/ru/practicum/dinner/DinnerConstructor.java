package ru.practicum.dinner;

import java.util.List;
import java.util.Map;

public class DinnerConstructor {
    private final Menu menu = new Menu();
    private final ComboGenerator comboGenerator = new ComboGenerator();

    public boolean addNewDish(String dishType, String dishName) {
        return menu.addNewDish(dishType, dishName);
    }

    public List<List<String>> generateCombos(int quantity, List<String> dishTypes) {
        return comboGenerator.generateCombos(quantity, dishTypes, menu.getMenu());
    }

    private Map<String, List<String>> getMenu() {
        return menu.getMenu();
    }

    public boolean checkType(String type) {
        Map<String, List<String>> currentMenu = getMenu();
        return currentMenu.containsKey(type) && !currentMenu.get(type).isEmpty();
    }
}
