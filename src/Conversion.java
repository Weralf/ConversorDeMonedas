import com.google.gson.JsonObject;

public class Conversion {

    private String moneda;
    private JsonObject valorEnOtrasMonedas;

    public Conversion (ConversionOmbd conversionombd){
    this.moneda = conversionombd.base_code();
    this.valorEnOtrasMonedas = conversionombd.conversion_rates();

    }

    public String getMoneda() {
        return moneda;
    }

    public Object getValorEnOtrasMonedas() {
        return valorEnOtrasMonedas;
    }

    public String toString() {
        System.out.println("Moneda: "+moneda);
        System.out.println("Conversion a otras monedas: ");
        String[] monedasDeseadas = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};
        for (String monedaDeseada : monedasDeseadas) {
            if (valorEnOtrasMonedas.has(monedaDeseada) && !monedaDeseada.equals(moneda)) {
                    System.out.println(monedaDeseada + ": " + valorEnOtrasMonedas.get(monedaDeseada).getAsDouble());
            }
        }
        return "";
    }
}
