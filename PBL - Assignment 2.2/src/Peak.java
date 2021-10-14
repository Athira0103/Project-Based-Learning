import java.util.*;
public class Peak
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n,i;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        System.out.println("Enter the number of elements in the array.");
        n=s.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements ");
        for(i=0;i<n;i++)
            a[i]=s.nextInt();
        if(a[0]>a[1])
            arr.add(a[0]);
        for(i=1;i<n-1;i++)
        {
            if(a[i]>a[i-1] && a[i]>a[i+1])
            {
                arr.add(a[i]);
                i++;
            }
        }
        if(a[n-1]>a[n-2])
            arr.add(a[n-1]);
        System.out.println("The peak elements in the given array are :");
        for(i=0;i< arr.size();i++)
            System.out.print(arr.get(i)+"\t");
        s.close();
    }
}
