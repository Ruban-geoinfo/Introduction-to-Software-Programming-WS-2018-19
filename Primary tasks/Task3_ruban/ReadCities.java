import java.io.IOException;

public class ReadtheCities{

	public static void main(String[] args)
	{
		String path = "./CapitalCities.txt";
		City cities [] = new City[11];
		Point cityPoints [] = new Point[11];
		String Filelines [];
		SimpleFrame frame = new SimpleFrame(1000,1000);
		Point windowCenter = new Point();
		windowCenter.setX(500);
		windowCenter.setY(500);
		Point bBoxCenter = new Point();

		try{
			Filelines = InputStringReader.readFileAsArray(path);
    		for (int i = 1; i < Filelines.length; i++) {
				cities[i] = new City();
				String cityAttributes [] = Filelines[i].split(",");
				for (int j = 1; j < cityAttributes.length; j++) {
					String coords [] = cityAttributes[1].split(" ");
					double xcoord = Double.parseDouble(coords[1]);
					double ycoord = Double.parseDouble(coords[0]);
					cityPoints[i] = new Point();
					cityPoints[i].setX(xcoord);
					cityPoints[i].setY(ycoord);
					cities[i].setCoordinates(cityPoints[i]);
					
					double area = Double.parseDouble(cityAttributes[2]);
					int pop = Integer.parseInt(cityAttributes[3]);
					double popdens = Double.parseDouble(cityAttributes[4]);
					double foreignp = Double.parseDouble(cityAttributes[5]);
					double gdp = Double.parseDouble(cityAttributes[6]);
					
					cities[i].setName(cityAttributes[0]);
					cities[i].setArea(area);
					cities[i].setPopulation(pop);
					cities[i].setPopDensity(popdens);
					cities[i].setForeignpop(foreignp);
					cities[i].setGDP(gdp);
				}
			}
			///////////////////////
			double maxY = -1000;
			double minY = 1000;
			double minX = 1000;
			double maxX = -1000;
			for (int i = 1; i < Filelines.length; i++) {
				if (cities[i].getCoordinates().getX() > maxX) {
					maxX = cities[i].getCoordinates().getX();
				}
				if (cities[i].getCoordinates().getX() < minX) {
					minX = cities[i].getCoordinates().getX();
				}
				if (cities[i].getCoordinates().getY() > maxY) {
					maxY = cities[i].getCoordinates().getY();
				}
				if (cities[i].getCoordinates().getY() < minY) {
					minY = cities[i].getCoordinates().getY();
				}
			}
			minX -= 10;
			maxX += 10;
			minY -= 10;
			maxY += 10;
			double scale = 900/Math.max((minY-maxY),(maxX-minX));
			Point topLeftPoint = new Point();
			topLeftPoint.setX(minX);
			topLeftPoint.setY(maxY);
			for (int i = 1; i < Filelines.length; i++) {
				cities[i].getCoordinates().setX(cities[i].getCoordinates().getX()*scale);
				cities[i].getCoordinates().setY(cities[i].getCoordinates().getY()*scale);
				Label cityname = new Label();
				cityname.setText(cities[i].getName());
				cityname.setPosition(cities[i].getCoordinates());
				frame.addToPlot(cityname);
			}
			bBoxCenter.setX((topLeftPoint.getX()+(0.5*(maxX-minX)))*scale);
			bBoxCenter.setY((topLeftPoint.getY()+(0.5*(minY-maxY)))*scale);
			double xTranslation = windowCenter.getX() - bBoxCenter.getX();
			double yTranslation = windowCenter.getY() - bBoxCenter.getY();
			for (int i = 1; i < Filelines.length; i++) {
				cities[i].getCoordinates().setX(cities[i].getCoordinates().getX() + xTranslation);
				cities[i].getCoordinates().setY(cities[i].getCoordinates().getY() + yTranslation);
				cities[i].getCoordinates().setY(900 -(cities[i].getCoordinates().getY()));
				frame.addToPlot(cities[i].getCoordinates());
			}
			frame.drawAllFeature();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}