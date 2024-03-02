public class HunterDog extends HotDog{
    public HunterDog(String name, int cost) {
        super(name, cost);
    }

    @Override
    public int Buy(int money) {
        if(money >= _cost){
            money -= _cost;
            System.out.println("Вы успешно купили Хантер Дог");
            _orderTotalSum += _cost;
            _totalOrderAmount ++;
        }
        else
            System.out.println("У Вас недостаточно средств");
        return money;
    }
}
