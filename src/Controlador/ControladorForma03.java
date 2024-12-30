package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
import Proceso.*;
import Mensaje.*;

public class ControladorForma03 implements ActionListener {

    //Atributos
    Forma03 vista;
    ServicioArreglo Lista;
    Servicio ser;
    int posicion;

    //Metodo principal
    public ControladorForma03(Forma03 f3) {
        vista = f3;
        vista.btnAgregar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);

        Lista = new ServicioArreglo();
        Lista.RecuperarDeArchivo();
        Lista.ActualizarCantidadSer();
        ProcesosForma03.MostrarEnTabla(vista, Lista.getLista());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Guardar Servicio
        if (e.getSource() == vista.btnAgregar) {
            ser = ProcesosForma03.LeerServicio(vista);
            Lista.AgregarServicio(ser);
            Lista.GuardarEnArchivo();
            ProcesosForma03.MostrarEnTabla(vista, Lista.getLista());
            ProcesosForma03.LimpiarEntradas(vista);
        }

        //Buscar por codigo
        if (e.getSource() == vista.btnBuscar) {
            String codigo = vista.txtBuscar.getText();
            Lista.RecuperarDeArchivo();
            Lista.ActualizarCantidadSer();
            posicion = ProcesosForma03.BusquedaBinariaPorCodigo(Lista.getLista(), codigo);
            if (posicion == -1) {
                Mensaje.Texto("El codigo no existe");
            } else {
                Servicio ser = Lista.RecuperarServicio(posicion);
                vista.txtNombre.setText(ser.getNombre());
                vista.txtCodigo.setText(ser.getCodigo());
                vista.txtCosto.setText(ser.getCosto());
                vista.txtDescripcion.setText(ser.getDescripcion());
                vista.txtDuracion.setText(ser.getDuracion());
            }
            vista.txtBuscar.setText("");
        }

        //Editar servicio
        if (e.getSource() == vista.btnEditar) {
            Servicio actualizado = ProcesosForma03.LeerServicio(vista);
            Lista.ActualizarServicio(posicion, actualizado);
            Lista.GuardarEnArchivo();
            ProcesosForma03.MostrarEnTabla(vista, Lista.getLista());
            ProcesosForma03.LimpiarEntradas(vista);
        }

        //Eliminar Servicio
        if (e.getSource() == vista.btnEliminar) {
            Mensaje.Confirmar("Desea eliminar el servicio: " + Lista.RecuperarServicio(posicion).getNombre(), "Confirmar");
            Lista.EliminarServicio(posicion);
            Lista.GuardarEnArchivo();
            ProcesosForma03.MostrarEnTabla(vista, Lista.getLista());
        }
        
        //Ordenar por codigo
        if (e.getSource() == vista.btnOrdenar) {
            Servicio[] listaOrdenada = null;
            Servicio[] lista = Lista.getLista();
            if (lista == null) {
                Mensaje.Error("La lista de servicios es nula", "Error");
            }
            if (vista.rbtnAsce.isSelected()) {
                listaOrdenada = ProcesosForma03.OrdenarPorCodigoASC(lista);
            } else {
                if (vista.rbtnDesce.isSelected()) {
                    listaOrdenada = ProcesosForma03.OrdenarPorCodigoDES(lista);
                }
            }
            if (listaOrdenada != null) {
                ProcesosForma03.MostrarEnTabla(vista, lista);
            }
        }

    }
}
