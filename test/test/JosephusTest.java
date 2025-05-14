import josephus.Josephus;
import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static josephus.Josephus.Josephus;

public class JosephusTest {
    @org.junit.jupiter.api.Test
    public void test0() {
        assertArrayEquals(new int[]{1, 2}, Josephus.Josephus(3));
        assertArrayEquals(new int[]{1, 4}, Josephus.Josephus(4));
        assertArrayEquals(new int[]{2, 4}, Josephus.Josephus(5));
        assertArrayEquals(new int[]{1, 4}, Josephus.Josephus(7));
        assertArrayEquals(new int[]{1, 7}, Josephus.Josephus(9));
        assertArrayEquals(new int[]{4, 10}, Josephus.Josephus(10));
    }
}