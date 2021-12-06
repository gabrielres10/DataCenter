package model;
import java.util.ArrayList;
	/*
	* This is the controller class
	*/
public class Center{
	private double baseValue;
	private MiniRoom miniRooms[][];
	private ArrayList<Rent> rents;

	/**
	* This is the constructor method for Center class
	* @param baseValue, double, this is the base value for all the rooms of the center
	*/
	public Center (double baseValue){
		this.baseValue = baseValue;
		this.miniRooms = new MiniRoom[8][50];
		this.rents = new ArrayList<Rent>();
	}

	/**
	* Gets the base value of all the rooms
	* @return baseValue, double, this is the base value of the rooms and it depends on the location
	*/
	public double getBaseValue (){
		return baseValue;
	}

	/**
	* Sets the base value of all the rooms
	* @param baseValue, double, this is the base value of the rooms and it depends on the location
	*/
	public void setBaseValue (double baseValue){
		this.baseValue = baseValue;
	}

	/**
	* Gets the mini rooms
	* @return miniRooms[][], MiniRoom, this is a matrix with the rooms
	*/
	public MiniRoom [][] getMiniRooms (){
		return miniRooms;
	}

	/**
	* Sets the mini rooms
	* @param miniRooms[][], MiniRoom, this is a matrix with the rooms
	*/
	public void setMiniRooms (MiniRoom [][] miniRooms){
		this.miniRooms = miniRooms;
	}

	/**
	* Gets the array of rents
	* @return rents, ArrayList[Rent] rents of the center
	*/
	public ArrayList<Rent> getRents (){
		return rents;
	}

	/**
	* Sets an array of rents
	* @param rents, ArrayList[Rent] rents of the center
	*/
	public void setRents (ArrayList<Rent> rents){
		this.rents = rents;
	}

	/**
	* Adds a rent to the array of rents
	* @param rent, Rent, this is the new rent to add
	*/
	public void addRent(Rent rent){
		this.rents.add(rent);
	}

	/**
	* Sets a new room in a position of the matrix
	* @param i, int, this is the row
	* @param j, int, this is the column
	* @param room, MiniRoom, this is the room to add
	*/
	public void setRoom(int i, int j, MiniRoom room){
		this.miniRooms[i][j] = room;
	}


	/**
	* Creates all the rooms
	*/
	public void createRooms(){
		Location roomLocation = Location.NO_WINDOW;
		Location window = Location.WINDOW;
		char [] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		double rentalValue = baseValue;


		for (int i = 0; i < miniRooms.length ; i++ ) {
			roomLocation = Location.NO_WINDOW;
			rentalValue = baseValue; 

			for (int j = 0; j < miniRooms[1].length ; j++ ) {
				roomLocation = Location.NO_WINDOW;
				rentalValue = baseValue; 

				String roomNumber = "" + alphabet[i] + (j+1);
				if (i == 0 || i == 7 || j == 0 || j == 49) {
					roomLocation = Location.WINDOW;
				}
				if (roomLocation.equals(window)) {
					rentalValue *= 0.90;
				}else if (i == 6) {
					rentalValue *= 0.85;
				}else if (i >= 1 && i <= 5) {
					rentalValue *= 1.25;
				}
				setRoom(i, j, new MiniRoom (roomNumber, roomLocation, rentalValue));
			}
		}
	}

	/**
	* Creates a String with the information of the rooms
	* @return availableRooms, String, This is the information of all the rooms
	*/
	public String showRooms(){
		char [] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		Status available = Status.AVAILABLE;
		String availableRooms = "";
		for (int i = 0; i < miniRooms.length ; i++ ) {
			availableRooms += "\n                 ------------------------------------Hall " + alphabet[i] + "--------------------------------------" + "\n \n";
			for (int j = 0; j < miniRooms[1].length ; j++ ) {
				if (miniRooms[i][j].getAvailability().equals(available)) {
					availableRooms += "                      " + miniRooms[i][j].toString() + "\n     ____________________________________\n" ;
				}
			}
		}

		return availableRooms;
	}

	/** 
	* Returns the row index of the room that matches with the number entered as parameter
	* @param roomNumber, String, number which match will be searched
	* @return  matchFound, int, row index of the room that matches with the number entered as parameter, the value will be -1 otherwise
	*/
	public int roomNumberMatchI(String roomNumber) {
		int matchFound = -1;
		boolean flag = false;
		String num = "";
		for (int i = 0; i<miniRooms.length && !flag ;i++ ) {
			for (int j = 0; j < miniRooms[1].length && !flag ;j++) {
				num = miniRooms[i][j].getUniqueNumber().toUpperCase();
				if (num.equals(roomNumber.toUpperCase())) {
					matchFound = i;
					flag = true;
				}
			}
		}
		return matchFound;
	}


	/** 
	* Returns the column index of the room that matches with the number entered as parameter
	* @param roomNumber, String, number which match will be searched
	* @return  matchFound, int, column index of the room that matches with the number entered as parameter, the value will be -1 otherwise
	*/
	public int roomNumberMatchJ(String roomNumber) {
		int matchFound = -1;
		boolean flag = false;
		String num = "";
		for (int i = 0; i<miniRooms.length && !flag ;i++ ) {
			for (int j = 0; j < miniRooms[1].length && !flag ;j++) {
				num = miniRooms[i][j].getUniqueNumber().toUpperCase();
				if (num.equals(roomNumber.toUpperCase())) {
					matchFound = j;
					flag = true;
				}
			}
		}
		return matchFound;
	}


	/**
	* Verifies if at least one room is available
	* @return out, boolean, true if there is at least one available room, false otherwise
	*/
	public boolean atLeastOneAvailableRoom(){

		Status available = Status.AVAILABLE;
		boolean out = false;
		for (int i = 0; i < miniRooms.length ; i++ ) {
			for (int j = 0; j < miniRooms[1].length ; j++ ) {
				if (miniRooms[i][j].getAvailability().equals(available)) {
					out = true;
				}
			}
		}

		return out;
	}

	/**
	* Verifies if at least one room is occupied
	* @return out, boolean, true if there is at least one occupied room, false otherwise
	*/
	public boolean atLeastOneOccupiedRoom(){

		Status occupied = Status.OCCUPIED;
		boolean out = false;
		for (int i = 0; i < miniRooms.length ; i++ ) {
			for (int j = 0; j < miniRooms[1].length ; j++ ) {
				if (miniRooms[i][j].getAvailability().equals(occupied)) {
					out = true;
				}
			}
		}

		return out;
	}

	/**
	* Verifies if a room is available
	* @param roomNumber, String, this is the number of the room
	* @return out, boolean, true if the room is available, false otherwise
	*/
	public boolean verifyAvailability (String roomNumber){
		int i = roomNumberMatchI(roomNumber);
		int j = roomNumberMatchJ(roomNumber);
		boolean out = false;
		Status available = Status.AVAILABLE;

		if (miniRooms[i][j].getAvailability().equals(available)) {
			out = true;
		}

		return out;
	}

	/**
	* Creates a new rent
	* @param day, int, day of the rent
	* @param month, int, month of the rent
	* @param year, int, year of the rent
	* @param servers, int, amount of servers for the rent
	* @param cache, double, this value can be a decimal number and its unit of measurement is GB (GygaByte)
	* @param processors, int, this is the number of processors that the server has
	* @param ram, double, this is the amount of ram memory which the server works with
	* @param disks, int, this is the amount of disks the server works with and it's an integer number
	* @param disksCapacity, double, this is the capacity of the disks. All disks work with the same capacity
	* @param brand, boolean, this boolean represents the brand of the server, true for INTEL, false for AMD
	* @param surcharge, double, this is the percentage of surcharge in the cost of the rent
	* @param roomNumber, String, this is the reference of the room that will be rented+
	* @param corporateUse, boolean, this boolean is true if the rent is for an investigation project, or it is for corporate usage
	* @return rentalNumber, String, this is the number of the new rent
	*/
	public String rentMiniRoom(int day, int month, int year, int servers, double cache, int processors, double ram, int disks, double disksCapacity, boolean brand, double surcharge, String roomNumber, boolean corporateUse){
		Date rentalDate = new Date (day,month,year);
		double monthlyValue = 0.0;
		Status occupied = Status.OCCUPIED;
		String rentalNumber = "" + (rents.size() + 1);
		Brand serverBrand = Brand.INTEL;
		int i = roomNumberMatchI(roomNumber);
		int j = roomNumberMatchJ(roomNumber);
		
		monthlyValue = miniRooms[i][j].getRentalValue() + surcharge;
		
		if (!brand) {
			serverBrand = Brand.AMD;
		}

		//this section changes the status of the room
		miniRooms[i][j].setAvailability(occupied);
		//this section adds N servers to the room
		for (int k = 0; k < servers; k++) {
			miniRooms[i][j].addServer(new Server(cache, processors, ram, disks, disksCapacity, serverBrand));
		}

		if (!corporateUse) {
			int projectNumber = 0;
			for (int k = 0; k < rents.size() ; k++) {
				if (rents.get(k) instanceof UniversityRent) {
					projectNumber++;
				}
			}
			projectNumber++;
			rents.add(new UniversityRent(rentalNumber, monthlyValue, rentalDate, roomNumber, servers, "" + projectNumber));
		}else{
			rents.add(new Rent(rentalNumber, monthlyValue, rentalDate, roomNumber, servers));
		}
		
		return rentalNumber;
	}

	/**
	* registers a company to a rent wich name is taken as a parameter
	* @param rentalNumber, String, number of the rent
	* @param name, String, name of the company
	* @param nit, String, nit of the company
	*/
	public void registerCompanyToRent(String rentalNumber, String name ,String nit){
		int i = (int) Integer.parseInt(rentalNumber) - 1;
		rents.get(i).setLinkedCompany(new Company (nit, name));
	}


	/**
	* Verifies if at least one rent is registered
	* @return out, boolean, true if there is at least one registered rent, false otherwise
	*/
	public boolean atLeastOneRentRegistered(){
		boolean out = !rents.isEmpty();;
		return out;
	}


	/**
	* Creates a string with the information of all the rents in the center
	* @return rentsInfo, String, string with all the rents
	*/
	public String showRents() {
		String rentsInfo = "";
		rentsInfo += "      " + "These are all the rents until now " + "\n ---------------------------------------------\n";
		for (int i = 0; i < rents.size() ; i++ ) {
			 rentsInfo += "               " + rents.get(i).toString() + "\n ____________________________________________\n";
		}

		return rentsInfo;
	}


	/**
	* Eliminates a registered rent
	* @param roomNumber, String, number of the rented room
	*/
	public void eliminateRentByRoom(String roomNumber){
		String rentedRoom;
		boolean flag = false;
		int i = roomNumberMatchI(roomNumber);
		int j = roomNumberMatchJ(roomNumber);

		for (int k = 0; k < rents.size() && !flag; k++) {
			rentedRoom = rents.get(k).getRoomNumber().toUpperCase();
			if (rentedRoom.equals(roomNumber.toUpperCase())) {
				rents.remove(k);
				flag = true;
				miniRooms[i][j].setAvailability(Status.AVAILABLE);
				miniRooms[i][j].clearRack();
			}
		}
	}


	/**
	* Eliminates all the rents from a company
	* @param company, String, name of the company
	*/
	public void eliminateRoomsFromCompany(String company){
		String companyName;
		String roomNumber;
		boolean flag = false;

		while(theCompanyExists(company)){
			flag = false;
			for (int i = 0; i < rents.size() && !flag; i++) {
				companyName = rents.get(i).getCompanyName().toUpperCase();
				if (companyName.equals(company.toUpperCase())) {
					roomNumber = rents.get(i).getRoomNumber();
					eliminateRentByRoom(roomNumber);
					flag = true;
				}
			}
		}
	
	}

	/**
	* Verifies the existence of a company, returns true or false
	* @param name, String, name of the company
	* @return out, boolean, true if the company exists, false otherwise
	*/
	public boolean theCompanyExists (String name){
		String company;
		boolean out = false;

		for (int i = 0; i < rents.size() ;i++ ) {
			company = rents.get(i).getCompanyName().toUpperCase();
			if (company.equals(name.toUpperCase())) {
				out = true;
			}
		}
		return out;
	}


	/**
	* Gets the processability of a room by taking its number as a parameter
	* @param roomNumber, String, number of the room
	* @return processability, String, this is the processability of the room
	*/
	public String getProcessabilityOfRoom(String roomNumber){
		int i = roomNumberMatchI(roomNumber);
		int j = roomNumberMatchJ(roomNumber);

		return miniRooms[i][j].calculateProcessability();
	}

	/**
	* Creates a String with the information of the rooms
	* @param instruction, String, this is a number that representates one instruction to show the map in a specific way
	* @param column, int, this the column of a room, it will be used for a turning off option
	* @param hall, int, this is the hall of a room, it will be used for a turning off option
	* @return availableRooms, String, This is the information of all the rooms
	*/
	public String showMap(String instruction, int column, int hall){
		
		char [] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		String horizontalWindows = "";
		String blankSpace = "";

		for (int i = 0; i<=106 ; i++) {
			horizontalWindows += "=";
			if (i <= 104) {
				blankSpace += " ";
			}
			
		}

		String map = "          " + horizontalWindows + "\n";
		map += "  Hall " + alphabet[0] + "  |  ";
		for (int i = 0; i < miniRooms.length ; i++ ) {
			for (int j = 0; j < miniRooms[1].length ; j++ ) {
				switch(instruction){
					case "A": //Map of the center
						map += miniRooms[i][j].setMapSymbol();
					break;

					case "B": //Map with the rooms turned on
						map += miniRooms[i][j].turnRoomOn();
					break;

					default: //Map with the rooms turned off
						map += turningOffOptions(i,j,instruction, column, hall);
					break;
				}
			}
			map += "|  |";
			if (i != (miniRooms.length - 1)) {
				map += "\n          |" + blankSpace + "|\n  Hall " + alphabet[i+1] + "  |  ";
			}
			
		}
		map += "\n          " + horizontalWindows;

		return map;
	}


	/**
	* Validates the conditions of a room to turn it off according the option
	* @param i, int, this is the row
	* @param j, int, this is the column
	* @param instruction, String, this is the option
	* @param column, int, this the column of a room, it will be used for a turning off option
	* @param hall, String, this is the hall of a room, it will be used for a turning off option
	* @return switchSymbol, String, this is the symbol of the room depending if the room must be turned on or off
	*/
	public String turningOffOptions(int i, int j, String instruction, int column, int hall){
		String switchSymbol = "";
		switch(instruction){
			case "L":
				if (j == 0 || i==0) {
					switchSymbol = "|X";
				}else{
					switchSymbol = "|O";
				}
			break;

			case "Z":
				if (i == 0 || i == 7) {
					switchSymbol = "|X";
				}else{
					switchSymbol = "|O";
				}
			break;

			case "H":
				if (i%2 == 0) {
					switchSymbol = "|X";
				}else{
					switchSymbol = "|O";
				}
			break;

			case "O":
				if (i == 0 || i == 7 || j == 0 || j == 49) {
					switchSymbol = "|X";
				}else{
					switchSymbol = "|O";
				}
			break;

			case "M":
				if (j == column) {
					switchSymbol = "|X";
				}else{
					switchSymbol = "|O";
				}
			break;

			case "P":
				if (i == hall) {
					switchSymbol = "|X";
				}else{
					switchSymbol = "|O";
				}
		}

		return switchSymbol;
	}


}