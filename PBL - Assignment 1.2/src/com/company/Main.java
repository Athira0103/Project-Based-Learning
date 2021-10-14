package com.company;

import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        int ch,o;
        float x,y;
        Scanner a = new Scanner(System.in);
        Calculator c = new Calculator();
        boolean quit=false;
        while(!quit)
        {
            System.out.println("Calculator operations. \nChoose the operation. Enter \n 1.Addition\n 2.Subtraction \n 3.Multiplication \n 4.Division\n 5.Square root\n 6.Power\n 7.Mean\n 8.Variance");
            ch = a.nextInt();
            switch (ch)
            {
                case 1:
                    c.sum();
                    break;
                case 2:
                    System.out.println("Enter the first number");
                    x=a.nextFloat();
                    System.out.println("Enter the second number");
                    y=a.nextFloat();
                    c.diff(x,y);
                    break;
                case 3:
                    c.product();
                    break;
                case 4:
                    System.out.println("Enter the dividend");
                    x=a.nextFloat();
                    System.out.println("Enter the divisor");
                    y=a.nextFloat();
                    c.quo(x,y);
                    break;
                case 5:
                    System.out.println("Enter the number");
                    x=a.nextFloat();
                    c.sr(x);
                    break;
                case 6:
                    System.out.println("Enter the base number");
                    x=a.nextFloat();
                    System.out.println("Enter its power");
                    y=a.nextFloat();
                    c.pow(x,y);
                    break;
                case 7:
                    c.mean();
                    break;
                case 8:
                    c.variance();
                    break;
                default:
                    System.out.println("Wrong choice.");

            }
            System.out.println("If you want to continue press 1.Else press any other key");
            o=a.nextInt();
            if(o!=1)
                quit=true;
        }
    }
}
