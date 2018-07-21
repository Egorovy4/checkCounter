package checkCounter;

public class View {
	void showCheckForClient(CheckInformation ci) {
		int summ = 0;
		System.out.printf("%-15s%10s%n","Офіціант",ci.getWaiterName());
		System.out.println("Стіл №" + ci.getTableNumber());
		System.out.println("--------------");
		System.out.println(ci.getClientName());
		for(int i = 0; i < ci.getDishName().size(); i++){
			System.out.printf("%-15s%10s%n","     " + ci.getDishName().get(i), ci.getQuantityOfDish().get(i) + "x" + " " + ci.getPriceOfDish().get(i) + " грн");
			summ = summ + (Integer.parseInt(ci.getQuantityOfDish().get(i)) * Integer.parseInt(ci.getPriceOfDish().get(i)));
		}
		System.out.println("     ____________________");
		System.out.printf("%-15s%10s%n","     Разом", summ);
		System.out.println("-------------------------");
		System.out.printf("%-15s%10s%n","Загальна сума", summ + " грн");
	}
	
	void showCheckForTable(CheckInformation[] CI) {
		
		int[] summ = new int[CI.length];
		int fullSumm = 0;
		
		System.out.printf("%-15s%10s%n","Офіціант",CI[0].getWaiterName());
		System.out.println("Стіл №" + CI[0].getTableNumber());
		System.out.println("--------------");
		for(int i = 0; i < CI.length; i++) {
			System.out.println(CI[i].getClientName());
			for(int x = 0; x < CI[i].getDishName().size(); x++){
				System.out.printf("%-15s%10s%n","     " + CI[i].getDishName().get(x), CI[i].getQuantityOfDish().get(x) + "x" + " " + CI[i].getPriceOfDish().get(x) + " грн");
				summ[i] = summ[i] + (Integer.parseInt(CI[i].getQuantityOfDish().get(x)) * Integer.parseInt(CI[i].getPriceOfDish().get(x)));
			}
			System.out.println("     ____________________");
			System.out.printf("%-15s%10s%n","     Разом", summ[i]);
			System.out.println("-------------------------");
			fullSumm += summ[i];
		}
		System.out.printf("%-15s%10s%n","Загальна сума", fullSumm + " грн");
	}
}
