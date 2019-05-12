package i_TextProcessingAndRegularExpressions;

public class demo3Substring {
    public static void main(String[] args) {

        //substring(int startIndex, int endIndex)
        String card = "10C";
        String power = card.substring(0, 2);
        System.out.println(power); // 10

        //substring(int startIndex)

        String text = "My name is John";
        String extractWord = text.substring(11);
        System.out.println(extractWord); // John



    }
}
