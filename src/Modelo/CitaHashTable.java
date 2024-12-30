package Modelo;

import java.io.*;
import Mensaje.*;
import java.util.*;

public class CitaHashTable implements Serializable {
    
    //Estructura Hashtable
    private Hashtable<String, Cita> Lista;
    
    //Constructor de la clase
    public CitaHashTable() {
        Lista = new Hashtable();
    }
    
    //Metodo para guardar en archivo
    public static void GuardarEnArchivo(CitaHashTable lista){
        try{
            FileOutputStream fos = new FileOutputStream("DatosCitas.bin");
            ObjectOutputStream  oos =  new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.close();
        }catch(Exception ex){
            Mensaje.Error("No se pudo guardar", "Error al guardar");
        }
    }
    
    //Metodo para recuperar de archivo
    public static CitaHashTable RecuperarDeArchivo(){
        CitaHashTable lista =  new CitaHashTable();
        try{
            FileInputStream fis = new FileInputStream("DatosCitas.bin");
            ObjectInputStream  ois =  new ObjectInputStream(fis);
            lista=(CitaHashTable)ois.readObject();
            ois.close();
        }catch(Exception ex){
            Mensaje.Error("No se pudo recuperar", "Error al recuperar");
        }
        return lista;
    }
    
    //Metodo que guarda datos en la tabla hash
    public void AgregarCita(Cita cita) {
        getLista().put(cita.getCodigo(), cita);
    }
    
    //Metodo que obtiene una cita por su codigo
    public Cita ObtenerCita(String codigo) {
        return getLista().get(codigo);
    }
    
    //Metodo que actualiza los datos de una cita
    public void ActualizarCita(Cita actualizado) {
        getLista().replace(actualizado.getCodigo(), actualizado);
        GuardarEnArchivo(this);
    }
    
    //Metodo que eliminar un objeto de la lista
    public void EliminarCita(String codigo) {
        getLista().remove(codigo);
        GuardarEnArchivo(this);
    }
    
    //Metodo que cuenta la cantidad de citas
    public int CantidadCitas() {
        return getLista().size();
    }
    
    //Getters y Setters
    public Hashtable<String, Cita> getLista() { return Lista; }
    public void setLista(Hashtable<String, Cita> Lista) { this.Lista = Lista; }
    
}
