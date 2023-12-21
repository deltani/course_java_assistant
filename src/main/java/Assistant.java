/**
 * Java Assistant
 *
 * This program represents a simple interactive assistant with the following features:
 * 1. Make a note and save it to a file (notes.txt).
 * 2. Display the current date.
 * 3. Display the current time.
 * 4. Play a number guessing game.
 * 5. Exit the assistant.
 *
 * The user is presented with a menu to choose from these options.
 * When making a note, the user is prompted to enter a note, and the note is appended to the "notes.txt" file.
 *
 * Dependencies:
 * - Java Standard Library
 *
 * @author Tetyana Drobot
 * @version 1.0
 * @since 2023-11-15
 */

import java.util.Scanner;    // Import the Scanner to be able to get user input
import java.time.LocalDate;  // Import the LocalDate to get the current date
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Random;     // Import the Random class to generate the random integers

public class Assistant {
    /**
     * The main method representing the entry point of the program.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Display the main menu
            System.out.println("Welcome to Java Assistant!");
            System.out.println("Select one of the options presented by typing the number of the option.");
            System.out.println("1. Make a note");
            System.out.println("2. Tell the date");
            System.out.println("3. Tell the time");
            System.out.println("4. Play a game");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice: ");

            // Get the response of the user
            int choice = scanner.nextInt();

            /** Switch on a Variable: switch(input): This line begins the switch statement, testing the variable input.
             Case Clauses: Each case checks if input matches a specific value:
             case "1": If input is "1", execute makeANote(scanner).
             case "2": If input is "2", execute tellTheDate().
             case "3": If input is "3", execute tellTheTime().
             case "4": If input is "4", execute playAGAME().
             case "5": If input is "5", set running to false, which will eventually break the loop and end the program.
             **/
            switch (choice) {
                case 1:
                    // Option to make a note
                    System.out.println("Make a note...");
                    makeANote(scanner);
                    break;
                case 2:
                    // Option to tell the date
                    System.out.println("Checking the date");
                    tellTheDate();
                    break;
                case 3:
                    // Option to tell the time
                    System.out.println("Checking the time...");
                    tellTheTime();
                    break;
                case 4:
                    // Option to play a game
                    System.out.println("Launching the game...");
                    playAGAME();
                    break;
                case 5:
                    // Exit the program
                    running = false;
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please select from the options menu.");
            }
        }
    }

    /**
     * Display the current time.
     */
    private static void tellTheTime() {
        String currentTime = getCurrentTime();
        System.out.println("Current time: " + currentTime);
    }
    /**
     * Get the current time as a string.
     *
     * @return A string representing the current time.
     */
    private static String getCurrentTime() {
        return java.time.LocalTime.now().toString();
    }
    /**
     * Display the current date.
     */
    private static void tellTheDate() {
        String currentTime = getCurrentDate();
        System.out.println("Current date: " + currentTime);
    }
    /**
     * Get the current date as a string.
     *
     * @return A string representing the current date.
     */
    private static String getCurrentDate() {
        return LocalDate.now().toString();
    }
    /**
     * Make a note and save it to a file (notes.txt).
     *
     * @param scanner The Scanner object for user input.
     */
    private static void makeANote(Scanner scanner) {
        try {
            // Consume the newline character left by scanner.nextInt()
            scanner.nextLine();

            // Prompt the user to enter a note
            System.out.print("Enter your note: ");
            String note = scanner.nextLine();

            // Append the note to the "notes.txt" file
            FileWriter myWriter = new FileWriter("notes.txt", true); // Append mode
            myWriter.write(note + "\n"); // Add a newline after each note
            myWriter.close();

            System.out.println("Note successfully added.");
        } catch (IOException e) {
            // Handle IO exception in case of the errors
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private static void playAGAME() {
        // This line creates an instance of the Random class, named r.
        // The Random class is part of java.util and is used to generate pseudo-random numbers.
        Random r = new Random();
        // r.nextInt(10) generates a random integer between 0 (inclusive) and 10 (exclusive). So, it can be any value from 0 to 9.
        //The + 1 at the end adjusts this range to be from 1 to 10. Without the + 1, the range would be from 0 to 9, but with it, the range shifts to 1 to 10.
        int NUMBER = r.nextInt(10) + 1;
        // This line declares an integer variable named userNUMBER and initializes it to 0, prior to asking the user for their guess.
        int userNUMBER = 0;

        Scanner player = new Scanner(System.in);

        while ( userNUMBER != NUMBER ) {
            // Prompt player for guess
            System.out.println("Guess a number between 1 and 10:");
            userNUMBER = player.nextInt();

            if ( userNUMBER > NUMBER ) {
                // Check if the number from user is larger than the random number
                System.out.println("Your number is too high, try again:");
            } else if ( userNUMBER < NUMBER ) {
                // Check if the number from user is smaller than the random number
                System.out.println("Your number is too low, try again:");
            } else {
                // In case it's neither, so number of the user is equal to the random number
                System.out.println("Congratulations - you just read my mind!");
                // Exit the program
                break;
            }
        }
    }
}
