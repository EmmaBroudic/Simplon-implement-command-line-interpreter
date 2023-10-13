import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Cli {

    public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt

		// Date
		LocalDate today = LocalDate.now();

		// Time
		LocalTime timeNow = LocalTime.now(); // Get time

		//Date and time
		String dateAndTime = today + "T" + timeNow;

		// User
                String name = System.getProperty("user.name");

		// Home
		String home = System.getProperty("user.home");

		// OS
		String operatingSysName = System.getProperty("os.name");
		String operatingSysVersion = System.getProperty("os.version");
		String operatingSys = operatingSysName + " (" + operatingSysVersion + ")";

		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as a string
			String output = ""; // A variable named output of type String
			String[] parts = command.split(" ");

			if (command.equals("exit")) {
				break; // Forces exit of the while loop
			} else {

				if (command.equals("date")) {
					System.out.println("The date is : " + today); // print date
				} else if (command.equals("time")) {
					System.out.println("The time is : " + timeNow); // print date
				} else if (command.equals("datetime")) {
					System.out.println("Date and time are : " + dateAndTime); // print date and time
				} else if (command.equals("useraccount")) {
					System.out.println("User account is : " + name); // print name
				} else if (command.equals("userhome")) {
					System.out.println("User home is : " + home); // print home
				} else if (command.equals("os")) {
					System.out.println("User os is : " + operatingSys); // print OS
				} else {
					if (command.startsWith("printenv")) {
						System.out.println(parts[1]);
						String homeValue = System.getenv(parts[1]);
						System.out.println(homeValue);
        			} else if (command.startsWith("echo")) {						
						int nbrLoop = parts.length;
						String result = "";

						for (int i = 1; i < nbrLoop; i++) {
							result = result + parts[i] + " ";
						}

						System.out.println(result);

					} else {
						output = "Command '" + command + "' not found.";
					}
				}
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye !");
    }

}