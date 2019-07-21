package webSite.pageObjects;




import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;




public class LoginPage {
	private WebDriver navegador;
	
	public LoginPage(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	public LoginPage inserirLogin(String login){
		this.navegador.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/input[1]")).sendKeys(login);
		return this;
	}
	public LoginPage inserirSenha(String senha) {
		this.navegador.findElement(By.name("password")).sendKeys(senha);
		return this;
	}
	public LoginPage pressionarLogar() {
		this.navegador.findElement(By.xpath("//button[@class=\'btn btn-primary btn-block ladda-button fadeIn animated\']")).click();
		return this;
	}

}
