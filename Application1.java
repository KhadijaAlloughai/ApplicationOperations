import java.util.ArrayList;
import java.util.Scanner;

public class Application1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean mainMenuRunning = true;

        //
        ArrayList<Integer> ticketNumbers = new ArrayList<>();
        ArrayList<String> descriptions = new ArrayList<>();
        ArrayList<String> priorities = new ArrayList<>();

        while (mainMenuRunning) {
            System.out.println("\nOptions\n [1] : Customer operation\n [2] : Admin operation\n [3] : Exit ");
            int userResponse = Integer.parseInt(scan.nextLine());

            if (userResponse == 1) {
                System.out.println("1. Create Ticket\n2. Back to Main Menu");
                int customerInput = Integer.parseInt(scan.nextLine());

                if (customerInput == 1) {
                    System.out.print("- Ticket Number: ");
                    int ticketNumber = Integer.parseInt(scan.nextLine());
                    System.out.print("- Description: ");
                    String descr = scan.nextLine();
                    System.out.print("- Priority: ");
                    String prior = scan.nextLine();
                    if (prior.isEmpty()) prior = "MEDIUM";

                    // Add them in order: ID, then Description, then Priority
                    ticketNumbers.add(ticketNumber);
                    descriptions.add(descr);
                    priorities.add(prior);

                    System.out.println("- Ticket created successfully!");
                }
            }
            else if (userResponse == 2) {
                System.out.print("- Admin PIN: ");
                int adminInput = Integer.parseInt(scan.nextLine());

                if (adminInput == 1234) {
                    System.out.println("Options: \n1. View All Tickets\n2. Update Description\n3. Back");
                    int adminOption = Integer.parseInt(scan.nextLine());

                    if (adminOption == 1) {
                        // 1. Change to i++ (Sequential loop)
                        for (int i = 0; i < ticketNumbers.size(); i++) {
                            System.out.println("ID: " + ticketNumbers.get(i) +
                                    " | Description: " + descriptions.get(i) +
                                    " | Priority: " + priorities.get(i));
                        }
                    }
                    else if (adminOption == 2) {
                        System.out.print("Enter Ticket ID to update: ");
                        int searchId = Integer.parseInt(scan.nextLine());

                        boolean found = false;
                        // 2. Change to i++ here too
                        for (int i = 0; i < ticketNumbers.size(); i++) {
                            if (ticketNumbers.get(i).equals(searchId)) {
                                System.out.print("- Enter New Description: ");
                                String newDescr = scan.nextLine();

                                // 3. Update 'i', NOT 'i + 1'
                                descriptions.set(i, newDescr);

                                System.out.println("Update successful.");
                                found = true;
                                break; // Stop looking once found
                            }
                        }
                        if (!found) System.out.println("Ticket ID not found.");
                    }



                }
            }
            else {
                System.out.println("Exiting the application. Goodbye!");
                mainMenuRunning = false;
            }
        }
        scan.close();
    }
}