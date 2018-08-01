package coding_challenges;

public class Car {
	private String Make, Model ,Color ;
	private Integer Year, Price  ,HwyMPG;
	private Double TCCRating;
	public String getMake() {
		return Make;
	}
	public Integer getHwyMPG() {
		return HwyMPG;
	}
	public void setHwyMPG(int hwyMPG) {
		HwyMPG = hwyMPG;
	}
	public void setMake(String make) {
		Make = make;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public Integer getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	
	
	public Double getTCCRating() {
		return TCCRating;
	}
	public void setTCCRating(double tCCRating) {
		TCCRating = tCCRating;
	}
	public Car() {
		super();
	}
	public Car(String make, String model, String color, int year, int price,double tCCRating, int HwyMPG ) {
		super();
		Make = make;
		Model = model;
		Color = color;
		Year = year;
		Price = price;
		this.HwyMPG=HwyMPG;
		TCCRating = tCCRating;
	}
	@Override
	public String toString() {
		return "Car [Make=" + Make + ", Model=" + Model + ", Color=" + Color + ", Year=" + Year + ", Price=" + Price
				+ ", HwyMPG=" + HwyMPG + ", TCCRating=" + TCCRating + "]\n";
	}
	
}
