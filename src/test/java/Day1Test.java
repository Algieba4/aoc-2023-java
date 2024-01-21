
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Day1Test {

    @Test
    public void MatchCalibrationValuePart1() throws IOException {
        var filePath = "C:\\github\\aoc-2023-java\\src\\test\\resources\\Day1Test1.txt";
        assertEquals(142, Day1.Day1Part1(filePath));
    }

    @Test
    public void MatchCalibrationValuePart2() throws IOException {
        var filePath = "C:\\github\\aoc-2023-java\\src\\test\\resources\\Day1Test2.txt";
        assertEquals(281, Day1.Day1Part2(filePath));
    }

}
