package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
public class ComboGenerator {
    Random random = new Random();

    private ArrayList<String> getRandomCombo(ArrayList<String> dishTypes, Map<String, ArrayList<String>> menu){
        ArrayList<String> combo = new ArrayList<>();

        for (String dishType : dishTypes) {
           ArrayList<String> dishesOfType = menu.get(dishType);
           String randomDishOfType = dishesOfType.get(random.nextInt(dishesOfType.size()));
           combo.add(randomDishOfType);
        }

        return combo;
    }

    public ArrayList<ArrayList<String>> generateSetOfCombo(int quantity, ArrayList<String> dishTypes, Map<String, ArrayList<String>> menu) {
        ArrayList<ArrayList<String>> setOfCombo = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            setOfCombo.add(getRandomCombo(dishTypes, menu));
        }

        return setOfCombo;
    }
}
