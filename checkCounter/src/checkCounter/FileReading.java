package checkCounter;
import java.io.*;
import java.util.*;
public class FileReading {
	private Orders[] orders;
	private Price[] price;
	
	List<String> readOrder(String address) throws Exception {
		List<String> str = new ArrayList<String>();
		File file = new File(address);
		FileReader fr = new FileReader(file);
		BufferedReader reader = new BufferedReader(fr);
		String line = null;
		while ((line = reader.readLine()) != null) {
		   str.add(line);
		}
		reader.close();
		return str;
	}

	void setOrder(String delimeter, List<String> al) {
		orders = new Orders[al.size()];
		String[] temp;
		for(int i = 0; i < orders.length; i++) {
			temp = ((String)al.get(i)).split(delimeter);
			orders[i] = new Orders(temp[0], temp[1], temp[2], temp[3]);
		}
	}
	
	Orders[] getOrder() {
		return orders;
	}
	
	List<String> readPrice(String address) throws Exception {
		List<String> str = new ArrayList<String>();
		File file = new File(address);
		FileReader fr = new FileReader(file);
		BufferedReader reader = new BufferedReader(fr);
		String line = null;
		while ((line = reader.readLine()) != null) {
		   str.add(line);
		}
		reader.close(); 
		return str;
	}
	
	void setPrice(String delimeter, List<String> al) {
		price = new Price[al.size()];
		String[] temp;
		for(int i = 0; i < price.length; i++) {
			temp = ((String)al.get(i)).split(delimeter);
			price[i] = new Price(temp[0], Integer.parseInt(temp[1]));
		}
	}
	
	Price[] getPrice() {
		return price;
	}	
}
