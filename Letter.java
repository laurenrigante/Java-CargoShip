
public class Letter extends Package {
// a child class of Package

	private final double PRICE=0.05; //price per oz of a package
	
	/**This is the default constructor.  It has no arguments. 
	 * if you do not include a call to a base class constructor (using super), 
	 * then the no-argument/default constructor of the base class is called automatically.*/
	public Letter() {}

	/** This is the parameterized constructor. It takes the following 3 parameters:
	 * @param trackingNumber	Stores the tracking number of the letter as a long
	 * @param pckgWeight        Stores the weight of the letter as a double
	 * @param shippingCost		Stores the Cost of shipping of the letter as a double
	 * we use super to call the parameterized constructor of the Parent class (Package class)
	 *  in order to assign the values of these parameters.*/
	public 	Letter(long trackingNumber, double pckgWeight, double shippingCost)
	{
		super(trackingNumber,pckgWeight,shippingCost);
	}

	/**This is a parameterized constructor. It takes the following parameter:
	 * @param weight		The weight of the package as a double
	  and assigns it to the pckgWeight */
	public Letter(double weight)
	{
		pckgWeight=weight;
	}

	
	@Override
	/** This is the overridden shipping Cost method. It takes the following 2 parameters:
	 *  @param weight 		the weight of the package as a double
	 *  @param isPounds		a boolean value which determines if the weight was entered in units of pounds or not
	The method then calculates the shipping cost of the package based on the weight and isPounds */
	public  double shippingCost( double weight, boolean isPounds) 
	{
		if(isPounds==false) //if the package was entered in units of oz
		{	
			shippingCost=weight*PRICE; //we multiply the weight in oz by the price(since letter is 0.05$ per ounce
			return shippingCost; 	// we return the shipping cost
		}
		else //the weight was entered in pounds
		{
				double convertedWeight=poundstoOz(weight); // we take the weight entered and convert it to ounces
				shippingCost=convertedWeight*PRICE; //we then calculate the shipping cost 
				return shippingCost; //we return the shipping cost
		}
	}

	


	@Override
	/** This is the overridden to String method that will display the information of the letter*/
	public String toString()
	{
		return "letter [trackingNumber=" + getTrackingNumber()+ ", package Weight=" + getPckgWeight() + ", shipping Cost="
				+ getShippingCost() + "]";
	}
		
}//end of letter class
