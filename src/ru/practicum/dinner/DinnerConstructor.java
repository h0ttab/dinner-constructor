package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Map;

public class DinnerConstructor {
    Menu menu = new Menu();
    ComboGenerator comboGenerator = new ComboGenerator();

    void addNewDish(String dishType, String dishName){
        menu.addNewDish(dishType, dishName);
    }

    ArrayList<ArrayList<String>> generateSetOfCombo(int quantity, ArrayList<String> dishTypes) {
        return comboGenerator.generateSetOfCombo(quantity, dishTypes, menu.getMenu());
    }

    Map<String, ArrayList<String>> getMenu() {
        return menu.getMenu();
    }
}
