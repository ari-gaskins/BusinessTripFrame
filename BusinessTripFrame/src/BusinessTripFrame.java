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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;


public class BusinessTripFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// the total amount available for reimbursement
	private double totalReimbursements;
		
	// the total expenses accrued by the user
	private double totalExpenses;
		
	// the total cost that the user must pay
	private double userCost;
	
	// text field for user to enter the cost of airfare
	private JTextField userAirfare;
	
	// text field for user to enter the cost of car rental
	private JTextField userCarRental;
	
	// text field for user to enter # of miles driven for rental
	private JTextField userMilesDriven;
	
	// text field for user to enter the cost of taxi charges
	private JTextField userTaxiCharges;
	
	// text field for user to enter the cost of registration fees
	private JTextField userRegistrationFees;
	
	// text field for user to enter the cost of lodging charges
	private JTextField userLodgingCharges;
	
	// text field for user to enter # of days business trip lasted
	private JTextField userNumDays;
	
	// output of total eligible reimbursements
	private JTextField userReimbursements;
	
	// output of total user input expenses
	private JTextField userTotalExpenses;
	
	// output of user cost after expenses & reimbursements calculated
	private JTextField userFinalCost;
	
	// label for airfare cost
	private JLabel airfareLabel;
	
	// label for car rental cost
	private JLabel rentalLabel;
	
	// label for miles driven cost
	private JLabel milesLabel;
	
	// label for taxi cost
	private JLabel taxiLabel;
	
	// label for registration cost
	private JLabel registrationLabel;
	
	// label for lodging cost
	private JLabel lodgingLabel;
	
	// label for length of trip in days
	private JLabel numDaysLabel;
	
	// label for the final user cost
	private JLabel finalCostLabel;
	
	// label for the total eligible reimbursements
	private JLabel reimbursementsLabel;
	
	// label for the total user expenses
	private JLabel expensesLabel;
	
	// button to submit form data
	private JButton submitButton = new JButton("Submit");
	
	// declare BusinessExpenses object
	private BusinessExpenses expensesObj;
	
	// declare BusinessReimbursements object
	private BusinessReimbursements reimbursementsObj;
	
	BusinessTripFrame() {
		// specifies GUI component layout
		GridBagConstraints layoutConstraints = null;
		
		// set frame title
		setTitle("Business Trip Expense Report");
		
		// initialize objects
		expensesObj = new BusinessExpenses();
		reimbursementsObj = new BusinessReimbursements();
		
		// initialize labels
		airfareLabel = new JLabel("Cost of Airfare:");
		rentalLabel = new JLabel("Cost of rental vehicle:");
		milesLabel = new JLabel("Number of miles driven in rental:");
		taxiLabel = new JLabel("Cost of taxi charges:");
		registrationLabel = new JLabel("Cost of registration fees:");
		lodgingLabel = new JLabel("Cost of lodging:");
		numDaysLabel = new JLabel("Length of trip (in days):");
		reimbursementsLabel = new JLabel("Eligble reimbursements:");
		expensesLabel = new JLabel("Total expenses:");
		finalCostLabel = new JLabel("Amount you pay:");
		
		// initialize text fields
		userAirfare = new JTextField(20);
		userAirfare.setEditable(true);
		
		userCarRental = new JTextField(20);
		userCarRental.setEditable(true);
		
		userMilesDriven = new JTextField(20);
		userMilesDriven.setEditable(true);
		
		userTaxiCharges = new JTextField(20);
		userTaxiCharges.setEditable(true);
		
		userRegistrationFees = new JTextField(20);
		userRegistrationFees.setEditable(true);
		
		userLodgingCharges = new JTextField(20);
		userLodgingCharges.setEditable(true);
		
		userNumDays = new JTextField(20);
		userNumDays.setEditable(true);
		
		userReimbursements = new JTextField(20);
		userReimbursements.setEditable(false);
		userReimbursements.setText(String.valueOf(totalReimbursements));
		
		userTotalExpenses = new JTextField(20);
		userTotalExpenses.setEditable(false);
		userTotalExpenses.setText(String.valueOf(totalExpenses));
		
		userFinalCost = new JTextField(20);
		userFinalCost.setEditable(false);
		userFinalCost.setText(String.valueOf(userCost));
		
		
		// Use a GridBagLayout
		setLayout(new GridBagLayout());
		
		// set component's locations: labels
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 0;
		add(airfareLabel, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 1;
		add(rentalLabel, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 2;
		add(milesLabel, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 3;
		add(taxiLabel, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 4;
		add(registrationLabel, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 5;
		add(lodgingLabel, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 6;
		add(numDaysLabel, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.LAST_LINE_START;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 7;
		add(reimbursementsLabel, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.LAST_LINE_START;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 8;
		add(expensesLabel, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.LAST_LINE_START;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 9;
		add(finalCostLabel, layoutConstraints);
		
		// set component's locations: fields
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 0;
		add(userAirfare, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 1;
		add(userCarRental, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 2;
		add(userMilesDriven, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.LINE_END;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 3;
		add(userTaxiCharges, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.LINE_END;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 4;
		add(userRegistrationFees, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.LINE_END;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 5;
		add(userLodgingCharges, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.LINE_END;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 6;
		add(userNumDays, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.LAST_LINE_END;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 7;
		add(userReimbursements, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.LAST_LINE_END;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 8;
		add(userTotalExpenses, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.LAST_LINE_END;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 9;
		add(userFinalCost, layoutConstraints);
		
		layoutConstraints = new GridBagConstraints();
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.LAST_LINE_END;
		layoutConstraints.weightx = 0.5;
		layoutConstraints.weighty = 0.5;
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 10;
		add(submitButton, layoutConstraints);
	}
	
	public void getTotalExpenses() {
		String airfareText = userAirfare.getText();
		String rentalText = userCarRental.getText();
		String milesText = userMilesDriven.getText();
		String taxiText = userTaxiCharges.getText();
		String registrationText = userRegistrationFees.getText();
		String lodgingText = userLodgingCharges.getText();
		String numDaysText = userNumDays.getText();
		
		double airfareValue = checkValue(airfareText);
		double rentalValue = checkValue(rentalText);
		double milesValue = checkValue(milesText);
		double taxiValue = checkValue(taxiText);
		double registrationValue = checkValue(registrationText);
		double lodgingValue = checkValue(lodgingText);
		double numDaysValue = checkValue(numDaysText);
		
		
	}
	
	public double checkValue(String value) {
		double newValue;
		
		if (value == null) {
			newValue = 0.0;
			return newValue;
		}
		else if (Double.valueOf(value) >= 0) {
			newValue = Double.valueOf(value);
			return newValue;
		}
		else {
			throw new InputMismatchException("Invalid value entered.");
		}
	}
	
	public static void main(String[] args) {
		// declares and initializes BusinessTripFrame and its components
		BusinessTripFrame tripFrame = new BusinessTripFrame();
		
		tripFrame.setSize(1650, 1080);
		tripFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tripFrame.pack();
		tripFrame.setVisible(true);
	}

}
