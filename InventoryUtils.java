package MiniInventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryUtils {
	
	static Inventory inventory = Inventory.getInventory();
	
	public InventoryUtils(){
		
	}
	
	public static void upddateStock(List<Item> aInListOfItem){
		
		for(Item item:aInListOfItem){
			inventory.addItem(item);
		}
	}
	
	public static synchronized List<Item> checkOutItem(List<Item> aInListOfItem)
	{	
		ArrayList<Item> lOutListOfItems = new ArrayList<Item>();	
		
		for(Item item:aInListOfItem){
		
			if(inventory.hasItem(item)){
				inventory.deductItem(item);
				lOutListOfItems.add(item);
			}
		}
		return lOutListOfItems;
	}
	
	public static void generateReport(){
		
		List<Item> lList = inventory.getListOfItemsInInventory();
		
		for(Item lItem: lList){
			System.out.println(lItem.getId()+" "+lItem.getName() +" "+lItem.getPrice()+" "+lItem.getCount());
		}
	}
}
