package Ejemplaso;

// Ejemplo tomado del libro 
// D EITEL , P AUL J. Y H ARVEY M. D EITEL
// CÓMO PROGRAMAR EN J AVA . Séptima edición
// fines educativos
// Prueba de la clase ArchivoTexto.

// Este programa lee un archivo de texto y muestra cada registro.
import lecturaArchivos.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

public class LeerArchivoTexto1 {

    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("ejemplaso calificaciones.txt"));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrirArchivo

    // lee registro del archivo
    public void leer_informacion() {
        double promedio[] = new double[4];
        double promedio_final = 0;
        double alto = 0;
        double suma2= 0;
        String alto2 ="";
        int c = 0;

        try // lee registros del archivo, usando el objeto Scanner
        {
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                 System.out.println(linea);
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split(";")));
                System.out.println(linea_partes);
                
               
                
                for (int i=2; i<(linea_partes.size()-1); i++){
                    c=0;
                    promedio[c] = 0;
                    
                    promedio[c] = (promedio[c] + Double.parseDouble(linea_partes.get(i))+ Double.parseDouble(linea_partes.get(i+1))) / 2;
                    System.out.printf("El promedio de %s es %.2f\n", linea_partes.get(0), promedio[c]);
                    promedio_final = promedio_final + promedio[c];
                    
                    if (alto<promedio[c]){
                    alto = promedio[c];
                    alto2 = linea_partes.get(0);
                    }
                    c= c+1;
                }
                

            } // fin de while
            
           
            promedio_final = promedio_final / (promedio.length);
            
            
            
            
            
            
            System.out.println("------------------------------------------------------");
            System.out.printf("El promedio del curso es: %.2f\n", promedio_final);
            System.out.printf("El promedio de %s mas alto es: %.2f\n", alto2, alto);
            System.out.println("------------------------------------------------------");
       
            
        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del metodo leerRegistros
    // cierra el archivo y termina la aplicación

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del metodo cerrarArchivo
} // fin de la clase LeerArchivoTexto

