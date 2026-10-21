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
        File file = new File("walkers.txt");
        Scanner scanner = new Scanner(file);
        int chosen = 69;
        if (lineExists(file, chosen)) {
            System.out.println("Line exists.");
            for (int i = 0; i < chosen - 1; i++) {
                scanner.nextLine();}
            String line = scanner.nextLine();
            Walker walker = new Walker(line);
                        System.out.println(walker.getAttributes());
            int co = walker.getCompany() + 1;
            Company company = new Company(co);
                        System.out.print("Company " + walker.getCompany() + "'s schedule be4: " + company.getCompanyDogs(false));
                        System.out.println();
                        System.out.println("Dogs walked: " + company.getPaymentWithDeduction(walker));
                        System.out.print("Company " + walker.getCompany() + "'s schedule now: " + company.getCompanyDogs(false));
            
        } else {
            System.out.println("Line does not exist.");
        }
        scanner.close();
    }
}