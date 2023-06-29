package largestvaluefinderservice.service;

import largestvaluefinderservice.service.impl.LargestValueServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LargestValueServiceTest {
    private final static int[] TEST_ARRAY = {1, 3, 5, 0, -1, 6, 9, 2};

    private final LargestValueService largestValueService = new LargestValueServiceImpl();

    @Test
    void testGetLargestValue() {
        var result = largestValueService.getLargestValue(TEST_ARRAY, 2);
        assertEquals(6, result);

        result = largestValueService.getLargestValue(TEST_ARRAY, 1);
        assertEquals(9, result);

        result = largestValueService.getLargestValue(TEST_ARRAY, TEST_ARRAY.length);
        assertEquals(-1, result);
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> largestValueService.getLargestValue(TEST_ARRAY,
                TEST_ARRAY.length + 1));
    }
}
