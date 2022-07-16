public class Circle extends Shape {
	
	private float diameter;
	Point topLeftPoint = new Point();
	
	public float getDiameter() {
		return diameter;
	}
	
	public Point getCoordinates() {
		return topLeftPoint;
	}
	
	public void setCoordinates(Point p){
		topLeftPoint = p;
	}
	
	public void setDiameter(float diameterC){
		diameter = diameterC;
	}
			
	public double area() {
		double areaCalc = ((diameter/2)*(diameter/2)) * Math.PI;
		return areaCalc;
	}
	
	public double perimeter() {
		double perimeterCalc = 2 * Math.PI * (diameter/2);
		return perimeterCalc;
	}
	
	public boolean contains(Point p1) {
		double containtest = p1.distance(topLeftPoint.getX(),topLeftPoint.getY());
		if( containtest < (diameter/2)){
			return true;
		}
		else {
			return false;
		}
	}
	
	public Point centroid(){
		Point centroidP = new Point();
		centroidP.setPosition(topLeftPoint.getX()+(diameter/2), topLeftPoint.getY()+(diameter/2));
		return centroidP;
		
	}

}