
import java.util.Scanner;

public class CargoTest1 {

		public static void main(String[] args) {
		//declaring variables
	//---------------------------------------- Variables------------------------------------------------------		
			int choice=0; //variable for the menu options
			
			String weightUnitchoice=null; //variable for the choice of weight unit (lb,kg,oz)
			Scanner keyin=new Scanner(System.in); //Scanner for user input

			String driversName=null,originatingCity=null, destinationCity=null; //truck attributes
			
			double unloadedWeight=0,Weight=0.0, convertedWeight=0.0; //weight variables for package and truck
			
			long trackingNumber=0; //variable to hold the tracking number
		
			//instantiating a new truck object with all of its attributes initialized to the zero of their type.
			Truck truck=new Truck(driversName,originatingCity,destinationCity,unloadedWeight,unloadedWeight); //instantiating a new truck
		
		
			
			System.out.println();
			System.out.println("******************WELCOME TO THE CARGOTEST PROGRAM*******************");
	//--------------------------------------------MENU--------------------------------------------------------------	

do {
			System.out.println("What would you like to do ?");
			System.out.println("\n1. Start a cargo "
					+ "\n \t a. Driver name "
					+ "\n \t b. Unload weight(kg,lb)"
					+ "\n \t c. Originating city "
					+ "\n \t d. Destination city"
					+ "\n\n2.Load the truck with packages"
					+ "\n \t a. Package tracking number"
					+ "\n \t b. Package weight(oz,lb)"
					+ "\n \t c. Package shipping cost"
					+ "\n\n 3.Unload a package"
					+ "\n\n 4.The number of packages loaded"
					+ "\n\n 5. The gross income earned by shipping of the cargo"
					+ "\n\n 6. Weight of the truck (After it has been completely loaded"
					+ "\n\n 7. Drive the truck to the destination"
					+ "\n\n 0. To quit"
					+ "\n\nPlease enter your choice and press <Enter>: ");

			
			choice=keyin.nextInt(); //user enters their choice
			
//-------------------------------------NUMBER 1 : START A CARGO---------------------------------------------------
				if(choice==1)
				{
					System.out.println("\nYou have chosen option 1:Start A Cargo");

					System.out.println("Please enter the drivers name");
					keyin.nextLine();
					driversName=keyin.nextLine(); //saving the drivers name into String variable
					truck.setDriversName(driversName); //setting the trucks driver name using the variable and set method

			do { //do while loop for the weight options
				
					System.out.println("\nIf you are entering the weight in kg : type kg. "
							+ "\nIf you are entering the weight in lb: type lb");

					weightUnitchoice=keyin.next(); //accepting the user input

					
					if(weightUnitchoice.equalsIgnoreCase("kg"))
					{
						System.out.println("you have chosen to enter the weight in kg");
						unloadedWeight=keyin.nextDouble(); //saving the use input in the unloadedWeight variable
						
						//converting the weight by calling kgtoPounds method. Then setting the trucks unloaded weight using the now converted weight
						truck.setUnloadedWeight(truck.kgtoPounds(unloadedWeight)); 
						
						System.out.println("The trucks unloaded weight in pounds is "+truck.getUnloadedWeight());
						break; //exit the loop and move on
					}
					
					else if(weightUnitchoice.equalsIgnoreCase("lb"))
					{
						System.out.println("you have chosen to enter the weight in lb");
						unloadedWeight=keyin.nextDouble(); //saving the user input into the unloaded weight variable
						truck.setUnloadedWeight(unloadedWeight); //setting the trucks unloaded weight to unloaded weight
						
						System.out.println("the weight in pounds is "+truck.getUnloadedWeight());
						break; //exit the loop
					}
					else 
						//if the user did not enter kg or lb, it is not a valid weight unit.
						System.out.println("you did not enter a valid weight unit");
				
					
					//keep repeating loop until the user enters either kg or lb.
			}while(!(weightUnitchoice.equalsIgnoreCase("kg"))|| !(weightUnitchoice.equalsIgnoreCase("lb")));
				
			
					System.out.println("please enter the originating city");
					originatingCity=keyin.next(); //saving the originating city into the variable
					truck.setOriginatingCity(originatingCity); //setting the trucks originating city using the variable
					
					
					System.out.println("please enter the destination city");
					destinationCity=keyin.next(); //saving the destination city into the variable
					truck.setDestinationCity(destinationCity); //setting the trucks destination city using the variable
				}
				
//--------------------------------------	NUMBER 2 : LOAD PACKAGES	 --------------------------------------------------		
				
				else if(choice==2) 
				{	
					System.out.println("You have chosen option 2: Load Packages.");

					System.out.println("please enter the package tracking number");
					trackingNumber=keyin.nextLong();
					
					
				do { //do while loop for the weight options

					System.out.print("\nIf you are entering the weight in oz : enter oz. "
							+ "\nIf you are entering the weight in lb: enter lb");

					weightUnitchoice=keyin.next();
			
					if(weightUnitchoice.equalsIgnoreCase("oz"))
					{
						System.out.println("\nyou have chosen to enter the weight in oz");
						Weight=keyin.nextDouble(); // saving the weight in oz to the weight variable
						 convertedWeight=Package.oztoPounds(Weight); // converting the weight to pounds using oztoPounds method 

						System.out.println("The packages  weight in pounds is : "+convertedWeight);
						break; //exit the loop and move on
					}
					else if(weightUnitchoice.equalsIgnoreCase("lb"))
					{
						System.out.println("you have chosen to enter the weight in lb");
						// if the weight is in lbs, it is technically already converted to the correct weight, so we save the weight in lbs to converted weight
						convertedWeight=keyin.nextDouble(); 

						System.out.println("the weight in pounds is "+convertedWeight);
						break; //exit loop and move on
					}
					else
					{ // if oz or lbs was not entered, display this  message
						System.out.println("you did not enter a valid weight unit");
					}
					
					// continues looping until the user enters either oz ot lb
				}while(!(weightUnitchoice.equalsIgnoreCase("oz"))||!(weightUnitchoice.equalsIgnoreCase("lb")));
					
				// creating various package objects with only the converted weight as their attribute, then calling the
				//shipping cost method to calculate shipping cost
				
					Letter letter=new Letter(convertedWeight); 
					letter.shippingCost(convertedWeight, true); 
					
					Box box=new Box(convertedWeight);
					box.shippingCost(convertedWeight, true);
					
					MetalCrate mc= new MetalCrate(Weight);
					mc.shippingCost(convertedWeight, true);
					
					WoodCrate wc=new WoodCrate(Weight);
					wc.shippingCost(convertedWeight, true);
				
				System.out.println();
				
				
				try {	
					
					if(trackingNumber%10==0) //if it is a letter,
					{
						System.out.println("The shipping cost is : " +letter.getShippingCost());
						System.out.println();
						System.out.println("You are loading a Letter");
						
						//call the loadPackage method using a new Letter object that has all 3 attributes of a package
						truck.loadPackage(letter= new Letter(trackingNumber,convertedWeight,letter.getShippingCost()));	
					}
					else if(trackingNumber%10==1) //if its a box
					{
						System.out.println("The shipping cost is : " +box.getShippingCost());
						System.out.println();
						System.out.println("You are loading a Box");
						//call the loadPackage method using a new Box object that has all 3 attributes of a package
						truck.loadPackage( box=new Box (trackingNumber,convertedWeight, box.getShippingCost()));
					}
					else if(trackingNumber%10==2) //if its a wood crate
					{
						System.out.println("The shipping cost is : " +wc.getShippingCost());
						System.out.println();
						System.out.println("You are loading a Wood Crate");
						//call the loadPackage method using a new WoodCrate object that has all 3 attributes of a package
						truck.loadPackage(wc=new WoodCrate(trackingNumber,convertedWeight,wc.getShippingCost()));
					}
					else if(trackingNumber%10==3) //if its a metal crate
					{
						System.out.println("The shipping cost is : " +mc.getShippingCost());
						System.out.println();
						System.out.println("You are loading a Metal Crate");
						//call the loadPackage method using a new MetalCrate object that has all 3 attributes of a package
						truck.loadPackage(mc=new MetalCrate(trackingNumber,convertedWeight,mc.getShippingCost()));
					}
					else  // if its not a valid package, we throw an exception
					{
						throw new PackageException("This is not a valid Package. We cannot load it");
					}
				}catch(PackageException e)
				{
					System.out.println(e.getMessage()); // print error message
					//print the toString of the unknown package
					System.out.println( "This is an unknown package [ trackingnumber : "+trackingNumber+ " Weight : "+convertedWeight+" Shipping Cost : No shipping cost]");
				}
			}

//-----------------------------------------		NUMBER 3: UNLOAD A PACKAGE		--------------------------------------------------------------------
				else if(choice==3)
				{
					System.out.println("you have chosen unload packages."
							+ "Unloading the package at the last index of the array.");
					
					System.out.println("The package being unloaded is :"+ truck.arrayPackage[truck.getLoadingIndex()]);
					truck.unloadPackage(truck.getLoadingIndex());
					
					truck.setLoadingIndex(truck.getLoadingIndex()-1);
				}

//------------------------------------------	NUMBER 4 : NUMBER OF PACKAGES	--------------------------------------------------------------------
				else if(choice==4)
				{		//call the attribute of the truck class loadingIndex, which increments everytime a package is loaded
					System.out.println("The number of packages loaded is "+(truck.getLoadingIndex()+1));
				}
//----------------------------------------		NUMBER 5 : GROSS INCOME EARNED BY CARGO		---------------------------------------------------------
				else if(choice==5)
				{
					double sum=0.0;
					for(int i =0; i<(truck.getLoadingIndex()+1); i++)
					{
						truck.getArrayPackage(); // get the array that has all of the Package objects saved in it
						sum+=truck.arrayPackage[i].getShippingCost(); //get the shipping cost of every object at position i and add it to sum
					}
					System.out.println("The gross income earned by shipping the cargo is "+sum);
				}
//-----------------------------------		NUMBER 6 : THE WEIGHT OF LOADED TRUCK		-----------------------------------------------------------
				else if(choice==6)
				{
					double sumWeight=0.0;
					for(int i=0; i <(truck.getLoadingIndex()+1); i++)
					{
						sumWeight+= truck.arrayPackage[i].getPckgWeight(); //get the weight of the package at position i and add it to the sum
					}
					// since the loaded weight also incudes the unloaded weight of the truck, we add the sum of packages weights and trucks unloaded weight
					System.out.println("the weight of the truck after is has been completely loaded is "+ (sumWeight+unloadedWeight));
					
					
				}
//------------------------------------		NUMBER 7 : TRUCK DRIVING THROUGH CITIES		---------------------------------------
				else if(choice==7)
				{
					System.out.println("The cargo truck is driving from "+ truck.getOriginatingCity()+ " to "+truck.getDestinationCity()+ ".");
				}
				
//--------------------------------------		NUMBER 0: EXITING THE PROGRAM		-------------------------------------------------------
				else if (choice==0)
				{
					System.out.print("Thankyou for using the Cargo program");
					System.exit(0);
				}	


			}while((truck.getLoadingIndex()+1)<200 ||(choice>=0 || choice<=7));
	//the menu option will keep repeating until a user chooses to exit

			keyin.close();
		}

} //end of cargotest class
