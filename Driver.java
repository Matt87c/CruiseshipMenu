import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Driver {

    // instance variables (add more as needed)
    private static ArrayList<Ship> shipList = new ArrayList();
    private static ArrayList<Cruise> cruiseList = new ArrayList();
    private static ArrayList<Passenger> passengerList = new ArrayList();


    public static void main(String[] args) {

        initializeShipList();       // initial ships
        initializeCruiseList();     // initial cruises
        initializePassengerList();  // initial passengers

        // add loop and code here that accepts and validates user input
        // and takes the appropriate action. include appropriate
        // user feedback and redisplay the menu as needed
        
        try (Scanner userInput = new Scanner(System.in)) {
			char menuOption;
			char exit;
			exit = 'x';
			
		//do while statement to iterate the loop
			do {
				displayMenu(); 
				menuOption = userInput.next().charAt(0);
				
				//Switch statement to represent multi-branching menu options
				switch(menuOption) {
					case '1':
						addShip();
						break;
					case '2':
						editShip();
						break;
					case '3':
						addCruise();
						break;
					case '4':
						editCruise();
						break;
					case '5':
						addPassenger();
						break;
					case '6':
						editPassenger();
						break;
					case 'A':
						printShipList("name");
						break;
					case 'B':
						printShipList("active");
						break;
					case 'C':
						printShipList("full");
						break;
					case 'D':
						printCruiseList("list");
						break;
					case 'E':
						printCruiseList("details");
						break;
					case 'F':
						printPassengerList();
						break;
					case 'x':
						break;
				}
			
			}while(!(exit == 'x'));
				System.out.println("Exiting system menu");
			
			}
    }

    // hardcoded ship data for testing
    // Initialize ship list
    public static void initializeShipList() {
        add("Candy Cane", 20, 40, 10, 60, true);
        add("Peppermint Stick", 10, 20, 5, 40, true);
        add("Bon Bon", 12, 18, 2, 24, false);
        add("Candy Corn", 12, 18, 2, 24, false);
    }

    // hardcoded cruise data for testing
    // Initialize cruise list
    public static void initializeCruiseList() {
        Cruise newCruise = new Cruise("Southern Swirl", "Candy Cane", "Miami", "Cuba", "Miami");
        cruiseList.add(newCruise);
    }

    // hardcoded cruise data for testing
    // Initialize passenger list
    public static void initializePassengerList() {
        Passenger newPassenger1 = new Passenger("Neo Anderson", "Southern Swirl", "STE");
        passengerList.add(newPassenger1);

        Passenger newPassenger2 = new Passenger("Trinity", "Southern Swirl", "STE");
        passengerList.add(newPassenger2);

        Passenger newPassenger3 = new Passenger("Morpheus", "Southern Swirl", "BAL");
        passengerList.add(newPassenger3);
    }

    // custom method to add ships to the shipList ArrayList
    public static void add(String tName, int tBalcony, int tOceanView,
                           int tSuite, int tInterior, boolean tInService) {
        Ship newShip = new Ship(tName, tBalcony, tOceanView, tSuite, tInterior, tInService);
        shipList.add(newShip);
    }


    public static void printShipList(String listType) {
        // printShipList() method prints list of ships from the
        // shipList ArrayList. There are three different outputs
        // based on the listType String parameter:
        // name - prints a list of ship names only
        // active - prints a list of ship names that are "in service"
        // full - prints tabbed data on all ships

    	
        if (shipList.size() < 1) {
            System.out.println("\nThere are no ships to print.");
            return;
        }
        if (listType == "name") {
            System.out.println("\n\nSHIP LIST - Name");
            for (int i = 0; i < shipList.size(); i++) {
                System.out.println(shipList.get(i));
            }
        } else if (listType == "active") {
            System.out.println("\n\nSHIP LIST - Active");

            // complete this code block
            for (int i = 0; i < shipList.size(); i++) {
            	if (shipList.get(i).getInService())
            		System.out.println(shipList.get(i));
            }
            

        } else if (listType == "full") {
            System.out.println("\n\nSHIP LIST - Full");
            System.out.println("-------------------------------------------------------------");
            System.out.println("                    Number of Rooms                    In");
            System.out.print("SHIP NAME           Bal OV      Ste     Int            Service");
            System.out.println("\n---------------------------------------------------------------");
            for (Ship eachShip: shipList)
                eachShip.printShipData();

        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printCruiseList(String listType) {
        if (cruiseList.size() < 1) {
            System.out.println("\nThere are no cruises to print.");
            return;
        }
        if (listType == "list") {
            System.out.println("\n\nCRUISE LIST");
            for (int i=0; i < cruiseList.size(); i++) {
                System.out.println(cruiseList.get(i));
            }
        } else if (listType == "details") {
            System.out.println("\n\nCRUISE LIST - Details");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("                                      |----------------------PORTS-----------------------|");
            System.out.print("CRUISE NAME         SHIP NAME           DEPARTURE           DESTINATION         RETURN");
            System.out.println("\n-----------------------------------------------------------------------------------------");
            for (Cruise eachCruise: cruiseList)
                eachCruise.printCruiseDetails();
        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printPassengerList() {
        if (passengerList.size() < 1) {
            System.out.println("\nThere are no passengers to print.");
            return;
        }
        System.out.println("\n\nPASSENGER LIST");
        System.out.println("-----------------------------------------------------");
        System.out.print("PASSENGER NAME      CRUISE              ROOM TYPE");
        System.out.println("\n-----------------------------------------------------");
        for (Passenger eachPassenger: passengerList)
            eachPassenger.printPassenger();
    }

    // display text-based menu
    public static void displayMenu() {

       
        System.out.println("\t    Luxury Ocean Cruise Outings");
        System.out.println("\t\t    System Menu\n");
        System.out.println("[1] Add Ship            [A] Print Ship Names");
        System.out.println("[2] Edit Ship           [B] Print Ship In Service List");
        System.out.println("[3] Add Cruise          [C] Print Ship Full List");
        System.out.println("[4] Edit Cruise         [D] Print Cruise List");
        System.out.println("[5] Add Passenger       [E] Print Cruise Details");
        System.out.println("[6] Edit Passenger      [F] Print Passenger List");
        System.out.println("[x] Exit System");
        System.out.println("\nEnter a menu selection: ");
    }

    // Add a New Ship
    public static void addShip() {

        // complete this method
    	
    	try (Scanner addNewShip = new Scanner(System.in)) {
			System.out.println("Add new ship, input cruise ship name: ");
			String cruiseShipName = addNewShip.nextLine();
			
			for (Ship newShip: shipList) {
				if (newShip.getShipName().equalsIgnoreCase(cruiseShipName)) {
				System.out.println("This cruise ship already exists in the system.");
				return;
			}
   
			System.out.println("Enter number of balcony cabins: ");
			int shipRoomBalcony = Integer.parseInt(addNewShip.nextLine());

			System.out.println("Enter number of ocean view cabins: ");
			int shipOceanView = Integer.parseInt(addNewShip.nextLine());

			System.out.println("Enter number of room suite cabins: ");
			int shipRoomSuite = Integer.parseInt(addNewShip.nextLine());

			System.out.println("Enter number of interior cabins: ");
			int shipRoomInterior = Integer.parseInt(addNewShip.nextLine());

			System.out.println("Enter 'YES' if the ship is in service, or 'NO' if the ship is not in service: ");
			String shipInserviceStr = (addNewShip.nextLine());
			

			if ((shipInserviceStr.equalsIgnoreCase("yes"))) {
				boolean shipInservice = true;
				
				//After ship information is inputed and "yes" is typed for in service, the details is printed
				System.out.println("Cruise Ship Details");
				System.out.println("");
				System.out.println("Cruise ship: Available to book passengers");
				System.out.println("Cruise ship name: " + cruiseShipName);
				System.out.println("Balcony cabins: " + shipRoomBalcony);
				System.out.println("Ocean view cabins: " + shipOceanView);
				System.out.println("Room suite cabins: " + shipRoomSuite);
				System.out.println("Interior cabins: " + shipRoomInterior);
				break;
				}
			//If the ship is not in service, cruise ship details will print to display chosen options
			else if ((shipInserviceStr.equalsIgnoreCase("no"))) {
				boolean shipInservice = false;
				
				System.out.println("Cruise Ship Details");
				System.out.println("");
				System.out.println("Cruise ship: Not available to book passengers" );
				System.out.println("Cruise ship name: " + cruiseShipName);
				System.out.println("Balcony cabins: " + shipRoomBalcony);
				System.out.println("Ocean view cabins: " + shipOceanView);
				System.out.println("Room suite cabins: " + shipRoomSuite);
				System.out.println("Interior cabins: " + shipRoomInterior);
				break;
			}
   }
		}
    }
    
    // Edit an existing ship
    	public static void editShip() {

        // This method does not need to be completed
        System.out.println("The \"Edit Ship\" feature is not yet implemented.");

    }

    // Add a New Cruise
    public static void addCruise() {

        // complete this method
    
    		//If cruise is new then the adding cruise input menu will follow
    	try (Scanner newCruiseInput = new Scanner(System.in)) {
			System.out.println("Add new cruise, input cruise name: ");
			String cruiseName = newCruiseInput.nextLine();
			
			//If cruise name is already in the system this message will print and menu will end.
			for (Cruise eachCruise: cruiseList) {
				if (eachCruise.getCruiseName().equalsIgnoreCase(cruiseName)) {
					System.out.println("This cruise ship already exists in the system.");
					return; 
			}
  	}
			       //System menu asking for specific details about the cruise for user input.
			        System.out.println("Enter name of cruise ship");
			        String cruiseShipName = newCruiseInput.nextLine();
			        
			        
			        System.out.println("Enter departure port");
			        String departurePort = newCruiseInput.nextLine();
			        
			      
			        System.out.println("Enter destination");
			        String destination = newCruiseInput.nextLine();
			        
			        System.out.println("Enter return port");
			        String returnPort = newCruiseInput.nextLine();
			        
			        Cruise newCruiseDetails = new Cruise(cruiseShipName, cruiseName, departurePort, destination, returnPort);
			        cruiseList.add(newCruiseDetails);
			        
			        //Prints out cruise details with user inputs
			        System.out.println("Cruise Details");
					System.out.println("");
					System.out.println("Name of cruise: " + cruiseName);
					System.out.println("Cruise ship name: " + cruiseShipName);
					System.out.println("Departure port: " + departurePort);
					System.out.println("Destination: " + destination);
					System.out.println("Return port: " + returnPort);
					
				}
			        
		}
    	

    // Edit an existing cruise
    public static void editCruise() {

        // This method does not need to be completed
        System.out.println("The \"Edit Cruise\" feature is not yet implemented.");

    }

    // Add a New Passenger
    public static void addPassenger() {

        try (Scanner newPassengerInput = new Scanner(System.in)) {
			System.out.println("Enter the new passenger's name: ");
			String newPassengerName = newPassengerInput.nextLine();

			// ensure new passenger name does not already exist
			for (Passenger eachPassenger: passengerList) {
			    if (eachPassenger.getPassengerName().equalsIgnoreCase(newPassengerName)) {
			        System.out.println("That passenger is already in the system. Exiting to menu...");
			        return; // quits addPassenger() method processing
			    }
			}

			// get cruise name for passenger
			System.out.println("Enter cruise name: ");
			String newCruiseName = newPassengerInput.nextLine();

			// ensure cruise exists
			for (Cruise eachCruise: cruiseList) {
			    if (eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
			        // cruise does exist
			    } else {
			        System.out.println("That cruise does not exist in the system. Exiting to menu...");
			        return; // quits addPassenger() method processing
			    }
			}

			// get room type
			System.out.println("Enter Room Type (BAL, OV, STE, or INT: ");
			String room = newPassengerInput.nextLine();
			// validate room type
			if ((room.equalsIgnoreCase("BAL")) || (room.equalsIgnoreCase("OV")) ||
			        (room.equalsIgnoreCase("STE")) || (room.equalsIgnoreCase("INT"))) {
			    // validation passed - add passenger
			    Passenger newPassenger = new Passenger(newPassengerName, newCruiseName, room.toUpperCase());
			    passengerList.add(newPassenger);
			} else {
			    System.out.println("Invalid input. Exiting to menu...");
			    return; // quits addPassenger() method processing
			}
		}
    }

    // Edit an existing passenger
    public static void editPassenger() {

        // This method does not need to be completed
        System.out.println("The \"Edit Passenger\" feature is not yet implemented.");

    }

    // Method to check if input is a number
    public static boolean isANumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false)
                return false;
        }
        return true;
       
    }

}
