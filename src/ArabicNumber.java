public class ArabicNumber extends Number {

    public ArabicNumber(String name) {
        super(name);
    }

    @Override
    public boolean isYourNumber(String input1, String input2) {
        boolean result1 = false;
        boolean result2 = false;
        try {
            for (int i = 1; i < 11; i++) {
                if (Integer.parseInt(input1) == i) {
                    result1 = true;
                }
                if (Integer.parseInt(input2) == i) {
                    result2 = true;
                }
                if (result1 & result2) return true;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    @Override
    public int convertToArithmetic(RomanNumbersEnum romanNumber) {
        return 0;
    }

    @Override
    public String convertToRoman(int number) {
        return null;
    }
}
