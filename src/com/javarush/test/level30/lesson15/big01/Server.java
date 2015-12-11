package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alexei on 30.11.2015.
 */
public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            }
            catch (IOException e) {
                try {
                    entry.getValue().send(new Message(MessageType.TEXT, "Не удалось отправить сообщение"));
                }
                catch (IOException e1) {

                }
            }
        }
    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Handler(clientSocket).start();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {

        private Socket socket;

        public Handler(Socket socket) {
            super();
            this.socket = socket;
        }

        @Override
        public void run() {
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом " + connection.getRemoteSocketAddress());
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            }
            catch (IOException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
                if (userName != null){
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
            }
            catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
                if (userName != null){
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            boolean success = false;
            Message userNameMessage = null;
            while (!success) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                userNameMessage = connection.receive();
                if (!userNameMessage.getType().equals(MessageType.USER_NAME)) {
                    continue;
                }
                if (userNameMessage.getData().equals("") || userNameMessage.getData() == null) {
                    continue;
                }
                if (connectionMap.containsKey(userNameMessage.getData())) {
                    continue;
                }
                connectionMap.put(userNameMessage.getData(), connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                success = true;
            }
            return userNameMessage.getData();
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (!entry.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message userMessage = connection.receive();
                if (userMessage.getType().equals(MessageType.TEXT)) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + userMessage.getData()));
                }
                else {
                    ConsoleHelper.writeMessage("Получено некорректное сообщение");
                }
            }
        }
    }
}
