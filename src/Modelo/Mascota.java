package Modelo;

import java.io.*;
import java.util.*;

public class Mascota implements Serializable{
    
    //Atributos
    private String nombre;
    private String especie;
    private String raza;
    private String peso;
    private String edad;
    private String color;
    private String sexo;
    private ArrayList<String> alergias;
    private ArrayList<String> vacunas;
    private String dueño;
    
    //Contructor de la clase
    public Mascota() { 
        this.alergias = new ArrayList<>();
        this.vacunas = new ArrayList<>();
    };
    
    //Arreglo para mostrar en tabla
    public Object[] Registro(int num) {
        Object fila[] = {num, nombre, especie, raza, peso, edad, color, sexo, dueño};
        return fila;
    }
    
    //Arreglo para mostrar vacunas en tabla
    public Object[] Vacunas(int num) {
        Object fila[] = {num, vacunas};
        return fila;
    }
    
    //Arreglo para mostrar alergias en tabla
    public Object[] Alergias(int num) {
        Object fila[] = {num, alergias};
        return fila;
    }

    //Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }
    public String getPeso() { return peso; }
    public void setPeso(String peso) { this.peso = peso; }
    public String getEdad() { return edad; }
    public void setEdad(String edad) { this.edad = edad; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public ArrayList<String> getAlergias() { return alergias; }
    public void setAlergias(ArrayList<String> alergias) { this.alergias = alergias; }
    public ArrayList<String> getVacunas() { return vacunas; }
    public void setVacunas(ArrayList<String> vacunas) { this.vacunas = vacunas; }
    public String getDueño() { return dueño; }
    public void setDueño(String dueño) { this.dueño = dueño; }
    
    //Metodo para agregar una alergia
    public void AgregarAlergia(String alergia) {
        this.alergias.add(alergia);
    }
    
    //Metodo para agregar una vacuna
    public void AgregarVacuna(String vacuna) {
        this.vacunas.add(vacuna);
    }
    
}
