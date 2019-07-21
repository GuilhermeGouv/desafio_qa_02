package webService.stepDefinitions;




import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import webService.serviceObjects.GET;


public class StepDefinitionGET {
	private GET get = new GET(Hooks.getCon());
	
	@Quando("^envio a requisicao$")
	public void envio_a_requisicao() throws Exception {
		get.EnviarReq();
	}

	@Entao("^Rebo os dados$")
	public void rebo_os_dados() throws Exception {
		get.Receberdados();
	}

	@Entao("^exibo os requeridos$")
	public void exibo_os_requeridos() throws Exception {
	    get.ExibirDados();
	}
}
