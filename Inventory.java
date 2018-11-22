package MiniInventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory
{
	   private Map<Integer,Item> map = new ConcurrentHashMap<Integer, Item>();
	   
	   private static Inventory inventory = null;
		
		private Inventory(){
			
		}
		
		public static Inventory getInventory(){
			if(inventory == null){
				synchronized (Inventory.class) {
					
					if(inventory == null){
						inventory = new Inventory();
					}
				}
				return inventory;
			}
			return inventory;
		}
		
		public void addItem(Item aInItem){
			
			if(map.containsKey(aInItem.getId())){
				Item lItem = map.get(aInItem.getId());	
				lItem.count = lItem.count +1;
				map.put(lItem.getId(), lItem);
			}
			else
			{
				aInItem.setCount(1);
				map.put(aInItem.getId(), aInItem);
			}
		}
		
		public void deductItem(Item aInItem){
			
			Item lItem = map.get(aInItem.getId());
			lItem.count = lItem.count -1;
			
			map.put(lItem.getId(), lItem);
		}
		
		public boolean hasItem(Item aInItem){
			
			Item lItem = map.get(aInItem.getId());
			if(lItem.count > 0)
				return true;
			return false;
		}
		
		public List<Item> getListOfItemsInInventory(){
			
			List<Item> lOutListOfItemsForReport = null;
			if(lOutListOfItemsForReport == null)
			{
				synchronized(this){
					
					if(lOutListOfItemsForReport == null){
						
						lOutListOfItemsForReport = new ArrayList<Item>();
					}
				}
			}
			
			for(Entry<Integer,Item> entry : map.entrySet()){
				Item lItem = entry.getValue();
				lOutListOfItemsForReport.add(lItem);
			}
			return lOutListOfItemsForReport;
		}
		
		public void reset(){
			map.clear();
		}
}

