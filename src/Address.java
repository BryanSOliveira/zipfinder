import com.google.gson.annotations.SerializedName;

public record Address(@SerializedName("cep") String zip,
                      @SerializedName("logradouro") String street,
                      @SerializedName("complemento") String complement,
                      @SerializedName("localidade") String locality,
                      @SerializedName("bairro") String neighborhood,
                      @SerializedName("uf") String state) {
}
