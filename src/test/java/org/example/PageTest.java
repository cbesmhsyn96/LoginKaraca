package org.example;
import com.thoughtworks.gauge.Step;
import org.example.basetest.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PageTest extends BaseTest {
    @Step("<xpath> xplath li Hesabım butonunun göründüğü doğrulandı.")
    public void displayHesabim(String xpath) {
        WebElement hesabim = driver.findElement(By.xpath(xpath));
        if (hesabim.isDisplayed()) {
            System.out.println("Hesabım butonu başarıyla görüntülendi.");
        }
    }
    @Step("<xpath> xplath li Hesabım butonuna tıklandı.")
    public void clickHesabim(String xpath) {
        WebElement hesabim = driver.findElement(By.xpath(xpath));
        hesabim.click();
    }
    @Step("Login sayfasının açıldığı doğrulandı.")
    public void loginPageDisplayControl() {
        WebElement loginButton = driver.findElement(By.id("login-with-recaptcha"));
        if (loginButton.isDisplayed()){
            System.out.println("Login sayfası görüntülendi.");
        }
    }
    @Step("E-main ve Şifre girişi yapıldı.")
    public void loginEntering(){
        WebElement inputEmailLogin = driver.findElement(By.id("inputEmailLogin"));
        inputEmailLogin.sendKeys("hsynakcn96@gmail.com");
        WebElement inputPassLogin = driver.findElement(By.cssSelector("#login > div.form-row > div.form-group.is-required.col-md-12.password > input"));
        inputPassLogin.sendKeys("usu2882Gsh&");
    }
    @Step("<loginButtonId> id li Giriş Yap butonuna tıklandı.")
    public void doLogin(String loginButtonId) throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath(loginButtonId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);
        Thread.sleep(5000);
        loginButton.submit();
        System.out.println("Giriş yapıldı.");
    }
}