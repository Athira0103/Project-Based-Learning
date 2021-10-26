import java.util.Scanner;

public class Game
{
    public static void main(String[] args)throws InterruptedException
    {
        int ch;
        Scanner sc = new Scanner(System.in);
        Cards c = new Cards();
        System.out.println("Enter\n1.Create Deck \n2.Print deck \n" +
                "3.Deal cards\n4.Shuffle Cards\n5.Compare cards\n" +
                "6.Sort Cards\n7.Find Card\n8.Restart game\n9.Exit");
        boolean quit = false;
        while (!quit)
        {
            System.out.println("Enter your choice");
            ch = sc.nextInt();
            switch (ch)
            {
                case 1:
                    c.create_deck();
                    break;
                case 2:
                    c.print_deck();
                    break;
                case 3:
                    c.deal_cards();
                    break;
                case 4:
                    c.shuffle_deck();
                    System.out.println("The shuffled deck is: ");
                    c.print_deck();
                    break;
                case 5:
                    int res = c.compare_card();
                    if(res==-1)
                        System.out.println("Second Card is greater than first");
                    else if (res==1)
                        System.out.println("First Card is greater than second");
                    else if(res==0)
                        System.out.println("Both cards are equal");
                    break;
                case 6:
                    c.sort_card();
                    break;
                case 7:
                    int k = c.find_card();
                    if(k==0)
                        System.out.println("The card was not found in the deck.");
                    else if(k==1)
                        System.out.println("The card was found in the deck.");
                    break;
                case 8:
                    System.out.println("Unique id of first object of card before calling garbage collector: " + c.getHashCode());
                    c.reset();
                    c.create_deck();
                    System.out.println("Unique id of first object of card after calling garbage collector: " + c.getHashCode());
                    break;
                case 9:
                    sc.close();
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

}