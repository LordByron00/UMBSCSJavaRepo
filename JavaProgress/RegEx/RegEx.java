package JavaProgress.RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[BCN]");
        Matcher matcher = pattern.matcher("A BANANA CAN FLY BETTER THAN A BIRD");
        int count = 0;
        while(matcher.find())count++;
        System.out.println(count);
        System.out.print("Hello, World!");
        System.out.print("Java is awesome.");
        System.out.print("Java is awesome.");
        System.out.print("Java is awesome.");
        System.out.print("Java is awesome.");
        System.out.print("Java is awesome.");

        String[] strings = {"CCQQ", "QQCC", "CQQ", "QUACK", "CCQ", "CQC", "CQQQ", "CCCQQ"};

        Pattern pattern2 = Pattern.compile("C+Q{2}");
        for(String s: strings){
            Matcher matcher2 = pattern2.matcher(s);
            boolean matched = matcher2.matches();
            if (matched) {
                String matchContent = matcher2.group();
                System.out.print(matchContent + " - ");
            }
            System.out.println(matched);
        }

    }
}
