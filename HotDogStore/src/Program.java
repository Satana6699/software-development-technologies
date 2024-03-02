public class Program {
    public static void main(String[] args){
        Berlinka berlinka = new Berlinka("Berlinka", 12);
        HunterDog hunterDog = new HunterDog("HunterDog", 10);
        MasterDog masterDog = new MasterDog("MasterDog", 15);
        HotDog[] hotDogs = new HotDog[]{berlinka, hunterDog, masterDog};

        String assortiment = "";
        for (HotDog hotDog : hotDogs) {
            assortiment += hotDog._name + "\t";
        }
        System.out.println("В ассортименте: " + assortiment);


        int money = 50;
        money = berlinka.Buy(money); //money = 38 Успешная покупка
        money = hunterDog.Buy(money); //money = 28 Успешная покупка
        money = masterDog.Buy(money); //money = 13 Успешная покупка
        money = masterDog.Buy(money); //money = 13 Недостаточно средств
        System.out.println("\nmoney = " + money);
        System.out.println("Общее кол-во заказов = " + berlinka.GetTotalOrderAmount());
        System.out.println("Общая сумма заказов = " + berlinka.GetOrderTotalSum());
        System.out.println("Средняя сумма заказов = " + berlinka.GetOrderTotalSum()/(float)berlinka.GetTotalOrderAmount());

    }
}
