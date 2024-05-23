public class Berlinka extends HotDog {
    public Berlinka(String name, int cost) {
        super(name, cost);
    }

    public int Buy(int money) {
        if (money >= this._cost) {
            money -= this._cost;
            System.out.println("Вы успешно купили Берлинку");
            _orderTotalSum += this._cost;
            ++_totalOrderAmount;
        } else {
            System.out.println("У Вас недостаточно средств");
        }

        return money;
    }
}