import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private static Set<PrintWriter> clientWriters = new HashSet<>();
    private static Set<String> userNames = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Chat Server started...");

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private String userName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                out = new PrintWriter(socket.getOutputStream(), true);

                // Ask for username
                out.println("Enter your name:");
                userName = in.readLine();

                synchronized (userNames) {
                    userNames.add(userName);
                }

                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                broadcast(userName + " joined the chat");;

                String message;
                while ((message = in.readLine()) != null) {
                    broadcast(userName + ": " + message);
                }

            } catch (IOException e) {
                System.out.println("Connection error.");
            } finally {
                if (userName != null) {
                    userNames.remove(userName);
                    broadcast(userName + " left the chat");
                }
                if (out != null) {
                    clientWriters.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {}
            }
        }

        private void broadcast(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    writer.println(message);
                }
            }
        }
    }
}