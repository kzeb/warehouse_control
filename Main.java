public class Main {
    public static void main(String[] args) {
        FulfillmentCenterContainer Container= new FulfillmentCenterContainer();

        FulfillmentCenter Warehouse1 = Container.addCenter("Warehouse1", 2000);
        FulfillmentCenter Warehouse2 = Container.addCenter("Warehouse2", 1200);
        FulfillmentCenter Warehouse3 = Container.addCenter("Warehouse3", 1200);

        Item iPhone = new Item("iPhone", ItemCondition.NEW, 5, 35);
        Item iPad = new Item("iPad", ItemCondition.REFURBISHED, 10, 15);

        Warehouse1.addProduct(iPhone);
        Warehouse1.addProduct(iPad);
        Warehouse2.addProduct(iPhone);

        Container.summary();
        Warehouse1.summary();

//        Warehouse1.getProduct(iPhone);
//        Warehouse1.summary();
//
//        Container.summary();
//        Warehouse1.addProduct(iPad);
//        Warehouse1.summary();
//        Container.summary();
//
//        Warehouse1.getProduct(iPhone);
//        Warehouse1.summary();
//
//        Container.removeCenter("Warehouse2");
//        Container.removeCenter("Warehouse4");
//
//        Container.findEmpty();
    }
}