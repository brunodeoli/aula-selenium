package com.ada.aulaselenium.pages;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RiachueloPageTest {

    ChromeDriver chrome;

    @BeforeAll
    public static void init(){
        System.setProperty("webdriver.chrome.driver", "src\\drive\\chromedriver.exe");
    }

    @BeforeEach
    public void beforeEach(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        chrome = new ChromeDriver(options);
    }

    @Test
    public void testLogin(){
        RiachueloLoginPage page = new RiachueloLoginPage(chrome);

        String cpf = "88857276031";
        String senha = "password123";

        page.login(cpf, senha);
    }

    @Test
    public void testBusca(){
        RiachueloBuscaPage page = new RiachueloBuscaPage(chrome);

        String busca = "moletom";

        page.buscar(busca);
    }

    @Test
    public void testBuscaAvancada(){
        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofMillis(10000));

        RiachueloBuscaPage page = new RiachueloBuscaPage(chrome);

        String busca = "camisa feminina";

        String xpathTamanho = "/html/body/div[4]/div/div[2]/main/div/section/div[1]/div[1]/button[1]/span[1]/p";
        String xpathbuscaPorTamanhoP = "/html/body/div[4]/div/div[2]/main/div/section/div[1]/div[1]/button[1]/span[1]/div/div/ul/li[1]";

        page.buscar(busca);

        //chrome.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathTamanho)));
        page.getBuscaAvancada(xpathTamanho).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathbuscaPorTamanhoP)));
        page.getBuscaAvancada(xpathbuscaPorTamanhoP).click();
    }
}
