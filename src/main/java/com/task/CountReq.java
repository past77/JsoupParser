package com.task;

public class CountReq {
    private static int count;
  public static void countReguests() {
        count++;
    }
     public static int getCountRequests(){
        return count;
    }
}
