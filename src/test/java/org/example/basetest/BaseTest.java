package org.example.basetest;

import org.example.PageTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;
    @Before
    public static void BeforeTest(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();

        //Google Chrome'u büyük ekrana alıyorum.
        driver.manage().window().maximize();

        //google sayfasına gidiyoruz.
        driver.get("https://www.karaca.com");
    }

    @After
    public static void AfterTest(){
            if (driver != null) {
                driver.close();
                driver.quit();
            }
    }
    public static void main(String[] args) throws InterruptedException {
        BeforeTest();
        PageTest pageTest = new PageTest();
        pageTest.displayHesabim("//*[@id='account_header']/div[3]/span");
        pageTest.clickHesabim("//*[@id='account_header']/div[3]/span");
        pageTest.loginPageDisplayControl();
        pageTest.loginEntering();
        pageTest.doLogin("//*[@id=\"login-with-recaptcha\"]");
        AfterTest();
    }
}

