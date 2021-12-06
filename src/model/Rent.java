package model;

public class Rent{

	protected String rentalNumber;
	protected double monthlyValue;
	protected Company linkedCompany;
	protected Date rentalDate;
	protected String roomNumber;
	protected int serversAmount;

	/**
	* This is the constructor method of Rent class
	* @param rentalNumber, String, this is the number of the rent
	* @param monthlyValue, double, this is the monthly rental value
	* @param rentalDate, Date, this is the date of the rent
	* @param roomNumber, String, this is the number of the rented room
	* @param serversAmount, int, this is the amount of servers in use
	*/
	public Rent (String rentalNumber, double monthlyValue, Date rentalDate, String roomNumber, int serversAmount){
		this.monthlyValue = monthlyValue;
		this.rentalDate = rentalDate;
		this.rentalNumber = rentalNumber;
		this.roomNumber = roomNumber;
		this.serversAmount = serversAmount;
	}

	/**
	* Gets the number of the room rented
	* @return roomNumber, String, this is the number of the room
	*/
	public String getRoomNumber (){
		return roomNumber;
	}

	/**
	* Sets the number of the room rented
	* @param roomNumber, String, this is the number of the room
	*/
	public void setRoomNumber (String roomNumber){
		this.roomNumber = roomNumber;
	}

	/**
	* Gets the amount of servers
	* @return serversAmount, int,this is the amount of servers 
	*/
	public int getServersAmount (){
		return serversAmount;
	}

	/**
	* Sets the amount of servers
	* @param serversAmount, int,this is the amount of servers 
	*/
	public void setServersAmount (int serversAmount){
		this.serversAmount = serversAmount;
	}

	/**
	* Gets the rental number
	* @return rentalNumber, String, this is the rental number 
	*/
	public String getRentalNumber (){
		return rentalNumber;
	}

	/**
	* Sets the rental number
	* @param rentalNumber, String, this is the rental number 
	*/
	public void setRentalNumber (String rentalNumber){
		this.rentalNumber = rentalNumber;
	}

	/**
	* Gets the linked company of the room
	* @return linkedCompany, Company, this is the company that is related with the room 
	*/
	public Company getLinkedCompany (){
		return linkedCompany;
	}

	/**
	* Sets the linked company of the room
	* @param linkedCompany, Company, this is the company that is related with the room 
	*/
	public void setLinkedCompany (Company linkedCompany){
		this.linkedCompany = linkedCompany;
	}

	/**
	* Gets the date
	* @return date, Date, this is the date related with the rental record
	*/
	public Date getRentalDate() {
		return rentalDate;
	}

	/**
	* Sets the date
	* @param rentalDate, Date, this is the date related with the rental record
	*/
	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	/**
	* Gets the rental value
	* @return monthlyValue, double, this is the value of the rent
	*/
	public double getRentalValue (){
		return monthlyValue;
	}

	/**
	* Sets the rental value
	* @param monthlyValue, double, this is the value of the rent
	*/
	public void setRentalValue (double monthlyValue){
		this.monthlyValue = monthlyValue;
	}

	/**
	* Gets the name of the company that rents the room
	* @return name, String, name of the company
	*/
	public String getCompanyName(){
		return linkedCompany.getName();
	}

	/**
	* Creates a string with the information of a rent
	* @return rent, String, this is the string with the information
	*/
	public String toString() {
		String rent = "   RENTED ROOM: " + roomNumber + "\n"
			+ "   Date of the rent: " + rentalDate.toString() + "\n"
			+ linkedCompany.toString() + "\n"
			+ "   Total rental value: " + monthlyValue + "$";

		return rent;
	}

}