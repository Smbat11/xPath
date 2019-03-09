import java.util.Properties;

public class Driver {
    public void Driver() {
        Properties property = new Properties();

        try {
            property.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            System.out.println("Ошибка " + e);
        }

        System.setProperty("webdriver.chrome.driver", property.getProperty("chrome_executable_path"));

    }
}
