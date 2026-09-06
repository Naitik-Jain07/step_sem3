import java.util.Scanner;
public class WordReversalEncoder {

    static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {

            StringBuilder word = new StringBuilder();

            for (int j = words[i].length() - 1; j >= 0; j--) {
                word.append(words[i].charAt(j));
            }

            result = result + word.toString();

            if (i < words.length - 1) {
                result = result + " ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();

        System.out.println(reverseEachWord(sentence));

        sc.close();
    }
}
