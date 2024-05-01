
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String[] monedasDeseadas = {"1. USD", "2. ARG", "3. BRL", "4. CLP", "5. COP", "6. BOB", "9. Salir"};
        Scanner scan = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        int opcion = 0;
        while (opcion != 9) {
            System.out.println("Eliga el numero de la moneda: ");
            for (String monedaDeseada : monedasDeseadas) {
                System.out.println(monedaDeseada);
            }
            try {
                opcion = Integer.parseInt(scan.nextLine());
                if (opcion != 9) {
                    System.out.println(consulta.consultaMoneda(opcion));
                } else {
                    System.out.println("Saliendo del programa... Gracias por usar nuestro servicio!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida, debe elegir un numero!");
            } catch (Exception e) {
                System.out.println("Error: "+ e);
            }
        }
    }

}
