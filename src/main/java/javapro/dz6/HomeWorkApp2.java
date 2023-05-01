package javapro.dz6;

public class HomeWorkApp2 {

    public static void main(String[] args) {
        System.out.println(isRange(11, 12));
        sideNumber(2);
        System.out.println(isNegative(-25));
        printString(" надрукований рядок", 5);
        System.out.println(isLeapYear(2008));
    }

    public static boolean isRange(int a, int b) {
        // 6. Написати метод, який приймає на вхід два цілих числа і перевіряє, що їхня сума лежить в межах
        // від 10 до 20 (включно), якщо так – повернути true, інакше – false

        System.out.println("Cума лежить в межах від 10 до 20 (включно)");
        int sum = a + b;
        if (sum >= 10 && sum <=20) {
            return true;
        }
        return false;
    }

        public static void sideNumber(int number) {
            // 7. Написати метод, якому як параметр передається ціле число, метод повинен надрукувати в консоль,
            // чи додатнє число передали або від’ємне. Примітка: нуль вважаємо позитивним числом

            System.out.println("Чи додатнє число передали або від’ємне");
            if (number >= 0) {
                System.out.println(number + " є додатнє");
            } else {
                System.out.println(number + " є від'ємне");
            }
        }

    public static boolean isNegative(int x) {
        // 8. Написати метод, якому як параметр передається ціле число. Метод повинен повернути true, якщо число є негативним,
        // і повернути false якщо позитивне

        System.out.println("Негативне: true, позитивне: false");
        if (x >= 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void printString(String str, int n) {
        // 9. Написати метод, якому як аргументи передається рядок і число, метод повинен надрукувати в консоль
        // зазначений рядок, вказану кількість разів

        for (int i = 1; i <= n; i++) {
            System.out.println("- " + i + str);
        }
    }

    public static boolean isLeapYear(int year) {
        //10. * Написати метод, який визначає, чи є рік високосним, і повертає boolean (високосний – true, не високосний – false).
        // Кожен 4-й рік є високосним, крім кожного 100-го, причому кожен 400-й – високосний.

        System.out.println("Чи є рік " + year + " високосним");
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        else {
            return false;
        }

    }

}
