import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

    private final WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(String email, String password) {
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys(password);

        WebElement signInButton = driver.findElement(By.id("SubmitLogin"));
        signInButton.click();
    }

    public String getAccountName() {
        WebElement accountName = driver.findElement(By.className("account"));
        return accountName.getText();
    }
}

