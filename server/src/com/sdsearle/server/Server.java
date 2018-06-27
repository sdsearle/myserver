package com.sdsearle.server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Server {

    Server() {
        int port = 8331;
        try (
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socketClient = serverSocket.accept();
            PrintWriter out =
                    new PrintWriter(socketClient.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socketClient.getInputStream()));
            BufferedReader stdIn =
                    new BufferedReader(
                            new InputStreamReader(System.in))
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
    	System.out.println("Start");
        Server server = new Server();
    }

}