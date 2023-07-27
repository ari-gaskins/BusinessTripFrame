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
	
	// number of days the business trip lasts
	private int numDays;
	
	/**
	 * Constructor for initializing the number of days 
	 */
	public BusinessReimbursements() {
		this.numDays = 1;
	}
	
	public BusinessReimbursements(int numDays) {
		this.numDays = numDays;
	}
	
	public double getMealsPaid() {
		return mealsPaid;
	}
	
	public double getParkingPaid() {
		return parkingPaid;
	}
	
	public double getTaxiPaid() {
		return taxiPaid;
	}
	
	public double getLodgingPaid() {
		return lodgingPaid;
	}
	
	public double getMileageRate() {
		return mileageRate;
	}
	
	public int getNumDays() {
		return numDays;
	}
	
}
