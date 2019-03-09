import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainClass {


    private WebDriver driver;

    private By menu = By.xpath("//div[@class=\"header__9V1so header__3rtwn\"]//a[@class=\"header__3E29o header__DX3-q\"]");
    //поиск родительского элемента:
    private String parent = "//div[./div[@class=\"header__9V1so header__3rtwn\"]//a[@class=\"header__3E29o " +
            "header__DX3-q\"]]";


    List<WebElement> allMenu;
    int size;

    public MainClass(WebDriver driver){
        this.driver = driver;
    }

    public void wait(By name){
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(name));
    }

    public void getListMenu(){
        wait(menu);
        allMenu = driver.findElements(menu);
        size = allMenu.size();
    }

    public void clickLastElement(){
        wait(menu);
        driver.findElements(menu).get(size - 1).click();
    }

    public void clickSecondElement() {
        driver.navigate().back();
        wait(menu);
        driver.findElements(menu).get(1).click();
    }

    public void searchParentElement(){
        wait(menu);
        driver.findElement(By.xpath(parent));
        try {
            Thread.sleep(3000);
            allMenu = driver.findElements(By.xpath(parent + "//a"));
            Thread.sleep(3000);
        } catch (Exception e){
            System.out.println("Fail " + e.getMessage());
        }
        for(WebElement menu : allMenu){
            System.out.println(menu.getText() + " " + menu);
        }
    }
}
