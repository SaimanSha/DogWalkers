import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static boolean lineExists(File file, int chosen) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        int counter = 0;
        while (s.hasNextLine() && counter < chosen) {
            s.nextLine();
            counter++;
        }
        if (counter >= chosen) {
            s.close();
            return true;
        }
        s.close();
        return false;
    }
    public static void main(String[] args) throws FileNotFoundException {
        int MONEY = 0;
        File file = new File("walkers.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Walker walker = new Walker(line);
            Company company;
            if (Company.isAccountedFor(walker.getCompany())) {
                company = Company.getExistingCompany(walker.getCompany());
            } else {
                company = new Company(walker.getCompany());
            }
            MONEY += company.getPaymentWithDeduction(walker);
            
            // PUT THE THING THAT DETECTS WHETHER THE COMPANY HAS ALREADY BEEN EVALUATED
        }
        System.out.print("Total Money: " + MONEY);
        scanner.close();
    }
}


/**             String side = scanner.nextLine();
            for (int i = 0; i < chosen - 1; i++) {
                scanner.nextLine();} */