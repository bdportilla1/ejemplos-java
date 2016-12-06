package tres;

// Ejemplo tomado del libro 
// D EITEL , P AUL J. Y H ARVEY M. D EITEL
// CÓMO PROGRAMAR EN J AVA . Séptima edición
// fines educativos
// Prueba de la clase CrearArchivoTexto.

public class Ejecutor
{
   public static void main( String args[] )
   {
      LeerArchivos1 aplicacion = new LeerArchivos1();

      aplicacion.abrirArchivo();
      aplicacion.leer_informacion();
      aplicacion.cerrarArchivo();
   } // fin de main
} // fin de la clase PruebaCrearArchivoTexto

