package com.gameskraft;

import java.net.Socket;

/**
 *  MultipleClientHandler  : Multi-threaded Client handler for concurrent execution .
 */


public class MultipleClientHandler extends Thread {


  private static StringOccurenceUpdater stringOccurenceUpdater = null;
  private final In in;
  private final Out out;
  private final Socket s;

  public MultipleClientHandler(Socket s, In in, Out out, StringOccurenceUpdater stringOccurenceUpdater) {
    this.s = s;
    this.in = in;
    this.out = out;
    this.stringOccurenceUpdater = stringOccurenceUpdater;
  }

  @Override
  public void run() {
    while (true) {
      try {
        String input;
        while ((input = in.readLine()) != null) {
          int count = stringOccurenceUpdater.updateStringOccurence(input);
          out.println(input + " => " + count);
        }

        // input is empty from client
        out.close();
        in.close();
        s.close();
        break;

      } catch (Exception ex) {
        System.err.println("Error occured while closing  connection with client");
      }

    }
  }


}

