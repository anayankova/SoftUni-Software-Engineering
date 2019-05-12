package f_ObjectsAndClasses.AdvartisementMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Message message = new Message();

        for (int i = 0; i < n ; i++) {
            String randomMessage = message.randomMessage();
            System.out.println(randomMessage);

        }



    }
}
