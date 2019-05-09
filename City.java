public class City extends Shape{
	
	private String name;
    private Point coordinates;
	private double area;
    private int population;
    private double popDensity;
	private double foreignresi;
	private double gdp;
	
	public String getName() {
		return name;
	}
	
	public Point getCoordinates() {
		return coordinates;
	}
	
	public double getArea() {
		return area;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public double getPopDensity() {
		return popDensity;
	}
	
	public double getForeignresi() {
		return foreignresi;
	}
	
	public double getGDP() {
		return gdp;
	}
	
	public String toString() {
		return this.getName() + " " + this.getCoordinates() + " " + this.getArea() + " " +  this.getPopulation() + " " + this.getPopDensity() + " " + this.getForeignresi() + " " + this.getGDP();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCoordinates(Point coordinates) {
		this.coordinates = coordinates;
	}
	
	public void setArea(double area) {
		this.area= area;
	}
	
	public void setPopulation(int population) {
		this.population = population;
	}
	
	public void setPopDensity(double popDensity) {
		this.popDensity = popDensity;
	}
	
	public void setForeignresi(double foreignresi) {
		this.foreignresi = foreignresi;
	}
	
	public void setGDP(double gdp) {
		this.gdp = gdp;
	}

}
