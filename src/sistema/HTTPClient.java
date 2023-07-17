package sistema;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.swing.JOptionPane;

public class HTTPClient {
	
			public String findData(String url) {

	        URI address = URI.create(url);
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder(address).GET().build();

	        HttpResponse<String> response;

	        try {
	            response = client.send(request, BodyHandlers.ofString());
	            return response.body();
	        } catch (IOException | InterruptedException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Erro de conexão.", Navegacao.TITULO, 0);
	            throw new RuntimeException("Erro ao buscar URL ou sem acesso a internet.");
	        }

	    }
	}