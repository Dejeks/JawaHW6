package org.example.Homework.HW6;
import java.util.*;

public class Task {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("HP", 8, 500, "Windows", "Silver"));
        laptops.add(new Laptop("Dell", 16, 1000, "Windows", "Black"));
        laptops.add(new Laptop("Apple", 16, 512, "MacOS", "Silver"));
        laptops.add(new Laptop("Lenovo", 4, 256, "Windows", "Black"));

        Map<Integer, Object> filterCriteria = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criteria = scanner.nextInt();

        switch (criteria) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ:");
                int minRam = scanner.nextInt();
                filterCriteria.put(criteria, minRam);
                break;
            case 2:
                System.out.println("Введите минимальный объем ЖД:");
                int minStorage = scanner.nextInt();
                filterCriteria.put(criteria, minStorage);
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.next();
                filterCriteria.put(criteria, os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.next();
                filterCriteria.put(criteria, color);
                break;
            default:
                System.out.println("Некорректный ввод.");
                return;
        }

        filterAndPrintLaptops(laptops, filterCriteria);
    }

    private static void filterAndPrintLaptops(Set<Laptop> laptops, Map<Integer, Object> filterCriteria) {
        Set<Laptop> filteredLaptops = new HashSet<>(laptops);

        for (Map.Entry<Integer, Object> entry : filterCriteria.entrySet()) {
            int criteria = entry.getKey();
            Object value = entry.getValue();

            switch (criteria) {
                case 1:
                    filteredLaptops.removeIf(laptop -> laptop.getRam() < (int) value);
                    break;
                case 2:
                    filteredLaptops.removeIf(laptop -> laptop.getStorage() < (int) value);
                    break;
                case 3:
                    filteredLaptops.removeIf(laptop -> !laptop.getOperatingSystem().equals(value));
                    break;
                case 4:
                    filteredLaptops.removeIf(laptop -> !laptop.getColor().equals(value));
                    break;
            }
        }

        System.out.println("Найденные ноутбуки:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop.toString());
        }
    }

}
