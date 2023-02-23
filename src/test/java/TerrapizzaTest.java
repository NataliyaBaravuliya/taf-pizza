import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


    public class TerrapizzaTest {
        WebDriver driver;

        @Before
        public void warmUp() {
            driver = new ChromeDriver();
            driver.get(TerrapizzaPage.URL);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @Test
        public void testPizzaToGo() {
            driver.findElement(By.xpath(TerrapizzaPage.BTN_MENU)).click();
            driver.findElement(By.xpath(TerrapizzaPage.BTN_PIZZA)).click();
            driver.findElement(By.xpath(TerrapizzaPage.BTN_CHOOSE_PIZZA)).click();
            driver.findElement(By.xpath(TerrapizzaPage.BTN_CART)).click();
            driver.findElement(By.xpath(TerrapizzaPage.BTN_CLOSE)).click();
            driver.findElement(By.xpath(TerrapizzaPage.BTN_CHECK_CART)).click();


            WebElement textProductName = driver.findElement(By.xpath(TerrapizzaPage.PRODUCT_NAME));
            Assert.assertEquals("Пицца Маргарита Классическая 32 см", textProductName.getText());
        }

        @After
        public void tearDown() {
            driver.quit();
        }
    }

