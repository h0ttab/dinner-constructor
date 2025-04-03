package ru.practicum.dinner;

import java.util.List;
import java.util.Map;

public class DinnerConstructor {
    Menu menu = new Menu();
    ComboGenerator comboGenerator = new ComboGenerator();

    void addNewDish(String dishType, String dishName) {
        menu.addNewDish(dishType, dishName);
    }

    List<List<String>> generateSetOfCombo(int quantity, List<String> dishTypes) {
        return comboGenerator.generateSetOfCombo(quantity, dishTypes, menu.getMenu());
    }

    Map<String, List<String>> getMenu() {
        return menu.getMenu();
    }

    boolean checkType(String type) {
        return this.getMenu().containsKey(type);
    }
}
