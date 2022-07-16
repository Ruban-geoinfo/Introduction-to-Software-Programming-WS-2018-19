import java.awt.Color;
import java.io.IOException;

public class ReadtheCities {

	public static void main(String[] args) 
	{
		//**TO Read a data and creating cities and city points from Text file**//
		
		String path = "./CapitalCities.txt";
		City cities [] = new City[11];
		Point cityPoints [] = new Point[11];	
		String Filelines [];
		
		// ** To define a SimpleFrame 1000x1000 window as per task-3, but here i set 1400x1000 window for visulising the bar graphs**//
		
		SimpleFrame frame = new SimpleFrame(1400,1000);
		
		//**To create a frame center point**// for display rectangle purpose i adjusted the value of setX 500 into 450
		
		Point windowCenter = new Point();
		windowCenter.setX(450);
		windowCenter.setY(500);
		
		//**here Center point of the bounding box**//
		Point bBoxCenter = new Point();
		
		//**To Creating city points for scaling**//
		
		Point scaledcityPoints[] = new Point[11];
		
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
					cities[i].setForeignresi(foreignp);
					cities[i].setGDP(gdp);
				}
			}
			
    		//** Here the Variables for calculating the maxy/minY/minX/maxX-most coordinates**//
			
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
			
			//** To Calculating the scale as per task-3,previously seted scale = 900/Math.max(bbox.length, bbox.width); 
			 //for now i set 500/Math.max for visulising graph bars
			 
			double scale = 500/Math.max((minY-maxY),(maxX-minX));
			
			//**here Top left point of the bounding box**//
			
			Point topLeftPoint = new Point();
			topLeftPoint.setX(minX);
			topLeftPoint.setY(maxY);
			
			//**here to Calculating the center of the bounding box**//
			
			bBoxCenter.setX((topLeftPoint.getX()+(0.5*(maxX-minX)))*scale);
			bBoxCenter.setY((topLeftPoint.getY()+(0.5*(minY-maxY)))*scale);
			
			//** To Calculating normalization for the color value of the circles**//
			
			double popdensnorm [] = new double[11];
			double maxdensity = 25000;
			double mindensity = 1000;
			for (int i = 1; i < Filelines.length; i++) {
				if (cities[i].getPopDensity() < mindensity) {
					mindensity = cities[i].getPopDensity();
				}
				else if (cities[i].getPopDensity() > maxdensity) {
					maxdensity = cities[i].getPopDensity();
				}
			}
			maxdensity = maxdensity - mindensity;
			
			for (int i = 1; i < Filelines.length; i++) {
				popdensnorm[i] = cities[i].getPopDensity() - mindensity;
				popdensnorm[i] = popdensnorm[i]/maxdensity;
			}
			
			
			//** To Calculating normalization for the color value in GDP per capital of the rectangle**//
			
			double gdpnorm [] = new double[11];
			double maxgdp = 1000;
			double mingdp = 50;
			for (int i = 1; i < Filelines.length; i++) {
				if (cities[i].getGDP() < mingdp) {
					mingdp = cities[i].getGDP();
				}
				else if (cities[i].getGDP() > maxgdp) {
					maxgdp = cities[i].getGDP();
				}
			}
			maxgdp = maxgdp - mingdp;
			
			for (int i = 1; i < Filelines.length; i++) {
				gdpnorm[i] = cities[i].getGDP() - mingdp;
				gdpnorm[i] = gdpnorm[i]/maxgdp;
			}
			
			
			
			//** To Calculating normalization for the color value in population of the rectangle**//
			
			double popnorm [] = new double[11];
			double maxpop = 10000000;
			double minpop = 0;
			for (int i = 1; i < Filelines.length; i++) {
				if (cities[i].getPopulation() < minpop) {
					minpop = cities[i].getPopulation();
				}
				else if (cities[i].getPopulation() > maxpop) {
					maxpop = cities[i].getPopulation();
				}
			}
			maxpop = maxpop - minpop;
			
			for (int i = 1; i < Filelines.length; i++) {
				popnorm[i] = cities[i].getPopulation() - minpop;
				popnorm[i] = popnorm[i]/maxpop;
			}
			
			//** To Calculating normalization for the color value in foreign population percentage of the rectangle**//
			
			double foreignpopnorm [] = new double[11];
			double maxforeignpop = 100;
			double minforeignpop = 0;
			for (int i = 1; i < Filelines.length; i++) {
				if (cities[i].getForeignresi() < minforeignpop) {
					minforeignpop = cities[i].getForeignresi();
				}
				else if (cities[i].getForeignresi() > maxforeignpop) {
					maxforeignpop = cities[i].getForeignresi();
				}
			}
			maxforeignpop = maxforeignpop - minforeignpop;
			
			for (int i = 1; i < Filelines.length; i++) {
				foreignpopnorm[i] = cities[i].getForeignresi() - minforeignpop;
				foreignpopnorm[i] = foreignpopnorm[i]/maxforeignpop;
			}
			
			
			//**To Calculate the GDP per capital**//
			
			double gdppercapita [] = new double[11];
			for (int i = 1; i < Filelines.length; i++) {
				gdppercapita[i] = (cities[i].getGDP()*1000000000)/cities[i].getPopulation();
			}
			
			//**For Applying the scale to the coordinates**//
			
			for (int i = 1; i < Filelines.length; i++) {
				scaledcityPoints[i] = new Point();
				scaledcityPoints[i].setX(cities[i].getCoordinates().getX()*scale);
				scaledcityPoints[i].setY(cities[i].getCoordinates().getY()*scale);
				cities[i].setCoordinates(scaledcityPoints[i]);
				
				//**Here to Setting labels**//
				
				Label cityname = new Label();
				cityname.setText(cities[i].getName());
				cityname.setPosition(cities[i].getCoordinates());
				frame.addToPlot(cityname);
				
				//**ToSetting circles**
				// apply the HSB concept
				
				Circle pd = new Circle();
				pd.setCoordinates(cities[i].getCoordinates());
				pd.setDiameter((float)(cities[i].getArea()/5.5));
				pd.setStrokeColor(Color.BLACK);
				pd.setStrokeWidth(1);
				pd.setFillColor(Color.getHSBColor(0.1f, (float)popdensnorm[i], 0.95f));
				frame.addToPlot(pd);
			}
			
			//**Here to Calculating translation for coordinates**//
			
			double xTranslation = windowCenter.getX() - bBoxCenter.getX();
			double yTranslation = windowCenter.getY() - bBoxCenter.getY();
			
			//**The Variable for drawing  bars in the diagrams**//
			int t = 0;
	
			//**To Setting the scaled points as points for the cities**//
			
			for (int i = 1; i < Filelines.length; i++) {
				cities[i].getCoordinates().setX(cities[i].getCoordinates().getX() + xTranslation);
				cities[i].getCoordinates().setY(cities[i].getCoordinates().getY() + yTranslation);
				cities[i].getCoordinates().setY(900 - cities[i].getCoordinates().getY());
				cities[i].getCoordinates().setStrokeColor(Color.BLACK);
				frame.addToPlot(cities[i].getCoordinates());
				
				//**Here to Creating points for the diagram of city population**//
				
				Point pnPoint = new Point();
				pnPoint.setX(870);
				pnPoint.setY(400+t);
				
				//**here Creating rectangle for the bars for the diagram of city population**//
				
				Rectangle pn = new Rectangle();
				pn.setCoordinates(pnPoint);
				pn.setWidth(cities[i].getPopulation()/10000);
				pn.setHeight(20);
				pn.setFillColor(Color.getHSBColor(0.6f, (float)popnorm[i], 0.9f));
				pn.setStrokeColor(Color.BLACK);
				pn.setStrokeWidth(1);
				frame.addToPlot(pn);
				
				//**To Creating points for the diagram of the amount of foreign population in percentage**//
				
				Point pfPoint = new Point();
				pfPoint.setX(870+(cities[i].getPopulation()/10000));
				pfPoint.setY(400+t);
				
				//**To Creating rectangle for the bars for the diagram of the foreign population in percentage**//
				
				Rectangle pf = new Rectangle();
				pf.setCoordinates(pfPoint);
				pf.setWidth(cities[i].getForeignresi());
				pf.setHeight(20);
				pf.setFillColor(Color.getHSBColor(0.3f, (float)foreignpopnorm[i], 0.5f));
				pf.setStrokeColor(Color.BLACK);
				pf.setStrokeWidth(1);
				frame.addToPlot(pf);
				
				//**To Creating points for the diagram of GDP per capital**//
				
				Point gdpPoint = new Point();
				gdpPoint.setX(870);
				gdpPoint.setY(125+t);
				
				//**To Creating rectangle for the bars for the diagram of GDP per capita**//
				
				Rectangle gdp = new Rectangle();
				gdp.setCoordinates(gdpPoint);
				gdp.setWidth(gdppercapita[i]/1000);
				gdp.setHeight(20);
				gdp.setFillColor(Color.getHSBColor(0f, (float)gdpnorm[i], 1f));
				gdp.setStrokeColor(Color.BLACK);
				gdp.setStrokeWidth(1);
				frame.addToPlot(gdp);
				
				//**To Creating labels for the diagrams**//
				
				Point labelPoint = new Point();
				labelPoint.setX(800);
				labelPoint.setY(142+t);
				
				Label describeDiagram = new Label();
				describeDiagram.setPosition(labelPoint);
				describeDiagram.setText(cities[i].getName());
				frame.addToPlot(describeDiagram);
				
				Point labelPoint2 = new Point();
				labelPoint2.setX(800);
				labelPoint2.setY(417+t);
				
				Label describeDiagram2 = new Label();
				describeDiagram2.setPosition(labelPoint2);
				describeDiagram2.setText(cities[i].getName());
				frame.addToPlot(describeDiagram2);
				
				Point gdpValues = new Point();
				gdpValues.setX(gdp.getCoordinates().getX() + gdp.getWidth() + 15);
				gdpValues.setY(gdp.getCoordinates().getY()+17);
				
				Label gdpValuesLabel = new Label();
				gdpValuesLabel.setPosition(gdpValues);
				gdpValuesLabel.setText(String.valueOf((Math.round(gdppercapita[i]))) + " €");
				frame.addToPlot(gdpValuesLabel);
				
				Point popValues = new Point();
				popValues.setX(pn.getCoordinates().getX() + 15);
				popValues.setY(pn.getCoordinates().getY()+17);
				
				Label popValuesLabel = new Label();
				popValuesLabel.setPosition(popValues);
				popValuesLabel.setText(String.valueOf(cities[i].getPopulation()));
				frame.addToPlot(popValuesLabel);
				
				Point popFValues = new Point();
				popFValues.setX(pf.getCoordinates().getX() + pf.getWidth() + 15);
				popFValues.setY(pf.getCoordinates().getY()+17);
				
				Label popFValuesLabel = new Label();
				popFValuesLabel.setPosition(popFValues);
				popFValuesLabel.setText(String.valueOf(cities[i].getForeignresi()) + "%");
				frame.addToPlot(popFValuesLabel);

				t = t + 20;
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		//**General Points and labels for the diagram headings**//
		
		Point gdpHeading = new Point();
		gdpHeading.setX(950);
		gdpHeading.setY(100);
		
		Label gdpHeadingLabel = new Label();
		gdpHeadingLabel.setPosition(gdpHeading);
		gdpHeadingLabel.setText("Gross Domestic Product(GDP) per Capita");
		frame.addToPlot(gdpHeadingLabel);
		
		Point popHeading = new Point();
		popHeading.setX(890);
		popHeading.setY(380);
		
		Label popHeadingLabel = new Label();
		popHeadingLabel.setPosition(popHeading);
		popHeadingLabel.setText("City Population and foreign inhabitants in percentage");
		frame.addToPlot(popHeadingLabel);
		
		//** To set Points and labels for this project heading **//
		
		Point projectHeading = new Point();
		projectHeading.setX(30);
		projectHeading.setY(30);
		
		Label projectHeadingLabel = new Label();
		projectHeadingLabel.setText("Java programming final Project - output by Rubankumar Moorthy(457282)");
		projectHeadingLabel.setPosition(projectHeading);
		frame.addToPlot(projectHeadingLabel);
		
		//**To descripe the Points and labels for description of the visual output**//
		
		Point outputDescription = new Point();
		outputDescription.setX(30);
		outputDescription.setY(50);
		
		Label outputDescriptionLabel = new Label();
		outputDescriptionLabel.setText("The Displayed circles area represents the area of the each cities and the colors represents the population density.Two bar graphs denotes each city's GDP in Euros and  visualize the population of the city and the population of foreign nationals.");
		outputDescriptionLabel.setPosition(outputDescription);
		frame.addToPlot(outputDescriptionLabel);
		
		frame.drawAllFeature();
	}
}