import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class Service {
    private Connection conn;
    private Scanner scanner; 
    private Set<Team> teams = new TreeSet<>(Comparator.comparing(Team::getPoints).reversed());
   
    public Service() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dealer", "root", "av22");
            scanner = new Scanner(System.in); 
            teams.add(new Team("Red Bulls", new ArrayList<>(), "RedBull", 120));
            teams.add(new Team("Ferrari", new ArrayList<>(), "Shell", 90));
            teams.add(new Team("Mercedes", new ArrayList<>(), "Petronas", 100));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void header() {
        System.out.println("----------------");
    }

    private void waitInput() {
        System.out.println("\n---- Enter ----");
        try {
            scanner.nextLine(); 
        } catch (Exception e) {}
    }

    private void addCSV(String line) {
        try {
            String timestamp = LocalDateTime.now().toString();
            FileWriter writer = new FileWriter("output.csv", true);
            writer.write(timestamp + "," + line + "\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printTeams() {
        header();
        try (Statement stmt = conn.createStatement();
             ResultSet teams = stmt.executeQuery("SELECT * FROM Team ORDER BY points DESC;")) {

            while (teams.next()) {
                int id = teams.getInt("id");
                int points = teams.getInt("points");
                String name = teams.getString("name");

                System.out.println("(id:" + id + "): points:" + points + " - " + name);
            }

        } catch (Exception e) {}

        addCSV("print teams");
        waitInput();
    }
    
    public void showTeamsCollection() {
    System.out.println("=== Teams Collection (sorted by points) ===");
    for (Team t : teams) {
        System.out.println(t);
    }
    addCSV("print teams_collection");
    waitInput();
}


    public void printEmployees() {
        try {
            System.out.print("Enter Team ID to see employees: ");
            int teamId = scanner.nextInt(); 
            scanner.nextLine(); 

            header();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee WHERE teamid = " + teamId + ";");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                String nation = rs.getString("nation");
                String specialty = rs.getString("specialty");
                int experience = rs.getInt("experience");
                int number = rs.getInt("number");

                System.out.println("(id:" + id + "): " + name + " | Salary: " + salary
                        + " | Nation: " + nation + "| Specialty: " + specialty + " | Exp: " + experience + " | Number: " + number);
            }
            
            addCSV("print employees");
            waitInput();
        } catch (Exception e) {}
    }

    public void addEmployee() {
        try {
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();

            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); 

            System.out.print("Enter specialty: ");
            String specialty = scanner.nextLine();

            System.out.print("Enter experience (years): ");
            int experience = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Team ID: ");
            int teamId = scanner.nextInt();
            scanner.nextLine(); 

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO Employee (name, salary, specialty, experience, teamid) VALUES (" +
                        "'" + name + "', " + salary + ", '" + specialty + "', " + experience + ", " + teamId + ")";
            stmt.executeUpdate(sql);

            System.out.println("Employee added.");
            addCSV("add employee");
            waitInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeEmployee() {
        try {
            System.out.print("Employee ID");
            int employeeId = scanner.nextInt();
            scanner.nextLine(); 

            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM Employee WHERE id = " + employeeId;
            int rowsAffected = stmt.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + employeeId + " has been removed.");
            } else {
                System.out.println("No employee found with ID " + employeeId + ".");
            }

            addCSV("remove employee");
            waitInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printCars() {
        try {
            header();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Car;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String model = rs.getString("model");
                int hp = rs.getInt("hp");
                int teamId = rs.getInt("teamid");

                System.out.println("(id:" + id + ") Model: " + model + " | HP: " + hp + " | Team ID: " + teamId);
            }

            addCSV("print cars");
            waitInput();
        } catch (Exception e) {}
    }

    public void addCar() {
        try {
            System.out.print("Enter car model: ");
            String model = scanner.nextLine();

            System.out.print("Enter horsepower (HP): ");
            int hp = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter Team ID: ");
            int teamId = scanner.nextInt();
            scanner.nextLine(); 

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO Car (model, hp, teamid) VALUES (" +
                        "'" + model + "', " + hp + ", " + teamId + ")";
            stmt.executeUpdate(sql);

            System.out.println("Car added.");
            addCSV("add car");
            waitInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printSponsors() {
        try {
            header();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Sponsor;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double spent = rs.getDouble("spent");
                int teamId = rs.getInt("teamid");

                System.out.println("(id:" + id + ") Name: " + name + " | Spent: " + spent + " | Team ID: " + teamId);
            }

            addCSV("see sponsors");
            waitInput();
        } catch (Exception e) {}
    }

    public void addSponsor() {
        try {
            System.out.print("Enter sponsor name: ");
            String name = scanner.nextLine();

            System.out.print("Enter amount spent: ");
            double spent = scanner.nextDouble();
            scanner.nextLine(); 

            System.out.print("Enter Team ID: ");
            int teamId = scanner.nextInt();
            scanner.nextLine(); 

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO Sponsor (name, spent, teamid) VALUES (" +
                        "'" + name + "', " + spent + ", " + teamId + ")";
            stmt.executeUpdate(sql);

            System.out.println("Sponsor added.");
            addCSV("add sponsor");
            waitInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void totalSponsor() {
        try {
            header();
            System.out.print("team ID: ");
            int teamId = scanner.nextInt();
            scanner.nextLine(); 

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT SUM(spent) AS total FROM Sponsor WHERE teamid = " + teamId
            );

            if (rs.next()) {
                double total = rs.getDouble("total");
                System.out.println("Total: " + teamId + ": " + total);
            }

            addCSV("total income");
            waitInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printCircuits() {
        try {
            header();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Circuit;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String location = rs.getString("country");
                int length = rs.getInt("length");
                double bestMs = rs.getDouble("best_ms");

                System.out.println("(id:" + id + ") " + name + " | Location: " + location + " | Length: " + length + " | Best MS: " + bestMs);
            }

            addCSV("see circuits");
            waitInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void improveBest() {
        try {
            header();
            System.out.print("Enter Circuit ID to improve best_ms: ");
            int circuitId = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter milliseconds to subtract (improvement): ");
            double improvement = scanner.nextDouble();
            scanner.nextLine(); 

            Statement stmt = conn.createStatement();
            String sql = "UPDATE Circuit SET best_ms = best_ms - " + improvement + " WHERE id = " + circuitId;
            int rowsAffected = stmt.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Circuit ID " + circuitId + " best_ms improved by " + improvement + " ms.");
            } else {
                System.out.println("No circuit found with ID " + circuitId + ".");
            }

            addCSV("improve best_ms for circuit");
            waitInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            addCSV("close db");
            conn.close();
            scanner.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
