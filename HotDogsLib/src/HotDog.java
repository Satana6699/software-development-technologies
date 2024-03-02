public abstract class HotDog {
    static{
        _orderTotalSum = 0;
        _totalOrderAmount = 0;
    }
    public HotDog(String name, int cost){
        _name = name;
        _cost = cost;
    }
    protected String _name;
    protected int _cost;
    protected static int _orderTotalSum;
    protected static int _totalOrderAmount;
    public abstract int Buy(int money);
    public int GetOrderTotalSum(){
        return _orderTotalSum;
    }
    public int GetTotalOrderAmount(){
        return _totalOrderAmount;
    }
}
