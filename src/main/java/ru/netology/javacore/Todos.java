package ru.netology.javacore;
import java.util.*;


public class Todos {
    protected List<String> tasks = new ArrayList<>();
    private final int LIST_SIZE = 7;


    public void addTask(String task) {
        if (tasks.size() < LIST_SIZE) {
            tasks.add(task);
        }
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        Collections.sort(tasks);
        StringJoiner allTasks = new StringJoiner(" ");
        for (int i = 0; i < tasks.size(); i++) {
            allTasks.add(tasks.get(i));
        }

        return allTasks.toString();

    }

}
