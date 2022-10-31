package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TodosTests {

    Todos todos;

    @BeforeEach
    void setUp() {
        todos = new Todos();
        TreeSet<String> list = new TreeSet<>();
        list.add("Пробежка");
        list.add("Акробатика");
        list.add("Учеба");

        todos.allTasks = list;
    }

    @Test
    @DisplayName("Проверка сортировки и вывода всего списка")
    void allTalksToStringAndSorted() {
        String expected = "Акробатика Пробежка Учеба";
        String actual = todos.getAllTasks();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка добавления задачи в список")
    void addTaskToList() {
        String taskToAdd = "Работа";
        todos.addTask(taskToAdd);
        Assertions.assertTrue(todos.allTasks.contains(taskToAdd));
    }

    @Test
    @DisplayName("Проверка удаления задачи из списка")
    void removeTaskFromList() {
        String taskToRemove = "Учеба";
        todos.removeTask(taskToRemove);
        Assertions.assertFalse(todos.allTasks.contains(taskToRemove));
    }

    @Test
    @DisplayName("Проверка добавления задачи сверх лимита")
    void addTaskOverLimit() {
        final int MAXSIZEALLTASKS = 3;
        int sizeListOfAllTasks = todos.allTasks.size();
        todos.addTask("Работа");
        Assertions.assertEquals(3, sizeListOfAllTasks);
    }
}
