import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ZipCodeLookup {

  public Address findAddress(String zip) {
    URI address = URI.create("https://viacep.com.br/ws/" + zip + "/json");

    HttpRequest request = HttpRequest.newBuilder()
            .uri(address)
            .build();

    try {
      HttpResponse<String> response = HttpClient
              .newHttpClient()
              .send(request, HttpResponse.BodyHandlers.ofString());
      return new Gson().fromJson(response.body(), Address.class);
    } catch (Exception e) {
      throw new RuntimeException("I couldn't retrieve the address from this ZIP Code.");
    }

  }
}
