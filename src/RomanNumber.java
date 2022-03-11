public class RomanNumber extends Number {

    public RomanNumber(String name) {
        super(name);
    }

    public int convertToArithmetic(RomanNumbersEnum romanNumber) {
        return switch (romanNumber) {
            case I -> 1;
            case II -> 2;
            case III -> 3;
            case IV -> 4;
            case V -> 5;
            case VI -> 6;
            case VII -> 7;
            case VIII -> 8;
            case IX -> 9;
            case X -> 10;
            default -> -1;
        };
    }

    @Override
    public String convertToRoman(int number) {
        StringBuilder s = new StringBuilder();
        while (number == 100) {
            s.append("C");
            number -= 100;
        }
        while (number >= 90) {
            s.append("XC");
            number -= 90;
        }
        while (number >= 50) {
            s.append("L");
            number -= 50;
        }
        while (number >= 40) {
            s.append("XL");
            number -= 40;
        }
        while (number >= 10) {
            s.append("X");
            number -= 10;
        }
        while (number >= 9) {
            s.append("IX");
            number -= 9;
        }
        while (number >= 5) {
            s.append("V");
            number -= 5;
        }
        while (number >= 4) {
            s.append("IV");
            number -= 4;
        }
        while (number >= 1) {
            s.append("I");
            number -= 1;
        }
        return s.toString();
    }

    @Override
    public boolean isYourNumber(String input1, String input2) {
        try {
            int result1 = convertToArithmetic(RomanNumbersEnum.valueOf(input1));
            int result2 = convertToArithmetic(RomanNumbersEnum.valueOf(input2));
            if (!(result1 == -1 & result2 == -1)) {
                return true;
            }
        } catch (Exception ignored) {
        }
        return false;
    }
}
