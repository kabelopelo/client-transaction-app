package com.client.transaction.webapi.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtilsExt extends StringUtils {

    public static boolean hasMinNameLength(String str, int minLength) {
        return hasLength(str) && str.length() >= minLength;
    }


    /**
     * @param idNumber
     * @return true if ID is valid. False otherwise.
     * @author https://codereview.stackexchange.com/
     */
    public static Boolean isValidIdentification(String idNumber) {
        if (idNumber == null) return false;

        char[] idchars = idNumber.toCharArray();
        int sum = 0;
        // loop over each digit right-to-left, including the check-digit
        for (int i = 1; i <= idchars.length; i++) {
            int digit = Character.getNumericValue(idchars[idchars.length - i]);
            if ((i % 2) != 0) {
                sum += digit;
            } else {
                sum += digit < 5 ? digit * 2 : digit * 2 - 9;
            }
        }
        return (sum % 10) == 0;
    }

    public static Boolean isValidCellphoneNumber(String cellphone) {
        // 1) Begins with 0
        // 2) Then contains 6 or 7 or 8.
        // 3) Then contains 8 digits
        Pattern p = Pattern.compile("(0)?[6-8][0-9]{8}");
        Matcher m = p.matcher(cellphone);
        return (m.find() && m.group().equals(cellphone));
    }
}
