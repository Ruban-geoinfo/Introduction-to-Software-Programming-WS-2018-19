Introduction to Software Programming – WS 2018/19
Final Report
University of Münster, Germany
Institute for Geoinformatics, Heisenbergstraße 2, 48149 Münster, Germany
Report submitted by: Rubankumar Moorthy (r_moor02@uni-muenster.de)

Abstract:

The final project of java programming, were created the Shape objects and visualization fulfilled in the graphic panel provided by Marcelo for the labs. The implementation part, Europe capital cities information were collected from Wikipedia, European union, City population and other open service portal. The ten capital cities and details are stored in order name of the city, GPS coordinates (in decimal degrees), area (in sq.km), population, population density (number per sq.km), percentage of foreign residents in the population, GDP (in billion €) . City geographical information has plotted and visualised in the graphical panel. In this course, has introduced to the basics of software programming with emphasis on common data structures and algorithms often required in geospatial applications. The course covered the basics of programming using Java that has relevant to Geoinformatics.

Keywords: Europe cities, Bounding box, Graphical panel, Scale, Buffer, Geoscience, Saturation, Translation.

1 Introduction
The Final Java project completed as a part of the course “Introduction to Software Programming” under the guidance of Dr.Malumbo Chipofya and Marcelo. In this course, were to complete the objective of project that divided into four separate tasks.

2 Task 1
In this task, has created a text file for 10 capital cities in Europe and data collected from Wikipedia, European Union portal. The capital cities in Europe which considered Amsterdam, Berlin, Brussels, London, Helsinki, Madrid, Oslo, Paris, Stockholm, Zurich.

2.1 Task Description
The information of the each city has retrieved from https://europa.eu/european-union/about-eu/countries/member-countries and Wikipedia. Almost of the data about cities were accessible in European Portal. The geo coordinates (decimal degrees) obtained from clicking on the coordinates in the side panel on the main page, which takes to a GeoHack page with the different coordinate formats, and other Coordinate Reference Systems (Figure.1). The side panel in the Wikipedia page contained most of the required information. Exclusion was that for some cities, the Percentage of Foreign Residents and the GDP were yet display in the side panel but it was available in the Demographics, Immigration or the Economic section of the text that followed the particular Cities description. Outstanding Population Density data and Percentage of Foreign Residents for the cities were obtain from different resources on web. All the collected data was stored as per the guidelines. The Line format of the Created a text file for the collected data: name, lat lon, area, pop., pop. Density, % foreign residents, GDP( for example: Amsterdam,52.366667 4.9,219.32,851573,5135,50,170).

 

3	 Task 2

    In this task, to read the stored data as a text file into the application and used the StringInputReader class. Used the method that returns the file contents as an array of strings. For each line (i.e. String in your array) use string.split(",") to create a new array of Strings that is split across the commas (,). A city class has created with the appropriate attributes (variables) to model the city and the coordinates stored in a Point attribute inside the City class. The attributes are private and provide getter and setter methods with a program that reads the city data file, creates a City object for each city and iterates through the city objects printing their content one per line. Double.parseDouble() is used to converted the String value to double where necessary.

3.1	Task Description

    Read the cities data into an application, considered the classes namely City, InputStringReader, Point, ReadtheCities (main class). Apart from City and ReadtheCities class remains already created during the Lab assignments.

3.1.1	ReadtheCities (Main) Class

      It is the main and executable class of this task. In this public class distributed into multiple modules based on the different functionality. For the Main class to setup the file path string as “./CapitalCities.txt”. To creating an array, object for the each city and created a static class to include all the city data’s. With help of the Try, InputStringReader class has been called and the file that was reads line by line is assigned to a variables. Java try block is used to enclose the code that might throw an exception within the method. Based on the city objects are created according to the content length. In every  line the string.split(",") is used to create a new array of Strings that is split across the commas (,). Here after all the attributes are using Double.parseDouble() to convert your String value to double and each double is stored in a separate cityProps array.

     Furthermore, setting up all the attributes by creating a new object for the arrays of the cities. For print statement is generally used to print attributes that was stored. Before that we need to get the attributes in order to print it hence in a For loop the object or city is related to the city and with these objects all the get attributes are displayed. Catch Java try block must be followed by either catch or finally block. The error are caught and stores in object e and this in turn prints the printStackTrace.


3.1.2	City Class
     The City class created, with all the appropriate attributes along with their data types except for the cityName and cityLocation having datatypes string and point respectively, population as integer, and all other attributes have a datatype of double. The creation of a city entity is completed and accessed from ReadtheCity class. The attributes was declare “private” as the condition of the Task stated, use of private used to restrict the errors caused by many people making changes. “Getters” and “Setters” method has been used with “public” operator rather than private as it used to access from various classes. This class similar to the developed with it during Lab assignments but here certain modifications done here. To represent the city geo location, latitude and longitude values of the cities using split operator and created as object coordinates, later which stored the setX and setY values and printed the coordinates of all the cities.

3.1.3	Point Class
     In this class, to handle the point shape objects and represents the location two point, (i.e) point x and point y are used. The function of this point class includes Get, Set and Printing points of x and y. The Calculation of Distance between the two points and description of the Point derived from this class. While location function has called, that turn will run the point class.

4	Task 3
   In this task, created 1000 x 1000 window graphical panel for displaying cities information’s. Hereafter computed the bounding box of the coordinates of the cities. The data has displayed in a 900 x 900 area inside the window and created Bounding box for all the points. Used the scale of each coordinates will be centered the coordinates and applied the amount of translation for the centering of points. For the third task, existing classes has been updated and created a new classes such as SimplePanel, SimpleFrame, Shape, Rectangle, Polyline, Polygon, Label, DrawingContent, Circle. 

4.1	Bounding Box
      In ReadtheCities class (Main), has created a bounding box method works on the array of city objects and accesses their coordinates to identify the points on the extremes. The bounding box four points were selected and all the city coordinates was iterates in the condition checking which is the maxY, minY , maxX and the maxY points.  Primarily the north and the west were given a max of 1000 accordingly maxY and minX with which it was easy to obtain the max north point.

4.2	Scale 
       Furthermore the ReadtheCities class were scaled the data as per instruction. The scale factor computed by, 
             scale = 900/Math.max(bbox.length, bbox.width);
For applying the scale factor I have adopted double scale = 900/Math.max((minY-maxY),(maxX-minX));  that are based on the bounding box, length, width. To apply the scaling multiply each coordinate (lat and lon) by the scale factor and the program created a new City objects with scaled coordinates of simply change the coordinates of the current city objects.


4.3	Center of Bounding Box
      After that applying the scaling in ReadtheCities, as per the guidelines to center the data in the display window. For this first fix the center point of the display window as (500 x 500), then the center point of the bounding box of the city data. The center point of the display window was set with width and height initially where the TopLeftPoint X and Y.

4.4	Translation
      Once found the centers used determine the amount of translation required for the centers to coincide by subtracting:
                   xTranslation = window.center.x - bbox.center.x
                   yTranslation = window.center.y - bbox.center.y
the bounding box center from the actual window center which was (500,500). xTranslation and yTranslation was calculated and based on the window, bounding box center. Use of translation distances to translate the coordinates. After which the Y-axis need to be flipped for which the Y-axis had to subtracted from 900 instead of 1000. I have unified both the flipping and yTranslation in the setY. Finally performing these transformations plotted the cities as points in the graphic panel.

4.5	SimplePanel 

      To plotted the city coordinates a Simple Cartesian Frame of (1000,1000) was set according to the display of the city location. In addition, the background colour set as white and changed the drawer and their attributes. Furthermore drawing contents were defined for performing task, and created a shape class namely Draw Circles, Rectangle, Polygon, Polyline, Points, Labels.  

4.6	SimpleFrame

       Created simple frame class, with suitable attributes and setting the title as public "Java-Task3_Rubankumar Moorthy". After that describes the simple panel conditions and set the visible colour true. Finally “Getters” have been used with “public void” operator rather than private as it should be accessible from various classes and addToPlot the properties of the cities such as Point, Polygon, Circle, Rectangle, Label.

4.7	Shape
    
     Created shape class and attributes has made “private” condition for this Task. StrokeWidth, fillColor, Transparency, strokeColor the attributes private will restrict many people making changes of the attributes and hence avoid error. “Getters” and “Setters” have been used with “public” operator within the above attributes.

4.8	Rectangle

     Created a Rectangle class, and defined the topLeftPoint, width, height as a private class. center point of the display window was set with width and height initially where the TopLeftPoint X and Y were added with Width/2 and Height/2 respectively and stored in the point.

4.9	Polyline

        Polyline class created and the class to handle the polyline shape objects. Points and numpoints are in the private class, used get set method for performing this task

4.10	Polygon

      Created the polygon class for handling the polygon shape objects. Similarly used get set method accomplished the task.  

4.11	 Label

       Created a Label class, new Label has created and based on the city locations plotted along with their names.

4.12	 DrawingContent

      Created drawing content class for representing Array lists Rectangle, circle, point, polyline, polygon and label. All the array list are defines as private class. Furthermore used get set method for displaying the attributes of the content.  

4.13	 Circle

     In this Class to handle, the circle shape objects, topLeftPoint, and diameter are in the private class. Commonly used get set method for thorough the task.


5	Task 4

     In this task, there were main class (ReadtheCities) and other 10 classes (Circle, City, DrawingContent, InputStringReader, Label, Point, Rectangle, Shape, SimpleFrame, SimplePanel) see figure.2 that fulfils the section of java-programming final task of the project. I have used the shape classes from the previous task to expresses the demographic data in the panel and eliminated polyline and polygon classes that are not used. 

 
Fig.2.Overview of Class Diagram
      For the visualisation of the bar charts, SimpleFrame has been modified as fit for display cities data (1400 x 1000). At the same on frame center point of window size taken  as 450 x 500. Instead of 900, which was given in the scale factor, adopted 500 as which to include all city coordinates. When applied 900 some of points were overlapped into the bar charts, so had to decrease the number of scale.
      Furthermore this task, circles were used for representing area of the each city and the population density. Rectangles were used for representing the population of the city, the GDP and the population of foreign nationals. The circles were used to create a buffer, colour saturation that represents the each of the 10 cities Area and Population. The buffer enlarge denotes areas and the colour denotes population density of the cities. 
    The rectangles created with two bar charts used to represent three demographic data. In the graphical panel, one of the rectangles display the GDP per capita and another rectangle represents the total population and the foreign inhabitants in percentage. The saturation had been used to differentiate the ranges of the above three data. The point of the each location were named using the labels. Finally, we can get the output of final task as per the guidelines, easily to interpret the city information’s using the graphical panel.




6	Challenging Aspects

    In the beginning, was challenging to learn the basic facts and functions about this project. The previous class assignments much useful for understanding aspects and parameters. Furthermore, with help of Marcelo labs visualised the map into the virtual system. It took much time to adopt the concept of bounding box and window center while applying into the graphical panel. Because as per the task guidelines setup the bounding box and window center scale values caused the overlapping into the horizontal bar charts. Additionally, needed more attention and focus while the scaling and translation of the coordinates in the bounding box. Next difficult aspect was to display bar charts into the graphical panel, which considered GDP, City Population and Foreign resident’s percentage. However after the study of draw charts using the shape classes, that can be plotted in graphical panel.


7	Conclusion

   In this Course, I learned the basic java programming based on previous assignments and above tasks. The four tasks much useful to understand the shape objects and the virtual system, which related to the geoinformation science. However, the cities has plotted with labels and buffer by satisfying all the conditions for the tasks. Moreover calculating normalization for the colour values of the circles, Rectangles for demographic data which much helpful to interpretation. Visual interpretation of cities information in virtual system easily to obtains the knowledge through map, that greatly understanding to the users.  
