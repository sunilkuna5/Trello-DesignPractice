import CommandLineInterface.CommandLineAdapter;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        CommandLineAdapter commandLineAdapter = new CommandLineAdapter();
        String scannedString;
        while (!(scannedString = scanner.nextLine()).isEmpty()){
            System.out.println(commandLineAdapter.parse(scannedString));
        }
    }
}
