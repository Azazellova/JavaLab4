import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Validator {

    public static int inputInteger(Scanner input, String prompt) {
        int value;
        System.out.print(prompt);
        while (!(input.hasNextInt())) {
            //input.nextLine();
            System.out.println("Ошибка ввода, повторите попытку: ");
            System.out.print("> ");
            input.next();
        }
        value = input.nextInt();
        input.nextLine();
        return value;
    }

    public static int inputPositiveInteger(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value > 0) {
                    scanner.nextLine();
                    return value;
                } else {
                    System.out.println("Ошибка: количество должно быть положительным числом.");
                }
            } else {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }
    }

    public static double inputDouble(Scanner input, String prompt) {
        double value;
        System.out.print(prompt);
        while (!(input.hasNextDouble())) {
            //input.nextLine();
            System.out.println("Ошибка ввода, повторите попытку: ");
            System.out.print("> ");
            input.next();
        }
        value = input.nextDouble();
        input.nextLine();
        return value;
    }

    public static int inputIntegerInRange(Scanner input, int a, int b, String prompt) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        while (true) {
            int value = inputInteger(input, prompt);

            if (value >= min && value <= max) {
                return value;
            } else {
                System.out.println("Ошибка ввода. Число не находится в диапазоне от " + min + " до " + max + ".");
                System.out.print("Повторите ввод: ");
            }
        }
    }

    public static int inputMark(Scanner input, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                value = input.nextInt();
                if (value >= 1 && value <= 5) {
                    return value;
                } else {
                    System.out.println("Ошибка: введите целое число от 1 до 5.");
                }
            }
            else {
                System.out.println("Ошибка: введите целое число.");
                input.next();
            }
        }
    }

    public static Integer inputIntegerWithNull(Scanner scanner, String prompt) {
        while (true){
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.isEmpty() || input.equalsIgnoreCase("null")) {
                return null;
            }

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число, 'null' или оставьте пустым для null.");
            }
        }
    }

    public static String inputStringWithNull(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.isEmpty() || input.equalsIgnoreCase("null")) {
            return null;
        }

        return input;
    }

    public static List<String> inputStringList(Scanner scanner) {
        System.out.println("=== Ввод списка строк ===");
        int count = Validator.inputPositiveInteger(scanner, "Введите количество строк:");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(Validator.inputStringWithNull(scanner,"Строка " + (i + 1) + ": "));
        }
        return list;
    }

    public static List<Integer> inputIntegerList(Scanner scanner) {
        System.out.println("=== Ввод списка чисел ===");
        int count = Validator.inputPositiveInteger(scanner, "Введите количество чисел: ");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(Validator.inputInteger(scanner,"Число " + (i + 1) + ": "));
        }
        return list;
    }

    public static List<int[]> inputArraysList(Scanner scanner) {
        System.out.println("=== Ввод списка массивов ===");
        int arrayCount = Validator.inputPositiveInteger(scanner, "Введите количество массивов: ");

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arrayCount; i++) {
            int size = Validator.inputPositiveInteger(scanner, "Введите размер массива " + (i + 1) + ": ");

            int[] array = new int[size];
            System.out.println("Введите элементы массива:");
            for (int j = 0; j < size; j++) {
                array[j] = Validator.inputInteger(scanner,"Элемент " + (j + 1) + ": ");
            }
            list.add(array);
        }
        return list;
    }
}
