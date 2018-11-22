package MiniInventoryManagementSystem;

public enum Item {
	Pen(1,"pen",10,0),Book(2,"book",50,0),Scale(3,"scale",20,0);
	
	private Integer id;
	private String name;
	private int price;
	int count;
	
	Item(Integer aInId ,String aInName,int aInPrice,int aInCount){
		this.id = aInId;
		this.name = aInName;
		this.price = aInPrice;
		this.count = aInCount;
	}
	
	public Integer getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPrice(){
		return price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
