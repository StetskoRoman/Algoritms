package garbage.expertSoft.enharitance;

public class Building  {

    public static void main(String[] args) throws Exception {

//        Building b1 = new Shop();
        Building b1 = new Building();
        Building b2 = new Warehouse();

//        Warehouse w1 = b2;
        Warehouse w2 = (Warehouse) b2;
//        Warehouse w3 = new SportShop();
//        Shop s1 = (Shop) b1;  //CLASS cast exception - можно было бы Shop s1 = (Shop) b1 если бы   Building b1 = new Shop();
        Shop s2 = new SportShop();

    }
}
