import java.util.*;
import java.util.Collection;

public class FulfillmentCenter {
    private String name;
    private List<Item> listOfItems = new ArrayList<>();
    private double maxMassCapacity;
    private double currentWarehouseMass;

    FulfillmentCenter(String name, double maxMassCapacity){
        this.name = name;
        this.maxMassCapacity = maxMassCapacity;
        this.currentWarehouseMass = 0;
    }

    public void addProduct(Item item){
        if(currentWarehouseMass +(item.getMass()*item.getAmount())> maxMassCapacity) {
            System.err.println("Warehouse has not enough space available to fit that!");
            return;
        }
        currentWarehouseMass += (item.getMass()*item.getAmount());
        for (Item existingItem : listOfItems) {
            if (existingItem.getName().equals(item.getName())) {
                existingItem.setAmount(existingItem.getAmount()+item.getAmount());
                return;
            }
        }
        listOfItems.add(item);
    }

    public void getProduct(Item item){
        boolean exists = false;
        for (Item existingItem : listOfItems) {
            if (existingItem.getName().equals(item.getName())) {
                exists = true;
                if(existingItem.getAmount() == 1){
                    currentWarehouseMass -=item.getMass();
                    listOfItems.remove(item);
                }
                else
                {
                    currentWarehouseMass -=item.getMass();
                    existingItem.setAmount(item.getAmount()-1);
                }
            }
        }
        if (!exists){
            throw new IllegalArgumentException("This item does not exist in warehouse!");
        }
    }

    public void removeProduct(Item item){
        currentWarehouseMass -=item.getMass()*item.getAmount();
        listOfItems.remove(item);
    }

    public Item search(String name){
        Comparator<String> comparator = String::compareTo;
        for(Item item : listOfItems){
            if(comparator.compare(item.getName(), name)==0){
                return item;
            }
        }
        return null;
    }

    public List<Item> searchPartial(String name){
        List<Item> results = new ArrayList<>();
        for(Item existingItem : listOfItems) {
            if (existingItem.getName().contains(name)) {
                existingItem.print();
                results.add(existingItem);
            }
        }
        return results;
    }

    public int countByCondition(ItemCondition temp) {
        int counter = 0;
        for(Item existingItem : listOfItems){
            if (existingItem.getCondition() == temp) {
                counter++;
            }
        }
        return counter;
    }

    public void summary(){
        if (currentWarehouseMass == 0) {
            System.out.println("\n" + this.getName() + " IS EMPTY !!!");
            return;
        }
        System.out.println("\n" + this.getName() + " SUMMARY");
        for (Item existingItem : listOfItems){
            existingItem.print();
        }
    }

    public List<Item> sortByName(){
        List <Item> temp = new ArrayList<>();
        for(int i = 0; i<listOfItems.size(); i++){
            temp.add(listOfItems.get(i));
        }

        Collections.sort(temp);
        for(Item existingItem : temp) {
            existingItem.print();
        }
        return temp;
    }

    public List<Item> sortByAmount(){
        List <Item> temp = new ArrayList<Item>();
        for(int i = 0; i<listOfItems.size(); i++){
            temp.add(listOfItems.get(i));
        }

        Collections.sort(listOfItems, new ComparatorAmount());
        for(Item existingItem : temp) {
            existingItem.print();
        }
        return temp;
    }

    public Item max(){
        return Collections.max(listOfItems, Comparator.comparingInt(Item::getAmount));
    }

    public boolean isEmpty(){
        return listOfItems.isEmpty();
    }

    public String getName() {
        return name;
    }

    public double getMaxMassCapacity() {
        return maxMassCapacity;
    }

    public double getCurrentWarehouseMass() {
        return currentWarehouseMass;
    }
}
