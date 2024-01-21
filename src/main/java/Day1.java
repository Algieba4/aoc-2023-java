import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1 {

    private static final HashMap<String, Character> numbers = new HashMap<>() {{
        put("one", '1');
        put("two", '2');
        put("three", '3');
        put("four", '4');
        put("five", '5');
        put("six", '6');
        put("seven", '7');
        put("eight", '8');
        put("nine", '9');
    }};

    public Day1() throws IOException {
        var filePath = "C:\\github\\aoc-2023-java\\src\\main\\resources\\Day1.txt";
        System.out.printf("Calibration Document (Part 1): %s", Day1Part1(filePath));
        System.out.println();
        System.out.printf("Calibration Document (Part 2): %s", Day1Part2(filePath));
    }

    public Day1(String filePath) throws IOException {
        System.out.printf("Calibration Document (Part 1): %s", Day1Part1(filePath));
        System.out.println();
        System.out.printf("Calibration Document(Part 2): %s", Day1Part2(filePath));
    }

    public static int Day1Part1(String filePath) throws IOException {
        var values = Files.lines(Path.of(filePath))
                .map(Day1::FindNumbersFromNumerics)
                .toList();
        return GetCalibrationDocument(values);
    }

    public static int Day1Part2(String filePath) throws IOException {
        var values = Files.lines(Path.of(filePath))
                .map(Day1::FindNumbersFromAlphanumerics)
                .toList();
        return GetCalibrationDocument(values);
    }

    private static int FindNumbersFromNumerics(String line) {
        char[] charArray = line.toCharArray();
        char[] charArrayReverse = new StringBuilder(line).reverse().toString().toCharArray();
        String numberString = String.valueOf(GetNumberFromNumerics(charArray)) + GetNumberFromNumerics(charArrayReverse);
        return Integer.parseInt(numberString);
    }

    private static char GetNumberFromNumerics(char[] charArray) {
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                return c;
            }
        }
        return 0;
    }

    private static int FindNumbersFromAlphanumerics(String line) {
        char[] charArray = line.toCharArray();
        char[] charArrayReverse = new StringBuilder(line).reverse().toString().toCharArray();
        String numberString = String.valueOf(GetNumberFromAlphanumerics(charArray, false))
                + GetNumberFromAlphanumerics(charArrayReverse, true);
        return Integer.parseInt(numberString);
    }

    private static char GetNumberFromAlphanumerics(char[] charArray, Boolean reverse) {
        var inputStream = new StringBuilder();
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                return c;
            }
            else {
                if(reverse) {
                    inputStream.insert(0, c);
                } else {
                    inputStream.append(c);
                }
                for(HashMap.Entry<String, Character> stringNumber : numbers.entrySet()) {
                    if(inputStream.toString().contains(stringNumber.getKey())) {
                        return stringNumber.getValue();
                    }
                }
            }
        }
        return 0;
    }

    private static int GetCalibrationDocument(List<Integer> values) {
        int calibrationDocument = 0;
        for (Integer value : values) {
            calibrationDocument += value;
        }
        return calibrationDocument;
    }

    public static void main(String[] args) throws IOException {
        new Day1();
    }
}
