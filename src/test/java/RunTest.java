import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RunTest {
    private WebDriver driver;
    private MainClass mainClass;


    @Before
    public void setUp() {
        Driver driverLoader = new Driver();
        driverLoader.Driver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        mainClass = new MainClass(driver);
    }

    @Test
    public void testXpath() throws InterruptedException {
        driver.get("https://www.tinkoff.ru/");
        mainClass.getListMenu();
        mainClass.clickLastElement();
        Thread.sleep(3000);
        mainClass.clickSecondElement();
        mainClass.searchParentElement();

    }

    @After
    public void tearDown(){
        driver.close();
    }
}
