package com.zrh.hanfu.utils.sms;
import javax.xml.bind.PropertyException;
import java.io.IOException;
import java.util.Properties;

public class VerificationState {
    private static final Properties prop = new Properties();

    static {
        try {
            prop.load(VerificationState.class.getClassLoader().getResourceAsStream("verification.state.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getSate(String value) {
        String enumValue = prop.getProperty(value);
        return enumValue;
    }
}
