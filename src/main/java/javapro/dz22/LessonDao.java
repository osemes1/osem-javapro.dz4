package javapro.dz22;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {
    private Connection connection;

    public LessonDao(Connection connection) {
        this.connection = connection;
    }

    public void addLesson(Lesson lesson) throws SQLException {
        // Перевірка, чи існує домашнє завдання, перед додаванням уроку
        Homework homework = lesson.getHomework();
        if (homework != null && getHomeworkById(homework.getId()) == null) {
            addHomework(homework);
        }

        // Підготовка SQL-запиту для додавання уроку
        String sql = "INSERT INTO Lesson (id, name, homework_id) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, lesson.getId());
        statement.setString(2, lesson.getName());
        statement.setInt(3, lesson.getHomework().getId());
        statement.executeUpdate();
    }

    public void removeLesson(int lessonId) throws SQLException {
        // Підготовка SQL-запиту для видалення уроку
        String sql = "DELETE FROM Lesson WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, lessonId);
        statement.executeUpdate();
    }

    public List<Lesson> getAllLessons() throws SQLException {
        // Підготовка SQL-запиту для отримання всіх уроків
        String sql = "SELECT * FROM Lesson";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        List<Lesson> lessons = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int homeworkId = resultSet.getInt("homework_id");
            Homework homework = getHomeworkById(homeworkId);
            Lesson lesson = new Lesson(id, name, homework);
            lessons.add(lesson);
        }

        return lessons;
    }

    public Lesson getLessonById(int lessonId) throws SQLException {
        // Підготовка SQL-запиту для отримання уроку за його ідентифікатором
        String sql = "SELECT * FROM Lesson WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, lessonId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int homeworkId = resultSet.getInt("homework_id");
            Homework homework = getHomeworkById(homeworkId);
            return new Lesson(id, name, homework);
        }

        return null;
    }

    private void addHomework(Homework homework) throws SQLException {
        // Перевірка, чи існує домашнє завдання перед додаванням
        if (getHomeworkById(homework.getId()) != null) {
            return;
        }

        // Підготовка SQL-запиту для додавання домашнього завдання
        String sql = "INSERT INTO Homework (id, name, description) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, homework.getId());
        statement.setString(2, homework.getName());
        statement.setString(3, homework.getDescription());
        statement.executeUpdate();
    }

    private Homework getHomeworkById(int homeworkId) throws SQLException {
        // Підготовка SQL-запиту для отримання домашнього завдання за його ідентифікатором
        String sql = "SELECT * FROM Homework WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, homeworkId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            return new Homework(id, name, description);
        }

        return null;
    }
}
