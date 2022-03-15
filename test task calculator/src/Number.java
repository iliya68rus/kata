public abstract class Number {
    protected String name;

    public Number(String name) {
        this.name = name;
    }

    public abstract boolean isYourNumber(String input1, String input2);

    public int calculation(int number1, ArithmeticOperationsEnum operation, int number2) {
        return switch (operation) {
            case ADDITION -> number1 + number2;
            case SUBTRACTION -> number1 - number2;
            case MULTIPLICATION -> number1 * number2;
            case DIVISION -> number1 / number2;
        };
    }

    public boolean isArithmeticSign(String input) {
        try {
            if (returnArithmeticOperation(input) != null) {
                return true;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    public ArithmeticOperationsEnum returnArithmeticOperation(String input) {
        return switch (input) {
            case "+" -> ArithmeticOperationsEnum.ADDITION;
            case "-" -> ArithmeticOperationsEnum.SUBTRACTION;
            case "*" -> ArithmeticOperationsEnum.MULTIPLICATION;
            case "/" -> ArithmeticOperationsEnum.DIVISION;
            default -> null;
        };
    }

    public abstract int convertToArithmetic(RomanNumbersEnum romanNumber);

    public abstract String convertToRoman(int number);

    @Override
    public String toString() {
        return name;
    }
}
