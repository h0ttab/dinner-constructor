package ru.practicum.dinner;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

class ComboGenerator {
    private final Random random = new Random();

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

    public List<List<String>> generateCombos(int quantity,
            List<String> dishTypes, Map<String, List<String>> menu) {
        List<List<String>> combos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            combos.add(getRandomCombo(dishTypes, menu));
        }

        return combos;
    }
}
