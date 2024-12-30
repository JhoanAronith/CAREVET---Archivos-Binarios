package Proceso;

import Vista.*;
import javax.swing.*;
import Modelo.*;
import javax.swing.table.*;

public class ProcesosForma04 {

    //Agregar tipo de personal a combo
    public static void AgregarTipo(JComboBox cbx) {
        cbx.addItem("Veterinario");
        cbx.addItem("Técnico");
    }

    //Agregar especialidad de personal a combo
    public static void AgregarEspecialidad(JComboBox cbx) {
        cbx.addItem("Farmacología veterinaria");
        cbx.addItem("Veterinaria analgésica");
        cbx.addItem("Cirugía veterinaria");
        cbx.addItem("Dermatología veterinaria");
        cbx.addItem("Veterinaria de emergencia");
    }

    //Agregar horario de personal a combo
    public static void AgregarHorario(JComboBox cbx) {
        cbx.addItem("8:00 - 13:00");
        cbx.addItem("13:00 - 18:00");
    }
    
    //Agregar servicio de personal a combo
    public static void AgregarServicio(JComboBox<String> cbx) {
        ServicioArreglo servicioArreglo = new ServicioArreglo();
        servicioArreglo.RecuperarDeArchivo();
        servicioArreglo.ActualizarCantidadSer();

        Servicio[] listaServicios = servicioArreglo.getLista();
        for (int i = 0; i < ServicioArreglo.getCantSer(); i++) {
            cbx.addItem(listaServicios[i].getNombre());
        }

    }

    //Metodo par limpiar entradas
    public static void LimpiarEntradas(Forma04 f4) {
        f4.txtCorreo.setText("");
        f4.txtDireccion.setText("");
        f4.txtDni.setText("");
        f4.txtNombre.setText("");
        f4.txtTelefono.setText("");
        f4.cbxEspecialidad.setSelectedIndex(0);
        f4.cbxHorario.setSelectedIndex(0);
        f4.cbxServicios.setSelectedIndex(0);
        f4.cbxTipo.setSelectedIndex(0);
    }

    //metodo para limpiar tabla
    public static void LimpiarTabla(DefaultTableModel modtabla) {
        modtabla.setRowCount(0);
    }

    //metodo para leer personal
    public static Personal LeerPersonal(Forma04 vista) {
        String nombre = vista.txtNombre.getText();
        String dni = vista.txtDni.getText();
        String telefono = vista.txtTelefono.getText();
        String correo = vista.txtCorreo.getText();
        String direccion = vista.txtDireccion.getText();
        String tipo = vista.cbxTipo.getSelectedItem().toString();
        String horario = vista.cbxHorario.getSelectedItem().toString();
        String especialidad = vista.cbxEspecialidad.getSelectedItem().toString();
        String servicios = vista.cbxServicios.getSelectedItem().toString();
        Object[] Registro = {nombre, dni, telefono, correo, direccion, tipo, horario, especialidad, servicios};
        return new Personal(Registro);
    }

}
