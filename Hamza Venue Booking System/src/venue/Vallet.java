package venue;

import java.util.Scanner;

public class Vallet extends Service{

    Vallet()
    {
        super();
    }

    public void setDetails()
    {
        Scanner in = new Scanner(System.in);


        System.out.println("Enter Type of Vallet(1/2/3)");
        type = in.nextInt();
        System.out.println("Enter Number of Cars(1/2)");
        quantity = in.nextInt();

        if(type==1)
            cost=100;
        else
        {
            if(type==2)
                cost=200;
            else
            {
                if(type==3)
                    cost=300;
                else
                    cost=0;
            }
        }
    }

    public int getTotalCost()
    {
        return quantity*cost;
    }

    public boolean getStatus()
    {
        return status;
    }
}
