package ch.unil.doplab.caesar.ejb;

import javax.ejb.Singleton;

/**
 * DOPLab / UniL 
 * 
 * Software Architecture, 2019
 *
 * @author Melike Geçer
 */
@Singleton
public class CaesarSingletonBean {

    private String message = "hello";

    private String[] encodedMessages = {
        "hello", "ifmmp", "jgnnq", "khoor", "lipps", "mjqqt", "nkrru", "olssv",
        "pmttw", "qnuux", "rovvy", "spwwz", "tqxxa", "uryyb", "vszzc", "wtaad",
        "xubbe", "yvccf", "zwddg", "axeeh", "byffi", "czggj", "dahhk", "ebiil",
        "fcjjm", "gdkkn"};
    
    private String[] decodedMessages = {
        "hello", "gdkkn", "fcjjm", "ebiil", "dahhk", "czggj", "byffi", "axeeh", 
        "zwddg", "yvccf", "xubbe", "wtaad", "vszzc", "uryyb", "tqxxa", "spwwz", 
        "rovvy", "qnuux", "pmttw", "olssv", "nkrru", "mjqqt", "lipps", "khoor", 
        "jgnnq", "ifmmp"};

    private int key;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key % 26;
    }

    public String getMessage() {
        return message;
    }

    public String getEncodedMessage() {
        return encodedMessages[this.key];
    }
    
    public String getDecodedMessage() {
        return decodedMessages[this.key];
    }

    
}
