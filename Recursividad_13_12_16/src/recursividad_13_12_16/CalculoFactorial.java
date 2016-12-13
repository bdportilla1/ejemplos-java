/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursividad_13_12_16;

/**
 *
 * @author SALAS
 */
public class CalculoFactorial {

    public double factorial(double numero) {
        if (numero <= 1) {
            return 1;
        }else{
            return numero * factorial( numero -1 );
        }//fin if
    }// fin del metodo factoriall
    
    //imprime factoral para los valores del 0 al 10
    public void mostrarFactorial() {
        for (int contador = 0; contador <= 10; contador++) {
            System.out.printf("%d! = %.0f\n", contador, factorial(contador));
            //System.out.printf("%.2f ", 4.0);
        }//fin for
    }// fin del metodo mostrarFactoriales
}// fin de la clase CalculoFactorial

