package webSite.pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SupplierManagement {
	WebDriverWait wait;
	private WebDriver navegador;
	
	public SupplierManagement(WebDriver navegador) {
		this.navegador = navegador;
		this.wait = new WebDriverWait(this.navegador, 5);
	}
	
	public SupplierManagement ClickAccounts() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("social-sidebar-menu")));
		this.navegador.findElement(By.xpath(("//a[@href=\'#ACCOUNTS\']"))).click();
		return this;		
	}
	
	public SupplierManagement ClickSuppliers() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\'https://www.phptravels.net/admin-portal/admin/accounts/suppliers/\']")));
		this.navegador.findElement(By.xpath(("//a[@href=\'https://www.phptravels.net/admin-portal/admin/accounts/suppliers/\']"))).click();
		return this;
	}

	public SupplierManagement ClickAdd() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'content\']/div[2]/form/button")));
		this.navegador.findElement(By.xpath("//*[@id=\'content\']/div[2]/form/button")).click();
		return this;
	}
	
	public SupplierManagement ChecarCadastro(String email) {
			this.navegador.findElement(By.linkText(email));
			return this;
	}
}
