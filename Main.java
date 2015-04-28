import java.util.Scanner;
public class Main {

    //MAIN METHOD
    public static void main(String [] args) {
        Main mainController= new Main();
        mainController.start();
    }

    public void start() {
        System.out.printf("Welcome to Hungry Puppies, please insert a correct input...\n");
        String input = getInput();
    }

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

    public boolean correctInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 47 || input.charAt(i) > 58 && input.charAt(i) != ' ')  {
                return false;
            }
        }
        return true;
    }

}
