package Proceso;

import Modelo.*;
import Vista.*;
import javax.swing.*;
import javax.swing.table.*;
import Mensaje.*;
import java.util.*;

public class ProcesosForma02 {

    //Metodo para limpiar entradas
    public static void LimpiarEntradas(Forma02 f2) {
        f2.txtNombre.setText("");
        f2.txtEspecie.setText("");
        f2.txtRaza.setText("");
        f2.txtAlergias.setText("");
        f2.txtColor.setText("");
        f2.txtPeso.setText("");
        f2.txtEdad.setText("");
        f2.txtDueño.setText("");
        f2.cbxSexo.setSelectedIndex(0);
        f2.txtVacunas.setText("");
    }

    //metodo para agregar itemas al comboBox de sexo
    public static void AgregarSexo(JComboBox cbxSexo) {
        cbxSexo.addItem("Macho");
        cbxSexo.addItem("Hembra");
    }
    
    //Metodo que agrega vacunas al ArryaList de cada mascota
    public static void AgregarVacuna(Forma02 f2, Mascota mascota) {
        if (mascota != null) {
            String vacuna = f2.txtVacunas.getText();
            mascota.AgregarVacuna(vacuna);
            f2.txtVacunas.setText("");
        } else {
            Mensaje.Texto("error al guardar");
        }
    }
    
    //Metodo que agrega alergias al ArryaList de cada mascota
    public static void AgregarAlergia(Forma02 f2, Mascota mascota) {
        if (mascota != null) {
            String alergia = f2.txtAlergias.getText();
            mascota.AgregarAlergia(alergia);
            f2.txtAlergias.setText("");
        } else {
            Mensaje.Texto("error al guardar");
        }
    }
    
    //Metodo que lee una mascota
    public static Mascota LeerMascota(Forma02 f2) {
        Mascota mas = new Mascota();
        mas.setNombre(f2.txtNombre.getText());
        mas.setEspecie(f2.txtEspecie.getText());
        mas.setRaza(f2.txtRaza.getText());
        mas.setPeso(f2.txtPeso.getText());
        mas.setEdad(f2.txtEdad.getText());
        mas.setColor(f2.txtColor.getText());
        mas.setSexo(f2.cbxSexo.getSelectedItem().toString());
        mas.AgregarAlergia(f2.txtAlergias.getText());
        mas.AgregarVacuna(f2.txtVacunas.getText());
        mas.setDueño(f2.txtDueño.getText());
        return mas;
    }

    //Metodo que muestros los datos más importantes en una tabla
    public static void MostrarDatosGenerales(JTable tabla, MascotaListaEnlazada Lista) {
        String titulos[] = {"Num", "Nombre", "Especie", "Raza", "Peso", "Edad", "Color", "Sexo", "Dueño"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        MascotaNodo actual = Lista.getIni();
        int numeracion = 1;
        while(actual != null) {
            Mascota mas = actual.getMas();
            String fila[] = {String.valueOf(numeracion), mas.getNombre(), mas.getEspecie(), mas.getRaza(), 
                             mas.getPeso(), mas.getEdad(), mas.getColor(), mas.getSexo(), mas.getDueño()};
            modelo.addRow(fila);
            actual = actual.getSig();
            numeracion++;
        }
        tabla.setModel(modelo);
    }
    
    //Metodo que muestras las vacunas de la mascota en una tabla
    public static void MostrarDatosVacunas(JTable tabla, ArrayList<String> a) {
        String titulos[] = {"Num", "Vacuna"};
        DefaultTableModel mt = new DefaultTableModel(null, titulos);
        tabla.setModel(mt);
        for (int i = 0; i < a.size(); i++) {
            Object[] fila = {i + 1, a.get(i)};
            mt.addRow(fila);
        }
    }
    
    //Metodo que muestras las alergias de la mascota en una tabla
    public static void MostrarDatosAlergias(JTable tabla, ArrayList<String> a) {
        String titulos[] = {"Num", "Alergias"};
        DefaultTableModel mt = new DefaultTableModel(null, titulos);
        tabla.setModel(mt);
        for (int i = 0; i < a.size(); i++) {
            Object[] fila = {i + 1, a.get(i)};
            mt.addRow(fila);
        }
    }
    
    //Metodo que muestra los datos de una mascota en los txt
    public static void MostrarDatosNodo(MascotaNodo actual, Forma02 f2) {
        if (actual != null) {
            f2.txtNombre.setText(actual.mas.getNombre());
            f2.txtEspecie.setText(actual.mas.getEspecie());
            f2.txtRaza.setText(actual.mas.getRaza());
            f2.txtEdad.setText(actual.mas.getEdad());
            f2.txtPeso.setText(actual.mas.getPeso());
            f2.txtColor.setText(actual.mas.getColor());
            f2.cbxSexo.setSelectedItem(actual.mas.getSexo());
            f2.txtDueño.setText(actual.mas.getDueño());
        }
        
    }

}
