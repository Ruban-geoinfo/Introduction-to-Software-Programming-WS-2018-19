# Introduction-to-Software-Programming-WS-2018-19

In the final project of the Java part of the course, you will be creating Shape objects and visualizing them in the graphic panel provided by Marcelo for the labs.

For the project, you are required to collect data for 10 capital cities in Europe. For each city you should record the name, GPS coordinates (in decimal degrees), area (in sqr km), population, population density (number per sqr km), percentage of foreign residents in the population, GDP (in billion €) - in that order.


Task 1: Create a text file for the collected data with the following format:
1.1 Data for each city are written on the same line
1.2 The data items on a line are separated by commas (lat and lon are space separated)
1.3 Line format: name, lat lon, area, pop., pop. density, % foreign residents, GDP
1.4 Line example: Berlin, 52.516667 13.388889, 891.7, 6004857, 4100, 18.4, 130

Task 2: Read your cities data into your application
2.1 To read your data into your application you will have to use the StringInputReader class provided in Learnweb. Use the method that returns the file contents as an array of strings.
2.2 For each line (i.e. String in your array) use string.split(",") to create a new array of Strings that is split across the commas (,). E.g. the following have the same result
□String[] cityData = "Berlin, 52.516667 13.388889, 891.7,6004857, 4100, 18.4, 130".split(",");
□String[] cityData = {"Berlin", " 52.516667 13.388889", "891.7", " 6004857", " 4100", " 18.4", " 130"};
2.3 First, create a City class with the appropriate attributes (variables) to model the city data - each city will be an object. Note that the coordinates can be stored in a Point attribute inside your City class. Be sure to make your attributes private and provide getter and setter methods.
2.4 Test your city class with a program that reads the city data file, creates a City object for each city and then iterates through the city objects printing their content one per line.
2.5 NOTE: remember to use Double.parseDouble() to convert your String value to double where necessary.

Task 3: Display your cities in a 1000 x 1000 window
3.1 In this task you are required to simply display your the distribution of your city locations in the graphic panel.
3.2 First compute the bounding box of the coordinates of your cities. Then decide a padding you want to have applied in your window (Let's try 50 to begin with). This padding is necessary to avoid having data displayed at the edges of the window. Your data will display in a 900 x 900 area inside the window.
3.3 Next we want scale the data. Compute the scale factor by
scale = 900/Math.max(bbox.length, bbox.width);
where bbox is your bounding box object.
3.4 Use the formula above to scale the x and y axes separately and compare the results with the single scale above in the graphic panel.
3.5 To apply the scaling multiply each coordinate (lat and lon) by the scale factor. In your program you could create new City objects with scaled coordinates or simply change the coordinates of your current city objects.
3.6 After applying the scaling, we must now center the data in the display window. For this first find the center point of the display window (this easy, it's the point (500, 500)), then the center point of the bounding box of the city data. NOTE: you can do this by finding the center of the original bounding box and applying the scale factor to it.
3.7 Once we find the centers we can determine the amount of translation required for the centers to coincide by subtracting:
xTranslation = window.center.x - bbox.center.x
yTranslation = window.center.y - bbox.center.y
3.8 Use the translation distances to translate your coordinates
myCity.x = myCity.x + xTranslation (same for the y-axis)
3.9 Finally, we have to flip our map around the horizontal centerline because our coordinates increase bottom-to-top while the window coordinates increase top-to-bottom. For this simply subtract every y-coordinate from 1000:
myCity.y = 1000 - myCity.y;
3.10 After performing these transformations, you can plot your cities as points in the graphic panel.

Task 4: Decorate your map with additional data about the cities. Be creative!
4.1 Use the shapes classes we created in the labs (circle, rectangle, polyline) to expresses the demographic data in the panel.
4.2 It is mandatory to use circle as buffer, color saturation, and one or more rectangle for bar chart.
4.3 It is mandatory to present at least three demographic data. Population and GDP per capita MUST be presented as well.
4.4 It is mandatory to name the cities with labels

