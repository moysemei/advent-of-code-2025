package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args){
        File file = new File("src/day03/input-day03.txt");
        long finalResult = 0;

        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.length() < 12) continue;

                int currentPosition = -1;
                String result = "";

                for (int k = 0; k < 12; k++) {
                    int remaining = 12 -k;
                    int limit = line.length() - remaining;
                    char maxDigit = 0;
                    int bestIndex = -1;
                    for (int v = currentPosition + 1; v <= limit; v++) {
                        if (line.charAt(v) > maxDigit) {
                            maxDigit = line.charAt(v);
                            bestIndex = v;
                        }
                    }
                    result += maxDigit;

                    currentPosition = bestIndex;


                }
                long value = Long.parseLong(result);
                finalResult += value;
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(finalResult);
    }
}
