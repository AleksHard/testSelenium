import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCard {
    ChromeDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void TestCard() {
        wd.get("https://app.geteasyqa.com/users/sign_in");
        wd.findElement(By.id("user_email")).click();
        wd.findElement(By.id("user_email")).sendKeys("acc4easyqatest@gmail.com");
        wd.findElement(By.id("user_password")).click();
        wd.findElement(By.id("user_password")).sendKeys("acc4easyqatestQwe");
        wd.findElement(By.name("commit")).click();
        wd.findElement(By.linkText("Мои Проекты")).click();
        wd.findElement(By.className("project-name")).click();
        wd.findElement(By.linkText("Баг Трекер")).click();
        wd.findElement(By.linkText("Создать карточку")).click();
        wd.findElement(By.id("issue_summary")).click();
        wd.findElement(By.id("issue_summary")).sendKeys("Красивая карточка");
        /*wd.findElement(By.linkText("Ошибка")).click();
        wd.findElement(By.linkText("Ошибка")).click();
        wd.findElement(By.linkText("Средний")).click();
        wd.findElement(By.linkText("Критический")).click();
        wd.findElement(By.linkText("Созданные")).click();
        */
        wd.findElement(By.xpath("//label[@for='issue_description']")).click();
        wd.findElement(By.id("issue_description")).click();
        wd.findElement(By.id("issue_description")).click();
        wd.findElement(By.id("issue_description")).sendKeys("Чё-нибудь");
        wd.findElement(By.name("commit")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
