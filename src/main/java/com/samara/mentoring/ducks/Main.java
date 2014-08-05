package com.samara.mentoring.ducks;

import com.samara.mentoring.ducks.clients.Day1;
import com.samara.mentoring.ducks.clients.Day2;

public class Main {
    public static void main(String[] args) {
        try {
            if(args.length == 0) throw new IllegalArgumentException();
            switch (Integer.parseInt(args[0])) {
            case 1:
                Day1.createClient();
                break;
            case 2:
                Day2.createClient();
                break;
            default:
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException e) {
          System.out.println("Number in range [1;2] is expected");
        }
    }
}
