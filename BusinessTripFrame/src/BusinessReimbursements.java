/*******************************************************************************
'Project: Java GUI Assignment 01
'Programmer: Ari Gaskins
'Company Info:  arigaskins.work@gmail.com
'Date: 26 07 2023
'Description:  Problem Number 2.  
'    
'   Application with graphical user interface that allows business person
'   user to enter their business trip expenses - lodging, taxi, rental, 
'   airfare, etc. User is shown their total expenses, company's reimbursement 
'	amount, excess user needs to pay, and the amount they save if the 
'	expenses don't exceed the reimbursements.
'
'
'  LINE LENGTH - AVOID LINES LONGER THAN 80 CHARACTERS
'  SCALE BELOW IS TO CALIBRATE SCREENSHOTS
'  DO NOT HAVE YOUR CODE OR SCREENSHOT EXTEND BEYOND THE SCALE
0........1.........2.........3.........4.........5.........6.........7.........8
12345678901234567890123456789012345678901234567890123456789012345678901234567890
*/


/**
 * A class intended to establish reimbursement amounts and return those 
 * values. This class will return values only if certain values' associated
 * boolean fields are true.
 * @author Ari Gaskins
 * @version 1.0
 */
public class BusinessReimbursements {
	// amount paid for meals per day
	private double mealsPaid = 37.0;
	
	// amount paid for parking per day
	private double parkingPaid = 10.0;
	
	// amount paid taxi charges per day
	private double taxiPaid = 20.0;
	
	// amount paid for lodging charges per day
	private double lodgingPaid = 97.40;
	
	// rate paid for miles driven in a car rental
	private double mileageRate = 0.27;
	
	// amount reimbursed based on number of miles driven
	private double milesReimbursed;
	
	// number of days the business trip lasts
	private int numDays;
	
	// total reimbursements business person is able to receive
	private double totalReimbursements;
	
	// tracks if user has a car rental for reimbursement
	private boolean hasRental;
		
	// tracks if user gets a taxi
	private boolean hasTaxi;
		
	// tracks if user gets parking fees
	private boolean hasParking;
		
	// tracks if user gets lodging charges
	private boolean hasLodging;
	
	
	/**
	 * Constructor for initializing the number of days to 1 when 
	 * an object is created.
	 */
	public BusinessReimbursements() {
		this.numDays = 1;
		this.hasRental = false;
		this.hasTaxi = false;
		this.hasParking = false;
		this.hasLodging = false;
	}
	
	/**
	 * Constructor for initializing the number of days to parameter
	 * and setting the boolean values based on if items exist.
	 * @paramnumDays int number of days trip lasted
	 */
	public BusinessReimbursements(int numDays, boolean hasRental, 
			boolean hasTaxi, boolean hasParking, boolean hasLodging) {
		this.numDays = numDays;
		this.hasRental = hasRental;
		this.hasTaxi = hasTaxi;
		this.hasParking = hasParking;
		this.hasLodging = hasLodging;
	}
	
	/**
	 * Mutator for milesReimbursed based on number of miles driven entered
	 * by user.
	 * @param milesDriven int number of miles driven 
	 */
	public void setMilesReimbursed(int milesDriven) {
		if (hasRental) {
			milesReimbursed = milesDriven * mileageRate;
		}
		else {
			milesReimbursed = 0;
		}
	}
	
	/**
	 * Return milesReimbursed
	 * @return
	 */
	public double getMilesReimbursed() {
		return milesReimbursed;
	}
	
	/**
	 * Return mealsPaid
	 * @return mealsPaid double amount paid for meals per day
	 */
	public double getMealsPaid() {
		return mealsPaid;
	}
	
	/**
	 * Return parkingPaid
	 * @return parkingPaid double amount paid for parking per day
	 */
	public double getParkingPaid() {
		if (hasParking) {
			return parkingPaid;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Return taxiPaid
	 * @return taxiPaid double amount paid for taxi charges
	 */
	public double getTaxiPaid() {
		if (hasTaxi) {
			return taxiPaid;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Return lodgingPaid if user has lodging input 
	 * @return lodgingPaid double amount paid for lodging charges
	 */
	public double getLodgingPaid() {
		if (hasLodging) {
			return lodgingPaid;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Return mileageRate 
	 * @return mileageRate double rate paid for miles driven in a car rental
	 */
	public double getMileageRate() {
		if (hasRental) {
			return mileageRate;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Return numDays
	 * @return numDays int number of days the business trip lasts
	 */
	public int getNumDays() {
		return numDays;
	}
	
	public double getTotalReimbursements() {
		totalReimbursements = (getMealsPaid() + getParkingPaid() + getTaxiPaid()
			+ getLodgingPaid()) * numDays;
		
		return totalReimbursements;
	}
}
