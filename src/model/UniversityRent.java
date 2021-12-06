package model;

public class UniversityRent extends Rent{
 	private String numberOfProject;


 	/**
 	* This is the constructor method of UniversityRent class
 	* @param rentalNumber, String, this is the number of the rent
	* @param monthlyValue, double, this is the monthly rental value
	* @param rentalDate, Date, this is the date of the rent
	* @param roomNumber, String, this is the number of the rented room
	* @param serversAmount, int, this is the amount of servers in use
	* @param numberOfProject, String, this is the number of the investigation project
 	*/
 	public UniversityRent(String rentalNumber, double monthlyValue, Date rentalDate, String roomNumber, int serversAmount, String numberOfProject){
 		super(rentalNumber, monthlyValue, rentalDate, roomNumber, serversAmount);
 		this.numberOfProject = numberOfProject;

	}

	/**
	* Gets the number of project
	* @return numberOfProject, String, this is the number of the investigation project
	*/
	public String getNumberOfProject (){
		return numberOfProject;
	}

	/**
	* Sets the number of project
	* @param numberOfProject, String, this is the number of the investigation project
	*/
	public void setNumberOfProject (String numberOfProject){
		this.numberOfProject = numberOfProject;
	}

	/**
	* Creates a string with the information of a rent
	* @return rent, String, this is the string with the information
	*/
	public String toString() {
		String rent = "   RENTED ROOM: " + roomNumber + "\n"
			+ "   #Project: " + numberOfProject + "\n"
			+ "   Date of the rent: " + rentalDate.toString() + "\n"
			+ linkedCompany.toString() + "\n"
			+ "   Number of servers: " + serversAmount + "\n"
			+ "   Total rental value: " + monthlyValue + "$";

		return rent;
	}
}