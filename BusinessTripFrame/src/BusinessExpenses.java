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

public class BusinessExpenses {
	// number of days the trip lasted
	private int numDays;
	
	// cost of airfare per day
	private double airfare;
	
	// cost of car rental day
	private double carRental;
	
	// miles driven if business person drove car rental
	private int milesDriven;
	
	// cost of parking fees per day
	private double parkingFees;
	
	// cost of taxi expenses per day
	private double taxiCharges;
	
	// cost of conference or seminar registration fees per day
	private double registrationFees;
	
	// cost of lodging per day
	private double lodgingCharges;
	
	// tracks if user gets a car rental
	private boolean hasRental = false;
	
	// tracks if user gets a taxi
	private boolean hasTaxi = false;
	
	// tracks if user gets parking fees
	private boolean hasParking = false;
	
	public void setNumDays(int userDays) {
		numDays = userDays;		
	}
	
	public void setAirfare(double userAirfare) {
		airfare = userAirfare;
	}
	
	public void setCarRental(double userRental) {
		carRental = userRental;
		if (carRental > 0) {
			hasRental = true;
		}
	}
	
	public void setMilesDriven(int userMiles) {
		if (carRental > 0) {
			milesDriven = userMiles;
		}
	}
	
	public void setParkingFees(double userParking) {
		parkingFees = userParking;
		if (parkingFees > 0) {
			hasParking = true;
		}
	}
	
	public void setTaxiCharges(double userTaxi) {
		taxiCharges = userTaxi;
	}
	
	public void setRegistrationFees(double userRegistration) {
		registrationFees = userRegistration;
	}
	
	public void setLodgingCharges(double userLodging) {
		lodgingCharges = userLodging;
	}
}
