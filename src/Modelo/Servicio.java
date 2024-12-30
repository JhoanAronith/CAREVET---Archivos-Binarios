package Modelo;

import java.io.*;

public class Servicio implements Serializable {
    
    //Atributos de la clase
    private String nombre;
    private String codigo;
    private String costo;
    private String descripcion;
    private String duracion;
    
    //Constructor vacío
    public Servicio() {};
    
    //Arreglo para presentar
    public Object[] Registro(int num) {
        Object fila[] = {num, codigo, nombre, costo, descripcion, duracion};
        return fila;
    }

    //Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getCosto() { return costo; }
    public void setCosto(String costo) { this.costo = costo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getDuracion() { return duracion; }
    public void setDuracion(String duracion) { this.duracion = duracion; }
    
}
