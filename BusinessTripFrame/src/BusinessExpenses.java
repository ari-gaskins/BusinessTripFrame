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
	
	// tracks if user gets lodging charges
	private boolean hasLodging = false;
	
	/**
	 * Mutator for numDays.
	 * @paramuserDays int user input number of days
	 */
	public void setNumDays(int userDays) {
		numDays = userDays;		
	}
	
	/**
	 * Mutator for airfare.
	 * @paramuserAirfare double user input cost of airfare
	 */
	public void setAirfare(double userAirfare) {
		airfare = userAirfare;
	}
	
	/**
	 * Mutator for carRental. Sets hasRental if carRental exists.
	 * @paramuserRental double user input cost of car rental
	 */
	public void setCarRental(double userRental) {
		carRental = userRental;
		if (carRental > 0) {
			hasRental = true;
		}
	}
	
	/**
	 * Mutator for milesDriven. Sets to user input if carRental exists.
	 * @paramuserMiles int user input number of miles driven in rental
	 */
	public void setMilesDriven(int userMiles) {
		if (hasRental) {
			milesDriven = userMiles;
		}
		else {
			milesDriven = 0;
		}
	}
	
	/**
	 * Mutator for parkingFees. Sets hasParking if parkingFees exists.
	 * @paramuserParking double user input cost of parking fees
	 */
	public void setParkingFees(double userParking) {
		parkingFees = userParking;
		if (parkingFees > 0) {
			hasParking = true;
		}
	}
	
	/**
	 * Mutator for taxiCharges. Sets hasTaxi if taxiCharges exists.
	 * @param userTaxi double user input cost of taxi charges
	 */
	public void setTaxiCharges(double userTaxi) {
		taxiCharges = userTaxi;
		if (taxiCharges > 0) {
			hasTaxi = true;
		}
	}
	
	/**
	 * Mutator for registrationFees. 
	 * @paramuserRegistration double user input cost of registration fees
	 */
	public void setRegistrationFees(double userRegistration) {
		registrationFees = userRegistration;
	}
	
	/**
	 * Mutator for lodgingCharges. Sets hasLodging if lodgingCharges exists.
	 * @paramuserLodging 
	 */
	public void setLodgingCharges(double userLodging) {
		lodgingCharges = userLodging;
		if (lodgingCharges > 0) {
			hasLodging = true;
		}
	}
	
	/**
	 * Return number of days the trip lasted.
	 * @return numDays
	 */
	public int getNumDays() {
		return numDays;
	}
	
	/**
	 * Return cost of airfare.
	 * @return airfare
	 */
	public double getAirfare() {
		return airfare;
	}
	
	/**
	 * Return cost of car rental.
	 * @return carRental
	 */
	public double carRental() {
		return carRental;
	}
	
	/**
	 * Return number of miles driven.
	 * @return milesDriven
	 */
	public int getMilesDriven() {
		return milesDriven;
	}
	
	/**
	 * Return cost of parking fees.
	 * @return parkingFees
	 */
	public double getParkingFees() {
		return parkingFees;
	}
	
	/**
	 * Return cost of taxi charges
	 * @return taxiCharges
	 */
	public double getTaxiCharges() {
		return taxiCharges;
	}
	
	/**
	 * Return cost of registration fees
	 * @return registrationFees
	 */
	public double getRegistrationFees() {
		return registrationFees;
	}
	
	/**
	 * Return cost of lodging
	 * @return lodgingCharges
	 */
	public double getLodgingCharges() {
		return lodgingCharges;
	}
	
	/**
	 * Return whether user has car rental
	 * @return hasRental boolean true if user has car rental false if not
	 */
	public boolean getHasRental() {
		return hasRental;
	}
	
	/**
	 * Return whether user has taxi charges
	 * @return hasTaxi boolean true if user has taxi charges false if not
	 */
	public boolean getHasTaxi() {
		return hasTaxi;
	}
	
	/**
	 * Return whether user has parking fees
	 * @return hasParking boolean true if user has parking fees false if not
	 */
	public boolean getHasParking() {
		return hasParking;
	}
	
	/**
	 * Return whether user has lodging charges
	 * @return hasLodging boolean true if user has lodging charges false if not
	 */
	public boolean getHasLodging() {
		return hasLodging;
	}
	
	/**
	 * Return total expenses based on number of days
	 * @return total expenses double total fees times number of days
	 */
	public double getTotalExpenses() {
		double totalExpenses;
		
		totalExpenses = (airfare + carRental + parkingFees + taxiCharges 
				+ registrationFees + lodgingCharges) * numDays;
		
		return totalExpenses;
	}
}
