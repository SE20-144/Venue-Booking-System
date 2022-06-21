package venue;


import java.util.Scanner;

public class Book {
    String bookno;
    Vallet t[][][];
    FoodMenu l[][][];
    int ff;
    Customer cust;
    int s1=0,s2=0;


    public String getBookingNumber()
    {
        return bookno;
    }

    public void BookNew(Customer c,Marquee ly,BallRoom dx,Banquet sdx,Vallet tr[][][],FoodMenu lr[][][],
                        int ily,int flag1,int idx,int flag2,int isdx,int flag3)

    {
        cust=c;
        Fare f=new Fare();
        int no,i;

        t=tr;
        l=lr;

        if(c.type==1)
        {
            if(flag1==0)
            {
                System.out.println("No Marquee Available, Sorry!");
                Scanner in5=new Scanner(System.in);

                System.out.println("Do you want any other Venue? Ball Room(2) or Banquet(3) ");
                int g=in5.nextInt();

                if(g==2)
                    BookBallRoom(c,dx,g,idx,c.ld,c.d);
                if(g==3)
                    BookBanquet(c,sdx,g,isdx,c.ld,c.d);
            }
            if(flag1==1)
                BookMarquee(c,ly,c.type,ily,c.ld,c.d);
        }
        if(c.type==2)
        {
            if(flag2==0)
            {
                System.out.println("No Ball Room Available, Sorry!");
                Scanner in6=new Scanner(System.in);

                System.out.println("Do you want any other Venue? Marquee(1) or Banquet(3) ");
                int g=in6.nextInt();

                if(g==2)
                    BookMarquee(c,ly,g,ily,c.ld,c.d);
                if(g==3)
                    BookBanquet(c,sdx,g,isdx,c.ld,c.d);
            }


            if(flag2==1)
                BookBallRoom(c,dx,c.type,idx,c.ld,c.d);
        }


        if(c.type==3)
        {
            if(flag3==0)
            {
                System.out.println("No Banquet Room Available, Sorry!");
                Scanner in5=new Scanner(System.in);

                System.out.println("Do you want any other Venue? Ball Room(2) or Marquee(3) ");
                int g=in5.nextInt();

                if(g==2)
                    BookBallRoom(c,dx,g,idx,c.ld,c.d);
                if(g==1)
                    BookMarquee(c,ly,g,ily,c.ld,c.d);
            }

            if(flag3==1)
                BookBanquet(c,sdx,c.type,isdx,c.ld,c.d);
        }


    }



    public void BookMarquee(Customer c,Marquee ly,int type,int ily,int ld,int d)
    {
        Fare f=new Fare();
        ly.statuschange();

        if(ld==1)
        {
            System.out.println("Single Marquee Venue is Booked");
            ff= f.farecalculator(d,ly.rate,ld);
            bookno=ily+"m1";
            BookDisplay(ff,c.name,t[ily][0][0].getTotalCost(),l[ily][0][1].getTotalCost(),bookno);

        }
        if(ld==2)
        {
            System.out.println("Double Marquee Venue is Booked");
            ff= f.farecalculator(d,ly.rate,ld);
            bookno=ily+"m2";
            BookDisplay(ff,c.name,t[ily][1][0].getTotalCost(),l[ily][1][1].getTotalCost(),bookno);
        }


    }

    public void BookBallRoom(Customer c,BallRoom dx,int type,int idx,int ld,int d)
    {
        dx.statuschange();
        Fare f=new Fare();

        if(ld==1)
        {
            System.out.println("Single Ball Room Venue is booked");
            ff= f.farecalculator(d,dx.rate,ld);
            bookno=idx+"br1";
            BookDisplay(ff,c.name,t[idx][0][0].getTotalCost(),l[idx][0][1].getTotalCost(),bookno);
        }
        if(ld==2)
        {
            System.out.println("Double Ball Room Venue is booked");
            ff= f.farecalculator(d,dx.rate,ld);
            bookno=idx+"br2";
            BookDisplay(ff,c.name,t[idx][1][0].getTotalCost(),l[idx][1][1].getTotalCost(),bookno);
        }


    }

    public void BookBanquet(Customer c,Banquet sdx,int type,int isdx,int ld,int d)
    {
        Fare f=new Fare();

        sdx.statuschange();

        if(ld==1)
        {
            System.out.println("Single Banquet Venue is Booked");
            ff= f.farecalculator(d,sdx.rate,ld);
            bookno=isdx+"b1";
            BookDisplay(ff,c.name,t[isdx][0][0].getTotalCost(),l[isdx][0][1].getTotalCost(),bookno);

        }
        if(ld==2)
        {
            System.out.println("Double Banquet Venue is Booked");
            ff= f.farecalculator(d,sdx.rate,ld);
            bookno=isdx+"b2";
            BookDisplay(ff,c.name,t[isdx][1][0].getTotalCost(),l[isdx][1][1].getTotalCost(),bookno);

        }


    }
    public void BookDisplay(int ff,String name,int tr,int lr,String b)
    {
        System.out.println("Booking Number: "+bookno);

        System.out.println("Customer Number: "+cust.no);

        System.out.println("Booking Name: "+name);

        System.out.println("Fare is: "+ ff);

        System.out.println("Total cost of Vallet is: "+tr);

        System.out.println("Total cost of Food is: "+lr);
    }


}