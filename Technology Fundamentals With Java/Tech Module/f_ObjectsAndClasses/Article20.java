package f_ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Article20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Articles2> articles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = (scanner.nextLine().split(", "));
            Articles2 article = new Articles2(input[0], input[1], input[2]);
            articles.add(article);
        }
        String command = scanner.nextLine();

        switch (command){
            case "title":
                articles = articles.stream()
                        .filter(article -> !article.getTitle().isEmpty())
                        .sorted((a1,a2) -> a1.getTitle().compareTo(a2.getTitle()))
                        .collect(Collectors.toList());
                for (Articles2 article : articles) {
                    System.out.println(article);
                }
                break;
            case "content":
                articles = articles.stream()
                        .filter(article -> !article.getContent().isEmpty())
                        .sorted((a1,a2) -> a1.getContent().compareTo(a2.getContent()))
                        .collect(Collectors.toList());
                for (Articles2 article : articles) {
                    System.out.println(article);
                }
                break;
            case "author":
                articles = articles.stream()
                        .filter(article -> !article.getAuthor().isEmpty())
                        .sorted((a1,a2) -> a1.getAuthor().compareTo(a2.getAuthor()))
                        .collect(Collectors.toList());
                for (Articles2 article : articles) {
                    System.out.println(article);
                }
                break;
        }
    }
    public static class Articles2 {
        private String title;
        private String content;
        private String author;

        public Articles2(){

        }

        public Articles2(String title,String content,String author){
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s",this.getTitle(),this.getContent(),this.getAuthor());
        }
    }
}


