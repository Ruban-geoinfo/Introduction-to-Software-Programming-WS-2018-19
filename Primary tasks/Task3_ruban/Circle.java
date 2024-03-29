public class Circle extends Shape{
    
    private Point topLeftPoint = new Point();
    private float diameter;
    
    double dis = 0;

    public float area(){
        return (float)(Math.PI*Math.pow(diameter/2, 2));
    }

    public float perimiter(){
        return (float) (2*Math.PI*diameter/2);
    }

    public Point centroid(){
        Point p = new Point();
        p.setX(topLeftPoint.getX()+(this.diameter/2));
        p.setY(topLeftPoint.getY()+(this.diameter/2));
        return p;
    }

    public String toString() {
        return " topLeftPoint(" + topLeftPoint.getX() +","+ topLeftPoint.getY() +"), diameter="+diameter;
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

    public float getDiameter(){
        return diameter;
    }

    public void setDiameter(float diameter){
        this.diameter = diameter;
    }

    public Point getTopLeftPoint(){
        return topLeftPoint;
    }

    public void setTopLeftPoint(Point topLeftPoint){
        this.topLeftPoint = topLeftPoint;
    }
	
}