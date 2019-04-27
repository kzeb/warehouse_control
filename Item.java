public class Item implements Comparable<Item> {
    private String name;
    private ItemCondition condition;
    private double mass;
    private int amount;

    Item(String name, ItemCondition condition, double mass, int amount){
        this.name = name;
        this.condition = condition;
        this.mass = mass;
        this.amount = amount;
    }

    void print(){
        System.out.println("ITEM INFO [ Name: " + name + ", Condition: " + condition + ", Mass: " + mass + ", Amount: " + amount + " ]");
    }

    public String getName() { return name; }
    public ItemCondition getCondition() { return condition; }
    public double getMass() { return mass; }
    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCondition(ItemCondition condition) {
        this.condition = condition;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(Item thing) {
        return name.compareTo(thing.name);
    }
}
