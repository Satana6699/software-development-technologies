public abstract class HotDog {
    protected String _name;
    protected int _cost;
    protected static int _orderTotalSum = 0;
    protected static int _totalOrderAmount = 0;

    public HotDog(String name, int cost) {
        this._name = name;
        this._cost = cost;
    }

    public abstract int Buy(int var1);

    public int GetOrderTotalSum() {
        return _orderTotalSum;
    }

    public int GetTotalOrderAmount() {
        return _totalOrderAmount;
    }

    @Override
    public String toString() {
        return _name + " (Cost: " + _cost + ")";
    }
}
