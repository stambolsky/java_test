package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    private GroupHelper groupHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "../Drivers/geckodriver");
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "../Drivers/chromedriver");
            wd = new ChromeDriver();
        }
        //System.setProperty("webdriver.gecko.driver", "../Drivers/geckodriver");
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/index.php");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
