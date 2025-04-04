package ru.practicum.dinner;

import java.util.List;
import java.util.Map;

public class DinnerConstructor {
    Menu menu = new Menu();
    ComboGenerator comboGenerator = new ComboGenerator();

    boolean addNewDish(String dishType, String dishName) {
        return menu.addNewDish(dishType, dishName);
    }

    List<List<String>> generateCombos(int quantity, List<String> dishTypes) {
        return comboGenerator.generateCombos(quantity, dishTypes, menu.getMenu());
    }

    Map<String, List<String>> getMenu() {
        return menu.getMenu();
    }

    boolean checkType(String type) {
        Map<String, List<String>> currentMenu = this.getMenu();
        return currentMenu.containsKey(type) && !currentMenu.get(type).isEmpty();
    }
}
