package javapro.dz6;

public class HomeWorkApp {

    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        // 2. Створіть метод printThreeWords(), який під час виклику повинен надрукувати в стовпець
        // три слова: Orange, Banana, Apple.

        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        // 3. Створіть метод checkSumSign(), у тілі якого оголосіть дві int змінні a і b, та ініціалізуйте їх
        // будь-якими значеннями, якими захочете. Далі метод повинен підсумувати ці змінні, і якщо їх сума
        // більша або дорівнює 0, то вивести в консоль повідомлення "Сума позитивна", інакше - "Сума негативна";

        int a = 11;
        int b = 12;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сума позитивна");
        } else {
            System.out.println("Сума негативна");
        }
    }

    public static void printColor() {
        // 4. Створіть метод printColor() у тілі якого задайте int змінну value та ініціалізуйте її будь-яким значенням.
        // Якщо значення менше 0 (0 включно), то в консоль метод повинен вивести повідомлення "Червоний",
        // якщо лежить в межах від 0 (0 виключно) до 100 (100 включно), то "Жовтий", якщо більше 100 (100 виключно) -
        // "Зелений";

        int value = 100;

        if (value <= 0) {
            System.out.println("Червоний");
        } else if (value > 0 & value <= 100) {
            System.out.println("Жовтий");
        } else {
            System.out.println("Зелений");
        }
    }

    public static void compareNumbers() {
        // 5. Створіть метод compareNumbers(), у тілі якого оголосіть дві int змінні a і b, та ініціалізуйте їх
        // будь-якими значеннями, якими захочете. Якщо a більше або одно b, необхідно вивести в консоль повідомлення
        // “a >= b”, інакше “a < b”;

        int a = 10;
        int b = 50;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}