import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TestSolution {
    @Test
    public void addRow(){
        Solution s = new Solution();
        s.addValue("PAYPALISHIRING",3);
        Map<Integer, ArrayList<String>> expected = new HashMap<>();
    }

    @Test
    public void printResult(){
        Solution s = new Solution();
        s.addValue("PAYPALISHIRING",4);
        assertEquals("PINALSIGYAHRPI",s.print(4));

        Solution X = new Solution();
        X.addValue("ABCDE",4);
        assertEquals("ABCED",X.print(4));
    }
}
