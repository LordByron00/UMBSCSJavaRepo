package JavaProgress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[BCN]");
        Matcher matcher = pattern.matcher("A BANANA CAN FLY BETTER THAN A BIRD");
        int count = 0;
        while(matcher.find())count++;
        System.out.println(count);
    }
}
