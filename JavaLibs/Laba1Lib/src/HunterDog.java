public class HunterDog extends HotDog {
    public HunterDog(String name, int cost) {
        super(name, cost);
    }

    public int Buy(int money) {
        if (money >= this._cost) {
            money -= this._cost;
            System.out.println("Вы успешно купили Хантер Дог");
            _orderTotalSum += this._cost;
            ++_totalOrderAmount;
        } else {
            System.out.println("У Вас недостаточно средств");
        }

        return money;
    }
}