import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int MONEY = 0;
        File file = new File("walkers.txt");
        Scanner scanner = new Scanner(file);
        int ie = 0;
        while (scanner.hasNextLine()) {
            ie++;
            String line = scanner.nextLine();
            Walker walker = new Walker(line);
            Company company;
            if (Company.isAccountedFor(walker.getCompany())) {
                company = Company.getExistingCompany(walker.getCompany());
            } else {
                company = new Company(walker.getCompany());
            }
            int earnings = company.getPaymentWithDeduction(walker);
            MONEY += earnings;
            System.out.print(ie + "|" + earnings + ", ");
        }
        System.out.println();
        System.out.print("Total Money: $" + MONEY);
        scanner.close();
    }


        /** Code below was used for debugging. */
    /* public static boolean lineExists(File file, int chosen) throws FileNotFoundException {
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
    } */
}