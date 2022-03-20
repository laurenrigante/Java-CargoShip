

public class Truck {

	//the trucks parameters
	private String driversName;
	private String originatingCity;
	private String destinationCity;
	private double grossWeight;
	private double unloadedWeight;
	
	
	//variables that have to do with packages
	public  Package [] arrayPackage=new Package[200]; //assume max of 200 packages.
	private int loadingIndex=-1; //keeps track of how many packages have been loaded

	int i=0;
	//----------------------------------- constructors------------------------------------------------

	/**This is the default constructor.  It has no arguments. */
	public Truck() {}
	
	
	/** This is the parameterized constructor. It takes the following parameters:
	 * @param driversName 			Stores the drivers name as a String
	 * @param originatingCity		Stores the originating city name as a String
	 * @param destinationCity		Stores the destination city name as a String
	 * @param grossWeight			Stores the gross weight of the truck as a double
	 * @param unloadedWeight		Stores the unloaded weight of the truck as a double
	 */
	public Truck(String driversName, String originatingCity, String destinationCity,
	double grossWeight, double unloadedWeight)
	{
		this.driversName=driversName;
		this.originatingCity=originatingCity;
		this.destinationCity=destinationCity;
		this.grossWeight=grossWeight;
		this.unloadedWeight=unloadedWeight;
	}
	
	//--------------------------------------------------- get and set methods-------------------------
	/** Get method to get the drivers name as a String
	 * @return the drivers Name*/
	public String getDriversName()
	{
		return driversName;
	}

	/** Set method to set the drivers name
	 * @param driversName  variable for drivers name*/
	public void setDriversName(String driversName) 
	{
		this.driversName = driversName;
	}

	/** Get method to set the originating City Name as A String
	 * @return Originating city name*/
	public String getOriginatingCity() 
	{
		return originatingCity;
	}

	/** Set method to set originating city name in String format
	 * @param originatingCity  variable for originating city name */
	public void setOriginatingCity(String originatingCity) 
	{
		this.originatingCity = originatingCity;
	}
	
	/** get method to get the destination city name in String format
	 * @return  the destination city name*/
	public String getDestinationCity() 
	{
		return destinationCity;
	}

	
	/**Set method to set the destination city name in String format
	 * @param destinationCity  name of destination city*/
	public void setDestinationCity(String destinationCity)
	{
		this.destinationCity = destinationCity;
	}

	/** get method to get the gross weight of the truck as a double in pounds)
	  @return the gross weight */
	public double getGrossWeight() 
	{ 
		return grossWeight;
	}
	
	
	/**  set method to set the gross weight of the truck 
	 * @param grossWeight the gross weight of the truck in pounds
	 */
	public void setGrossWeight(double grossWeight)
	{
		this.grossWeight = grossWeight;
	}
 
	
	/** get method to get the unloaded weight of the truck as a double ( in pounds)
	 * @return the unloaded weight of the truck in pounds */
	public double getUnloadedWeight()
	{
		return unloadedWeight;
	}

	/** set method to set the unloaded weight of the truck as a double ( in pounds)
	 *  @param unloadedWeight  the unloaded weight of the truck in pounds*/
	public void setUnloadedWeight(double unloadedWeight) 
	{
		
		this.unloadedWeight = unloadedWeight;
	}
	
	/**Get method that returns the Array of Packages 
	 * @return  the array of Packages */
	public Package[] getArrayPackage()
	{
		return arrayPackage;
	}
	/**Set method that allows us to set the arrayPackage
	 * @param arrayPackage  	array of type Package*/
	public void setArrayPackage(Package[] arrayPackage) 
	{
		this.arrayPackage = arrayPackage;
	}
	/**Get method that allows us to get the Loading Index of the truck
	 * @return		the loading index(counter that keeps track of how many packages have been loaded) */
	public int getLoadingIndex() 
	{
		return loadingIndex;
	}

/**Set method that allows us to set the Loading Index of the packages
 * @param loadingIndex The index that keeps track of how many packages have been loaded */
	public void setLoadingIndex(int loadingIndex) 
	{
		this.loadingIndex = loadingIndex;
	}

//----------------------------- methods-------------------------------------------------------------------------
	
	/**This method converts kilograms toPounds
	 * @return the Weight in pounds*/
	public  double kgtoPounds(double weight)
	{
		return weight*2.205;
	}
	
	/**  boolean method to determine whether or not the truck is full
	 * @return whether or not the truck is full */
	public  boolean isTruckFull()
	{
		if(i>=0 && i< 200) //if the index is in between 0 and 200, the truck is not full
			return false; 
		else				// the truck is full since index is out of bounds
			return true; 
	}

			
	
	/**  This load method checks if the box is overweight,  and if the truck is full.
	 * if any of these  conditions are true, the method will throw an exception and will not load the package
	 *  Otherwise, the package will be loaded and the loadingIndex variable will be incremented
	 * @param p  Package object.  */
	public  void loadPackage(Package object) 
	{	
		boolean theresanerror=false; //boolean value to determine if theres an error or not
		
		
		try {
			/*this part checks if the packages are over weight. we get the package weight using the get method getPckgWeight
			 * and we compare it to the different maximum weights.
			 * If the Package is overweight,we throw an exception and we do not load it */
			
			
			//for Letter, get the package weight then convert it to pounds to compare it to the max weight of 2 lb 
			if((object.getPckgWeight())>2.0 && object.getClass()==(new Letter()).getClass())
			{
				throw new PackageException("This letter is overweight. We cannot load it");
			}
			else if(object.getPckgWeight()>40.0 && object.getClass()==(new Box()).getClass())
			{
				throw new PackageException("This Box is overweight. We cannot load it");
			}
			else if(object.getPckgWeight()>100 && object.getClass()==(new MetalCrate().getClass()))
			{
				throw new PackageException("This Metal Crate is overweight. We cannot load it");
			}
			else if(object.getPckgWeight()>80.0 &&object.getClass()==(new WoodCrate().getClass()))
			{
				throw new PackageException("This Wood Crate is overweight. We cannot load it");
			}
			
			
		}catch(PackageException e) //catch the exception
		{
			theresanerror=true; //there was an error since the packages were overweight. 
			System.out.println();
			System.out.println(object); //tostring that prints the information of the object
			System.out.println(e.getMessage()); //print the error message
		}
		

		try {
			//this try blocks tests if the truck is already full. if it is, we throw an exception and we do not load the package
			if( isTruckFull()==true )
			{
				throw new PackageException(" The truck is already full. We cannot load this package.");
			}
		}catch(PackageException e)
		{
			theresanerror=true; // there was an error since the truck is full.
			System.out.println();
			System.out.println(object); //print the objects to string
			System.out.print(e.getMessage()); //print the error message
		}
			
		if(theresanerror==true) // if there was an error (either the package is overweight or the truck is full
		{
			System.out.println("\n******THE PACKAGE WAS NOT LOADED******"); //we let the user know the package could not be loaded
		}
		else //if there was no error, we load the package
		{
			System.out.println("\n******THE PACKAGE WAS SUCCESSFULLY LOADED******");
			setLoadingIndex(loadingIndex+1); //increments the array to know how many  packages r loaded
			System.out.println("Loading index: "+loadingIndex);
			arrayPackage[loadingIndex]=object; //assigning the package object to the array position of loading index
			// loadingIndex++; //increments the array index to keep track of how many packages have been loaded  
		}	
	}	
	
	/** This unloading  method takes the package at the position i of the package array and makes it null. 
	 * It then decrements the loading index to make the array size smaller, thus deleting the package that was unloaded
	 * @param i 	the index of the package that we would like to delete */
	public void unloadPackage(int i)
	{
		arrayPackage[i]=null;
			//loadingIndex--;
	}

	
	public void hardcodedarray() //fills array w 200 package objects
	{
		Package [] hardcodedarray= new Package[200];
		
		for( i=0; i <200; i++)
		{
			Letter letters= new Letter(129180,2.0, 50.0);
			System.out.println(hardcodedarray[i]=letters);
		}					
		
	}

	
}//end of truck class
