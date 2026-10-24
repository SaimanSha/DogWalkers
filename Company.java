import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Company {
    private int companyNum;
    private String companyInfo;
    private int[] companyDogs;
    private static Company[] masterClass = new Company[120];

    public Company(int companyNum) throws FileNotFoundException {
        this.companyNum = companyNum;
        this.companyDogs = new int[24];
        
        File file = new File("companies.txt");
        Scanner scanner = new Scanner(file);
        for (int i = 0; i < companyNum - 1; i++) {
            scanner.nextLine();
        }
        String line = scanner.nextLine();
        scanner.close();

        int space = line.indexOf(" ");
        int count = 0;
        while (space > 0) {
        companyDogs[count] = Integer.parseInt(line.substring(0, space));
        line = line.substring(space + 1);
        space = line.indexOf(" ");
        count++;
        }
    }

    public int getPaymentWithDeduction(Walker walker) {
        if (walker.getCompany() == this.companyNum) {
            int cap = walker.getCapacity();
            int clockIn = walker.getClockIn();
            int clockOut = walker.getClockOut();
            
            int dogsWalked = 0;
            int bonuses = 0;
            for (int i = clockIn; i < clockOut; i++) {
                if (companyDogs[i] < cap) {
                    dogsWalked += companyDogs[i];
                    companyDogs[i] = 0;
                    bonuses++;
                } else {
                    dogsWalked += cap;
                    companyDogs[i] -= cap;
                    if (i >= 9 && i <= 17) {
                        bonuses++;
                    }
                }
            }
            if (this.isAccountedFor() != true) {
                masterClass[this.companyNum] = this;
            }
            return ((dogsWalked * 5) + (bonuses * 3));

        } else {return 0;}
    }

    public static Company getExistingCompany(int number) {
        if (masterClass[number] != null) {
            return masterClass[number];
        } else {return null;}
    }

    public boolean isAccountedFor() {
        return (masterClass[this.companyNum] != null);
    }

    public static boolean isAccountedFor(int number) {
        return (masterClass[number] != null);
    }

    public int getCompanyNum() {
        return this.companyNum;
    }

    public String getCompanyInfo() {
        return this.companyInfo;
    }

    public String getCompanyDogs(boolean print) {
        if (print) {
            for (int i = 0; i < this.companyDogs.length; i++) {
                System.out.print(this.companyDogs[i] + ", ");
            }
            return "";
        } else {
            String info = "";
            for (int i = 0; i < this.companyDogs.length; i++) {
                info += this.companyDogs[i] + ", ";
            }
            return info;
        }
    }
}
