package Proceso;

import Vista.*;
import Modelo.*;
import Mensaje.*;

public class ProcesosForma06 {
    
    //Método que muestra el resumen de la cita
    public static void MostrarResumen(Forma06 f6) {
        String diagnostico = f6.txaDiagnostico.getText();
        String medicinas = f6.txaMedicinas.getText();
        String recomendaciones = f6.txaRecomendaciones.getText();
        String receta = f6.txaRecetas.getText();
        //cambiar
        String cliente = f6.txtNombreCliente.getText();
        String codigo = f6.txtCodigoCita.getText();
        String mascota = f6.txtNombreMascota.getText();
        f6.txaResumenCita.setText("""
                                  --- RESUMEN CITA ---
                                  Informaci\u00f3n Cita: 
                                  C\u00f3digo      : """ + codigo +
                                  "\nCliente     : " + cliente +
                                  "\nMascota     : " + mascota +
                                  "\n---------------------" +
                                  "\nDiagnostico : " + diagnostico +
                                  "\nMedicinas   : " + medicinas + 
                                  "\nReceta      : " + receta +
                                  "\nRecomendaciones: " + recomendaciones);
    }
    
    //Método que cambia el estado de una cita a atendida
    public static void AtenderCita(Cita cita) {
        cita.setAtendida(true);
    }
    
    //Metodo que limpiar las entradas de los txa
    public static void LimpiarInformacion(Forma06 f6) {
        f6.txaDiagnostico.setText("");
        f6.txaMedicinas.setText("");
        f6.txaRecetas.setText("");
        f6.txaRecomendaciones.setText("");
        f6.txaResumenCita.setText("");
    }
    
    //Metodo que hace no editable los txt
    public static void EvitarEdicion(Forma06 f6) {
        f6.txtCodigoCita.setEditable(false);
        f6.txtFechaCita.setEditable(false);
        f6.txtNombreCliente.setEditable(false);
        f6.txtNombreMascota.setEditable(false);
        f6.txtPersonalCita.setEditable(false);
        f6.txtServicioCita.setEditable(false);
    }
    
    //Mostrar Datos mascota
    public static void MostrarDatosNodoMascota(MascotaNodo actualMascota, Forma06 f6) {
        if (actualMascota != null) {
            Mensaje.Texto("Nombre : " + actualMascota.mas.getNombre() +
                          "\nRaza : " + actualMascota.mas.getRaza() +
                          "\nEspecie : " + actualMascota.mas.getEspecie() +
                          "\nEdad: " + actualMascota.mas.getEdad() +
                          "\nSexo: " + actualMascota.mas.getSexo());
        }
    }
    
}
