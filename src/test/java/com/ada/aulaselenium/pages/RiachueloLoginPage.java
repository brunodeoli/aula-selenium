package com.ada.aulaselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RiachueloLoginPage extends BasicPage {
    public RiachueloLoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.riachuelo.com.br/cliente");
    }

    public WebElement getCpf() {
        return getPage().findElement(By.id("username"));
    }

    public WebElement getPassword() {
        return getPage().findElement(By.id("password"));
    }

    public void login(String cpf, String password) {
        getCpf().sendKeys(cpf);
        getPassword().sendKeys(password, Keys.ENTER);
    }
}
