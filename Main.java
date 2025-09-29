import java.util.*;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        List<String> menuOptions = Arrays.asList(
                "Leaderboard",
                "Employees from Team",
                "Add Employee",
                "Remove Employee",
                "See Cars",
                "Add Car",
                "See Sponsors",
                "Add Sponsor",
                "See Team Income",
                "See Circuits",
                "Change Circuit Best Time",
                "Show Team Collection",
                "Exit"
        );

        List<Runnable> actions = Arrays.asList(
                service::printTeams,
                service::printEmployees,
                service::addEmployee,
                service::removeEmployee,
                service::printCars,
                service::addCar,
                service::printSponsors,
                service::addSponsor,
                service::totalSponsor,
                service::printCircuits,
                service::improveBest,
                service::showTeamsCollection,
                
                () -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
        );

    try (Scanner scanner = new Scanner(System.in)) {   
        while (true) {
            System.out.println("\n============");
            for (int i = 0; i < menuOptions.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, menuOptions.get(i));
            }

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice >= 1 && choice <= menuOptions.size()) {
                actions.get(choice - 1).run();
            } else {
                System.out.println("Invalid choice, try again!");
            }
        }
    }
}
}