package Modelo;

import java.io.*;

public class MascotaNodo implements Serializable {
    
    //Atributos
    public Mascota mas;
    public MascotaNodo sig;
    
    //Metodo de la clase
    public MascotaNodo(Mascota m) {
        this.mas = m;
        this.sig = null;
    }

    //Getters y Setters
    public Mascota getMas() { return mas; }
    public void setMas(Mascota mas) { this.mas = mas; }
    public MascotaNodo getSig() { return sig; }
    public void setSig(MascotaNodo sig) { this.sig = sig; }
       
}
