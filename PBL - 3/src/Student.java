import java.util.Scanner;
public class Student
{
    float[] m;
    float t;
    long prn;
    String name;
    DOB date;

    public Student(float[] ma, long prn, String name, int d, int mo, int y) {
        this.m = ma;
        this.prn = prn;
        this.name = name;
        this.date = new DOB (d,mo,y);
    }
    public float calc_total()
    {
        t=0;
        for(int i=0;i<5;i++)
          t+=m[i];
        t/=5;
        return t;
    }
    public void display()
    {
        System.out.println("\nName : "+name+"\nPRN : "+prn+"\nTotal Marks : "+t);
        System.out.println("DOB : "+date.d+"/"+date.mo+"/"+date.y);
    }
    public void update()
    {
        Scanner sca = new Scanner(System.in);
        System.out.println("Do you want to update name? (y/n)");
        String a = sca.next();
        if(a.equalsIgnoreCase("y"))
        {
            System.out.println("Enter the new name :");
            name = sca.next();
            System.out.println("The student name is updated.");
        }
        System.out.println("Do you want to update marks? (y/n)");
        a = sca.next();
        if(a.equalsIgnoreCase("y"))
        {
            System.out.println("Enter the new set of marks :");
            for(int i=0;i<5;i++)
                m[i]=sca.nextInt();
            System.out.println("The student marks are updated.");
            t=calc_total();
            sca.close();
        }
    }
}
