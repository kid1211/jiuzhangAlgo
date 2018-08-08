import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoPointerTest {

    @Test
    void lengthOfLongestSubstring() {
        TwoPointer solution = new TwoPointer();

        String s1 = "asdfgh";
        String s2 = "aaaaaa";

        assertEquals(6, solution.lengthOfLongestSubstring(s1));
        assertEquals(1, solution.lengthOfLongestSubstring(s2));
        assertEquals(0, solution.lengthOfLongestSubstring(""));
        assertEquals(5, solution.lengthOfLongestSubstring("aabssrrdtregt"));
    }

}