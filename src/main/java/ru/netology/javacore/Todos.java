package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    protected List<String> allTasks;
    protected int maxSizeAllTasks = 7;

    public Todos() {
        allTasks = new ArrayList<>();
    }

    public void addTask(String task) {
        if (allTasks.size() < maxSizeAllTasks) {
            allTasks.add(task);
        }
    }

    public void removeTask(String task) {
        allTasks.remove(task);
    }

    public String getAllTasks() {
        String sortedAllTasks = this.allTasks.stream()
                .sorted()
                .collect(Collectors.joining(" "));
        return sortedAllTasks;
    }

    public int getMaxSizeAllTasks() {
        return maxSizeAllTasks;
    }
}
