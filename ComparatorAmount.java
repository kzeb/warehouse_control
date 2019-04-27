import java.util.Comparator;
public class ComparatorAmount implements Comparator<Item>{
    @Override
    public int compare(Item temp1, Item temp2){
        int amount = temp2.getAmount()-temp1.getAmount();
        if(amount==0){
            return temp2.compareTo(temp1);
        }
        return amount;
    }
}
