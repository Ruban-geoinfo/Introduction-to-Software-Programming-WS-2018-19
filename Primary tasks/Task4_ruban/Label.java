public class Label extends Shape {
	
	private String text;
	private Point position = new Point();
	
	public Point getPosition() {
		return position;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
}