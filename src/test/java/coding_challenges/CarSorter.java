package coding_challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CarSorter {
	//1) A function to calculate newest vehicles in order
	public static List<Car> sortByYear(List<Car> cars){
		Collections.sort(cars,(Car car1, Car car2) -> car2.getYear()-car1.getYear());
		return cars;
	}
	//2) A function to calculate alphabetized List of vehicles
	public static List<Car> sortByName(List<Car> cars){
		Collections.sort(cars,(Car car1, Car car2) -> car1.getMake().compareTo(car2.getMake()));
		return cars;
	}
	
	//3) A function to calculate ordered List of Vehicles by Price
	public static List<Car> sortByPrice(List<Car> cars){
		Collections.sort(cars,(Car car1, Car car2) -> car1.getPrice().compareTo(car2.getPrice()));
		return cars;
	}
	
	//4) A function to calculate the best value
	public static List<Car> sortByValue(List<Car> cars){
		Collections.sort(cars,(Car car1, Car car2) -> car1.getTCCRating().compareTo(car2.getTCCRating()) * -1);
		return cars;
	}
	
	//5) A function to calculate full consumption for a given distance
	public static List<Car> sortByMPG(List<Car> cars){
		Collections.sort(cars,(Car car1, Car car2) -> car1.getHwyMPG().compareTo(car2.getHwyMPG()) * -1);
		return cars;
	}
	
	//6) A function to return a random car from the list
	public static Car getRandomCar(List<Car> cars){
		return cars.get(new Random().nextInt(cars.size()-1));
	}
	
	//7) A function to return average MPG by year
	
	public static Map<Integer,Integer> sortByAvgMPGByYear(List<Car> cars){
			cars = sortByYear(cars);
			List<Integer> yearsChecked = new ArrayList<>();
			Map<Integer,Integer> yearAndAvgMPG = new HashMap<>();
			for(int i = 0; i < cars.size(); i++) {
				int totalMPGsForYear = 0;
				int countCarsForYear = 0;
				int year = cars.get(i).getYear();
				
				if(yearsChecked.contains(new Integer(year))) {
					continue;
				}
				
				yearsChecked.add(new Integer(year));
				
				for(Car car : cars) {
					
					if(car.getYear() == year) {
						totalMPGsForYear += car.getHwyMPG();
						countCarsForYear++;
					}
				}
				
				yearAndAvgMPG.put(year, totalMPGsForYear/countCarsForYear);
				
			}
			
			
			
			return yearAndAvgMPG;
	}
	
}
