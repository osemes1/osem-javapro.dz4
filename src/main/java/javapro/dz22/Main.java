package javapro.dz22;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            // Створення LessonDao
            LessonDao lessonDao = new LessonDao(connection);

            // Створення таблиць Lesson і Homework
            createLessonTable(connection);
            createHomeworkTable(connection);

            // Створення об'єктів Homework
            Homework homework1 = new Homework(1, "Homework 1", "Homework ONE");
            Homework homework2 = new Homework(2, "Homework 2", "Homework TWO");
            Homework homework3 = new Homework(3, "Homework 3", "Homework THREE");

            // Створення об'єктів Lesson з посиланням на Homework
            Lesson lesson1 = new Lesson(1, "Lesson 1", homework1);
            Lesson lesson2 = new Lesson(2, "Lesson 2", homework2);
            Lesson lesson3 = new Lesson(3, "Lesson 3", homework3);

            // Додавання уроків
            lessonDao.addLesson(lesson1);
            lessonDao.addLesson(lesson2);
            lessonDao.addLesson(lesson3);

            // Отримання всіх уроків
            List<Lesson> allLessons = lessonDao.getAllLessons();
            System.out.println("All Lessons:");
            for (Lesson lesson : allLessons) {
                System.out.println("Lesson ID: " + lesson.getId());
                System.out.println("Lesson Name: " + lesson.getName());
                System.out.println("Homework ID: " + lesson.getHomework().getId());
                System.out.println("Homework Name: " + lesson.getHomework().getName());
                System.out.println("Homework Description: " + lesson.getHomework().getDescription());
                System.out.println();
            }

            // Отримання уроку за ID
            int lessonId = 1;
            Lesson lessonById = lessonDao.getLessonById(lessonId);
            if (lessonById != null) {
                System.out.println("Lesson ID: " + lessonById.getId());
                System.out.println("Lesson Name: " + lessonById.getName());
                System.out.println("Homework ID: " + lessonById.getHomework().getId());
                System.out.println("Homework Name: " + lessonById.getHomework().getName());
                System.out.println("Homework Description: " + lessonById.getHomework().getDescription());
            } else {
                System.out.println("Lesson with ID " + lessonId + " not found.");
            }

            // Видалення уроку
            int lessonToRemoveId = 2;
            lessonDao.removeLesson(lessonToRemoveId);

            // Повторне отримання всіх уроків після видалення
            allLessons = lessonDao.getAllLessons();
            System.out.println("\nAll Lessons after removal:");
            for (Lesson lesson : allLessons) {
                System.out.println("Lesson ID: " + lesson.getId());
                System.out.println("Lesson Name: " + lesson.getName());
                System.out.println("Homework ID: " + lesson.getHomework().getId());
                System.out.println("Homework Name: " + lesson.getHomework().getName());
                System.out.println("Homework Description: " + lesson.getHomework().getDescription());
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createLessonTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Lesson (" +
                "id INT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "homework_id INT," +
                "FOREIGN KEY (homework_id) REFERENCES Homework(id)" +
                ")";
        connection.createStatement().execute(sql);
    }

    private static void createHomeworkTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Homework (" +
                "id INT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "description VARCHAR(255)" +
                ")";
        connection.createStatement().execute(sql);
    }
}
