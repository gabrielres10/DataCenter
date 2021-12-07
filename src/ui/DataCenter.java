package ui;

import java.util.Scanner;
import model.Center;

/**
* This is the main class, it allows the user to interact with the program
* @author Gabriel Restrepo
*/
public class DataCenter{
	private Scanner sc;
	private Center myCenter;

	/**
	* Constructor method of the class DataCenter
	*/
	public DataCenter(){
		sc = new Scanner(System.in);
	}

	/**
	 * Main method. **Description of the program**
	 * @param args The command line arguments.
	 **/
	public static void main(String[] args) {
		
		DataCenter dc = new DataCenter();


		System.out.println("Starting app...");
		dc.createCenter();
		int option = 0;
		do{
			option = dc.showMenu();
			dc.executeOperation(option);
		}while(option != 0);
	}

	/**
	* Creates the center by asking the user for the base cost
	*/
	public void createCenter(){
		double baseValue;

		System.out.println("Input the base value for the rooms: ");
		baseValue = askForDecimalNumber();
		System.out.println(" Thanks!");
		myCenter = new Center (baseValue);
		myCenter.createRooms();
	}

	/**
	* Shows the main menu to the user and returns its answer
	* @return option, int, the number of the option chosen by the user
	*/
	public int showMenu(){
		int option = 0;

		System.out.println(
			"Main menu, choose an option with a number: \n" + 
			"(1) Show available rooms \n" +
			"(2) Rent a room \n" +
			"(3) Show all the rents \n" +
			"(4) Cancel a rent \n" +
			"(5) Show map of data center \n" +
			"(6) Simulate turning all rooms on\n" +
			"(7) Simulate turning rooms off\n" +
			"(0) Exit <-"
			);
		option = askForNumber();
		return option;
	}

	/**
	* Executes the operation chosen by the user, according the number of the option
	* @param operation, int, the number of the option chosen by the user
	* @return option, int, variable with the option selected by the user
	*/
	public void executeOperation (int operation){
		int option = 0;
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			showAvailableRooms();
			
			break;
		case 2:
			rentARoom();
			break;
		case 3:
			showRents();
			break;
		case 4:
			if (!myCenter.atLeastOneOccupiedRoom()) {
			System.out.println("There are not rented rooms!");
			}else{
				do{
					menuCancel();
				}while(option != 0);
			}
			break;
		case 5:
			showDataCenterMap("A");
			break;
		case 6:
			showDataCenterMap("B");
			break;
		case 7:
			simulateTurningRoomsOff();
			break;
		default:
			System.out.println(" Warning!, invalid option");
		
		}
	}

	/**
	* Offers the option to cancel rents
	*/
	public int menuCancel (){
		int option = 0;
		System.out.println(
			"(1) Cancel rent by room number \n" +
			"(2) Cancel rents from a company \n" +
			"(0) <- Back");
		option = askForNumber();

		switch(option) {
		case 0:
			break;
		case 1:
			cancelRentByRoom();
			break;
		case 2:
			cancelRentsFromACompany();
			break;
		default:
			System.out.println(" Warning!, invalid option");
		
		}

		return option;
	}

	/**
	* Shows a list of the available rooms
	*/
	public void showAvailableRooms (){
		System.out.println(myCenter.showRooms());
	}

	/**
	* Requests the information needed to register a rent
	*/
	public void rentARoom (){

		if (!myCenter.atLeastOneAvailableRoom()) {
			System.out.println("We are sorry, there are not available rooms ");
		}else{
			int day, month, year, servers, processors, disks;
			String roomNumber, name, nit;
			double cache, ram, disksCapacity;
			boolean brand, corporateUse;
			double surcharge = 0.0;
			boolean flag = true;
			do{
				flag = true;
				System.out.println("Input the number of the room for rent: ");
				roomNumber = sc.nextLine().toUpperCase();
				if (myCenter.roomNumberMatchI(roomNumber) == -1) {
					System.out.println("Seems like this room does not exist, please input a valid number ");
					flag = false;
				}else{
					if (!myCenter.verifyAvailability(roomNumber)) {
						System.out.println("We are sorry, this room is currently rented");
						flag = false;
					}
				}
			}while(!flag);

			System.out.println("How many servers will be used ?");
			servers = askForNumber();
			if (servers < 4) {
				surcharge = myCenter.getBaseValue() * 0.15;
			}
			System.out.println("All servers will have the same specifications: ");
			
			System.out.println("Amount of cache memory: (GB)");
			cache = askForDecimalNumber();
			System.out.println("Amount of processors: ");
			processors = askForNumber();
			System.out.println("Amount of ram memory: (GB)");
			ram = askForDecimalNumber();
			System.out.println("Amount of disks: ");
			disks = askForNumber();
			System.out.println("Disks capacity: (Terabytes)");
			disksCapacity = askForDecimalNumber();
			System.out.println("Disks brand: \n" +
				"(1) INTEL \n" +
				"(2) AMD");
			brand = askForYesOrNoAnswer();

			System.out.println("Date of the rent: ");
			System.out.println("Day: ");
			day = askForNumber();
			System.out.println("Month: ");
			month = askForNumber();
			System.out.println("Year: ");
			year = askForNumber();

			System.out.println("What is the room going to be used for? \n" +
				"(1) Corporate use \n" +
				"(2) Investigation project");
			corporateUse = askForYesOrNoAnswer();

			if (corporateUse) {
				System.out.println("Name of the company");
				name = sc.nextLine();
				System.out.println("Nit of the company");
				nit = "" + askForNumber();
			}else{
				name = "ICESI";
				nit = "1010100101";
			}
			String rentalNumber = myCenter.rentMiniRoom(day, month, year, servers, cache, processors, ram, disks, disksCapacity, brand, surcharge, roomNumber, corporateUse);
			myCenter.registerCompanyToRent(rentalNumber, name, nit);
			System.out.println("....The rent of the room has been registered....");

		}

	}


	/**
	* Shows all the rents that have been done
	*/
	public void showRents (){
		if (myCenter.atLeastOneRentRegistered()) {
			System.out.println(myCenter.showRents());
		}else{
			System.out.println("We are sorry, there is not any rent registered yet");
		}
		
	}

	/**
	* Cancels a rent by asking the number of the room
	*/
	public void cancelRentByRoom (){
		
		String roomNumber;
		boolean flag = true;
		do{
			flag = true;
			System.out.println("Input the number of the room to cancel the rent:");
			roomNumber = sc.nextLine();
			if (myCenter.roomNumberMatchI(roomNumber) == -1) {
				System.out.println("Seems like this room does not exist, please input a valid number ");
				flag = false;
			}else{
				if (myCenter.verifyAvailability(roomNumber)) {
					System.out.println("This room is not actually rented, please input a rented room");
					flag = false;
				}
			}
		}while(!flag);
		System.out.println("This is the processability of the mini room: ");
		System.out.println(myCenter.getProcessabilityOfRoom(roomNumber));

		System.out.println("Confirm rental cancelation? \n" +
			"(1) Yes\n" +
			"(2) No");
		if (askForYesOrNoAnswer()) {
			myCenter.eliminateRentByRoom(roomNumber);

			System.out.println("....The rental has been cancelated successfully....");
		}else{
			System.out.println("....Cancelation aborted....");
		}
		
	}

	/**
	* Cancels all rents from a company
	*/
	public void cancelRentsFromACompany(){

		String company = "";
		boolean flag = true;
		do{
			flag = true;
			System.out.println("Input the name of the company which rents you want to cancel");
			company = sc.nextLine();
			if (!myCenter.theCompanyExists(company)) {
				System.out.println(" Ooops! Seems like this company does not have a rent, please input a valid company");
				flag = false;
			}
		}while(!flag);

		myCenter.eliminateRoomsFromCompany(company);

		System.out.println("....All the rents have been deleted successfully....");

	}

	/**
	* Shows a map of the data center that indicates what rooms are turned On and Off
	* @param instruction, String, this character indicates how the rooms must be 
	*/
	public void showDataCenterMap(String instruction){
		System.out.println("-------------This is a representation of the data center---------- \n" +
			"   \"X\" symbol means the room is OFF \n" +
			"   \"O\" symbol means the room is ON \n" +
			"   \"=\" and \"|\" symbols mean a window\n");
		System.out.println(myCenter.showMap(instruction,0,0));
		System.out.println("");

	}

	/**
	* Shows the user a map of the center with the rooms turned off according its instructions
	*/
	public void simulateTurningRoomsOff(){
		String option;
		int hall = 0;
		int column = 0;
		System.out.println("------------You can turn the rooms off with the options bellow------------\n " + 
			"Letter L: turn off the first mini-rooms in all corridors, along with the mini-rooms in the first corridor \n " +
			"Letter Z: turn off the mini-rooms in the first and last aisles, along with the mini-rooms on the reverse diagonal\n " +
			"Letter H: turn off the mini-rooms located in the odd-numbered hallways (A,C,E,G)\n " +
			"Letter O: turn off the mini-rooms located in the windows\n " +
			"Letter M: turn off column N\n " +
			"Letter P: turn off the mini-rooms in a corridor"
			);
		option = askForOption();
		if (option.equals("M")) {
			System.out.println(" Input the number of the column that you want to turn off (Number between 1 and 50)");
			do{
				column = askForNumber()-1;
				if (column > 49 || column == -1) {
					 System.out.println("You can only choose a column between 1 and 50");
				}
			}while(column > 49 || column == -1);
			
		}else if (option.equals("P")) {
			System.out.println(" Input the hall that you want to turn off (A, B, C, D, E, F, G or H)");
			hall = askForHall();
		}
		System.out.println("-------------This is a representation of the data center---------- \n" +
			"   \"X\" symbol means the room is OFF \n" +
			"   \"O\" symbol means the room is ON \n" +
			"   \"=\" and \"|\" symbols mean a window\n");
		System.out.println(myCenter.showMap(option, column, hall));
		
	}


	/**
	* Requests and validates an option to turn off rooms
	* @return option, String, it is the option of the user
	*/
	public String askForOption(){
		String option = "";
		boolean validInput = true;
		do{
			validInput = true;
			option = sc.nextLine().toUpperCase();
			if (!option.equals("L") && !option.equals("Z") && !option.equals("H") && !option.equals("O") && !option.equals("M") && !option.equals("P")) {
				System.out.println("\"" + option + "\" does not belong to the allowed options");
				validInput = false;
			}
		}while(!validInput);
		return option;
	}

	/**
	* Requests and validates a hall of rooms
	* @return row, int, it is a hall of the center
	*/
	public int askForHall(){
		String hall = "";
		int row = 0;
		boolean validInput = true;
		do{
			validInput = true;
			hall = sc.nextLine().toUpperCase();
			if (!hall.equals("A") && !hall.equals("B") && !hall.equals("C") && !hall.equals("D") && !hall.equals("E") && !hall.equals("F") && !hall.equals("G") && !hall.equals("H")) {
				System.out.println(hall + " is not a hall");
				validInput = false;
			}
		}while(!validInput);
		switch(hall){
			case "A":
				row = 0;
				break;
			case "B":
				row = 1;
				break;
			case "C":
				row = 2;
				break;
			case "D":
				row = 3;
				break;
			case "E":
				row = 4;
				break;
			case "F":
				row = 5;
				break;
			case "G":
				row = 6;
				break;
			case "H":
				row = 7;
				break;
		}
		return row;
	}



	/**
	* Requests and validates a number
	* @return number, int, integer number typed by the user
	*/
	public int askForNumber (){
		String num = "";
		boolean validInput = true;
		do{
			validInput = true;
			num = sc.nextLine();
			for (int i = 0; i < num.length() ; i++ ) {
				char singleNum = num.charAt(i);
				if (singleNum != '1' && singleNum != '2' && singleNum != '3' && singleNum != '4' && singleNum != '5' && singleNum != '6' && singleNum != '7' && singleNum != '8' && singleNum != '9' && singleNum != '0') {
					System.out.println("\"" + singleNum + "\" is not a number");
					validInput = false;
				}
			}
		}while(!validInput);
		int number = (int) Integer.parseInt(num);

		return number;

	}


	/**
	* Requests and validates a decimal number
	* @return number, double, decimal number typed by the user
	*/
	public double askForDecimalNumber (){
		String num = "";
		boolean validInput = true;
		do{
			validInput = true;
			num = sc.nextLine();
			for (int i = 0; i < num.length() ; i++ ) {
				char singleNum = num.charAt(i);
				if (singleNum != '1' && singleNum != '2' && singleNum != '3' && singleNum != '4' && singleNum != '5' && singleNum != '6' && singleNum != '7' && singleNum != '8' && singleNum != '9' && singleNum != '0' && singleNum != '.') {
					System.out.println("\"" + singleNum + "\" is not a number (Use \".\" as decimal separation)");
					validInput = false;
				}
			}
		}while(!validInput);
		double number = (double) Double.parseDouble(num);

		return number;

	}


	/**
	* Reads and verifies the user's answer to an affirmative or negative question 
	* @return answer, boolean, is the user's response, true if the user responds yes, false otherwise 
	*/
	public boolean askForYesOrNoAnswer (){
		int input = 0; 
		boolean answer = true;
		boolean validInput = false;
		do{
			input = askForNumber();
			if (input != 1 && input != 2) {
				System.out.println("You must answer \"1\" or \"2\" ");
			}else{
				validInput = true;
			}
			if (input==1) {
				answer = true;
			}else if(input == 2){
				answer = false;
			}
		}while(!validInput);

		return answer;
	}


}