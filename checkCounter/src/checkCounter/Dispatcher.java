package checkCounter;
import exceptions.*;

public class Dispatcher {
	public static void main(String[] args) {
		if(args.length < 2) System.out.println("Not all arguments are entered !");
		else {
			FileReading fr = new FileReading();
			try{
				fr.setOrder(" ", fr.readOrder(args[0]));
				Orders[] ordersTemp = fr.getOrder();
				fr.setPrice(" ", fr.readPrice("C:/Users/Іванишин Ігор/workspace/checkCounter/price.txt"));
				Price[] priceTemp = fr.getPrice();
				Calculation c = new Calculation();
				View v = new View();
				//table checking
				for(int i = 0; i < ordersTemp.length; i++) {
					if(ordersTemp[i].getTableNumber().equals(args[1])) {
						break;
					}else{
						if(i == (ordersTemp.length - 1)) {
							throw new IncorrectTableNumber();
						}
					}
				}
				//dish checking
				for(int i = 0; i < ordersTemp.length; i++) {
					for(int k = 0; k < priceTemp.length; k++) {
						if(ordersTemp[i].getDishName().equals(priceTemp[k].getDishName())) {
							break;
						}else{
							if(k == (priceTemp.length - 1)) {
								throw new IncorrectDishName();
							}
						}
					}
				}
				//waiter checking
				for(int i = 0; i < ordersTemp.length; i++) {
					for(int k = 0; k < priceTemp.length; k++) {
						if(ordersTemp[i].getTableNumber().equals(ordersTemp[k].getTableNumber())) {
							if(ordersTemp[i].getWaiterName().equals(ordersTemp[k].getWaiterName())) {
								break;
							}else{
								throw new IncorrectWaiterNameInListOfOrders();
							}
						}
					}
				}
				if(args.length == 2) {
					CheckInformation[] CI = c.calculateForTable(args[1], ordersTemp, priceTemp);
					v.showCheckForTable(CI); 
				}
				if(args.length == 3) {
					//client checking
					for(int i = 0; i < ordersTemp.length; i++) {
						if(ordersTemp[i].getTableNumber().equals(args[1]) && ordersTemp[i].getClientName().equals(args[2])) {
							break;
						}else{
							if(i == (ordersTemp.length - 1)) {
								throw new IncorrectClientName();
							}
						}
					}
					CheckInformation ci = c.calculateForClient(args[1], args[2], ordersTemp, priceTemp);
					v.showCheckForClient(ci);
				}
				if(args.length > 3) System.out.println("Invalid entering !");
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}