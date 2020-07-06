package com.tanoshii.junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParentTest {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	@Before
	public void configura(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/kzgk290/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
	}

	@After
	public void cierra(){
		driver.quit();
	}
	
	protected void veA(String url){
		driver.navigate().to(url);
	}
	
	protected void verificaInicio(){
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[src='../graphics/geisha.png']"))).isDisplayed());		
	}
	
	protected void buscaPalabra(String palabra){
		WebElement irADiccionario = driver.findElement(By.cssSelector("[href='../dictionary/']"));
		irADiccionario.click();
		WebElement campo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='j']")));
		campo.sendKeys(palabra);
		campo.submit();
	}
	
	protected boolean verificaMultiples(){
		try{
			return !wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("idStrokeOrderDiagrams"))).isDisplayed();
		}catch(Exception e){
			return true;
		}
	}
	
	protected void verificaKanji(){
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idStrokeOrderDiagrams"))).isDisplayed());
		System.out.println("Encontró escritura");
	}
	
	protected void veAPrimerResultado(){
		driver.findElement(By.cssSelector(".entry .message .entrylinks")).findElement(By.cssSelector("a")).click();
	}
}
