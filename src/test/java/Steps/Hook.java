package Steps;


import BaseUtil.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Hook extends Base {
    private Base base;

    public Hook(Base base) {
        this.base = base;
    }

    @Before
    public void instantiateLogin() {
        System.out.println("HOOK-> We are initializing Browser: Firefox");
        System.setProperty("webdriver.chrome.driver", "C:\\selenium-java-3.7.1\\chromedriver.exe");
//        ChromeDriverManager.getInstance().setup();
        System.setProperty("webdriver.firefox.marionette", "C:\\selenium-java-3.7.1\\geckodriver.exe");
        base.driver = new FirefoxDriver();
        //base.driver = new InternetExplorerDriver();
        base.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @After
    public void teardownLogin() {
        base.driver.quit();
        System.out.println("HOOK-> We are closing Browser: Firefox");
    }
}
