/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tres;

/**
 *
 * @author SALAS
 */
public class Estudiante {
    private String nombre;
    private String apellido;
    private int edad;

    public Estudiante(String n, String a, int e) {
        setNombre(n);
        setApellido(a);
        setEdad(e);
        
    }
    

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String a) {
        apellido = a;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int a) {
        edad = 2016 - a;
    }
    
    
    
    
    
    
}
