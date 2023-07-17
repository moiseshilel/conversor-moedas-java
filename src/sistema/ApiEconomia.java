package sistema;

public class ApiEconomia {

    public String[] extracao(String opcao1, String opcao2) {
        String url = "https://economia.awesomeapi.com.br/" + opcao2 + "-" + opcao1 + "/1?format=json";            
        HTTPClient apiLink = new HTTPClient();
        String json = apiLink.findData(url);
        JavaUtil parser = new JavaUtil();
        return parser.Parser(json);
        
     // Função usada para conectar e extrair os dados da API.

    }
}