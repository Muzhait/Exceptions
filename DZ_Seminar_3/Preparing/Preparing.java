package DZ_Seminar_3.Preparing;

import DZ_Seminar_3.Exceptions.*;
import DZ_Seminar_3.InputWorks.InputString;

import java.util.ArrayList;


public class Preparing {
      public static boolean PreparingArray(String[] inStr, String[] outStr) {
        boolean next = false;
        try {
            findFIO(inStr, outStr);
            findBDay(inStr, outStr);
            findPhone(inStr, outStr);
            findSex(inStr, outStr);
            next = true;
        } catch (CountFIOException | CountPhoneException | CountSexException e) {
            System.out.println(e.getMessage());
        }

        return next;
    }

    public static boolean IsBDateFormat(String pDate) {
        boolean bdFormat = false;
        boolean digits = false;
        boolean points = false;

        for (int i = 0; i < pDate.length(); i++) {
            if (i == 0 || i == 1 || i == 3 || i == 4
                    || i == 6 || i == 7 || i == 8 || i == 9) {
                if (pDate.charAt(i) >= '0' && pDate.charAt(i) <= '9') {
                    digits = true;
                }
            }
            if (i == 2 || i == 5) {
                if (pDate.charAt(i) == '.') {
                    points = true;
                }
            }
        }
        bdFormat = digits && points;
        return bdFormat;
    }

    public static String[] findFIO(String[] str, String[] outStr) {
        int currIndex = 0;
        int validCount = 3;
        int inpCount = 0;
        ArrayList<String> list;
        String[] arr = new String[3];
        list = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            if ((!str[i].matches("[.0-9]+")) && (str[i].length() != 1)) {
                list.add(str[i]);
            }
        }
        inpCount = list.size();
        if (inpCount != InputString.FIOCount){
            System.out.println();
            throw new CountFIOException(validCount, list.size());
        } else {
            for (int i = 0; i < arr.length; i++) {
                outStr[i] = list.get(i);
            }
        }
        return arr;
    }

    public static void findBDay(String[] inStr, String[] outStr) {
        int limitCount = 1;
        int count = 0;
        for (int i = 0; i < inStr.length; i++) {
            if ((inStr[i].matches("[.0-9]+"))) {

                if (IsBDateFormat(inStr[i])) {
                    outStr[4] = inStr[i];
                    count++;
                    if (count > limitCount) {
                        throw new CountBDException(InputString.bdCount, count);
                    }
                }
            }
        }
    }

    public static void findPhone(String[] inStr, String[] outStr) {
        int foundCount = 0;
        int limitCount = 1;
        for (int i = 0; i < inStr.length; i++) {
            if ((inStr[i].matches("[0-9]+"))) {
                outStr[5] = inStr[i];
                foundCount++;
                if (foundCount > limitCount) {
                    throw new CountPhoneException(InputString.phoneCount, foundCount);
                }
            }
        }
    }


    public static void findSex(String[] inStr, String[] outStr) {
        int foundCount = 0;
        int limitCount = 1;
        for (int i = 0; i < inStr.length; i++) {
            if ((inStr[i].length() == 1) && (inStr[i].equals("m") | inStr[i].equals("f"))) {
                outStr[3] = inStr[i];
                foundCount++;
                if (foundCount > limitCount) {
                    throw new CountSexException(InputString.sexCount, foundCount);
                }
            }
        }
    }

  
    public static boolean inputCheck(int needed, int entered) {
        boolean more = false;
        if (entered < needed) {
            more = false;
            throw new CountExceptionLess(entered, needed);
        }
        if (entered > needed) {
            more = false;
            throw new CountExceptionMore(entered, needed);
        }
        if (entered == needed) {
            more = true;
        }

        return more;
    }
}
