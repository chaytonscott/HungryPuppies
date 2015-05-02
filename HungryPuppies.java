import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HungryPuppies {
    ArrayList<Puppy> puppies = new ArrayList<Puppy>();

    //MAIN METHOD
    public static void main(String[] args) {
        HungryPuppies hungryPuppiesController = new HungryPuppies();
        hungryPuppiesController.start();
    }

    public void start() {
        System.out.printf("Welcome to Hungry Puppies, please insert a correct input...\n");
        String input = getInput();
        buildPuppies(input);
        setHappiness();
        printResults();
    }

    // String that recieves input from the user and validates it...
    public String getInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("> ");
        String input = in.nextLine();
        while (!correctInput(input)) {
            System.out.print("Incorrect Input! Please try again...\n");
            System.out.print("> ");

        }
        return input;
    }

    // Boolean that returns whether the input is valid...
    public boolean correctInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 47 || input.charAt(i) > 58 && input.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    // Method that builds puppy objects based upon the input...
    public void buildPuppies(String input) {
        StringTokenizer stringTokenizer = new StringTokenizer(input);
        for (int i = 0; i < stringTokenizer.countTokens(); i++) {
            int tempBiscuit = Integer.parseInt(stringTokenizer.nextToken());
            Puppy puppy = new Puppy(tempBiscuit);
        }
    }

    // Method that sets the happiness of all of the puppies...
    public void setHappiness() {
        for (int i = 0; i < puppies.size(); i++) {
            Puppy tempPuppy;
            if (i == 0) {
                tempPuppy = calculateHappiness(puppies.get(i), puppies.get(i + 1));
            } else if (i == puppies.size() - 1) {
                tempPuppy = calculateHappiness(puppies.get(i), puppies.get(i - 1));
            } else {
                tempPuppy = calculateHappiness(puppies.get(i), puppies.get(i + 1), puppies.get(i - 1));
            }
            puppies.get(i).set_happiness(tempPuppy.get_happiness());
        }
    }

    // Puppy returning method that calculates the happiness of puppies...
    public Puppy calculateHappiness(Puppy inputPuppy, Puppy rightPuppy, Puppy leftPuppy) {
        if (inputPuppy.get_biscuitSize() < leftPuppy.get_biscuitSize()) {
            inputPuppy.minusOneHappiness();
        } else if (inputPuppy.get_biscuitSize() > leftPuppy.get_biscuitSize()) {
            inputPuppy.addOneHappiness();
        }

        if (inputPuppy.get_biscuitSize() < rightPuppy.get_biscuitSize()) {
            inputPuppy.minusOneHappiness();
        } else if (inputPuppy.get_biscuitSize() > rightPuppy.get_biscuitSize()) {
            inputPuppy.addOneHappiness();
        }
        return inputPuppy;
    }

    // Puppy returning method that calculates the happiness of puppies on the end of the line...
    public Puppy calculateHappiness(Puppy inputPuppy, Puppy neighborPuppy) {
        if (inputPuppy.get_biscuitSize() < neighborPuppy.get_biscuitSize()) {
            inputPuppy.set_happiness(-9);
        } else if (inputPuppy.get_biscuitSize() > neighborPuppy.get_biscuitSize()) {
            inputPuppy.set_happiness(9);
        }
        return inputPuppy;
    }

    public void printResults() {

    }
}
