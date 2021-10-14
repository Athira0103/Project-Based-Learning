import java.util.*;
public class Main
{
public static void main(String[] args)
{
    int ch,d,mo,y,i;
    long p;
    float[] m=new float[5];
    String n;

    Scanner sc = new Scanner(System.in);
    ArrayList<Student> list = new ArrayList<>();
    System.out.println("Enter\n1.Add Student\n2.Display the list\n3.Search by prn\n4.Search by name\n5.Search by position\n6.Update/Edit\n7.Delete\n8.Display sorted list\n9.Display the number of students in different mark range\n10.Exit");
    boolean quit = false;
    while(!quit)
    {
        System.out.println("Enter your choice ");
        ch=sc.nextInt();
        switch (ch) {
            case 1:
                System.out.print("Enter the student details: \nName: ");
                n = sc.next();
                System.out.print("PRN: ");
                p = sc.nextLong();
                for(int k=0;k< list.size();k++)
                {
                    if(list.get(k).prn==p)
                    {
                        System.out.println("PRN already exists ");
                        break;
                    }
                }
                System.out.print("Marks of 5 subjects (out of 100): ");
                for (i = 0; i < 5; i++)
                    m[i] = sc.nextFloat();
                System.out.print("DOB in the order - day,month,year : ");
                d = sc.nextInt();
                mo = sc.nextInt();
                y = sc.nextInt();
                Student ob = new Student(m, p, n, d, mo, y);
                ob.calc_total();
                list.add(ob);
                break;
            case 2:
                System.out.println("The list of students and their details is :");
                for (i = 0; i < list.size(); i++)
                    list.get(i).display();
                break;
            case 3:
                System.out.println("Enter the prn to be searched ");
                long s = sc.nextLong();
                int check = 0;
                for (i = 0; i < list.size(); i++) {
                    if (list.get(i).prn == s) {
                        System.out.println("The searched student details are : ");
                        list.get(i).display();
                        check = 1;
                        break;
                    }
                }
                if (check == 0)
                    System.out.println("The searched item was not found in the list.");
                break;
            case 4:
                System.out.println("Enter the name to be searched ");
                String st = sc.next();
                int che = 0;
                for (i = 0; i < list.size(); i++) {
                    if (list.get(i).name.equalsIgnoreCase(st)) {
                        System.out.println("The searched student details are : ");
                        list.get(i).display();
                        che = 1;
                    }
                }
                if (che == 0)
                    System.out.println("The searched item was not found in the list.");
                break;
            case 5:
                System.out.println("Enter the position to be searched (Positions starting from 1)");
                int f = sc.nextInt();
                f--;
                if(f< list.size())
                {
                    System.out.println("The searched student details are : ");
                    list.get(f).display();
                }
                else
                    System.out.println("The list doesn't have position "+f+1);
                break;
            case 6:
                System.out.println("Enter the prn of the student to update details ");
                long no = sc.nextLong();
                int q = 0;
                for (i = 0; i < list.size(); i++)
                {
                    if (list.get(i).prn == no)
                    {
                        list.get(i).update();
                        System.out.println("The updated student details are : ");
                        list.get(i).display();
                        q = 1;
                        break;
                    }
                }
                if (q == 0)
                    System.out.println("There is no student with the given prn in the list.");
                break;
            case 7:
                System.out.println("Enter the prn of the student to delete ");
                long nu = sc.nextLong();
                int r = 0;
                for (i = 0; i < list.size(); i++) {
                    if (list.get(i).prn == nu) {
                        list.remove(i);
                        System.out.println("The student details are deleted");
                        r = 1;
                        break;
                    }
                }
                if (r == 0)
                    System.out.println("There is no student with the given prn in the list.");
                break;
            case 8:
                System.out.println("The sorted list is: ");
                Collections.sort(list, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2)
                    {
                        if(o1.t==o2.t)
                            return 0;
                        else if(o1.t>o2.t)
                            return -1;
                        else
                            return 1;
                    }
                });
                Iterator itr=list.iterator();
                while(itr.hasNext()){
                    Student stu =(Student)itr.next();
                    System.out.println(stu.name + " :\t"+stu.t);
                }
                break;
            case 9:
                int[] count = new int[4];
                for (i = 0; i < list.size(); i++) {
                    if (list.get(i).t > 80)
                        count[0]++;
                    else if (list.get(i).t > 60)
                        count[1]++;
                    else if (list.get(i).t > 40)
                        count[2]++;
                    else
                        count[3]++;
                }
                System.out.println("The number of students in the range : \nA (81-100) \t" + count[0]);
                System.out.println("B (61-80) \t" + count[1] + "\nC (41-60) \t" + count[2] + "\nF (Failed) \t" + count[3]);
                break;
            case 10:
                quit= true;
                sc.close();
                break;
            default:
                System.out.println("Wrong choice");
        }
    }
}
}
