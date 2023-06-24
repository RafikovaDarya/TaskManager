package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class TodoServer {
    private int port;
    private Todos todos;




    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(8989);) { // стартуем сервер один(!) раз

            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    // обработка одного подключения
                    System.out.println("Подключен клиент " + socket.getPort());

                    //парсинг JSON
                    out.println(parsingJSON(in.readLine()));

                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }

    public String parsingJSON(String jsonText) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        JsonText json = gson.fromJson(jsonText, JsonText.class);
        switch (json.type) {
            case ADD:
                todos.addTask(json.task);
                break;
            case REMOVE:
                todos.removeTask(json.task);
                break;
        }
        String result = todos.getAllTasks();
        return result;
    }
}
