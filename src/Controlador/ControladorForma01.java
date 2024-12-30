package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
import Proceso.*;
import Mensaje.*;

public class ControladorForma01 implements ActionListener {

    //Variables 
    Forma01 vista;
    ClienteArrayList lista;
    Cliente cli;
    int posicion;
    MascotaListaEnlazada ListaMascota;
    MascotaNodo actual;

    //Constructor
    public ControladorForma01(Forma01 f1) {
        vista = f1;

        vista.btnAgregar.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);

        ListaMascota = MascotaListaEnlazada.RecuperarDeArchivo();
        lista = new ClienteArrayList();
        lista.RecuperararDeArchivo();
        ProcesosForma01.MostrarDatos(vista.tblClientes, lista.Lista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Agregar Cliente
        if (e.getSource() == vista.btnAgregar) {
            cli = ProcesosForma01.LeerCliente(vista);
            lista.AgregarCliente(cli);
            lista.GuardarEnBinario();
            ProcesosForma01.LimpiarEntradas(vista);
            ProcesosForma01.MostrarDatos(vista.tblClientes, lista.Lista);
        }

        //Limpiar Entradas
        if (e.getSource() == vista.btnLimpiar) {
            ProcesosForma01.LimpiarEntradas(vista);
        }

        //Buscar Cliente
        if (e.getSource() == vista.btnBuscar) {
            String dni = vista.txtBuscar.getText();
            lista.RecuperararDeArchivo();
            posicion = ProcesosForma01.BuscarPorDni(lista.Lista, dni, posicion);
            if (posicion != -1) {
                Cliente cli = lista.RecuperarCliente(posicion);
                vista.txtNombre.setText(cli.getNombre());
                vista.txtDni.setText(cli.getDni());
                vista.txtTelefono.setText(cli.getTelefono());
                vista.txtCorreo.setText(cli.getCorreo());
                vista.txtDireccion.setText(cli.getDireccion());

                String nombreDueño = cli.getNombre();
                actual = ListaMascota.BuscarMascotaDueño(nombreDueño);
                if (actual == null) {
                    Mensaje.Error(nombreDueño + " no existe.", "Error al buscar");
                } else {
                    ProcesosForma01.MostrarMascotas(vista.tblMascotas, ListaMascota, nombreDueño);
                }

            } else {
                Mensaje.Texto("Cliente no encontrado");
            }
            vista.txtBuscar.setText("");
        }

        //Editar Cliente
        if (e.getSource() == vista.btnEditar) {
            Cliente actualizado = ProcesosForma01.LeerCliente(vista);
            lista.ActualizarCliente(posicion, actualizado);
            lista.GuardarEnBinario();
            ProcesosForma01.MostrarDatos(vista.tblClientes, lista.Lista);
            ProcesosForma01.LimpiarEntradas(vista);
        }

        //Eliminar Cliente
        if (e.getSource() == vista.btnEliminar) {
            int respuesta = Mensaje.Confirmar("¿Seguro de eliminar al cliente?", "Confirmar eliminación de cliente");
            if (respuesta == 0) {
                lista.EliminarCliente(posicion);
                lista.GuardarEnBinario();
                ProcesosForma01.MostrarDatos(vista.tblClientes, lista.Lista);
                ProcesosForma01.LimpiarEntradas(vista);
            }
        }
        
        //Ordenar Cliente por nombre ascendente
        if (e.getSource() == vista.btnOrdenar) {
            ProcesosForma01.OrdenPorNombresASC(lista.Lista);
            ProcesosForma01.MostrarDatos(vista.tblClientes, lista.Lista);
        }

    }

}
