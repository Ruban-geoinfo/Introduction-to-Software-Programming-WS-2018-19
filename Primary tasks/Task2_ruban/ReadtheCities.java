import java.io.IOException;

public class ReadtheCities{

	public static void main(String[] args)
	{
		//declaration path of the data fom task 1, cities and point of GPS coordinates of each city 
		String path = "./CapitalCities.txt";
		City cities [] = new City[11];
		Point cityPoints [] = new Point[11];
		String Filelines [];
		try{
			Filelines = InputStringReader.readFileAsArray(path);

    		for (int i = 1; i < Filelines.length; i++) {
				cities[i] = new City();
				
				String cityProps [] = Filelines[i].split(",");
				
				for (int j = 1; j < cityProps.length; j++) {
					String coords [] = cityProps[1].split(" ");
					double xcoord = Double.parseDouble(coords[0]);
					double ycoord = Double.parseDouble(coords[1]);
					cityPoints[i] = new Point();
					cityPoints[i].setX(xcoord);
					cityPoints[i].setY(ycoord);
					cities[i].setCoordinates(cityPoints[i]);
					
					double area = Double.parseDouble(cityProps[2]);
					int pop = Integer.parseInt(cityProps[3]);
					double popdens = Double.parseDouble(cityProps[4]);
					double foreignp = Double.parseDouble(cityProps[5]);
					double gdp = Double.parseDouble(cityProps[6]);
					
					cities[i].setName(cityProps[0]);
					cities[i].setArea(area);
					cities[i].setPopulation(pop);
					cities[i].setPopDensity(popdens);
					cities[i].setForeignpop(foreignp);
					cities[i].setGDP(gdp);
				}
			}
							
			for (int k = 1; k < cities.length; k++) {
				System.out.println(cities[k].toString());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}