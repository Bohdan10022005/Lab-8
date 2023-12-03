import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("http://automationpractice.com/index.php");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void searchForProduct(String query) {
        WebElement searchBox = driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys(query);
        WebElement searchButton = driver.findElement(By.name("submit_search"));
        searchButton.click();
    }

    public void clickSignInLink() {
        WebElement signInLink = driver.findElement(By.className("login"));
        signInLink.click();
    }
}

