import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    // Instance variables (if needed)
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    // Added Monkey Array
    
    public static void main(String[] args) {


        initializeDogList();
        initializeMonkeyList();
        
        boolean acceptingInput = true;
        Scanner input = new Scanner(System.in);
 
        do {
        	displayMenu();
        	String option = input.nextLine().trim().toLowerCase();
        	   
        	
        	switch(option) {
            case "1":
               // Input new dog
               intakeNewDog(input);
               break;

            case "2":
               // Input new monkey
               intakeNewMonkey(input);
               break;

            case "3":
               // Reserve animal
               reserveAnimal(input);
               break;

            case "4":
               // Print all dogs
               printAnimals("dog");
               break;

            case "5":
               // Print all monkies
               printAnimals("monkey");
               break;

            case "6":
               // Print all non reserved animals
               printAnimals("available");
               break;

            case "q":
               // Quit
               acceptingInput = false;
               break;

            default:
               System.out.println("Invalid option, please input a valid option");
               break;
         }
      } while(acceptingInput);

      System.out.println("Goodbye");
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

  
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Cappy", "Golden", "male", "5", "55.6", "06-02-2013", "United States", "Phase II", false, "United States");
        Monkey monkey2 = new Monkey("Max", "Emperor", "female", "4", "4.7", "06-09-2022", "Mexico", "Phase II", false, "Mexico");
        Monkey monkey3 = new Monkey("Tammy", "Silvery", "male", "6", "22.7", "01-01-2019", "United States", "in service", false, "United States");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
     }


    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        // Add the code to instantiate a new dog and add it to the appropriate list
        System.out.println("What is " + name + "'s breed?");
        String breed = scanner.nextLine().trim();
        	//gender
        System.out.println("What is " + name + "'s gender? (\"male\", \"female\")");
        String gender = scanner.nextLine().trim().toLowerCase();
        //age
        System.out.println("What is " + name + "'s age?");
        String age = scanner.nextLine().trim();
        //weight
        System.out.println("What is " + name + "'s weight? (in pounds)");
        String weight = scanner.nextLine().trim();
        //acquired
        System.out.println("When was " + name + "'s acquired? (MM-DD-YYYY)");
        String acquisitionDate = scanner.nextLine().trim();
        //country acquired
        System.out.println("Where was " + name + "'s acquired? (Country)");
        String acquisitionCountry = scanner.nextLine().trim();
        //training
        System.out.println("What is " + name + "'s training status? (\"intake\", \"in service\", \"Phase I/II/III\")");
        String trainingStatus = scanner.nextLine().trim();
        //reserved
        System.out.println("Is " + name + " reserved? (Y/N)");
        boolean reserved = scanner.nextLine().trim().equalsIgnoreCase("Y");
        //service country
        System.out.println("What is " + name + "'s service country?");
        String inServiceCountry = scanner.nextLine().trim();

        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);

        dogList.add(newDog);
     }
    
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine().trim();

        for(Monkey monkey : monkeyList)
           if(monkey.getName().equalsIgnoreCase(name)) {
              System.out.println("\n\nThis monkey is already in our system\n\n");
              return;
           }

        boolean invalidBreed = true;

        // Validate the monkey's breed
        String breed;
        do {
           System.out.println("What is " + name + "'s breed?");
           breed = scanner.nextLine().trim();

           for(String validBreed : Monkey.VALID_BREEDS)
              if(breed.equalsIgnoreCase(validBreed))
                 invalidBreed = false;

           if(invalidBreed)
              System.out.println("Invalid breed option");
        } while(invalidBreed);

        System.out.println("What is " + name + "'s gender? (\"male\", \"female\")");
        String gender = scanner.nextLine().trim().toLowerCase();

        System.out.println("What is " + name + "'s age?");
        String age = scanner.nextLine().trim();

        System.out.println("What is " + name + "'s weight? (in pounds)");
        String weight = scanner.nextLine().trim();

        System.out.println("When was " + name + "'s acquired? (MM-DD-YYYY)");
        String acquisitionDate = scanner.nextLine().trim();

        System.out.println("Where was " + name + "'s acquired? (Country)");
        String acquisitionCountry = scanner.nextLine().trim();

        System.out.println("What is " + name + "'s training status? (\"intake\", \"in service\", \"Phase I/II/III\")");
        String trainingStatus = scanner.nextLine().trim();

        System.out.println("Is " + name + " reserved? (Y/N)");
        boolean reserved = scanner.nextLine().trim().equalsIgnoreCase("Y");

        System.out.println("What is " + name + "'s service country?");
        String inServiceCountry = scanner.nextLine().trim();

        Monkey newMonkey = new Monkey(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);

        monkeyList.add(newMonkey);
     }

     public static void reserveAnimal(Scanner scanner) {
        System.out.println("What type of animal will be needed? (\"dog\", \"monkey\")");
        String animalType = scanner.nextLine().trim();

        System.out.println("Where will the animal be serving? (Country)");
        String animalServiceCountry = scanner.nextLine().trim();

        // Go through all dogs
           // Reserves the first non-reserved, in-service dog in the country
        if(animalType.equalsIgnoreCase("dog"))
           for(Dog dog : dogList)
              if(true
                 // && dog.getTrainingStatus().equalsIgnoreCase("in service")
                 && dog.getInServiceLocation().equalsIgnoreCase(animalServiceCountry)
                 && !dog.getReserved()
              ) {
                 dog.setReserved(true);

                 System.out.println(dog.getName() + " has been reserved");
                 return;
              }

        if(animalType.equalsIgnoreCase("monkey"))
           for(Monkey monkey : monkeyList)
              if(true
                 // && monkey.getTrainingStatus().equalsIgnoreCase("in service")
                 && monkey.getInServiceLocation().equalsIgnoreCase(animalServiceCountry)
                 && !monkey.getReserved()
              ) {
                 monkey.setReserved(true);

                 System.out.println(monkey.getName() + " has been reserved");
                 return;
              }

        System.out.println("Unable to reserve a " + animalType + " at this time");
     }

     public static void printAnimals(String outputType) {

        System.out.println("Name\t\t| Status\t| Acq. Country\t| Reserved");

        switch(outputType) {
           case "dog":
              for(Dog dog : dogList) {
                 String name = dog.getName();
                 String status = dog.getTrainingStatus();
                 String acquisitionCountry = dog.getAcquisitionLocation();
                 boolean reserved = dog.getReserved();

                 System.out.println(name + "\t\t| " + status + "\t| " + acquisitionCountry + "\t| " + reserved);
              }
              break;

           case "monkey":
              for(Monkey monkey : monkeyList) {
                 String name = monkey.getName();
                 String status = monkey.getTrainingStatus();
                 String acquisitionCountry = monkey.getAcquisitionLocation();
                 boolean reserved = monkey.getReserved();

                 System.out.println(name + "\t\t| " + status + "\t| " + acquisitionCountry + "\t| " + reserved);
              }
              break;

           case "available":
           
              for(Dog dog : dogList) {
                 String name = dog.getName();
                 String status = dog.getTrainingStatus();
                 String acquisitionCountry = dog.getAcquisitionLocation();
                 boolean reserved = dog.getReserved();

                 boolean available = !reserved && status.equalsIgnoreCase("in service");
                 if(!available)
                    continue;

                 System.out.println(name + " (dog)\t| " + status + "\t| " + acquisitionCountry + "\t| " + reserved);
              }

         
              for(Monkey monkey : monkeyList) {
                 String name = monkey.getName();
                 String status = monkey.getTrainingStatus();
                 String acquisitionCountry = monkey.getAcquisitionLocation();
                 boolean reserved = monkey.getReserved();

                 boolean available = !reserved && status.equalsIgnoreCase("in service");
                 if(!available)
                    continue;

                 System.out.println(name + " (monkey)\t| " + status + "\t| " + acquisitionCountry + "\t| " + reserved);
              }
              break;

}
}
}
       
