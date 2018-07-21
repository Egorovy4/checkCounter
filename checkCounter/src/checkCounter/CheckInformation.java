package checkCounter;
import java.util.*;

public class CheckInformation {
	private String waiterName;
	private String tableNumber;
	private String clientName;
	private List<String> dishName;
	private List<String> quantityOfDish;
	private List<String> priceOfDish;
		
	void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}
	String getWaiterName() {
		return this.waiterName;
	}
	
	void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}
	String getTableNumber() {
		return this.tableNumber;
	}
	
	void setClientName(String clientName) {
		this.clientName = clientName;
	}
	String getClientName() {
		return this.clientName;
	}
	
	void setDishName(List<String> dishName) {
		this.dishName = dishName;
	}
	List<String> getDishName() {
		return this.dishName;
	}
	
	void setQuantityOfDish(List<String> quantityOfDish) {
		this.quantityOfDish = quantityOfDish;
	}
	List<String> getQuantityOfDish() {
		return this.quantityOfDish;
	}
	
	void setPriceOfDish(List<String> priceOfDish) {
		this.priceOfDish = priceOfDish;
	}
	List<String> getPriceOfDish() {
		return this.priceOfDish;
	}
	
	CheckInformation(String wn, String cn, String tn, List<String> dn, List<String> qod, List<String> pod) {
		setWaiterName(wn);
		setClientName(cn);
		setTableNumber(tn);
		setDishName(dn);
		setQuantityOfDish(qod);
		setPriceOfDish(pod);
	}
}
