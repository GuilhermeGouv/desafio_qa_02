#language:pt

Funcionalidade: te de cadastro do site phptravels
  
  @CadastrarSupplier
  Cenario: Cadastrar um novo supplier
  	Dado Que acessei plataforma com as seguintes credenciais "admin@phptravels.com" e senha "demoadmin"
    E estou na aba Add Supplier
    Quando Inserir os dados de cadastro
    	|  PrimeiroNome | UltimoNome |             Email |    Senha |    Mobile | Country | Address1 |         Address2 | SupplierFor| Itemname |Assign Tours| ADD | EDIT | REMOVE |
    	|      Supplier |       Tour | Toru@Supplier.com |   123654 | 984345555 |       Br| Somewere | Over The Rainbow |       Tours| Item1135 |         36 |	 2 |    2 |      2 |
    Entao O supplier foi cadastado 