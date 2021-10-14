package com.company;
import java.util.Scanner;
public class Calculator
{
    int c=0,i;
    String n=" ";
    double v,result = 0.0;
    double[] m = new double[10];
    Scanner s = new Scanner(System.in);
    public void sum()
    {
        System.out.println("Enter the number of terms");
        c=s.nextInt();
        System.out.println("Enter the numbers");
        for(i=1;i<=c;i++)
            result+=s.nextDouble();
        System.out.println("The result of addition is "+result);
    }
    public void diff(float a,float b)
    {
        result=a-b;
        System.out.println("The result of subtraction is "+result);
    }
    public void product()
    {
        result=1;
        System.out.println("Enter the number of terms");
        c=s.nextInt();
        System.out.println("Enter the numbers");
        for(i=1;i<=c;i++)
            result*=s.nextDouble();
        System.out.println("The result of multiplication is "+result);
    }
    public void quo(float a,float b)
    {
        result=a/b;
        System.out.println("The result of division is "+result);
    }
    public void sr(float a)
    {
        result = Math.sqrt(a);
        System.out.println("The square root is "+result);
    }
    public void pow(float a,float b)
    {
        result = Math.pow(a,b);
        System.out.println("The result is "+result);
    }
    public double mean()
    {
        System.out.println("Enter the numbers");
        for(i=0;;)
        {
            n=s.nextLine();
            if(!("end".equalsIgnoreCase(n)))
            {
                m[i]=Double.parseDouble(n);
                result+=m[i];
                i++;
            }
            else
                break;
        }
        System.out.println("The mean of given numbers is "+result/i);
        return(result/i);
    }
    public void variance()
    {
        v=mean();
        result=0.0;
        for(c=0;c<i;c++)
            result+= Math.pow(v-m[c],2);
        System.out.println("The variance of given numbers is "+result/i);
    }
}
