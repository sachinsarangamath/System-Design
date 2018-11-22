package MiniInventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class ClientLogic {
	
	public static void main(String args[]){
		
		List<Item> lList = new ArrayList<Item>();
		
		lList.add(Item.Pen);
		lList.add(Item.Pen);
		lList.add(Item.Pen);
		
		lList.add(Item.Book);
		lList.add(Item.Book);
		lList.add(Item.Book);
		
		lList.add(Item.Scale);
		lList.add(Item.Scale);
		
		InventoryUtils.upddateStock(lList);
		
		InventoryUtils.generateReport();
		
		List<Item> lListCheckedOut = new ArrayList<Item>();
		lListCheckedOut.add(Item.Book);
		lListCheckedOut.add(Item.Pen);
		lListCheckedOut.add(Item.Scale);
		InventoryUtils.checkOutItem(lListCheckedOut);
		
		InventoryUtils.generateReport();
	}
}
