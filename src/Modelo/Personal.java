package Modelo;

import java.io.*;

public class Personal implements Serializable {

    //Atributos
    private String nombre;
    private String dni;
    private String telefono;
    private String correo;
    private String direccion;
    private String tipo;
    private String horario;
    private String especialidad;
    private String servicio;

    //Contructor vacio
    public Personal() { }
    
    //Object para llenar tablas
    public Personal(Object[] registro) {
        this.nombre = registro[0].toString();
        this.dni = registro[1].toString();
        this.telefono = registro[2].toString();
        this.correo = registro[3].toString();
        this.direccion = registro[4].toString();
        this.tipo = registro[5].toString();
        this.horario = registro[6].toString();
        this.especialidad = registro[7].toString();
        this.servicio = registro[8].toString();
    }
    
    //Object de titulos
    public Object[] Registro(int num) {
        Object[] fila = { nombre, dni, telefono, correo, direccion, tipo, horario, especialidad, servicio};
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
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public String getServicio() { return servicio; }
    public void setServicio(String servicio) { this.servicio = servicio; }

}
