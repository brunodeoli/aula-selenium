package com.ada.aulaselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RiachueloBuscaPage extends BasicPage {


    public RiachueloBuscaPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.riachuelo.com.br/");
    }

    public WebElement getBusca(){
        return getPage().findElement(By.id("search-input"));
    }

    public WebElement getBuscaAvancada(String xpath){
        return getPage().findElement(By.xpath(xpath));
    }

    public void buscar(String buscar){
        getBusca().sendKeys(buscar, Keys.ENTER);
    }

}
