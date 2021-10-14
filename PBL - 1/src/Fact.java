import java.io.*;
import java.util.Scanner;
public class Fact
{
    public static void main(String[] args)throws IOException {
        int ch, n, o;
        Scanner s = new Scanner(System.in);
        boolean quit=false;
        while(!quit) {
            System.out.println("Factorial of a number. \nChoose the option in which you want to input the number. Enter \n 1.Command Line Arguments\n 2.Scanner class \n 3.Buffered Reader \n 4.Data Input Stream\n 5.Console");
            ch = s.nextInt();
            System.out.println("Enter the number to find factorial ");
            switch (ch)
            {
                case 1:
                    System.out.println("Inputting Number using Command Line Arguments. ");
                    n = Integer.parseInt(args[0]);
                    fact(n);
                    break;
                case 2:
                    System.out.println("Inputting Number using Scanner class. ");
                    n = s.nextInt();
                    fact(n);
                    break;
                case 3:
                    System.out.println("Inputting Number using Buffered Reader. ");
                    InputStreamReader read = new InputStreamReader(System.in);
                    BufferedReader r = new BufferedReader(read);
                    n = Integer.parseInt(r.readLine());
                    fact(n);
                    break;
                case 4:
                    System.out.println("Inputting Number using Data Input Stream. ");
                    InputStream input = new FileInputStream("C:\\Users\\athir\\source.txt");
                    DataInputStream i = new DataInputStream(input);
                    n = Integer.parseInt(i.readLine());
                    fact(n);
                    break;
                case 5:
                    System.out.println("Inputting Number using Console.");
                    n = Integer.parseInt(System.console().readLine());
                    fact(n);
                    break;
                default:
                    System.out.println("Wrong Choice");
            }
            System.out.println("Enter 1 to continue. Else press any other key.");
            o=s.nextInt();
            if(o!=1)
                quit=true;
        }
    }
    public static void fact(int n)
    {
        int f=1;
        if(n<0)
            System.out.println("Invalid number . Factorial of negative cannot be calculated. ");
        else {
            while (n >= 1) {
                f = f * n;
                n--;
            }
            System.out.println("The factorial of the number is : " + f);
        }
    }
}


