Виконання ДЗ 22. Робота з базами даних у Java

1. Створити таблицю Homework. Ця таблиця складається з атрибутів: id, name, description

2. Створити таблицю Lesson. Ця таблиця складається з атрибутів: id, name, updatedAt, homework_id 
(пов'язано з таблицею Homework one-to-many)

3. Реалізувати клас DataBaseConnection. 
налаштувати підключення до БД
метод getConnection() - повертає нове з'єднання з БД
метод close(Connection) - закриває передане з'єднання

4. Реалізувати java клас Lesson, який містить такі властивості: id, name, homework

5. Реалізувати java клас Homework, який містить такі властивості: id, name, description

6. Реалізувати клас LessonDao
метод додавання уроку addLesson
метод видалення уроку removeLesson
метод отримання всіх уроків getAllLessons
метод отримання уроку за getLessonИнID - повинен повертати урок з посиланням на заняття  

7. Клас LessonDao взаємодіє з БД і повертає об'єкти типу Lesson - метод повинен повертати объєкти типа Lesson

==================================================
 
У процессі виконання я створив базу даних використовуючи наступний запит:

-- Створення таблиці Homework
CREATE TABLE Homework (
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(255),
 description VARCHAR(255)
);
-- Створення таблиці Lesson
CREATE TABLE Lesson (
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(255),
 updatedAt DATETIME,
 homework_id INT,
 FOREIGN KEY (homework_id) REFERENCES Homework(id)
);
-- Створення таблиці Schedule
CREATE TABLE Schedule (
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(255),
 updatedAt DATETIME
);
-- Створення зв'язку між таблицями Lesson і Schedule
CREATE TABLE Schedule_Lesson (
 schedule_id INT,
 lesson_id INT,
 FOREIGN KEY (schedule_id) REFERENCES Schedule(id),
 FOREIGN KEY (lesson_id) REFERENCES Lesson(id)
);

==================================================

Доданий у репозиторій код виконується у консолі IDEA без помилок:

All Lessons:
Lesson ID: 1
Lesson Name: Lesson 1
Homework ID: 1
Homework Name: Homework 1
Homework Description: Homework ONE

Lesson ID: 2
Lesson Name: Lesson 2
Homework ID: 2
Homework Name: Homework 2
Homework Description: Homework TWO

Lesson ID: 3
Lesson Name: Lesson 3
Homework ID: 3
Homework Name: Homework 3
Homework Description: Homework THREE

Lesson ID: 1
Lesson Name: Lesson 1
Homework ID: 1
Homework Name: Homework 1
Homework Description: Homework ONE

All Lessons after removal:
Lesson ID: 1
Lesson Name: Lesson 1
Homework ID: 1
Homework Name: Homework 1
Homework Description: Homework ONE

Lesson ID: 3
Lesson Name: Lesson 3
Homework ID: 3
Homework Name: Homework 3
Homework Description: Homework THREE

