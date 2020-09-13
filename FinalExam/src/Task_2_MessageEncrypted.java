import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_MessageEncrypted {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countOfInput = Integer.parseInt(scan.nextLine());

        Pattern patternRegex = Pattern.compile
                ("([*@])([A-Z][a-z]{2,})\\1: \\[([A-Za-z])]\\|\\[([A-Za-z])]\\|\\[([A-Za-z])]\\|$");

        List<String> decrypt = new ArrayList<>();
        StringBuilder letters = new StringBuilder();
        for (int i = 0; i < countOfInput; i++) {
            String message = scan.nextLine();

            Matcher matcher = patternRegex.matcher(message);

            if (matcher.find()) {
                System.out.print(matcher.group(2) + ": ");

                String group = matcher.group(3);
                letters.append(group);
                group = matcher.group(4);
                letters.append(group);
                group = matcher.group(5);
                letters.append(group);

                for (int j = 0; j < letters.length(); j++) {
                    int ascii = letters.charAt(j);
                    String collect = String.valueOf(ascii);
                    decrypt.add(collect);
                }
                System.out.println(String.join(" ", decrypt));
                decrypt.clear();
                letters.setLength(0);
            } else {
                System.out.println("Valid message not found!");

            }

        }
    }
}