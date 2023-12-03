import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

    private final WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getResultMessage() {
        WebElement resultMessage = driver.findElement(By.cssSelector(".heading-counter"));
        return resultMessage.getText();
    }
}


