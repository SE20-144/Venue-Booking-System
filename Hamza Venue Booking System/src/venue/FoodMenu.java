package venue;
import java.util.Scanner;

public class FoodMenu extends Service{
    FoodMenu()
    {
        super();
    }

    public void setDetails()
    {
        status=true;
        Scanner in = new Scanner(System.in);


        System.out.println("Enter Type of Food Menu(1/2/3)");
        type = in.nextInt();
        System.out.println("Enter Quantity Of Persons");
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
