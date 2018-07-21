package checkCounter;

public class Price {
	private String dishName;
	private int dishPrice;
	
	void setDishName(String dishName) {
		this.dishName = dishName;
	}
	String getDishName() {
		return dishName;
	}
	
	void setDishPrice(int dishPrice) {
		this.dishPrice = dishPrice;
	}
	int getDishPrice() {
		return dishPrice;
	}
	
	Price(String dn, int dp) {
		setDishName(dn);
		setDishPrice(dp);
	}
	
	public String toString() {
		return dishName + " " + dishPrice;
	}
}
