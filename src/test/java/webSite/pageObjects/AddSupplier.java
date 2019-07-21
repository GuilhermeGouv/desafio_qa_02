package webSite.pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import webSite.stepDefinitions.Hook;

public class AddSupplier extends Hook{
	public String email; 
	private Select selectValores;
	private WebDriver navegador;
	
	public String getEmail() {
		return email;
	}
	
	
	public AddSupplier(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	public AddSupplier inserirPrimeiroNome(String primeiroNome) {
		navegador.findElement(By.name("fname")).sendKeys(primeiroNome);
		return this;
	}
	
	public AddSupplier inserirUltimoNome(String ultimoNome) {
		navegador.findElement(By.name("lname")).sendKeys(ultimoNome);
		return this;
	}
	
	public AddSupplier inserirEmail(String email) {
		navegador.findElement(By.name("email")).sendKeys(email);
		this.email = email;
		return this;
	}
	
	public AddSupplier inserirSenha(String senha) {
		navegador.findElement(By.name("password")).sendKeys(senha);
		return this;	
	}
	
	public AddSupplier inserirMobile(String mobile) {
		navegador.findElement(By.name("mobile")).sendKeys(mobile);
		return this;	
	}
	
	public AddSupplier inserirCountry(String country) {
		navegador.findElement(By.name("country")).sendKeys(country);
		navegador.findElement(By.name("country")).sendKeys(Keys.ENTER);
		return this;	
	}
	
	public AddSupplier inserirAddress1(String address1) {
		navegador.findElement(By.name("address1")).sendKeys(address1);
		return this;	
	}
	
	public AddSupplier inserirAddress2(String address2) {
		navegador.findElement(By.name("address2")).sendKeys(address2);
		return this;	
	}
	
	public AddSupplier inserirSupFor(String supFor) {
		selectValores = new Select(navegador.findElement(By.name("applyfor")));
		selectValores.selectByValue(supFor);
		return this;	
	}
	
	public AddSupplier inserirItemName(String itemname) {
		navegador.findElement(By.name("itemname")).sendKeys(itemname);
		return this;	
	}
	
	public AddSupplier inserirAssigTours(String assigTours) {
		selectValores = new Select(navegador.findElement(By.name("tours[]")));
		selectValores.selectByValue(assigTours);
		return this;	
	}
	
	public AddSupplier checkEDIT(String check) {
		navegador.findElement(By.xpath("//*[@id=\'content\']/form/div/div[2]/div/div[22]/div[2]/div/div[2]/ul/li["+check+"]/label/div/ins")).click();
		return this;	
	}
	
	public AddSupplier checkREMOVE(String check) {
		navegador.findElement(By.xpath("//*[@id=\'content\']/form/div/div[2]/div/div[22]/div[3]/div/div[2]/ul/li["+check+"]/label/div/ins")).click();
		return this;	
	}
	
	public AddSupplier checkAdd(String check) {
		navegador.findElement(By.xpath("//*[@id=\'content\']/form/div/div[2]/div/div[22]/div[1]/div/div[2]/ul/li["+check+"]/label/div/ins")).click();
		return this;	
	}
	
	public AddSupplier botaoSubit() {
		navegador.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		try {
			navegador.findElement(By.xpath("//*[@id=\'content\']/div[2]/form/button"));
			return this;
		}catch (Exception e) {
	         List<WebElement> errormsg = navegador.findElements (By.xpath("//div[@class='alert alert-danger']//p"));
	         errormsg.forEach(msg->System.out.println(msg.getText()));
	         throw new RuntimeException ("Não foi possivel cadastrar o supplier");
		}		
	}
	
}
