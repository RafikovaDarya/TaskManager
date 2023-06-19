package ru.netology.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.ParseException;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {

        try (Socket socket = new Socket("127.0.0.1", 8989);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            //подключение к серверу


                System.out.println("Укажите номер операции и напишите задачу через пробел:" +
                        "\n" + "1.ADD" +
                        "\n" + "2.REMOVE");

                writer.println(choiceOfOperationJSON());




        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


    }

    public static String choiceOfOperationJSON() throws ParseException {

        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");

        String operation = null;
        if (parts[0].equals("1")) {
            operation = "ADD";
        } else if (parts[0].equals("2")) {
            operation = "REMOVE";
        }

        String jsonText = "{\"type\": \"" + operation + "\", \"task\": \"" + parts[1] + "\""+"}";
        System.out.println(jsonText);

        return jsonText;
    }

}