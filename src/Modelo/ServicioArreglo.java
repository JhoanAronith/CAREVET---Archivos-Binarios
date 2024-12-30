package Modelo;

import java.io.*;
import Mensaje.*;

public class ServicioArreglo implements Serializable {

    //Arreglo de servicios
    private Servicio[] Lista;
    private static int cantSer = 0;

    //Constructor del arreglo 
    public ServicioArreglo() {
        Lista = new Servicio[15];
    }

    //Metodo que agrega un servicio
    public void AgregarServicio(Servicio ser) {
        Lista[cantSer] = ser;
        cantSer++;
    }

    //Metodo que recupera un servicio
    public Servicio RecuperarServicio(int posicion) {
        return Lista[posicion];
    }

    //Metodo que elimina un servicio
    public void EliminarServicio(int posicion) {
        for (int i = posicion; i < cantSer - 1; i++) {
            Lista[i] = Lista[i + 1];
        }
        Lista[cantSer - 1] = null;
        cantSer--;
    }

    //Metodo para actualizar un servicio
    public void ActualizarServicio(int posicion, Servicio actualizado) {
        Lista[posicion] = actualizado;
    }

    //metodo para guardar en archivo binario
    public void GuardarEnArchivo() {
        try {
            FileOutputStream fos = new FileOutputStream("DatosServicios.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Lista);
            oos.close();
        } catch (Exception ex) {
            Mensaje.Error("Error al guardar", "Error de guardado");
        }
    }

    //Metodo para recuperar del archivo binario
    public void RecuperarDeArchivo() {
        try {
            FileInputStream fis = new FileInputStream("DatosServicios.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Lista = (Servicio[]) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            Mensaje.Error("Error al recuperar", "Error de archivo");
        }
    }
    
    //metodo para actualizar la cnatidad de servicios
    public void ActualizarCantidadSer(){
        cantSer=0;
        for(Servicio ser: Lista){
            if(ser!=null)  cantSer++;            
        }
    }

    //getters y setters
    public static int getCantSer() { return cantSer; }
    public static void setCantSer(int cantSer) { ServicioArreglo.cantSer = cantSer; }
    public Servicio[] getLista() { return Lista; }
    public void setLista(Servicio[] Lista) { this.Lista = Lista; }
    
}
