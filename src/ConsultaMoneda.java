import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ConsultaMoneda {

    public Conversion consultaMoneda(int opcion) {
        String moneda2 = switch (opcion) {
            case 1 -> "USD";
            case 2 -> "ARS";
            case 3 -> "BRL";
            case 4 -> "CLP";
            case 5 -> "COP";
            case 6 -> "BOB";
            default -> "USD";
        };

        //Http Connection
        String url_str = "https://v6.exchangerate-api.com/v6/4dd11576610bd5e24546dbe5/latest/"+moneda2;

        try {
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            //Parseo del body a JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            ConversionOmbd conversionOmbd = new Gson().fromJson(jsonobj, ConversionOmbd.class);
            return new Conversion(conversionOmbd);
        } catch (IOException e) {
            throw new RuntimeException("Ha habido un problema! Intentelo de nuevo :(");
        }
    }
    }
