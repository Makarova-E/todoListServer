package ru.netology.javacore;

public class Request {
    private String type;
    private String task;

    public Request(String type, String task) {
        this.type = type;
        this.task = task;
    }

    public String getType() {
        return type;
    }

    public String getTask() {
        return task;
    }

    @Override
    public String toString() {
        return "{ \"type: " + type +
                ", \"task: " + task + " }";
    }
}
