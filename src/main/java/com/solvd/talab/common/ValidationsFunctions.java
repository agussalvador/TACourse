package com.solvd.talab.common;

import com.solvd.talab.exceptions.InvalidCharacter;
import com.solvd.talab.exceptions.InvalidFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationsFunctions {

    //Invalid Character function
    public static boolean checkInvalidCharacter(String str) throws InvalidCharacter {
        Pattern pat = Pattern.compile("[a-zA-Z0-9]{7}");
        Matcher mat = pat.matcher(str);
        if (mat.matches()) {
            return true;
        } else {
            throw new InvalidCharacter();
        }
    }

    public static boolean checkLicensePlateFormat(String str) throws InvalidFormat {
        Pattern pat = Pattern.compile("^[A-Za-z][A-Za-z][0-9][0-9][0-9][A-Za-z][A-Za-z]");
        Matcher mat = pat.matcher(str);
        if (mat.matches()) {
            return true;
        } else {
            throw new InvalidFormat();
        }
    }
}
