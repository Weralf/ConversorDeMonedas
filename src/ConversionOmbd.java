import com.google.gson.JsonObject;

public record ConversionOmbd(String base_code, JsonObject conversion_rates) {
}
