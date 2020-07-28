import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;

public class TestSolution {

    Solution s = new Solution();
    @Test
    public void testExtractNums(){
        List<String> expected = new LinkedList<>();
        expected.add("2");
        expected.add("3");
        expected.add("4");
        expected.add("5");
        assertEquals(expected, s.extractNums("2345"));
    }

    @Test
    public void testToLetter(){
        List<String> expected = new LinkedList<>();
        expected.add("abc");
        expected.add("ghi");
        expected.add("def");
        assertEquals(expected,s.changeToLetters( s.extractNums("243")));
    }

    @Test
    public void testCombineTwoString(){
        List<String> expected = new LinkedList<>();
//        "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
        String []  x = {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        for(String i:x){
            expected.add(i);
        }
        assertEquals(expected,s.combineTwoString("abc","def"));
    }

    @Test
    public void testcombineStringList(){
        List<String> helperList = new LinkedList<>();
        List<String> expected = new LinkedList<>();
//        "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
        String []  x = {"ab","cd","ef"};
        String [] expectedString={"jab","jcd","jef","kab","kcd","kef"};
        for(String i:x){
            helperList.add(i);
        }
        for(String i:expectedString){
            expected.add(i);
        }
        assertEquals(expected,s.combineStringList("jk",helperList));
    }

    @Test
    public void testletterCombinationsHelper(){
        List<String> helperList = new LinkedList<>();
        List<String> expected = new LinkedList<>();
//        "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
        String []  x = {"ghi","abc","def"};
        String [] expectedString={"gad", "gae", "gaf", "gbd", "gbe", "gbf", "gcd", "gce", "gcf"
                ,"had", "hae", "haf", "hbd", "hbe", "hbf", "hcd", "hce", "hcf"
                ,"iad", "iae", "iaf", "ibd", "ibe", "ibf", "icd", "ice", "icf"};
        for(String i:x){
            helperList.add(i);
        }
        for(String i:expectedString){
            expected.add(i);
        }
        assertEquals(expected,s.letterCombinationsHelper(helperList));
    }

    @Test
    public void testletterCombinations(){
        List<String> helperList = new LinkedList<>();
        List<String> expected = new LinkedList<>();
//        "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
        String []  x = {"jk","abc","def"};
        String [] expectedString={"gad", "gae", "gaf", "gbd", "gbe", "gbf", "gcd", "gce", "gcf"
                ,"had", "hae", "haf", "hbd", "hbe", "hbf", "hcd", "hce", "hcf"
                ,"iad", "iae", "iaf", "ibd", "ibe", "ibf", "icd", "ice", "icf"};
        for(String i:x){
            helperList.add(i);
        }
        for(String i:expectedString){
            expected.add(i);
        }
        assertEquals(expected,s.letterCombinations("423"));
    }






}
