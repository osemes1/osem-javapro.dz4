package javapro.dz12_phonebook;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add(new Record("Захар", "067-3331111"));
        phoneBook.add(new Record("Тимур", "067-3332222"));
        phoneBook.add(new Record("Захар", "067-4443333"));

        Record record1 = phoneBook.find("Захар");
        if (record1 != null) {
            System.out.println("Знайдено: " + record1.getName() + ", " + record1.getPhoneNumber());
        } else {
            System.out.println("Немає записів");
        }

        List<Record> records = phoneBook.findAll("Захар");
        if (records != null) {
            System.out.println("Знайшлося:");
            for (Record record : records) {
                System.out.println(record.getName() + ", " + record.getPhoneNumber());
            }
        } else {
            System.out.println("Немає записів");
        }
    }
}
