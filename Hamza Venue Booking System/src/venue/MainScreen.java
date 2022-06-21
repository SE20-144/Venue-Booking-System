package venue;

import java.util.Scanner;

public class MainScreen {

    public static void main(String args[])
    {
        char ch='y';

        Marquee[] ly = new Marquee[3];
        BallRoom[] dx = new BallRoom[8];
        Banquet[] sdx= new Banquet[10];
        Customer c[] = new Customer[20];
        FoodMenu l[][][]=new FoodMenu[20][5][5];
        Vallet t[][][]=new Vallet[20][5][5];
        Book b[]=new Book[20];

        int i=0,j,k;

        try {

            for(i=0;i<3;i++)
            {
                ly[i]=new Marquee();
                ly[i].set(500,false,false);
            }
            for(i=0;i<8;i++)
            {
                dx[i]=new BallRoom();
                dx[i].set(1500,true,false);
            }
            for(i=0;i<10;i++)
            {
                sdx[i]=new Banquet();
                sdx[i].set(2500,true,false);
            }

            for(i=0;i<20;i++)
            {
                c[i]=new Customer();
            }

            for(i=0;i<20;i++)
            {
                b[i]=new Book();
            }

            for(i=0;i<20;i++)
            {
                for(j=0;j<5;j++)
                {
                    for(k=0;k<5;k++)
                    {
                        t[i][j][k]=new Vallet();
                        l[i][j][k]=new FoodMenu();

                    }
                }
            }
        }catch(Exception e) {
            System.out.print(e);
        }


        String no;
        int ic=0,ily=0,ilr=0,itr1=0,itr2=0,isdx=0,idx=0;

        int flag1=0,flag2=0,flag3=0;


        while(true)
        {
            try {

                System.out.println("What do you want to do?");
                System.out.println("For Book a Venues, Press b");
                System.out.println("For Avail a Service, Press s");
                System.out.println("For Cancel a Booked Venues, Press c");
                System.out.println("Exit Menu, Press e");
                Scanner in = new Scanner(System.in);
                ch = in.next(".").charAt(0);

                if(ch=='b')
                {

                    for(i=0;i<3;i++)
                    {
                        if(ly[i].getStatus()==false)
                        {
                            ily=i;
                            flag1=1;
                            break;
                        }
                        else
                            flag1=0;
                    }

                    for(i=0;i<8;i++)
                    {
                        if(dx[i].getStatus()==false)
                        {
                            idx=i;
                            flag2=1;
                            break;
                        }
                        else
                            flag2=0;
                    }

                    for(i=0;i<10;i++)
                    {
                        if(sdx[i].getStatus()==false)
                        {
                            isdx=i;
                            flag3=1;
                            break;
                        }
                        else
                            flag3=0;
                    }
                    c[ic].setInitialDetails(ic);
                    b[ic].BookNew(c[ic],ly[ily],dx[idx],sdx[isdx],t,l,ily,flag1,idx,flag2,isdx,flag3);
                    c[ic].setBookingNo(b[ic].getBookingNumber());
                    ic++;
                }

                if(ch=='c')
                {
                    ic--;
                    Scanner in2 = new Scanner(System.in);
                    System.out.println("Enter your Booking No: ");
                    no = in2.nextLine();

                    int no1=(int)no.charAt(0)-48;
                    int no2;

                    System.out.println("Enter Venue Type (1-Marquee,2-Ball Room,3-Banquet)");
                    no2= in2.nextInt();

                    if(no2==1)
                    {
                        ly[no1].statuschange();

                    }
                    if(no2==2)
                    {
                        dx[no1].statuschange();

                    }
                    if(no2==3)
                    {
                        sdx[no1].statuschange();
                    }

                    System.out.println("Cancelled Successfully");

                }

                int cno;

                if(ch=='s')
                {
                    Scanner in2 = new Scanner(System.in);

                    System.out.println("Enter your Booking No:");
                    no = in2.nextLine();

                    System.out.println("Enter your Customer No: ");
                    cno = in2.nextInt();

                    System.out.println("Enter the Service Required (Valet(1)/FoodMenu(2))");

                    int a = in2.nextInt();

                    itr1 = (int)(no.charAt(0))-48;

                    if(no.charAt(1)=='s')
                        itr2= (int)(no.charAt(4))-48;
                    else
                        itr2= (int)(no.charAt(3))-48;

                    if(a==1)
                    {
                        t[itr1][itr2][0].setDetails();
                        b[cno].s1=b[cno].s1+(t[itr1][itr2][0].getTotalCost());
                        b[cno].BookDisplay(b[cno].ff,c[cno].name,b[cno].s1,b[cno].s2,no);
                    }
                    if(a==2)
                    {
                        l[itr1][itr2][1].setDetails();
                        b[cno].s2=b[cno].s2+l[itr1][itr2][1].getTotalCost();
                        b[cno].BookDisplay(b[cno].ff,c[cno].name,b[cno].s1,b[cno].s2,no);
                    }
                }
                if(ch=='e')
                    break;
            }catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}
