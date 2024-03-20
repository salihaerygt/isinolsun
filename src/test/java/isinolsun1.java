import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class isinolsun1 {
    public AndroidDriver driver;
    public WebDriverWait Wait;
    //Elements By
    By jobsBy = By.id("com.isinolsun.app:id/rootRelativeView");
    By allowWhenUsingBy = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    By searchingJobBy = By.id("com.isinolsun.app:id/bluecollar_type_button");
    By animationBy = By.id("com.isinolsun.app:id/animation_view");
    By toolBarTitleBy = By.id("com.isinolsun.app:id/toolbarTitle");
    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 7 Pro");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.isinolsun.app");
        caps.setCapability("appActivity", "com.isinolsun.app.activities.SplashActivity");
        caps.setCapability("noReset", "false");
        Capabilities capabilities;
        AndroidDriver driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"), caps);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebDriverWait asd = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    @Test
    public void basicTest() throws InterruptedException {
        //Click and pass Splash
       //WebDriverWait wait= (ExpectedConditions.visibilityOfElementLocated(animationBy)).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(animationBy));
        element.click();

        //Click I am searching a job
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchingJobBy)).click();
        //Notification Allow
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(allowWhenUsingBy)).isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(allowWhenUsingBy)).click();
        }
        //Click Second Job
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jobsBy)).get(1).click();
        //Do a simple assertion
        String toolBarTitleStr = wait.until(ExpectedConditions.visibilityOfElementLocated(toolBarTitleBy)).getText();
        Assert.assertTrue(toolBarTitleStr.toLowerCase().contains("detay"));
    }
}