
public abstract class Package {
	
	protected long trackingNumber;
	protected   double pckgWeight;
	protected double shippingCost;
	protected int nbrPackages;
	
	protected final double maxPckgWeight=100.00;
	protected  Package [] arrayPackage;
	protected int i=0;

	
	
	//--------------------------------------constructors-----------------------------------------------------
	
	/**This is the default constructor.  It has no arguments. */
	public Package() {}
	

	/** This is the parameterized constructor. It takes the following 3 parameters:
	 * @param trackingNumber	Stores the tracking number of the package as a long
	 * @param pckgWeight        Stores the weight of the package as a double
	 * @param shippingCost		Stores the Cost of shipping of the package as a double. Shipping cost is based on weight */
	public Package(long trackingNumber, double pckgWeight, double shippingCost)
	{
		this.trackingNumber=trackingNumber;
		this.pckgWeight=pckgWeight;
		this.shippingCost=shippingCost;
	}
	
	
	//---------------------------------get and set methods------------------------------------------------
	
	/** Get method to get the tracking number of the package
	 * @return the tracking number */
	public long getTrackingNumber() 
	{
		return trackingNumber;
	}
	

	/** Set method to set the tracking number of the package 
	 * @param trackingNumber  The tracking number of the package as a long
	 */
	public void setTrackingNumber(long trackingNumber) 
	{
		this.trackingNumber = trackingNumber;
	}

	
	/** get method to get the weight of the package
	 * @return package weight */
	public  double getPckgWeight()
	{
		return pckgWeight;
	}
	
	/** set method to set the weight of the package
	 * @param pckgWeight the weight of the package as a double*/
	public   void setPckgWeight(double pckgWeight)
	{
		this.pckgWeight = pckgWeight;
	}

	
	/** get method to get the shipping cost of the package
	 *	@return the shipping cost*/
	public double getShippingCost()
	{
		return shippingCost;
	}

	
	/**Set method to set the shipping cost of the package
	 * @param shippingCost cost of the shipping*/
	public void setShippingCost(double shippingCost) 
	{
		this.shippingCost = shippingCost;
	}


	/** get method to get the number of packages 
	 *	@return the number of packages */
	public int getnbrPackages()
	{
		for(int i=0; i<arrayPackage.length;i++)
		{
			nbrPackages+=i;
		}
		return nbrPackages;
	}
	
	/**Set method to set the number of packages
	 * @param nbrPackages   the number of packages*/
	public void setnbrPackages(int nbrPackages)
	{
		this.nbrPackages=nbrPackages;
	}
	
	/** get method to get the maximum weight of the packages 
	 *	@return the maximum weight of  packages */
	 public double getMaxPckgWeight() {
		return maxPckgWeight;
	}


	
	
	
	//--------------------------------------------Methods----------------------------------------------


	/** Abstract method that we can extend in the derived classes. This method will 
	  * calculate the shipping cost based on the weight and type of the package
	  * @return the shipping cost as a double */
	public  abstract double shippingCost(double Weight, boolean isPounds);
	
	
	
	/** Method that turns ounces to pounds ( for the letter Package)
	 * @return  the package weight in pounds as a double*/
	public static  double oztoPounds(double weight) 
	{
		 return  weight/16.0;
	}
	public static double poundstoOz(double weight)
	{
		return weight*16.0;
	}
	
	
	/**To String method that prints the basic information on the packages
	 * Will be overridden in derived classes */
	@Override
	public String toString()
	{
		return "Package [trackingNumber=" + trackingNumber + ", package Weight=" + pckgWeight + ", shipping Cost="
				+ shippingCost + "]";
	}

	
}