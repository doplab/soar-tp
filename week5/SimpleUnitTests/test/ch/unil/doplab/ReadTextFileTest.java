package ch.unil.doplab;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * DOPLab / UniL Software Architecture, 2019
 *
 * @author Melike Geçer
 */
public class ReadTextFileTest {

    private ReadTextFile rtf;
    private ArrayList nameList;

    /**
     * ReadTextFileTest constructor initializes ReadTextFile instance.
     *
     * @throws FileNotFoundException when the file doesn't exist.
     */
    public ReadTextFileTest() throws FileNotFoundException {
        rtf = new ReadTextFile("sample.txt");
    }

    /**
     * BeforeClass annotation can be used to initialize some variables and
     * instances. Here, we also use it to read the file.
     */
    @BeforeClass
    public void beforeClassAnnotation() {
        rtf.readFromFile();
        nameList = rtf.getNameList();
    }

    /**
     * AfterClass annotation can be used for clean up actions. In addition, you
     * can use it to close connections and file readers.
     *
     * @throws IOException when an error occurs while working on BufferedReader
     * instance.
     */
    @AfterClass
    public void afterClassAnnotation() throws IOException {
        nameList.clear();
        rtf.closeReader();
    }

    /**
     * To check an expected value, you can use assertEquals, assertTrue and so
     * on. (press CTRL+SPACE and see all of the assert methods)
     */
    @Test
    public void expectingCorrectValue() {
        assertTrue(nameList.get(0).equals("john"));
    }

    /**
     * To check an expected value, you can use assertNotEquals, assertFalse and
     * so on. (press CTRL+SPACE and see all of the assert methods)
     */
    @Test
    public void expectingWrongValue() {
        assertNotEquals(nameList.size(), 6);
    }

    /**
     * Test of IndexOutOfBoundsException
     */
    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void exceptionTest() {
        nameList.get(5);
    }

    /**
     * Test of Timeout (milliseconds)
     *
     * @throws InterruptedException will be thrown when a thread is waiting,
     * sleeping, or occupied, and the thread is interrupted.
     */
    @Test(timeOut = 1000)
    public void timeOutTest() throws InterruptedException {
        Thread.sleep(500);
    }
}
