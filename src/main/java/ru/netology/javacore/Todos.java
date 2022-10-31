package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    protected TreeSet<String> allTasks;
    protected static final int MAXSIZEALLTASKS = 7;

    public Todos() {
        allTasks = new TreeSet<>();
    }

    public void addTask(String task) {
        if (allTasks.size() < MAXSIZEALLTASKS) {
            allTasks.add(task);
        }
    }

    public void removeTask(String task) {
        allTasks.remove(task);
    }

    public String getAllTasks() {
        String sortedAllTasks = this.allTasks.stream()
                .collect(Collectors.joining(" "));
        return sortedAllTasks;
    }
}
