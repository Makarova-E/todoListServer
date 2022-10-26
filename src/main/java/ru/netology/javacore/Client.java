package ru.netology.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final int PORT = 8989;
    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) {

        try (
                Socket clientSocket = new Socket(HOST, PORT);
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("{ \"type\": \"ADD\", \"task\": \"Первая\" }");
            //  out.println("{ \"type\": \"ADD\", \"task\": \"Вторая\" }");
            // out.println("{ \"type\": \"REMOVE\", \"task\": \"Первая\" }");
            // out.println("{ \"type\": \"ADD\", \"task\": \"Третья\" }");
            // out.println("{ \"type\": \"RESTORE\" }");
            // out.println("{ \"type\": \"RESTORE\" }");

            System.out.println(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
