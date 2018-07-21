package checkCounter;

public class Orders {
	private String waiterName;
	private String clientName;
	private String tableNumber;
	private String dishName;
	
	void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}
	String getWaiterName() {
		return waiterName;
	}
	
	void setClientName(String clientName) {
		this.clientName = clientName;
	}
	String getClientName() {
		return clientName;
	}
	
	void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}
	String getTableNumber() {
		return tableNumber;
	}
	
	void setDishName(String dishName) {
		this.dishName = dishName;
	}
	String getDishName() {
		return dishName;
	}
	
	Orders(String wn, String cn, String tn, String dn) {
		setWaiterName(wn);
		setClientName(cn);
		setTableNumber(tn);
		setDishName(dn);
	}
}
