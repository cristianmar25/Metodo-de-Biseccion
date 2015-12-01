package biseccion;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Empleando el Método de Bisección. El programa deberá pedir los valores
 * inicial y final del intervalo de búsqueda y el error aproximado máximo. El
 * programa deberá calcular y desplegar los valores de la raíz, el valor de la
 * función para esa raíz y el número de iteraciones requerida para encontrar la
 * raíz.
 *
 * @author Benny ID: 99664
 * Fecha: 13/09/2015
 */
public class Biseccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Este programa obtiene la raíz mediante el método de bisección\ny obtinene el valor de la función f(x) = 4x^3-6x^2+7x-2.3\n");
        System.out.print("Dame el valor de xi: ");
        double xi = scanner.nextDouble();
        System.out.print("Dame el valor de xf: ");
        double xf = scanner.nextDouble();
        System.out.print("Dame el valor del error maximo: ");
        double eamax = scanner.nextDouble();
        DecimalFormat dc = new DecimalFormat("#0.0000000");
        double r = biseccion(xi, xf, eamax);
        System.out.println("La raiz es: " + dc.format(r));
        System.out.println("Sustitución en la función: " + dc.format(f(r)));
    }

    /**
     * Realiza el proceso de bisección para encontrar la raiz.
     *
     * @param xi es la x inicial
     * @param xf es la x final
     * @param eamax es el valor de error maximo
     * @return el valor de la raíz
     */
    private static double biseccion(double xi, double xf, double eamax) {
        double xr = ((xi + xf) / 2);
        double xrv, ea;
        int i = 1;
        while (true) {
            i++;
            double yi = f(xi);
            double yr = f(xr);
            if ((yi * yr) < 0) {
                xf = xr;
            } else if ((yi * yr) > 0) {
                xi = xr;
            } else {
                System.out.println("Iteraciones: " + i);
                return xr;
            }
            xrv = xr;
            xr = (xi + xf) / 2;
            ea = Math.abs((xr - xrv) / xr);

            if (ea < eamax) {
                System.out.println("Iteraciones: " + i);
                return xr;
            }
        }
    }

    /**
     * Es la función
     *
     * @param x es el valor de x de la función
     * @return el resultado de la sustitución en la función
     */
    private static double f(double x) {
        return ((4 * Math.pow(x, 3)) - (6 * Math.pow(x, 2)) + (7 * x) - 2.3);
    }
}
