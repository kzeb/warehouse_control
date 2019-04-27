import java.util.*;
import java.util.stream.Collectors;

public class FulfillmentCenterContainer {
    private Map<String, FulfillmentCenter> warehouseList = new TreeMap<>();

    public FulfillmentCenter addCenter(String name, double capacity){
        warehouseList.put(name, new FulfillmentCenter(name, capacity));
        return warehouseList.get(name);
    }

    public void removeCenter(String name){
        if(warehouseList.containsKey(name)) {
            warehouseList.remove(name);
        }
        else {
            System.out.println("\nWarehouse named " + name + " does not exist!");
        }
    }

    public List<FulfillmentCenter> findEmpty() {
        List <FulfillmentCenter> listFulfillmentCenter = warehouseList.values().stream().filter(FulfillmentCenter::isEmpty).collect(Collectors.toList());
        for(FulfillmentCenter existingCenter : listFulfillmentCenter) {
            existingCenter.summary();
        }
        return listFulfillmentCenter;
    }

    public void summary(){
        Collection<FulfillmentCenter> mapValues = warehouseList.values();
        System.out.println("\nContainer SUMMARY:");
        for (FulfillmentCenter x : mapValues){
            double percent = (x.getCurrentWarehouseMass()*100)/x.getMaxMassCapacity();
            System.out.println("WAREHOUSE INFO [ Name: " + x.getName() + ", Filled in " + percent + " %, Mass: " + x.getCurrentWarehouseMass() + "/" + x.getMaxMassCapacity() + " ]");
        }
    }

    public FulfillmentCenter getFulfillmentCenter(String name){
        return warehouseList.get(name);
    }
}
