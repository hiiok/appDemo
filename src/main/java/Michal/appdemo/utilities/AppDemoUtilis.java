package Michal.appdemo.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppDemoUtilis {

    //Pattern regex checker to valid information pStr from user - correct email or password
    public static boolean checkEmailOrPassword(String pattern, String pStr) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(pStr);
        return m.matches();
    }
}