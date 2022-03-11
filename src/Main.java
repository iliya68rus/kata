import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ArabicNumber arabicNumber = new ArabicNumber("arabicNumber");
        RomanNumber romanNumber = new RomanNumber("romanNumber");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            String[] split = input.split(" ");
            if (!(split.length == 3))
                throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и " +
                        "один оператор (+, -, /, *)");
            if (!(arabicNumber.isArithmeticSign(split[1])))
                throw new Exception("т.к. строка не является математической операцией");
            boolean result1 = romanNumber.isYourNumber(split[0], split[2]);
            boolean result2 = arabicNumber.isYourNumber(split[0], split[2]);
            if (!result1 & !result2) {
                throw new Exception("т.к. используются одновременно разные системы счисления");
            } else if (result1) {
                int answer = result(split, romanNumber);
                String roman = romanNumber.convertToRoman(answer);
                System.out.println(roman);
            } else if (result2) {
                int answer = result(split, arabicNumber);
                System.out.println(answer);
            }
        }
    }

    public static int result(String[] input, Number numberType) throws Exception {
        int answer;
        ArithmeticOperationsEnum operation = numberType.returnArithmeticOperation(input[1]);
        if (numberType.toString().equals("arabicNumber")) {
            answer = numberType.calculation(Integer.parseInt(input[0]), operation, Integer.parseInt(input[2]));
            if (answer > 0) throw new Exception("т.к. в арабской системе предусмотренны только отрицательные числа");
        } else {
            int number1 = numberType.convertToArithmetic(RomanNumbersEnum.valueOf(input[0]));
            int number2 = numberType.convertToArithmetic(RomanNumbersEnum.valueOf(input[2]));
            answer = numberType.calculation(number1, operation, number2);
            if (answer <= 0) throw new Exception("т.к. в римской системе нет отрицательных чисел");
        }
        return answer;
    }
}
