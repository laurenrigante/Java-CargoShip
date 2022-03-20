

public class Crate extends Package {

	//child of package class
	
	
	/**This is the default constructor.  It has no arguments. 
	 * if you do not include a call to a base class constructor (using super), 
	 * then the no-argument/default constructor of the base class is called automatically.*/
	public Crate() {}

	/** This is the parameterized constructor. It takes the following 3 parameters:
	 * @param trackingNumber	Stores the tracking number of the MetalCrate as a long
	 * @param pckgWeight        Stores the weight of the MetalCrate as a double
	 * @param shippingCost		Stores the Cost of shipping of the MetalCrate as a double
	 * we use super to call the parameterized constructor of the Parent class (Package class)
	 *  in order to assign the values of these parameters.*/
	public Crate(long trackingNumber, double pckgWeight, double shippingCost)
	{
		super(trackingNumber,pckgWeight,shippingCost);
	}

	
	@Override
	/**The overridden shipping cost method that takes the following 2 parameters:
	 * @param weight 		the weight of the package as a double
	 *  @param isPounds		a boolean value which determines if the weight was entered in units of pounds or not
	  and calculates the* shipping cost based on these 2 parameters */
	//in this case, crate price changes depending on the type of crate. so we do not calculate the shipping cost here
	public double shippingCost(double Weight, boolean isPounds) 
	{
		return 0;
	}
	
	
	
	@Override
	/** Overridden toString method that displays the information of the crate*/
	public String toString() 
	{
		return "Crate [trackingNumber=" + getTrackingNumber()+ ", package Weight=" + getPckgWeight() + ", shipping Cost="
				+ getShippingCost() + "]";
	}

	
	
}//end of crate class
