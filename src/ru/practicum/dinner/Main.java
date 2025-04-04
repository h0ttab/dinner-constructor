package ru.practicum.dinner;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            String command;

            printMenu();
            command = scanner.nextLine();

            switch (command) {
                case "1" -> addNewDish();
                case "2" -> generateDishCombo();
                case "3" -> {
                    scanner.close();
                    return;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        String dishType;
        String dishName;

        System.out.println("Введите тип блюда:");
        dishType = scanner.nextLine();

        System.out.println("Введите название блюда:");
        dishName = scanner.nextLine();

        boolean isDishAdded = dc.addNewDish(dishType, dishName);
        if (!isDishAdded) {
            System.out.println("Такое блюдо уже есть в меню.");
        }
    }

    private static void generateDishCombo() {
        List<String> dishTypes = new ArrayList<>();
        String nextItem;
        int numberOfCombos = 0;
        boolean isValidPositiveNumber = false;
        int comboCounter = 1;

        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        while (!isValidPositiveNumber) {
            try {
                numberOfCombos = Integer.parseInt(scanner.nextLine());
                if (numberOfCombos > 0) {
                    isValidPositiveNumber = true;
                } else {
                    System.out.println("Количество наборов должно быть положительным числом.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не число. Пожалуйста, попробуйте снова.");
            }
        }

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter)." +
                "Для завершения ввода введите пустую строку");
        nextItem = scanner.nextLine();

        while (!nextItem.isEmpty()) {
            if (!dc.checkType(nextItem)) {
                System.out.println("Ошибка: Блюда этого типа не представлены в меню.");
            } else {
                dishTypes.add(nextItem);
            }
            nextItem = scanner.nextLine();
        }

        List<List<String>> dishComboList = dc.generateCombos(numberOfCombos, dishTypes);

        for (List<String> combo : dishComboList) {
            System.out.println("Комбо " + comboCounter++);
            System.out.println(combo.toString());
        }

        System.out.println();
    }
}
