package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
import javax.swing.table.*;
import Proceso.*;
import Mensaje.*;

public class ControladorForma04 implements ActionListener {

    //Atributos
    Forma04 vista;
    DefaultTableModel modtabla;
    PersonalArbol arbol;
    PersonalNodo actual;

    //Metodo principal del controlador
    public ControladorForma04(Forma04 f4) {
        vista = f4;
        vista.btnAgregar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);

        String[] columnNames = {"Nombre", "DNI", "Telefono", "Correo", "Direccion", "Tipo", "Horario", "Especialidad", "Servicio"};
        modtabla = new DefaultTableModel(columnNames, 0);
        vista.tblPersonal.setModel(modtabla);

        modtabla = (DefaultTableModel) vista.tblPersonal.getModel();
        arbol = new PersonalArbol();
        arbol = PersonalArbol.RecuperarDeArchivo();
        arbol.MostrarDatos(arbol.getRaiz(), modtabla);
        ProcesosForma04.AgregarEspecialidad(vista.cbxEspecialidad);
        ProcesosForma04.AgregarTipo(vista.cbxTipo);
        ProcesosForma04.AgregarHorario(vista.cbxHorario);
        ProcesosForma04.AgregarServicio(vista.cbxServicios);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Agregar Personal
        if (e.getSource() == vista.btnAgregar) {
            Personal per = ProcesosForma04.LeerPersonal(vista);
            arbol.setRaiz(arbol.Agregar(arbol.getRaiz(), per));
            ProcesosForma04.LimpiarEntradas(vista);
            PersonalArbol.GuardarEnArchivo(arbol);
            ProcesosForma04.LimpiarTabla(modtabla);
            arbol.MostrarDatos(arbol.getRaiz(), modtabla);
        }
        
        //Buscar personal
        if (e.getSource() == vista.btnBuscar) {
            String dni = vista.txtBuscar.getText();
            actual = arbol.BuscarDni(dni);
            if (actual == null) {
                Mensaje.Error("No existe el dni", "Error");
            } else {
                vista.txtNombre.setText(actual.getElemento().getNombre());
                vista.txtDni.setText(actual.getElemento().getDni());
                vista.txtDireccion.setText(actual.getElemento().getDireccion());
                vista.txtCorreo.setText(actual.getElemento().getCorreo());
                vista.txtTelefono.setText(actual.getElemento().getTelefono());
                vista.cbxEspecialidad.setSelectedItem(actual.getElemento().getEspecialidad());
                vista.cbxHorario.setSelectedItem(actual.getElemento().getHorario());
                vista.cbxServicios.setSelectedItem(actual.getElemento().getServicio());
                vista.cbxTipo.setSelectedItem(actual.getElemento().getTipo());
            }
            vista.txtBuscar.setText("");
        }

        //Eliminar personal
        if (e.getSource() == vista.btnEliminar) {
            String dni = vista.txtDni.getText();
            arbol.setRaiz(arbol.Eliminar(arbol.getRaiz(), dni));
            ProcesosForma04.LimpiarEntradas(vista);
            PersonalArbol.GuardarEnArchivo(arbol);
            ProcesosForma04.LimpiarTabla(modtabla);
            arbol.MostrarDatos(arbol.getRaiz(), modtabla);
        }

        
        //Editat personal
        if (e.getSource() == vista.btnEditar) {
            Personal actualizado = ProcesosForma04.LeerPersonal(vista);
            arbol.Actualizar(arbol.getRaiz(), actualizado);
            PersonalArbol.GuardarEnArchivo(arbol);
            ProcesosForma04.LimpiarTabla(modtabla);
            arbol.MostrarDatos(arbol.getRaiz(), modtabla);
            ProcesosForma04.LimpiarEntradas(vista);
        }
        
        //Limpiar Entradas
        if (e.getSource() == vista.btnLimpiar) {
            ProcesosForma04.LimpiarEntradas(vista);
        }  

    }

}
