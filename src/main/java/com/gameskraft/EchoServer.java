package com.gameskraft;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *  Echo Server  : Accepts  multiple client connection on port 4444.
 */

public class EchoServer {
  public static void main(String[] args) throws Exception {

    // create socket
    int port = 4444;
    ServerSocket serverSocket = new ServerSocket(port);
    System.err.println("Started server on port " + port);
    StringOccurenceUpdater stringOccurenceUpdater = new StringOccurenceUpdater();

    // repeatedly wait for connections, and process
    while (true) {

      // a "blocking" call which waits until a connection is requested
      Socket clientSocket = serverSocket.accept();
      System.err.println("Accepted connection from client");

      // open up IO streams
      In in = new In(clientSocket);
      Out out = new Out(clientSocket);

      Thread client = new MultipleClientHandler(clientSocket,
          in,
          out,
          stringOccurenceUpdater
      );
      client.start();

    }
  }
}

