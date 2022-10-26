package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TodoServer {
    private int port = 8989;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        String jsonRequest;
        List<Request> allRequests = new ArrayList<>();

        System.out.println("Starting server at " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(port);) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    jsonRequest = in.readLine();

                    Gson gson = new GsonBuilder().create();
                    Request request = gson.fromJson(jsonRequest, Request.class);

                    switch (request.getType()) {
                        case ("ADD"):
                            todos.addTask(request.getTask());
                            allRequests.add(request);
                            break;

                        case ("REMOVE"):
                            todos.removeTask(request.getTask());
                            allRequests.add(request);
                            break;

                        case ("RESTORE"):
                            Request lastRequest = allRequests.get(allRequests.size() - 1);
                            if (lastRequest.getType().equals("ADD")) {
                                todos.removeTask(lastRequest.getTask());
                                allRequests.remove(lastRequest);
                            } else if (lastRequest.getType().equals("REMOVE")) {
                                todos.addTask(lastRequest.getTask());
                                allRequests.remove(lastRequest);
                            }
                            break;
                    }
                    out.println(todos.getAllTasks());

                } catch (IOException e) {
                    System.out.println("Не могу стартовать сервер");
                    e.printStackTrace();
                }
            }
        }
    }

    public int getPort() {
        return port;
    }

    public Todos getTodos() {
        return todos;
    }
}