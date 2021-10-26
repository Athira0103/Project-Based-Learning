import java.util.ArrayList;
import java.util.Scanner;

public class Cards
{
    private int s,r;
    private String[] suits = { "Diamond","Clubs","Heart","Spade" };
    private String[] ranks = {"","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
    ArrayList<Cards> deck = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Cards() {
    }

    public Cards(int s, int r) {
        this.s = s;
        this.r = r;
    }

    public int getS() {
        return s;
    }

    public int getR() {
        return r;
    }

    public int card_to_suit(String s)
    {
        for (int i = 0; i < 4; i++) {
            if (suits[i].equalsIgnoreCase(s)) {
                this.s = i;
                return this.s;
            }
        }
        return -1;
    }
    public int card_to_rank(String r)
    {
        for(int i=0;i<=13;i++)
        {
            if(ranks[i].equalsIgnoreCase(r))
            {
                this.r = i;
                return this.r;
            }
        }
       return -1;
    }

    public void create_deck()
    {
        int ch;
        System.out.println("Enter \n 1.Create a full deck \n 2.Create a customised deck");
        ch = sc.nextInt();
        switch (ch)
        {
            case 1:
                for(int i=0;i<4;i++)
                {
                    for(int j=1;j<=13;j++)
                    {
                        Cards ob = new Cards (i,j);
                        deck.add(ob);
                    }
                }
                break;
            case 2:
                String c = "y";
                while(c.equalsIgnoreCase("y"))
                {
                    System.out.println("Enter the card (in order of suit and rank) ");
                    String a = sc.next();
                    String b = sc.next();
                    int e = card_to_suit(a);
                    int f = card_to_rank(b);
                    if(e==-1 || f==-1)
                        System.out.println("Invalid card");
                    else
                    {
                        Cards ob = new Cards(e,f);
                        deck.add(ob);
                    }
                    System.out.println("Do you want to add another card to the deck? (y/n) ");
                    c = sc.next();
                }
                break;
            default:
                System.out.println("Wrong choice");
        }
    }

    public void shuffle_deck()
    {
        if(deck.size()>0) {
            for (int i = 0; i < deck.size(); i++) {
                int j = (int) (Math.random() * deck.size());
                Cards temp = deck.get(i); // Swap the cards
                deck.set(i, deck.get(j));
                deck.set(j, temp);
            }
        }
        else
            System.out.println("Empty Deck ");

    }

    public void print_card(int s, int r)
    {
        System.out.println("Card : "+ranks[r]+" of "+suits[s]);
    }

    public void print_deck()
    {
        if(deck.size()>0)
            System.out.println(deck);
        else
            System.out.println("Empty deck.");
    }

    public boolean same_card(Cards ob,Cards obj)
    {

        return obj.r == ob.r
                && obj.s == ob.s;
    }

    public int compare_card()
    {
        System.out.println("Enter the first card (in order of suit and rank in words) ");
        int f = card_to_suit(sc.next());
        String b = sc.next();
        int k = card_to_rank(b);
        if(f==-1 || k==-1)
        {
            System.out.println("Invalid Card");
            return -2;
        }
        Cards obj = new Cards (f,k);
        System.out.println("Enter the second card (in order of suit and rank in words) ");
        int e = card_to_suit(sc.next());
        String d = sc.next();
        int g = card_to_rank(d);
        if(e==-1 || g==-1)
        {
            System.out.println("Invalid Second Card");
            return -2;
        }
        Cards ob = new Cards (e,g);
        if(!same_card(ob,obj))
        {
             if (obj.s < ob.s)
                 return -1;
             else if (obj.s > ob.s)
                 return 1;
             else if (obj.r < ob.r)
                 return -1;
             else
                 return 1;
        }
          return 0;
    }


    public void sort_card() {
        if (deck.size() > 0) {
            ArrayList<Cards> sorted = new ArrayList<>();
            sorted.add(deck.get(0));
            for(int i=1;i<deck.size();i++)
            {
                int check=0;
                for(int j=0;j<i;j++)
                {
                    if(deck.get(i).getS()>sorted.get(j).getS())
                    {
                        sorted.add(j,deck.get(i));
                        check++;
                        break;
                    }
                    else if (deck.get(i).getS()==sorted.get(j).getS())
                    {
                        if(deck.get(i).getR()>sorted.get(j).getR())
                        {
                            sorted.add(j,deck.get(i));
                            check++;
                            break;
                        }
                        else
                        {
                            sorted.add(j+1,deck.get(i));
                            check++;
                            break;
                        }

                    }
                }
                if(check==0)
                    sorted.add(deck.get(i));

            }
            System.out.println(sorted);
        }
        else
            System.out.println("Empty Deck");
    }

    public int find_card()
    {
        System.out.println("Enter the card (in order of suit and rank) ");
        int e = card_to_suit(sc.next());
        String b = sc.next();
        int f = card_to_rank(b);
        if(e==-1 || f==-1)
        {
            System.out.println("Invalid Card");
            return -1;
        }
        for(int i=0;i<deck.size();i++)
        {
            if(deck.get(i).s == e && deck.get(i).r == f)
                return 1;
        }
        return 0;
    }

    public void deal_cards()
    {
        System.out.println("Five random cards are ");
        for(int i=0;i<5;i++)
        {
            int random = (int)(Math.random()*deck.size());
            print_card(deck.get(random).s,deck.get(random).r);
        }
    }

    public void reset() throws InterruptedException
    {
        deck.clear();
        Runtime.getRuntime().gc();
        System.out.println("Garbage collector called.");
    }
    public int getHashCode()      ///test method to check if garbage collector was called,return unique hash code of object
    {
    return deck.get(0).hashCode();
    }

    @Override
    public String toString() {
        return String.format("\n %s - %s", suits[s], ranks[r]);
    }
}

