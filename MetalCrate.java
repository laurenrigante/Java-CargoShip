

public class MetalCrate extends Crate {

	//child of crate class
	
	private  final double PRICE=3.0;
	
	/**This is the default constructor.  It has no arguments. 
	 * if you do not include a call to a base class constructor (using super), 
	 * then the no-argument/default constructor of the base class is called automatically.*/
	public MetalCrate() {}


	/** This is the parameterized constructor. It takes the following 3 parameters:
	 * @param trackingNumber	Stores the tracking number of the MetalCrate as a long
	 * @param pckgWeight        Stores the weight of the MetalCrate as a double
	 * @param shippingCost		Stores the Cost of shipping of the MetalCrate as a double
	 * we use super to call the parameterized constructor of the Parent class (Package class)
	 *  in order to assign the values of these parameters.*/
	public MetalCrate(long trackingNumber, double pckgWeight, double shippingCost)
	{
		super(trackingNumber,pckgWeight,shippingCost);
	}


	/**This is a parameterized constructor. It takes the following parameter:
	 * @param weight		The weight of the package as a double
	  and assigns it to the pckgWeight */
	public MetalCrate(double weight) 
	{
		pckgWeight=weight;
	}


	/**The overridden shipping cost method that takes the following 2 parameters:
	 * @param weight 		the weight of the package as a double
	 *  @param isPounds		a boolean value which determines if the weight was entered in units of pounds or not
	  and calculates the* shipping cost based on these 2 parameters */
	public  double shippingCost( double weight, boolean isPounds) 
	{
		if(isPounds==true) //if the weight is entered in pounds (The correct weight unit)
		{	
			shippingCost=weight*PRICE; //we simply multiply the weight by the price
			return shippingCost;  //return shipping cost
		}
		else // if the weight was entered in ounces
		{
				double convertedWeight=oztoPounds(weight); // we have to convert the weight from ounces to pounds
				shippingCost=convertedWeight*PRICE; // then we calculate the shipping cost by multiplying weight by price
				return shippingCost; //return shipping cost
		}
	}

	

	@Override
	/**
	 * Overridden toString method to display the information of the Metal Crate
	 */
	public String toString() 
	{
		return "Metal Crate [trackingNumber=" + getTrackingNumber()+ ", package Weight=" + getPckgWeight() + ", shipping Cost="
				+ getShippingCost() + "]";
	}

	
	
}// end of metal crate class
