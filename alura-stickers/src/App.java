import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
		//1 abrir conex�o HTTP (protocolo de comunicacao da web) e buscar o top250 filmes
		
		String url = "https://alura-filmes.herokuapp.com/conteudos";
		URI endereco = URI.create(url);
		//criar o http client e chamar o metodo newHttpClient() e guarda-lo em uma var
		HttpClient client = HttpClient.newHttpClient();
		//criar uma requisi�ao passando o endere�o da URI
		//o metodo newBuilder dentro da classe HttpRequest devolve um build de requests, com metodos get, put, delete
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		//transformando os dados em string
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
				
		//2 parsear os dados => filtrar os dados que nos interessam (titulo, poster e classifica��o)
		//criamos uma lista, que vai mapear os dados de uma chave do tipo String e o valor associado a essa chave tbm � String
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
		//System.out.println(listaDeFilmes.size());
		//System.out.println(listaDeFilmes.get(0));

		
		//3 exibit e manipular os dados
		for (Map<String, String> filme: listaDeFilmes ) {
			System.out.println(filme.get("title"));
			System.out.println(filme.get("image"));
			System.out.println(filme.get("imDbRating"));
			System.out.println("");

		}
		
		
		
		
	}

}
