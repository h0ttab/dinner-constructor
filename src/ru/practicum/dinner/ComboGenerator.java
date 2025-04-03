package ru.practicum.dinner;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class ComboGenerator {
    Random random = new Random();

    private List<String> getRandomCombo(List<String> dishTypes, Map<String,
            List<String>> menu) {
        List<String> combo = new ArrayList<>();

        for (String dishType : dishTypes) {
            List<String> dishesOfType = menu.get(dishType);
            String randomDishOfType = dishesOfType.get(random.nextInt(dishesOfType.size()));
            combo.add(randomDishOfType);
        }

        return combo;
    }

    public List<List<String>> generateSetOfCombo(int quantity,
            List<String> dishTypes, Map<String, List<String>> menu) {
        List<List<String>> setOfCombo = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            setOfCombo.add(getRandomCombo(dishTypes, menu));
        }

        return setOfCombo;
    }
}
