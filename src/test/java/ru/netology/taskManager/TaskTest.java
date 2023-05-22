package ru.netology.taskManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void shouldMatchQueryInSimpleTaskTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean result = simpleTask.matches("родителям");
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotMatchQueryInSimpleTaskTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean result = simpleTask.matches("друзьям");
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldMatchQueryInEpicSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean result = epic.matches("Хлеб");
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotMatchQueryInEpicSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean result = epic.matches("Масло");
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldMatchQueryInMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean result = meeting.matches("версии");
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldMatchQueryInMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean result = meeting.matches("НетоБанка");
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotMatchQueryInMeetingTopicOrProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean result = meeting.matches("дизайна");
        Assertions.assertFalse(result);
    }
}
