package venue;

import java.util.Scanner;

public class Customer {
    int no;
    String name;
    String bookingno;

    int nod,type,ld,d;
    boolean status;

    Customer()
    {
        no=-1;
        name=null;
        bookingno=null;
        nod=type=ld=d=-1;
        status=false;
    }

    public void setInitialDetails(int c)
    {

        no=c;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter name");
        name = in.nextLine();

        System.out.println("Enter Venues type? 1 for Marquee, 2 for Ball Room, 3 for Banquet");
        type = in.nextInt();
        System.out.println("Enter No of Venues? 1/2");
        ld = in.nextInt();
        System.out.println("Enter No of hours?");
        d = in.nextInt();

    }

    public void setBookingNo(String b)
    {
        bookingno=b;
    }


}
