import java.util.Scanner;
public class Find
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[10];
        int i,n,min,res=0,check=0;
        System.out.println("Enter the number of elements in the array. ");
        n=s.nextInt();
        System.out.println("Enter the numbers.");
        for(i=0;i<n;i++)
            arr[i]=s.nextInt();
        if(arr[0]>arr[1])
        {
            min=arr[1];
            res=arr[0];
            check++;
        }
        else if(arr[0]==arr[1])
        {
            min=arr[0];
            for(i=2;i<n;i++)
            {
                if(arr[i]!=arr[0])
                {
                    res=arr[i];
                    check++;
                    break;
                }
            }
        }
        else
        {
            min=arr[0];
            res=arr[1];
            check++;
        }
        if(check==0)
            System.out.println("All numbers are equal and there is no second smallest number. ");
        else
        {
            for(i=2;i<n;i++)
            {
                if(arr[i]<res && arr[i]>min)
                    res=arr[i];
                else if(arr[i]<min)
                {
                    res=min;
                    min=arr[i];
                }
            }
            System.out.println("The second smallest number in the given array is: "+res);
        }
    }
}
