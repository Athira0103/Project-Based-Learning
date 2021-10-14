import java.util.*;
public class Arrays
{
    public static void main(String[] args)
    {
        int n,ch;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array. ");
        n = s.nextInt();
        int[] a = new int[n];
        ArrayList<Integer> arr = new ArrayList<Integer>();
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++)
        {
            ch=0;
            a[i]=s.nextInt();
            for(int j=0;j<i;j++)
            {
                if(a[j]==a[i])
                {
                    ch=1;
                    break;
                }
            }
            if(ch!=1)
                arr.add(a[i]);
        }
        System.out.println("The new length of the array is :"+arr.size());
        System.out.println("The revised array without repeated elements : ");
        for(int i=0;i<arr.size();i++)
            System.out.print(arr.get(i)+"\t");
        s.close();
    }
}
