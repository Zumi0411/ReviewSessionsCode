package coding_challenges;

import java.util.ArrayList;
import java.util.List;

public class CarDealer {
	public static List<Car> getAllCars(){
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Honda",  "CRV",  "Green",  2016,  23845, 8 ,33));
		cars.add(new Car("Ford",  "Escape",  "Red",  2017,  23590, 7.8, 32));
		cars.add(new Car("Ford",  "Escape",  "Red",  2017,  23590, 7.8, 32));
		cars.add(new Car("Hyundai",  "Sante Fe",  "Grey",  2016 , 24950, 8 ,27));
		cars.add(new Car("Mazda",  "CX-5",  "Red" , 2017 , 21795, 8, 35));
		cars.add(new Car("Subaru",  "Forester",  "Blue", 2016 , 22395, 8.4, 32));

		return cars;
	}
}
