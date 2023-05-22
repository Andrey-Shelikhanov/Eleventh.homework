package ru.netology.taskManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTasksByQuery() {
        SimpleTask task1 = new SimpleTask(1, "Купить продукты");
        SimpleTask task2 = new SimpleTask(2, "Убраться дома");
        SimpleTask task3 = new SimpleTask(3, "Позвонить другу");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        Task[] expected = {task3};
        Task[] actual = todos.search("другу");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayWhenSearchingByNonMatchingQuery() {
        SimpleTask task1 = new SimpleTask(1, "Написать отчет");
        SimpleTask task2 = new SimpleTask(2, "Заказать книгу");
        Epic task3 = new Epic(3, new String[]{"Регистрация", "Авторизация"});
        Meeting task4 = new Meeting(4, "Совещание", "Проект X", "Завтра в 10:00");

        Todos todos = new Todos();

        todos.add(task1);
        todos.add(task2);
        todos.add(task3);
        todos.add(task4);

        String query = "встреча";
        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayWhenSearchingInEmptyTodos() {
        Todos todos = new Todos();

        String query = "задача";
        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMultipleTasksByQuery() {
        SimpleTask task1 = new SimpleTask(1, "Сходить в кино");
        SimpleTask task2 = new SimpleTask(2, "Приготовить ужин");
        SimpleTask task3 = new SimpleTask(3, "Посетить спортивный зал");
        SimpleTask task4 = new SimpleTask(4, "Позвонить родителям");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);
        todos.add(task4);

        Task[] expected = {task1, task2, task3, task4};
        Task[] actual = todos.search("о");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayWhenNoTasksMatchQuery() {
        SimpleTask task1 = new SimpleTask(1, "Купить продукты");
        SimpleTask task2 = new SimpleTask(2, "Убрать дом");
        SimpleTask task3 = new SimpleTask(3, "Позвонить другу");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        Task[] expected = {};
        Task[] actual = todos.search("работа");
        Assertions.assertArrayEquals(expected, actual);
    }
}
