package webSite.stepDefinitions;


import cucumber.api.DataTable;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import webSite.pageObjects.AddSupplier;
import webSite.pageObjects.LoginPage;
import webSite.pageObjects.SupplierManagement;

import java.util.List;
import java.util.Map;


public class stepDefinition {

    private LoginPage loginpage = new LoginPage(Hook.getNavegador());
	private AddSupplier addsupplier = new AddSupplier(Hook.getNavegador());;
	private SupplierManagement suppliermanagement = new SupplierManagement(Hook.getNavegador());
	

	@Dado("^Que acessei plataforma com as seguintes credenciais \"([^\"]*)\" e senha \"([^\"]*)\"$")
	public void que_acessei_plataforma_com_as_seguintes_credenciais_e_senha(String arg1, String arg2) throws Exception {
		this.loginpage.inserirLogin(arg1);
	    this.loginpage.inserirSenha(arg2);
	    this.loginpage.pressionarLogar();

	}

	@Dado("^estou na aba Add Supplier$")
	public void estou_na_aba_Add_Supplier() throws Exception {
		suppliermanagement.ClickAccounts();
		suppliermanagement.ClickSuppliers();
		suppliermanagement.ClickAdd();
	}

	@Quando("^Inserir os dados de cadastro$")
	public void inserir_os_dados_de_cadastro(DataTable arg1) throws Exception {
		List<Map<String, String>> dados = arg1.asMaps(String.class, String.class);
		addsupplier.inserirPrimeiroNome(dados.get(0).get("PrimeiroNome"));
		addsupplier.inserirUltimoNome(dados.get(0).get("UltimoNome"));
		addsupplier.inserirEmail(dados.get(0).get("Email"));
		addsupplier.inserirSenha(dados.get(0).get("Senha"));
		addsupplier.inserirMobile(dados.get(0).get("Mobile"));
		addsupplier.inserirCountry(dados.get(0).get("Country"));
		addsupplier.inserirAddress1(dados.get(0).get("Address1"));
		addsupplier.inserirAddress2(dados.get(0).get("Address2"));
		addsupplier.inserirSupFor(dados.get(0).get("SupplierFor"));
		addsupplier.inserirItemName(dados.get(0).get("Itemname"));
		addsupplier.inserirAssigTours(dados.get(0).get("Assign Tours"));
		addsupplier.checkAdd(dados.get(0).get("ADD"));
		addsupplier.checkEDIT(dados.get(0).get("EDIT"));
		addsupplier.checkREMOVE(dados.get(0).get("REMOVE"));
		
		addsupplier.botaoSubit();
	}

	@Entao("^O supplier foi cadastado$")
	public void o_supplier_foi_cadastado(DataTable arg1) throws Exception {
		List<Map<String, String>> dados = arg1.asMaps(String.class, String.class);
		suppliermanagement.ChecarCadastro(dados.get(0).get("Email"));
	}
}

