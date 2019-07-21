package webService.stepDefinitions;


import java.util.List;

import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import webService.serviceObjects.POST;
import webService.serviceObjects.PostID;
import webService.serviceObjects.PostPassword;
import webService.serviceObjects.PostUserName;

public class StepDefinitionPOST {
	private POST post = new POST(Hooks.getCon());
	private PostID iD = new PostID();
	private PostUserName userName = new PostUserName();
	private PostPassword password = new PostPassword();
	

	@Quando("^preparo os dados para envio$")
	public void preparo_os_dados_para_envio(DataTable arg1) throws Exception {
		List<Map<String, String>> dados = arg1.asMaps(String.class, String.class);
		iD.setID(dados.get(0).get("ID"));
		userName.setUserName(dados.get(0).get("UserName"));
		password.setPassword(dados.get(0).get("Password"));	
	}

	@Quando("^envio o o POST para o servico$")
	public void envio_o_o_POST_para_o_servico() throws Exception {
	    post.EnviarValores(iD.getID(),userName.getUsername(),password.getPassword());

	}

	@Entao("^valido o respose do servico$")
	public void valido_o_respose_do_servico() throws Exception {
	    post.ExtrairResponse();
	    post.ValidarResponse();
	}
	
}
