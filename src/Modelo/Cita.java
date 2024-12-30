package Modelo;

import java.io.*;
import java.util.*;

public class Cita implements Serializable {
    
    //Atributos
    private String codigo;
    private String fechaHora;
    private String nomCliente;
    private String nomMascota;
    private String nomServicio;
    private String nomPersonal;
    private boolean atendida;
    private boolean cancelada;
    
    //Constructor vacio 
    public Cita() {};
    
    //Arreglo para mostrar en tabla
    public Object[] Registro(int num) {
        Object[] fila = {num, codigo, fechaHora, nomCliente, nomMascota, nomServicio, nomPersonal};
        return fila;
    }
    
    //Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }
    public String getNomCliente() { return nomCliente; }
    public void setNomCliente(String nomCliente) { this.nomCliente = nomCliente; }
    public String getNomMascota() { return nomMascota; }
    public void setNomMascota(String nomMascota) { this.nomMascota = nomMascota; }
    public String getNomServicio() { return nomServicio; }
    public void setNomServicio(String nomServicio) { this.nomServicio = nomServicio; }
    public String getNomPersonal() { return nomPersonal; }
    public void setNomPersonal(String nomPersonal) { this.nomPersonal = nomPersonal; }
    public boolean isAtendida() { return atendida; }
    public void setAtendida(boolean atendida) { this.atendida = atendida; }
    public boolean isCancelada() { return cancelada; }
    public void setCancelada(boolean cancelada) { this.cancelada = cancelada; }
        
}
