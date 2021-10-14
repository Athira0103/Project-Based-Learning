import java.util.*;
import java.lang.*;
public class SmallDiff
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n,i;
        System.out.println("Enter the number of elements in the array.");
        n = s.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements ");
        for (i = 0; i < n; i++)
            a[i] = s.nextInt();
        System.out.println("The required index is : "+gap(a,n));
        s.close();
    }
    public static int gap(int[] a,int n)
    {
        int min, pos, i;
        min= Math.abs(a[1]-a[0]);
        pos=0;
        for(i=1;i<n-1;i++)
        {
            if(min> Math.abs(a[i]-a[i+1]))
            {
                min=Math.abs(a[i]-a[i+1]);
                pos=i;
            }
        }
        System.out.println("The neighbouring elements with the least distance are : "+a[pos]+" "+a[pos+1]);
        return(pos);
    }
}
