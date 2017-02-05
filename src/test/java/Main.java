import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Lucas on 2017-02-05.
 */
public class Main {

    private WebDriver wd;
    private String url;
    private String username;
    private String password;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        wd = new ChromeDriver();
        url = "http://www.onet.pl";
        username = "JonDoe@onet.pl";
        password = "JonDoe";

    }

    @Test
    public void test(){
        wd.get(url);
        wd.findElement(By.partialLinkText("Poczta")).click();

        WebElement email = wd.findElement(By.name("login"));
        email.clear();
        email.sendKeys(username);

        WebElement password1 = wd.findElement(By.id("f_password"));
        password1.clear();
        password1.sendKeys(password);

        wd.findElement(By.xpath("//input[@value = 'Zaloguj']")).click();
        Assert.assertTrue(wd.getPageSource().contains("Wprowadź poprawne dane"));
    }

    @After
    public void end(){
        wd.quit();
    }
}
