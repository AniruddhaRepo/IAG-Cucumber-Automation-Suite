package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Constants {

    public Constants() {

    }

    private String browserName = "";
    private String url = "";
    Properties properties = new Properties();

    public void setProperty() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/resources/configs/config.properties");
        properties.load(fis);
    }

    public String getBrowserName() throws IOException {
        setProperty();
        browserName = properties.getProperty("Browser");
        return browserName;
    }

    public String getUrl() throws IOException {
        setProperty();
        url = properties.getProperty("URL");
        return url;
    }
}
