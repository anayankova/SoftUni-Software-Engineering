package i_TextProcessingAndRegularExpressions;

import java.util.Date;

public class demo9ConcatenatingVsStringBuilder {
    public static void main(String[] args) {

        //Concatenating strings is a slow operation because each iteration creates a new string

        System.out.println(new Date());
        String text = "";
        for (int i = 0; i < 1000000; i++) {
            text += "a";
        }
        System.out.println(new Date());

        //Tue Jul 10 13:57:20 EEST 2018
        //Tue Jul 10 13:58:07 EEST 2018

        System.out.println(new Date());
        StringBuilder text1 = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            text1.append("a");
        }
        System.out.println(new Date());

        //Tue Jul 10 14:51:31 EEST 2018
        //Tue Jul 10 14:51:31 EEST 2018


    }
}
