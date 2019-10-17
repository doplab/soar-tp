package ch.unil.doplab.unit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * DOPLab / UniL Software Architecture, 2019
 *
 * @author Melike Geçer
 */
public class ReadTextFile {

    private ArrayList nameList;
    private BufferedReader br;

    /**
     * ReadTextFile contructor initializes nameList variable.
     */
    private ReadTextFile() {
        nameList = new ArrayList();
    }

    /**
     * ReadTextFile contructor initializes nameList and BufferReader instance.
     *
     * @param fileName the name of the file to be read.
     * @throws FileNotFoundException when the file doesn't exist.
     */
    public ReadTextFile(String fileName) throws FileNotFoundException {
        this();
        br = new BufferedReader(new FileReader(new File(fileName)));
    }

    /**
     * This method closes the BufferedReader.
     *
     * @throws IOException when an error occurs while working on BufferedReader
     * instance.
     */
    public void closeReader() throws IOException {
        br.close();
    }

    /**
     * This method reads the lines of a file and adds each record to the
     * nameList.
     */
    public void readFromFile() {
        br.lines().forEach(name -> nameList.add(name));
    }

    /**
     * Get method of nameList variable
     * 
     * @return nameList
     */
    public ArrayList getNameList() {
        return nameList;
    }

}
