#language:pt

@tag
Funcionalidade: enviar uma requisição do tipo POST e validar o status code e o response do serviço



	Cenario: enviar um POST 
  	Quando preparo os dados para envio
  		| ID | UserName | Password |
    	|  1 |     Test |   123654 |
  	E envio o o POST para o servico
  	Entao valido o respose do servico
  	
  	

