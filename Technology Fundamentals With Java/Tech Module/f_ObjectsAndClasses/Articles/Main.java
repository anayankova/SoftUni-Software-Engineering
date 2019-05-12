package f_ObjectsAndClasses.Articles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(", ");
        Article article = new Article(data[0], data[1], data[2]);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n ; i++) {
            String[] input = reader.readLine().split(": ");
            String command = input[0];

            switch (command){
                case "Edit":
                    article.edit(input[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAutor(input[1]);
                    break;
                case "Rename":
                    article.rename(input[1]);
                    break;
            }
        }

        System.out.println(article);

    }
}
