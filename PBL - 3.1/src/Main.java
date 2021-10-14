import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Main
{
    public static void main(String[] args)
    {
        int ch;
        String n,id,j,s,o;
        float salary;
        Scanner sc = new Scanner(System.in);
        Vector <Employee> emp = new Vector<Employee>();
        System.out.println("Enter\n1.Add employee \n2.Delete Employee \n" +
                "3.Compare two employees (by salary)\n4.Search employee (By Id, Name)\n" +
                "5.Sort by Names\n6.Display all records and total count\n7.Quit");
        boolean quit = false;
        while(!quit)
        {
            System.out.println("Enter your choice");
            ch = sc.nextInt();
            switch (ch)
            {
                case 1:
                    System.out.println("Enter the employee details: ");
                    System.out.print("Name : ");
                    sc.nextLine();
                    n = sc.nextLine();
                    System.out.print("ID : ");
                    id = sc.nextLine();
                    System.out.print("Sex : ");
                    s = sc.nextLine();
                    System.out.print("Salary : ");
                    salary = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Job : ");
                    j = sc.nextLine();
                    System.out.print("Organisation : ");
                    o = sc.nextLine();
                    Employee e = new Employee(id,n,j,s,o,salary);
                    emp.add(e);
                    break;
                case 2:
                    System.out.println("Enter the employee id to be deleted ");
                    String i = sc.next();
                    int check=0;
                    for(int k=0;k< emp.size();k++)
                    {
                        if(emp.get(k).getId().equalsIgnoreCase(i))
                        {
                            emp.remove(k);
                            System.out.println("The given employee details are deleted.");
                            Employee.count --;
                            check=1;
                            break;
                        }
                    }
                    if(check==0)
                        System.out.println("The given id was not found.");
                    break;
                case 3:
                    int p1=-1,p2=-1;

                    System.out.print("Enter the name of first employee to be compared ");
                    sc.nextLine();
                    String n1 = sc.nextLine();
                    System.out.print("Enter the name of second employee to be compared ");
                    String n2 = sc.nextLine();
                    for(int k=0;k<emp.size();k++)
                    {
                        if(emp.get(k).getName().equalsIgnoreCase(n1))
                            p1=k;
                        else if(emp.get(k).getName().equalsIgnoreCase(n2))
                            p2=k;
                    }
                    if(p1==-1)
                    {
                        System.out.println("The name "+n1+" is not in the list");
                        break;
                    }
                    if(p2==-1)
                    {
                        System.out.println("The name "+n2+" is not in the list");
                        break;
                    }
                    if(emp.get(p1).getS()>emp.get(p2).getS())
                        System.out.println(n1+" earns more than "+n2);
                    else if(emp.get(p1).getS()==emp.get(p2).getS())
                        System.out.println("Both the employees earn equal salary");
                    else
                        System.out.println(n2+" earns more than "+n1);
                    break;
                case 4:
                    String srh;
                    int q;
                    System.out.println("Enter \t1.Search by ID \t2.Search by name ");
                    int c = sc.nextInt();
                    switch (c)
                    {
                        case 1:
                            System.out.println("Enter the employee id to be searched ");
                            srh=sc.next();
                            q=0;
                            for(int k=0;k<emp.size();k++)
                            {
                                if(emp.get(k).getId().equalsIgnoreCase(srh))
                                {
                                    System.out.println("The given element is found. The details are ");
                                    emp.get(k).display();
                                    q=1;
                                    break;
                                }
                            }
                            if(q==0)
                                System.out.println("The given record is not found");
                            break;
                        case 2:
                            System.out.println("Enter the employee name to be searched ");
                            sc.nextLine();
                            srh=sc.nextLine();
                            q=0;
                            for(int k=0;k<emp.size();k++)
                            {
                                if(emp.get(k).getName().equalsIgnoreCase(srh))
                                {
                                    System.out.println("The given element is found. The details are ");
                                    emp.get(k).display();
                                    q=1;
                                    break;
                                }
                            }
                            if(q==0)
                                System.out.println("The given record is not found");
                            break;
                        default:
                            System.out.println("Wrong choice");
                    }
                    break;
                case 5:
                    if (emp.size() > 0) {
                        Collections.sort(emp);
                        System.out.println(emp);
                    }
                    else
                        System.out.println("The database is empty.");
                    break;
                case 6:
                    System.out.println("The employee details are : \n");
                    for(int k=0;k<emp.size();k++)
                        emp.get(k).display();
                    System.out.println("\nThe total count of records : "+Employee.getCount());
                    break;
                case 7:
                    sc.close();
                    quit=true;
                    break;
                default :
                    System.out.println("Wrong choice ");
            }
        }
    }
}
