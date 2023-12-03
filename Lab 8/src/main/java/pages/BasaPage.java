import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AutomationPracticeTests {

    private WebDriver driver;
    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private SignInPage signInPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        signInPage = new SignInPage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testHomePageTitle() {
        homePage.navigateTo();
        assertEquals(homePage.getTitle(), "My Store");
    }

    @Test
    public void testSearchProduct() {
        homePage.navigateTo();
        homePage.searchForProduct("dress");
        assertTrue(searchResultPage.getResultMessage().contains("results have been found"));
    }

    @Test
    public void testSignIn() {
        homePage.navigateTo();
        homePage.clickSignInLink();
        signInPage.signIn("test@example.com", "password");
        assertEquals(signInPage.getAccountName(), "John Doe");
    }
}

