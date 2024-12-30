package Modelo;

import java.io.*;

public class PersonalNodo implements Serializable{
    
    //Atributos
    private Personal elemento;
    private PersonalNodo Izq;
    private PersonalNodo Der;
    
    //Constructor de la clase
    public PersonalNodo(Personal elemento) {
        this.elemento = elemento;
        Izq=Der=null;
    }

    //getters y setters
    public Personal getElemento() { return elemento; }
    public void setElemento(Personal elemento) { this.elemento = elemento; }
    public PersonalNodo getIzq() { return Izq; }
    public void setIzq(PersonalNodo Izq) { this.Izq = Izq; }
    public PersonalNodo getDer() { return Der; }
    public void setDer(PersonalNodo Der) { this.Der = Der; }
        
}
