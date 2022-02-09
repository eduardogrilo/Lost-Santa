//package blip.challenges;

public class RomanToArabicConverter {

    int sum = 0;

    // Read just the first element of the String, because in the switch statement
    // there is the substring method
    // which in case the string read in this recursive function achieves the end, it
    // will activate an exception
    // (charAt cannot read anything that is not a char, which in case the string
    // finishes it cannot read anything:
    // is going to trigger that exception)

    public int convertRomanToArabic(final String romanNumber) {
        if (romanNumber.length() == 1) {
            switch (romanNumber) {
                case "M":
                    return sum += 1000;
                case "D":
                    return sum += 500;
                case "C":
                    return sum += 100;
                case "L":
                    return sum += 50;
                case "X":
                    return sum += 10;
                case "I":
                    return sum += 1;
            }
        } else {
            if (romanNumber.isEmpty() == true) {
                return sum += 0;
            }
            switch (romanNumber.charAt(0)) {// Read as char just the first charater of the romanNumber String
                // Start with C because
                case 'C':
                    if (romanNumber.charAt(1) == 'M') {// CM
                        sum += 900;
                        sum = convertRomanToArabic(String.valueOf(romanNumber.substring(2)));
                    } else if (romanNumber.charAt(1) == 'D') {// CD
                        sum += 400;
                        sum = convertRomanToArabic(String.valueOf(romanNumber.substring(2)));
                    } else {
                        sum += 100;
                        sum = convertRomanToArabic(String.valueOf(romanNumber.substring(1)));
                    }
                    break;
                case 'M':
                    sum += 1000;
                    sum = convertRomanToArabic(String.valueOf(romanNumber.substring(1)));
                    break;
                case 'D':
                    if (romanNumber.charAt(1) == 'C') {
                        sum += 600;
                        sum = convertRomanToArabic(String.valueOf(romanNumber.substring(2)));
                    } else {
                        sum += 500;
                        sum = convertRomanToArabic(String.valueOf(romanNumber.substring(1)));
                    }
                    break;
                case 'L':
                    if (romanNumber.charAt(1) == 'X') {
                        sum += 60;
                        sum = convertRomanToArabic(String.valueOf(romanNumber.substring(2)));
                    } else {
                        sum += 50;
                        sum = convertRomanToArabic(String.valueOf(romanNumber.substring(1)));
                    }
                    break;
                case 'X':
                    if (romanNumber.charAt(1) == 'C') {
                        sum += 90;
                        sum = convertRomanToArabic(String.valueOf(romanNumber.substring(2)));
                    } else if (romanNumber.charAt(1) == 'L') {
                        sum += 40;
                        sum = convertRomanToArabic(String.valueOf(romanNumber.substring(2)));
                    } else {
                        sum += 10;
                        sum = convertRomanToArabic(String.valueOf(romanNumber.substring(1)));
                    }
                    break;
                case 'I':
                    if (romanNumber.charAt(1) == 'X') {
                        sum += 9;
                        sum = convertRomanToArabic(String.valueOf(romanNumber.substring(2)));
                    } else if (romanNumber.charAt(1) == 'V') {
                        sum += 4;
                        sum = convertRomanToArabic(String.valueOf(romanNumber.substring(2)));
                    } else {
                        sum += 1;
                        sum = convertRomanToArabic(String.valueOf(romanNumber.substring(1)));
                    }
                    break;
                case 'V':
                    sum += 5;
                    sum = convertRomanToArabic(romanNumber.substring(1));
                    break;
            }
        }
        return sum;
    }

    // Driver Code
    public static void main(String[] args) {
        RomanToArabicConverter rta = new RomanToArabicConverter();
        System.out.print("Conversion result to roman: " + rta.convertRomanToArabic("DXXI")); // 521
        rta.sum = 0;
        System.out.printf("%n");
        System.out.print("Conversion result to roman: " + rta.convertRomanToArabic("MMMCMLXXXIX")); // 3989
        System.out.printf("%n");
    }
}
