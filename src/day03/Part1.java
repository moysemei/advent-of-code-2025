package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        File file = new File("src/day03/input-day03.txt");
        long result = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.length() < 2) continue;

                long maxJoltage = 0;

                for (int i = 0; i < line.length(); i++) {
                    for (int j = i + 1; j < line.length(); j++) {
                        char c1 = line.charAt(i);
                        char c2 = line.charAt(j);

                        String numberStr = "" + c1 + c2;

                        long value = Long.parseLong(numberStr);

                        if (value > maxJoltage) {
                            maxJoltage = value;
                        }
                    }
                }

                result += maxJoltage;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        System.out.println("Final result: " + result);
    }
}