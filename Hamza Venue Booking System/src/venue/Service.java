package venue;

abstract public class Service {

    int type;
    int cost;
    int quantity;
    String bno;
    boolean status;

    Service()
    {
        type=0;
        cost=0;
        quantity=0;
        bno=null;
        status=false;
    }
    abstract public void setDetails();
    abstract public int getTotalCost();

}
