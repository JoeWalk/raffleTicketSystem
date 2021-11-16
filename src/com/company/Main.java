package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static String valid = "false";

    public static void main(String[] args) {
        String answer = "";
        ArrayList<String> takenTickets = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try{
            while(!answer.equals("C")) {
                System.out.println("What do you want to do?");
                System.out.println("A) Check a raffle ticket");
                System.out.println("B) Buy a raffle ticket");
                System.out.println("C) Leave");
                System.out.println("");
                System.out.println("Type A,B or C");

                answer = bf.readLine();
                switch (answer) {
                    case "A":
                        String valid = "false";
                        valid = checkTicket(takenTickets,valid);
                        if (!valid.equals("false")){
                            checkPrime(takenTickets);
                        }
                        break;
                    case "B":
                        System.out.println("What is your name? ");
                        String name = bf.readLine();
                        getTicket(takenTickets,name);
                        break;
                    default:
                }
            }
        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }
    }

        public static ArrayList<String> getTicket (ArrayList<String> takenTickets, String name) {
        Random random = new Random();
        String ticket = Integer.toString(random.nextInt(400) + 1);
        takenTickets.add(name + " " + ticket);
        System.out.println("Your ticket number is " + ticket);
        return(takenTickets);
    }

    public static String checkTicket (ArrayList<String> takenTickets, String valid){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Please type your name and your ticket number");
            String check = bf.readLine();
            if (takenTickets.contains(check)){
                valid = "true";
                return(valid);
            }
            else{
                System.out.println("Your ticket number doesn't match your name you scumbag");
            }
            return(null);
        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }
        return(null);
    }

    public static String checkPrime (ArrayList<String> takenTickets){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Please type your ticket number");
            String number = bf.readLine();
            int num = Integer.parseInt(number);
            boolean flag = false;
            for (int i = 2; i <= num / 2; ++i) {
                if (num % i == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag)
                System.out.println("Congratulations! You have won.");
            else
                System.out.println("Sorry but you haven't won. Feel free to buy another ticket.");
        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }
        return(null);
    }
}




