package cuatro;

// Ejemplo tomado del libro 
// D EITEL , P AUL J. Y H ARVEY M. D EITEL
// CÓMO PROGRAMAR EN J AVA . Séptima edición
// fines educativos
// Uso de la clase Formatter para escribir datos en un archivo de texto.
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CrearArchivo {

    private Formatter salida; // objeto usado para enviar texto al archivo

    // permite al usuario abrir el archivo
    public void abrir_archivo() {
        try {
            salida = new Formatter("factura.txt");
        } // fin de try
        catch (SecurityException securityException) {
            System.err.println(
                    "No tiene acceso de escritura a este archivo.");
            System.exit(1);
        } // fin de catch
        catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrir_archivo

    // agrega registros al archivo
    public void agregar_informacion() {
        // el archivo permite el ingreso
        // de edad, nombre, apellido de una persona

        Scanner entrada = new Scanner(System.in);

        boolean bandera2 = true;
        int eleccion = 0;
        int cant = 0;
        double precio = 0;
        double subtotal = 0;
        String producto = "";
        
        double iva;
        double precio_t;
        
            try // envía valores al archivo
            {
                // obtiene los datos que se van a enviar
                System.out.println("Ingrese el nombre del cliente");
                String nombre = entrada.nextLine();
                System.out.println("Ingrese la ciudad");
                String ciudad = entrada.next();
                
                salida.format("\t\tComercial Ventas y Reventas\nNombre: %s\nCiudad: %s\n"
                        + "-----------------------------------\n"
                        + "Producto\t\tCant\t\tPrecio\n", nombre, ciudad);

                while (bandera2) {
                    System.out.println("**********     MENU   ************");
                    System.out.println("** [1] ARROZ      costoKg $2.50 **");
                    System.out.println("** [2] AZUCAR     costoKg $1.50 **");
                    System.out.println("** [3] ACEITE     cost/U  $1.30 **");
                    System.out.println("** [4] TALLARINES cost/U  $1.50 **");
                    System.out.println("** [5] SAL        costKg  $1.00 **");
                    System.out.println("** **************************** **");

                    System.out.println("Ingrese elproducto");
                    eleccion = entrada.nextInt();
                    System.out.println("Ingrese la cantidad");
                    cant = entrada.nextInt();

                    switch (eleccion) {
                        case 1:
                            precio = 2.50 * cant;
                            producto = "ARROZ     ";
                            break;
                        case 2:
                            precio = 1.50 * cant;
                            producto = "AZUCAR    ";
                            break;
                        case 3:
                            precio = 1.30 * cant;
                            producto = "ACEITE    ";
                            break;
                        case 4:
                            precio = 1.50 * cant;
                            producto = "TALLARINES";
                            break;
                        case 5:
                            precio = 1.0 * cant;
                            producto = "SAL       ";
                            break;
                    }
                    salida.format("%s\t\t%d\t\t%.2f\n", producto, cant, precio);
                    
                    subtotal = subtotal + precio;

                    System.out.println("Desea ingresar más productos (1), no(2)");
                    int valor = entrada.nextInt();
                    if (valor == 2) {
                        bandera2 = false;
                    }
                    
                }
            iva = subtotal * 0.14;
            precio_t = subtotal + iva;
            
            
                    
                    
            salida.format("----------------------------------------\n"
                    + "\t\t\tSubtotal: %.2f\n"
                    + "\t\t\tIVA: %.2f\n"
                    + "\t\t\tTOTAL: %.2f\n", subtotal, iva, precio_t);
                    
                
            } // fin de try
            catch (FormatterClosedException formatterClosedException) {
                System.err.println("Error al escribir en el archivo.");
                return;
            } // fin de catch
            catch (NoSuchElementException elementException) {
                System.err.println("Entrada invalida. Intente de nuevo.");
                entrada.nextLine(); // descarta la entrada para que el usuario intente de nuevo
            } // fin de catch

        // fin de while
    } // fin del método agregarRegistros

    // cierra el arrchivo
    public void cerrar_archivo() {
        if (salida != null) {
            salida.close();
        }
    } // fin del método cerrarArchivo
} // fin de la clase ArchivoTexto
