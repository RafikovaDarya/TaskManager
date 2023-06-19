package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTests {

    Todos todos = new Todos();

    @Test
    void addOperation() {
        String first = "Зарядка";
        String second = "Пробежка";

        todos.addTask(first);
        todos.addTask(second);

        String expect = "Зарядка Пробежка";
        String result = todos.getAllTasks();

        Assertions.assertEquals(expect, result);
    }

    @Test
    void addAllOperation() {
        String first = "Зарядка";
        String second = "Пробежка";
        String third = "Чтение";
        String fourth = "Акробатика";
        String fifth = "Лыжи";
        String sixth = "Учеба";
        String seventh = "Готовка";
        String eighth = "Шитье";

        todos.addTask(first);
        todos.addTask(second);
        todos.addTask(third);
        todos.addTask(fourth);
        todos.addTask(fifth);
        todos.addTask(sixth);
        todos.addTask(seventh);
        todos.addTask(eighth); //шитье не добавится

        String expect = "Акробатика Готовка Зарядка Лыжи Пробежка Учеба Чтение";//максимум 7
        String result = todos.getAllTasks();

        Assertions.assertEquals(expect, result);
    }

    @Test
    void removeOperation() {
        String first = "Зарядка";
        String second = "Пробежка";
        String third = "Чтение";

        todos.addTask(first);
        todos.addTask(second);
        todos.addTask(third);

        todos.removeTask(second);

        String expect = "Зарядка Чтение";
        String result = todos.getAllTasks();
        Assertions.assertEquals(expect, result);
    }


}
