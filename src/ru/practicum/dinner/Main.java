package ru.practicum.dinner;

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

        dc.addNewDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        ArrayList<String> dishTypes = new ArrayList<>();
        String nextItem;
        int numberOfCombos;
        int comboCounter = 1;

        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        numberOfCombos = Integer.parseInt(scanner.nextLine());

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter)." +
                "Для завершения ввода введите пустую строку");
        nextItem = scanner.nextLine();

        while (!nextItem.isEmpty()) {
            if (!dc.checkType(nextItem)) {
                System.out.println("Такого типа блюд в меню нет.");
            } else {
                dishTypes.add(nextItem);
            }
            nextItem = scanner.nextLine();
        }

        ArrayList<ArrayList<String>> dishComboList = dc.generateSetOfCombo(numberOfCombos, dishTypes);

        for (ArrayList<String> combo : dishComboList) {
            System.out.println("Комбо " + comboCounter++);
            System.out.println(combo.toString());
        }

        System.out.println();
    }
}
