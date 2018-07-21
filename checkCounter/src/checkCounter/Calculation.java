package checkCounter;

import java.util.*;

public class Calculation {
	CheckInformation calculateForClient(String tableNumber, String clientName, Orders[] ordersTemp, Price[] priceTemp) {
		CheckInformation ci = new CheckInformation(null, null, null, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
		
		ci.setTableNumber(tableNumber);
		ci.setClientName(clientName);
	
		for(int i = 0; i < ordersTemp.length; i++) {
			if( tableNumber.equals(ordersTemp[i].getTableNumber()) && clientName.equals(ordersTemp[i].getClientName()) ) {
				ci.setWaiterName(ordersTemp[i].getWaiterName());
				if(ci.getDishName().contains(ordersTemp[i].getDishName())) {			 
					int index = ci.getDishName().indexOf(ordersTemp[i].getDishName()); 
					int tempQuantity = Integer.parseInt(ci.getQuantityOfDish().get(index));	 
					ci.getQuantityOfDish().remove(index);						 
					tempQuantity++;											 
					ci.getQuantityOfDish().add(index, Integer.toString(tempQuantity));				 
				}else{
					ci.getDishName().add(ordersTemp[i].getDishName());
					ci.getQuantityOfDish().add("1");
					for(int x = 0; x < priceTemp.length; x++) {
						if(ordersTemp[i].getDishName().equals(priceTemp[x].getDishName())) {
							ci.getPriceOfDish().add(Integer.toString(priceTemp[x].getDishPrice()));
							break;
						}
					}
				}
			}
		}
		return ci;
	}
		
	CheckInformation[] calculateForTable(String tableNumber, Orders[] ordersTemp, Price[] priceTemp) {
		List<String> clients = new ArrayList<String>();
		for(int i = 0; i < ordersTemp.length; i++) {
			if(clients.contains(ordersTemp[i].getClientName()) == false && ordersTemp[i].getTableNumber().equals(tableNumber)) {
				clients.add(ordersTemp[i].getClientName());
			}
		}
		
		CheckInformation[] CI = new CheckInformation[clients.size()];
		for(int i = 0; i < clients.size(); i++) {
			CI[i] = calculateForClient(tableNumber, (String)clients.get(i), ordersTemp, priceTemp);
		}
		return CI;
	}
}