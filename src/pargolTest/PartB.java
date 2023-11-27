package Assignment20;
import java.util.*;
import Assignment20.PartA.Computer;
public class PartB {
	//PartB class serves as the driver program for managing a computer store's inventory.
	//PartB class for the main method program logic

	
		private static final String PASSWORD = "password";
	    private static final int Maximum_TRIES = 3;

	    public static void main(String[] args) {
	        Scanner kb = new Scanner(System.in);
	        System.out.println("Welcome to my computer store");

	        // Prompt for the maximum number of computers
	        System.out.print("Enter the maximum size you can store: ");
	        int maxComputers = kb.nextInt();
	        kb.nextLine(); // Consume the newline character

	        // Create an empty array to store Computer objects
	        Computer[] inventory = new Computer[maxComputers];

	        int choice;
	        int tries = 0;

	        do {
	            displayMainMenu();
	            System.out.print("Please enter your choice: ");
	            choice = kb.nextInt();
	            kb.nextLine(); // Consume the newline character

	            switch (choice) {
	                case 1:
	                    if (authenticate(kb)) {
	                        addComputers(kb, inventory);
	                    } else {
	                        tries++;
	                        if (tries >= Maximum_TRIES) {
	                            System.out.println("Max number of password attempts reached. Returning to the main menu.");
	                        }
	                    }
	                    break;
	                case 2:
	                    if (authenticate(kb)) {
	                        updateComputer(kb, inventory);
	                    } else {
	                        tries++;
	                        if (tries >= Maximum_TRIES) {
	                            System.out.println("Max number of password attempts reached. Returning to the main menu.");
	                        }
	                    }
	                    break;
	                case 3:
	                    displayComputersByBrand(kb, inventory);
	                    break;
	                case 4:
	                    displayComputersCheaperThan(kb, inventory);
	                    break;
	                case 5:
	                    System.out.println("Thank you for using the Computer Store. Have a nice day!");
	                    break;
	                default:
	                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
	            }
	        } while (choice != 5);

	        kb.close();
	    }

	    private static boolean authenticate(Scanner kb) {
	        System.out.print("Enter your password: ");
	        String password = kb.nextLine();
	        return password.equals(PASSWORD);
	    }

	    private static void displayMainMenu() {
	        System.out.println("What do you want to do?");
	        System.out.println("1. Enter new computers (password required)");
	        System.out.println("2. Change information of a computer (password required)");
	        System.out.println("3. Display all computers by a specific brand");
	        System.out.println("4. Display all computers under a certain price");
	        System.out.println("5. Quit");
	    }

	    private static void displayUpdateMenu() {
	        System.out.println("What information would you like to change?");
	        System.out.println("1. Brand");
	        System.out.println("2. Model");
	        System.out.println("3. Serial Number (sn)");
	        System.out.println("4. Price");
	        System.out.println("5. Quit");
	    }
	    

	        private static void addComputers(Scanner kb, Computer[] inventory) {
	            System.out.print("Enter the number of computers you want to add: ");
	            int numComputersToAdd = kb.nextInt();
	            kb.nextLine(); // Consume the newline character
	        
	            int availableSpace = inventory.length - Computer.findNumberOfCreatedComputers();
	            if (numComputersToAdd > availableSpace) {
	                System.out.println("There is not enough space in the inventory to add " + numComputersToAdd + " computers.");
	                System.out.println("You can add a maximum of " + availableSpace + " computers.");
	                return;
	            }
	        
	            for (int i = 0; i < numComputersToAdd; i++) {
	                System.out.println("Enter details for Computer #" + (i + 1) + ":");
	                System.out.print("Brand: ");
	                String br = kb.nextLine();
	                System.out.print("Model: ");
	                String md = kb.nextLine();
	                System.out.print("Serial Number (sn): ");
	                long sn = kb.nextLong();
	                kb.nextLine(); // Consume the newline character
	                System.out.print("Price: $");
	                double pr = kb.nextDouble();
	                kb.nextLine(); // Consume the newline character
	        
	                Computer computer = new Computer(br, md, sn, pr);
	                inventory[Computer.findNumberOfCreatedComputers() - 1] = computer;
	                System.out.println("Computer #" + (i + 1) + " added successfully.");
	            }
	        }

	    private static void updateComputer(Scanner kb, Computer[] inventory) {
	        System.out.print("Enter the computer number you want to update: ");
	        int computerNumber = kb.nextInt();
	        kb.nextLine(); // Consume the newline character
	    
	        if (computerNumber < 1 || computerNumber > Computer.findNumberOfCreatedComputers()) {
	            System.out.println("Invalid computer number. No computer found at index " + computerNumber + ".");
	            return;
	        }
	    
	        int computerIndex = computerNumber - 1;
	        Computer computer = inventory[computerIndex];
	    
	        System.out.println("Current information for Computer #" + computerNumber + ":");
	        System.out.println(computer);
	    
	        int choice;
	        do {
	            displayUpdateMenu();	
	            System.out.print("Enter your choice: ");
	            choice = kb.nextInt();
	            kb.nextLine(); // Consume the newline character
	    
	            switch (choice) {
	                case 1:
	                    System.out.print("Enter the new brand: ");
	                    String newBrand = kb.nextLine();
	                    computer.setBrand(newBrand);
	                    break;
	                case 2:
	                    System.out.print("Enter the new model: ");
	                    String newModel = kb.nextLine();
	                    computer.setModel(newModel);
	                    break;
	                case 3:
	                    System.out.print("Enter the new Serial Number (SN): ");
	                    long newSN = kb.nextLong();
	                    kb.nextLine(); // Consume the newline character
	                    computer.setserialNumber(newSN);
	                    break;
	                case 4:
	                    System.out.print("Enter the new price: $");
	                    double newPrice = kb.nextDouble();
	                    kb.nextLine(); // Consume the newline character
	                    computer.setPrice(newPrice);
	                    break;
	                case 5:
	                    System.out.println("Changes saved. Updated information:");
	                    System.out.println(computer);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
	            }
	        } while (choice != 5);
	    }
	    
	    // Display computers with a specific brand
	    private static void displayComputersByBrand(Scanner kb, Computer[] inventory) {
	        System.out.print("Enter the brand name: ");
	        String searchBrand = kb.nextLine();

	        System.out.println("Computers with brand '" + searchBrand + "':");
	        for (Computer computer : inventory) {
	            if (computer != null && computer.getBrand().equalsIgnoreCase(searchBrand)) {
	                System.out.println(computer);
	            }
	        }
	    }

	    // Display computers cheaper than a specified price
	    private static void displayComputersCheaperThan(Scanner kb, Computer[] inventory) {
	        System.out.print("Enter the maximum price to search for: $");
	        double maxPrice = kb.nextDouble();

	        System.out.println("Computers with a price less than $" + maxPrice + ":");
	        for (Computer computer : inventory) {
	            if (computer != null && computer.getPrice() < maxPrice) {
	                System.out.println(computer);
	            }
	        }
	    }
	}


