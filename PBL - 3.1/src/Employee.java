public class Employee implements Comparable<Employee>
{
    private String id, name,job,sex, org ;
    private float s;
    public static int count =0;

    public Employee(String id, String name, String job, String sex, String org,float salary) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.sex = sex;
        this.org = org;
        this.s = salary;
        count++;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getS() {
        return s;
    }

    public static int getCount() {
        return count;
    }

    public void display ()
    {
        System.out.println("\nName : "+name+"\nEmployee ID : "+id+"\nSex : "+sex);
        System.out.println("Job : "+job+"\nSalary :"+s+"\nOrganisation :"+org);
    }
    @Override
    public int compareTo(Employee ob) {
        int compare = (this.name).compareTo(ob.name);
        if (compare == 0)
            compare = (this.id).compareTo(ob.id);
        return compare;
    }

    @Override
    public String toString() {
        return String.format("\nID: %s\nSalary: %f\nName: %s\n", id, s, name);
    }

  }


