import com.google.gson.Gson;
import monedas.Moneda;
import monedas.MonedaEX;
import monedas.RespuestaAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static String consultar(String moneda) throws IOException, InterruptedException {

        String token = "";  // SE DEBE AGREGAR EL TOKEN SECRETO ENTRE LAS COMILLAS

        String direccion = "https://v6.exchangerate-api.com/v6/" + token + "/latest/"+ moneda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("Bienvenid@ al Conversor de Monedas");

        while (true) {

            System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");

            int opcion = 1;

            ArrayList<String> opciones = new ArrayList<>();
            opciones.add("Dólar");
            opciones.add("Peso Argentino");
            opciones.add("Real Brasileño");
            opciones.add("Peso Colombiano");

            Map<String, String> codigoPaises = new HashMap<>();
            codigoPaises.put("Dólar", "USD");
            codigoPaises.put("Peso Argentino", "ARS");
            codigoPaises.put("Real Brasileño", "BRL");
            codigoPaises.put("Peso Colombiano", "COP");

            Map<String, String> codigoPaises2 = new HashMap<>();
            codigoPaises2.put("USD", "Dólar");
            codigoPaises2.put("ARS", "Peso Argentino");
            codigoPaises2.put("BRL", "Real Brasileño");
            codigoPaises2.put("COP", "Peso Colombiano");

            Map<Object, ArrayList<String>> conversiones = new HashMap<>();

            for (String op1 : opciones) {
                for (String op2 : opciones) {
                    if (!op1.equals(op2)) {
                        System.out.println(opcion + ") " + op1 + " -> " + op2);
                        ArrayList<String> par = new ArrayList<>();
                        par.add(codigoPaises.get(op1));
                        par.add(codigoPaises.get(op2));
                        conversiones.put(opcion, par);
                        opcion++;
                    }
                }
            }

            System.out.println(opcion + ") Salir");

            System.out.println("Elija una opción válida\n");

            int caso = scanner.nextInt();

            String resultado = "";
            String moneda = "";
            String moneda2 = "";
            String moneda1 = "";

            if (caso < opcion) {
                moneda1 = conversiones.get(caso).get(0);
                moneda2 = conversiones.get(caso).get(1);
                resultado = consultar(moneda1);
                moneda = codigoPaises2.get(moneda1);

            } else if(caso == opcion) {
                break;
            }

            if (caso > opcion) {
                System.out.println("Opción no válida. Ingrese una opción válida");

            } else {
                System.out.println("Ingrese el monto que desea convertir");
                float monto = scanner.nextFloat();

                Gson gson = new Gson();

                RespuestaAPI monedaRaw = gson.fromJson(resultado, RespuestaAPI.class);
                MonedaEX tasas = monedaRaw.getConversion_rates();
                Moneda monedaUso = new Moneda(moneda, tasas.USD(), tasas.ARS(), tasas.BRL(), tasas.COP());

                double precio = switch (moneda2) {
                    case "USD" -> monedaUso.getUsd();
                    case "ARS" -> monedaUso.getArs();
                    case "BRL" -> monedaUso.getBrl();
                    case "COP" -> monedaUso.getCop();
                    default -> 0.0;
                };

                double conversion = precio * monto;

                System.out.println("El valor " + monto + " [" + moneda1 + "] corresponde al valor final de --> " + conversion + " [" + moneda2 + "].");
            }
        }
    }
}
