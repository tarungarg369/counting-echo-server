package com.gameskraft;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  StringOccurenceUpdater  : Shared resource updater class with reantrant lock to provide thread safety .
 */

public class  StringOccurenceUpdater {

  private Map<String, Integer> countStringOccurence;
  private ReentrantReadWriteLock reentrantLock;
  public StringOccurenceUpdater(){
    countStringOccurence = new HashMap<>();
    reentrantLock = new ReentrantReadWriteLock();
  }

  public int updateStringOccurence(String input) {
    reentrantLock.writeLock().lock();
    int count = 0;
    try {
      count  = countStringOccurence.getOrDefault(input,0)+1;
      countStringOccurence.put(input,count);
    } catch (Exception ex ) {
      System.err.println("Error occured while update String occurence count");
    } finally {
      reentrantLock.writeLock().unlock();
    }
    return count;
  }
}
