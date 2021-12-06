package model;
import java.util.ArrayList;

public class MiniRoom{
	private String uniqueNumber;
	private SwitchStatus roomStatus;
	private Location roomLocation;
	private Rent rentalRecord;
	private ArrayList<Server> rack;
	private Status availability;
	private double rentalValue;

	/**
	* This is the constructor method of MiniRoom class
	* @param uniqueNumber, this is an unique number that identifies each room
	* @param roomLocation, this is the location of the room
	* @param rentalValue, this is the rental value of the room depending on its location
	*/
	public MiniRoom (String uniqueNumber, Location roomLocation, double rentalValue){
		this.uniqueNumber = uniqueNumber;
		this.roomLocation = roomLocation;
		this.roomStatus = SwitchStatus.OFF;
		this.rentalValue = rentalValue;
		this.availability = Status.AVAILABLE;
		this.rack = new ArrayList<Server>();

	}

	/**
	* Gets the number of the room
	* @return uniqueNumber, String, this is the number of the room
	*/
	public String getUniqueNumber (){
		return uniqueNumber;
	}

	/**
	* Sets the number of the room
	* @param uniqueNumber, String, this is the number of the room
	*/
	public void setUniqueNumber (String uniqueNumber){
		this.uniqueNumber = uniqueNumber;
	}

	/**
	* Gets the status of the room
	* @return roomStatus, SwitchStatus, this is the status of the room, it can be ON or OFF
	*/
	public SwitchStatus getRoomStatus (){
		return roomStatus;
	}

	/**
	* Sets the status of the room
	* @param roomStatus, SwitchStatus, this is the status of the room, it can be ON or OFF
	*/
	public void setRoomStatus (SwitchStatus roomStatus){
		this.roomStatus = roomStatus;
	}

	/**
	* Gets the room location type
	* @return roomLocation, Location, this is the location of the room 
	*/
	public Location getRoomLocation (){
		return roomLocation;
	}

	/**
	* Sets the room location type
	* @param roomLocation, Location, this is the location of the room, it can be with WINDOW or NO_WINDOW
	*/
	public void setRoomLocation (Location roomLocation){
		this.roomLocation = roomLocation;
	}

	/**
	* Gets the rack of the room
	* @return rack, ArrayList[Server], this is an array of servers
	*/
	public ArrayList<Server> getRack (){
		return rack;
	}

	/**
	* Sets the rack of the room
	* @param rack, ArrayList[Server], this is an array of servers
	*/
	public void setRack (ArrayList<Server> rack){
		this.rack = rack;
	}

	/**
	* Adds a new server to the rack
	* @param server, Server, this is the new server to add
	*/
	public void addServer (Server server){
		rack.add(server);
	}

	/**
	* Gets the availability of the room
	* @return availability, Status, this is the availability of the room, it can be AVAILABLE or OCCUPIED
	*/
	public Status getAvailability (){
		return availability;
	}

	/**
	* Sets the availability of the room
	* @param availability, Status, this is the availability of the room, it can be AVAILABLE or OCCUPIED
	*/
	public void setAvailability (Status availability){
		Status occupied = Status.OCCUPIED;
		if (availability.equals(occupied)) {
			this.roomStatus = SwitchStatus.ON;
		}else{
			this.roomStatus = SwitchStatus.OFF;
		}
		this.availability = availability;
	}

	/**
	* Gets the rental value of the room
	* @return rentalValue, double, this is the rental value of the room and it depends on the location
	*/
	public double getRentalValue (){
		return rentalValue;
	}

	/**
	* Sets the rental value of the room
	* @param rentalValue, double, this is the rental value of the room and it depends on the location
	*/
	public void setRentalValue (double rentalValue){
		this.rentalValue = rentalValue;
	}

	/**
	* Eliminates all servers of the rack
	*/
	public void clearRack (){
		rack.clear();
	}

	/**
	* Creates a string with the processability
	*/
	public String calculateProcessability() {
		double totalRam = 0.0;
		double totalDisk = 0.0;
		for (int i = 0; i < rack.size(); i++ ) {
			totalRam += rack.get(i).getAmountOfRamMemory();
			totalDisk += rack.get(i).getDisksCapacity();
		}
		String processability = "   Total ram memory: " + totalRam + " GB \n   Total disk capacity: " + totalDisk + "TB";

		return processability;
	}

	/**
	* Returns a symbol to mean if the room is turned ON or OFF
	* @return symbol, String, this is the symbol of the room, it is an "O" if the room is turned ON, and an "X" if the room is turned OFF
	*/
	public String setMapSymbol(){
		SwitchStatus on = SwitchStatus.ON;
		String symbol = "";
		if (roomStatus.equals(on)) {
			symbol = "|O";
		}else{
			symbol = "|X";
		}
		return symbol;
	}

	/**
	* Returns a symbol to mean if the room is turned ON or OFF
	* @return symbol, String, this is the symbol of the room, it is an "O" if the room is turned ON, and an "X" if the room is turned OFF
	*/
	public String turnRoomOn(){
		String symbol = "|O";
		return symbol;
	}

	/**
	* Returns a symbol to mean if the room is turned ON or OFF
	* @return symbol, String, this is the symbol of the room, it is an "O" if the room is turned ON, and an "X" if the room is turned OFF
	*/
	public String turnRoomOff(){
		String symbol = "|X";
		return symbol;
	}

	/**
	* returns a string with the information of interest
	* @return miniRoom, String, this is the information of the room
	*/
	public String toString() {
		String miniRoom = "          Room " + uniqueNumber + "\n"
		+ "          Location: " + roomLocation + "\n"
		+ "          Rental value: " + rentalValue + "$";
		return miniRoom;
	}
}