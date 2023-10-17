import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Cli {

    public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt

		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String output = ""; // A variable named output of type String
			String[] parts = command.split(" ");
			int nbrElems = parts.length;

			if (command.equals("exit")) {
				break; // Forces exit of the while loop
			} else {

				if (command.equals("date")) {
					output = "" + LocalDate.now(); // print date
				} else if (command.equals("time")) {
					output = "" + LocalTime.now(); // print date
				} else if (command.equals("datetime")) {
					output = "" + LocalDateTime.now(); // print date and time
				} else if (command.equals("useraccount")) {
					output = System.getProperty("user.name"); // print name
				} else if (command.equals("userhome")) {
					output = System.getProperty("user.home"); // print home
				} else if (command.equals("os")) {
					output = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")"; // print OS
				} else if (parts[0].equals("printenv")) {
					if (nbrElems < 2) {
						output = "";
					} else {
						String homeValue = System.getenv(parts[1]);
						if (homeValue == null) {
							output = "";
						} else {
							output = homeValue;
						}
					}
        			} else if (parts[0].equals("echo")) {
					if (nbrElems < 2) {
						output = "";
					} else {						
						String result = "";

						for (int i = 1; i < nbrElems; i++) {
							result = result + parts[i] + " ";
						}
						output = result;
					}
				} else {
					output = "Command '" + command + "' not found.";
				}
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye !");
    }

}