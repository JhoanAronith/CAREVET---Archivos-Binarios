package Modelo;

import java.io.*;

public class Cliente implements Serializable{
    
    //Atributos
    private String nombre;
    private String dni;
    private String telefono;
    private String correo;
    private String direccion;
    
    //Constructor vacio
    public Cliente() {}
    
    //Arreglo para mostrar en tabla
    public Object[] Registro(int num) {
        Object[] fila = {num, nombre, dni, telefono, correo, direccion};
        return fila;
    }

    //Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
}
