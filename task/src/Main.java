import java.util.Scanner;

class TextHelper {

    public static void printAlphabetNumbers(String text) {
        StringBuilder topRow = new StringBuilder();
        StringBuilder bottomRow = new StringBuilder();

        String ukrAlphabet = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            char lowerChar = Character.toLowerCase(currentChar);

            int alphabetNumber = 0;

            if (lowerChar >= 'a' && lowerChar <= 'z') {
                alphabetNumber = lowerChar - 'a' + 1;
            }
            else {
                int ukrIndex = ukrAlphabet.indexOf(lowerChar);
                if (ukrIndex != -1) {
                    alphabetNumber = ukrIndex + 1;
                }
            }

            if (alphabetNumber > 0) {
                topRow.append(currentChar).append("  ");

                if (alphabetNumber < 10) {
                    bottomRow.append(alphabetNumber).append("  ");
                } else {
                    bottomRow.append(alphabetNumber).append(" ");
                }
            }
        }

        System.out.println(topRow.toString());
        System.out.println(bottomRow.toString());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть текст:");
        String userInput = scanner.nextLine();

        TextHelper.printAlphabetNumbers(userInput);

        scanner.close();
    }
}