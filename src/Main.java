import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== МЕНЮ ====");
            System.out.println("1. Задание 1.2 - Хранилище чисел и строк");
            System.out.println("2. Задание 1.5 - Точки и линии (2D/3D)");
            System.out.println("3. Задание 2.1 - Сдвиг линии");
            System.out.println("4. Задание 3.1 - Преобразование элементов");
            System.out.println("5. Задание 3.2 - Фильтрация элементов");
            System.out.println("6. Задание 3.3 - Свертка элементов");
            System.out.println("7. Задание 3.4 - Сборка коллекций");
            System.out.println("0. Выход");

            int choice = Validator.inputIntegerInRange(input, 0, 7, "Выберите задание: ");

            switch (choice) {
                case 1:
                    task1_2(input);
                    break;
                case 2:
                    task1_5(input);
                    break;
                case 3:
                    task2_1(input);
                    break;
                case 4:
                    task3_1(input);
                    break;
                case 5:
                    task3_2(input);
                    break;
                case 6:
                    task3_3(input);
                    break;
                case 7:
                    task3_4(input);
                    break;
                case 0:
                    System.out.println("Выход из программы...");
                    input.close();
                    return;
            }

            System.out.println("\nНажмите Enter чтобы продолжить...");
            input.nextLine();
        }
    }

    // Задание 1.2 - Хранилище чисел и строк
    private static void task1_2(Scanner input) {
        System.out.println("\n==== Задание 1.2 ====");
        System.out.println("1. Хранилище чисел с null");

        Integer number1 = Validator.inputIntegerWithNull(input,"Введите основное число: ");
        Integer number2 = Validator.inputIntegerWithNull(input, "Альтернативное значение (для первой проверки 0):");
        Storage<Integer> numberStorage1 = new Storage<>(number1, number2);

        numberStorage1.printValue();
        System.out.println("Информация: " + numberStorage1);

        System.out.println("\n2. Хранилище чисел со значением 99");

        Integer number3 = Validator.inputIntegerWithNull(input,"Введите основное число: ");
        Integer number4 = Validator.inputIntegerWithNull(input, "Альтернативное значение (для первой проверки -1):");
        Storage<Integer> numberStorage2 = new Storage<>(number3, number4);

        numberStorage2.printValue();
        System.out.println("Информация: " + numberStorage2);

        System.out.println("\n3. Хранилище строк с null");

        String string1 = Validator.inputStringWithNull(input,"Введите основную строку: ");
        String string2 = Validator.inputStringWithNull(input,"Введите альтернативную строку(default): ");
        Storage<String> stringStorage1 = new Storage<>(string1, string2);

        stringStorage1.printValue();
        System.out.println("Информация: " + stringStorage1);

        System.out.println("\n4. Хранилище строк со значением 'hello'");

        String string3 = Validator.inputStringWithNull(input,"Введите основную строку: ");
        String string4 = Validator.inputStringWithNull(input,"Введите альтернативную строку(default): ");
        Storage<String> stringStorage2 = new Storage<>(string3, string4);

        stringStorage2.printValue();
        System.out.println("Информация: " + stringStorage2);
    }

    // Задание 1.5 - Точки и линии (2D/3D)
    private static void task1_5(Scanner input) {
        System.out.println("\n ==== Задание 1.5 ====");

        // Объявляем переменные в начале метода
        double startX2D = 0.0, startY2D = 0.0;
        Point2D start2D = null;
        double endX2D = 0.0, endY2D = 0.0;
        Point2D end2D = null;
        Line<Point2D> line2D = null;

        double startX3D = 0.0, startY3D = 0.0, startZ3D = 0.0;
        Point3D start3D = null;
        double endX3D = 0.0, endY3D = 0.0, endZ3D = 0.0;
        Point3D end3D = null;
        Line<Point3D> line3D = null;

        int pointType = Validator.inputIntegerInRange(input,0,2,
                "Введите тип точки:\n1 - 2D\n2 - 3D\n0 - Выход из задания: ");

        switch (pointType) {
            case 1: {
                startX2D = Validator.inputDouble(input,"Введите X начальной точки: ");
                startY2D = Validator.inputDouble(input,"Введите Y начальной точки: ");
                start2D = new Point2D(startX2D, startY2D);

                endX2D = Validator.inputDouble(input,"Введите X конечной точки: ");
                endY2D = Validator.inputDouble(input,"Введите Y конечной точки: ");
                end2D = new Point2D(endX2D, endY2D);

                line2D = new Line<>(start2D, end2D);

                System.out.println("Двухмерная линия: " + line2D);
                System.out.println("Расстояние: " + line2D.getDistance());
                break;
            }
            case 2: {
                startX3D = Validator.inputDouble(input,"Введите X начальной точки: ");
                startY3D = Validator.inputDouble(input,"Введите Y начальной точки: ");
                startZ3D = Validator.inputDouble(input,"Введите Z начальной точки: ");
                start3D = new Point3D(startX3D, startY3D, startZ3D);

                endX3D = Validator.inputDouble(input,"Введите X конечной точки: ");
                endY3D = Validator.inputDouble(input,"Введите Y конечной точки: ");
                endZ3D = Validator.inputDouble(input,"Введите Z конечной точки: ");
                end3D = new Point3D(endX3D, endY3D, endZ3D);

                line3D = new Line<>(start3D, end3D);

                System.out.println("Трехмерная линия: " + line3D);
                System.out.println("Расстояние (проекция на плоскость XY): " + line3D.getDistance());
                break;
            }
            case 0: {
                System.out.println("Выход из задания...");
                return;
            }
        }
    }

    // Задание 2.1 - Сдвиг линии
    private static void task2_1(Scanner input) {
        System.out.println("\n ==== Задание 2.1 ====");

        System.out.println("\n---- Сдвиг линии с Point2D -----");

        double startX2D = Validator.inputDouble(input,"Введите X начальной точки: ");
        double startY2D = Validator.inputDouble(input,"Введите Y начальной точки: ");
        Point2D start2D = new Point2D(startX2D, startY2D);

        double endX2D = Validator.inputDouble(input,"Введите X конечной точки: ");
        double endY2D = Validator.inputDouble(input,"Введите Y конечной точки: ");
        Point2D end2D = new Point2D(endX2D, endY2D);

        Line<Point2D> line2D = new Line<>(start2D, end2D);

        System.out.println("Создана линия: " + line2D);

        line2D.shiftLineX();
        System.out.println("После сдвига: " + line2D);

        System.out.println("\n---- Сдвиг линии с Point3D ----");

        double startX3D = Validator.inputDouble(input,"Введите X начальной точки: ");
        double startY3D = Validator.inputDouble(input,"Введите Y начальной точки: ");
        double startZ3D = Validator.inputDouble(input,"Введите Z начальной точки: ");
        Point3D start3D = new Point3D(startX3D, startY3D, startZ3D);

        double endX3D = Validator.inputDouble(input,"Введите X конечной точки: ");
        double endY3D = Validator.inputDouble(input,"Введите Y конечной точки: ");
        double endZ3D = Validator.inputDouble(input,"Введите Z конечной точки: ");
        Point3D end3D = new Point3D(endX3D, endY3D, endZ3D);

        Line<Point3D> line3D = new Line<>(start3D, end3D);

        System.out.println("Создана линия: " + line3D);

        Line.shiftLineStartX(line3D);

        System.out.println("После сдвига: " + line3D);
    }

    // Задание 3.1 - Преобразование элементов
    private static void task3_1(Scanner input) {
        System.out.println("\n==== Задание 3.1 ====");

        System.out.println("\n--- Преобразование: Строки -> Длины строк ---");
        List<String> strings = Validator.inputStringList(input);

        List<Integer> lengths = FunctionApply.apply(strings, String::length);

        System.out.println("\nРезультат: ");
        System.out.println("Исходные строки: " + strings);
        System.out.println("Длины строк: " + lengths);

        System.out.println("\nДетали:");
        for (int i = 0; i < strings.size(); i++) {
            System.out.printf("'%s' -> %d%n", strings.get(i), lengths.get(i));
        }

        System.out.println("\n--- Преобразование: Числа -> Абсолютные значения ---");
        List<Integer> numbers = Validator.inputIntegerList(input);

        List<Integer> absValues = FunctionApply.apply(numbers, Math::abs);

        System.out.println("\nРезультат: ");
        System.out.println("Исходные числа: " + numbers);
        System.out.println("Абсолютные значения: " + absValues);

        System.out.println("\nДетали:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%d -> %d%n", numbers.get(i), absValues.get(i));
        }

        System.out.println("\n--- Преобразование: Массивы -> Максимальные значения ---");
        List<int[]> arrays = Validator.inputArraysList(input);

        List<Integer> maxValues = FunctionApply.apply(arrays, arr -> {
            int max = arr[0];
            for (int value: arr) {
                if (value > max) {
                    max = value;
                }
            }
            return max;
        });

        System.out.println("\nРезультат: ");
        System.out.println("Исходные массивы:");
        for (int i = 0; i < arrays.size(); i++) {
            System.out.println("  Массив " + (i + 1) + ": " + Arrays.toString(arrays.get(i)));
        }
        System.out.println("Максимальные значения: " + maxValues);

        System.out.println("\nДетали:");
        for (int i = 0; i < arrays.size(); i++) {
            System.out.printf("%s -> %d%n",
                    Arrays.toString(arrays.get(i)), maxValues.get(i));
        }
    }

    // Задание 3.2 - Фильтрация элементов
    private static void task3_2(Scanner input) {
        System.out.println("\n==== Задание 3.2 ====");

        System.out.println("\n--- Фильтрация строк ---");

        List<String> list1 = Validator.inputStringList(input);

        int minLen = Validator.inputPositiveInteger(input,"Введите минимальную длину строки: ");
        List<String> filteredList1 = Filter.test(list1, str -> str.length() < minLen);

        System.out.println("\nИсходные строки: " + list1);
        System.out.println("Отфильтрованные строки (длина < " + minLen + "): " + filteredList1);

        System.out.println("\n--- Фильтрация чисел ---");

        List<Integer> list2 = Validator.inputIntegerList(input);
        List<Integer> posFilteredList2 = Filter.test(list2,x -> x > 0);

        System.out.println("Исходный список чисел: " + list2);
        System.out.println("Отфильтрованный список положительных чисел: " + posFilteredList2);

        System.out.println("\n--- Фильтрация массивов ---");

        List<int[]> list3 = Validator.inputArraysList(input);
        List<int[]> negFilteredList3 = Filter.test(list3, arr -> {
            for (int num: arr) {
                if (num >= 0) {
                    return false;
                }
            }
            return true;
        });

        System.out.println("Исходные массивы:");
        for (int i = 0; i < list3.size(); i++) {
            System.out.println("  Массив " + (i + 1) + ": " + Arrays.toString(list3.get(i)));
        }

        System.out.println("Отфильтрованные массивы (без положительных элементов): ");
        for (int i = 0; i < negFilteredList3.size(); i++) {
            System.out.println("  Массив " + (i + 1) + ": " + Arrays.toString(negFilteredList3.get(i)));
        }
    }

    // Задание 3.3 - Свертка элементов
    private static void task3_3(Scanner input) {
        System.out.println("\n==== Задание 3.3 ====");

        System.out.println("\n--- Объединение строк ---");
        List<String> strings1 = Validator.inputStringList(input);
        String concatenated = Decrease.reduce(strings1, "", (s1, s2) ->
                (s1 == null ? "" : s1) + (s2 == null ? "" : s2));
        System.out.println("Объединенная строка: " + concatenated);

        System.out.println("\n--- Сумма чисел ---");
        List<Integer> integers = Validator.inputIntegerList(input);
        Integer sum = Decrease.reduce(integers, 0, (a, b) -> a + b);
        System.out.println("Сумма чисел: " + sum);

        System.out.println("\n--- Общее количество элементов во вложенных списках ---");
        List<int[]> listOfArrays = Validator.inputArraysList(input);
        List<Integer> sizes = new ArrayList<>();
        for (int[] array : listOfArrays) {
            sizes.add(array.length);
        }

        Integer totalElements = Decrease.reduce(sizes, 0, (a, b) -> a + b);
        System.out.println("Общее количество элементов во всех массивах: " + totalElements);
    }

    // Задание 3.4 - Сборка коллекций
    private static void task3_4(Scanner input) {
        System.out.println("\n==== Задание 3.4 ====");

        System.out.println("\n--- Разделение чисел на положительные и отрицательные ---");
        List<Integer> list4 = Validator.inputIntegerList(input);
        System.out.println("Исходные числа: " + list4);

        List<Integer> positiveNumbers = Collections.collect(list4, ArrayList::new, num -> num > 0);
        List<Integer> negativeNumbers = Collections.collect(list4, ArrayList::new, num -> num < 0);
        System.out.println("Положительные числа: " + positiveNumbers);
        System.out.println("Отрицательные числа: " + negativeNumbers);

        System.out.println("\n--- Группировка строк по длине ---");
        List<String> list5 = Validator.inputStringList(input);
        System.out.println("Исходные строки: " + list5);

        Set<Integer> lengthsList5 = new HashSet<>();
        for (String s : list5) {
            if (s != null) {
                lengthsList5.add(s.length());
            }
        }

        Map<Integer, List<String>> colList5 = new HashMap<>();
        for (Integer len : lengthsList5) {
            List<String> group = Collections.collect(list5, ArrayList::new,
                    str -> str != null && str.length() == len);
            colList5.put(len, group);
        }
        System.out.println("Подсписки строк с одинаковой длиной: " + colList5);

        System.out.println("\n--- Уникальные строки ---");
        List<String> list6 = Validator.inputStringList(input);
        System.out.println("Исходные строки: " + list6);

        Collection<String> colList6 = Collections.collect(list6, HashSet::new, str -> true);
        System.out.println("Набор с уникальными объектами: " + colList6);
    }
}