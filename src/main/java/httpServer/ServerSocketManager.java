package httpServer;

import httpfs.httpfs;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerSocketManager {
    public ServerSocket serverSocket;
    public Socket clientSocket;
    public PrintWriter outputStream;
    public BufferedReader inputStream;

    public ServerSocketManager(int port) {
        createServerSocket(port);
        listenForClientConnections();
    }

    public void createServerSocket(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Successfully created server socket...");
        } catch (IOException e) {
            System.out.println("Could not create server socket...");
            System.exit(1);
        }
    }

    public void listenForClientConnections() {
        try {
            System.out.println("Listening for new client connections on port " + serverSocket.getLocalPort() + "...");
            clientSocket = serverSocket.accept();
            outputStream = new PrintWriter(clientSocket.getOutputStream());
            inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));
            if (httpfs.verbose) {
                System.out.println("Received client socket connection...");
                System.out.println("Client Socket connected: " + clientSocket.isConnected());
                System.out.println("Client Connected on port: " + clientSocket.getPort());
                System.out.println("Client socket address: " + clientSocket.getRemoteSocketAddress());
            }
        } catch (IOException e) {
            System.out.println("Could not accept/listen to client requests...");
            System.exit(1);
        }
    }

    public void closeServerSocket() {
        try {
            outputStream.close();
            inputStream.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Could not close server/client socket...");
            System.exit(1);
        }
    }

    public void closeClientSocket() {
        try {
            outputStream.close();
            inputStream.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Could not close client socket...");
            System.exit(1);
        }
    }

}
