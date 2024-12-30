package Controlador;

import Mensaje.*;
import Modelo.*;
import Vista.*;
import java.awt.event.*;
import Proceso.*;

public class ControladorForma05 implements ActionListener {

    //Atributos
    Forma05 vista;
    CitaHashTable lista;
    Cita actual;
    ClienteArrayList listaCliente;
    MascotaListaEnlazada listaMascotas;
    int posicion;
    
    PersonalArbol arbol;
    PersonalNodo actualPersonal;

    //Metodo principal
    public ControladorForma05(Forma05 f5) {
        vista = f5;
        vista.btnAgregar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        vista.btnCliente.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        vista.btnMascota.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);
        vista.btnPersonal.addActionListener(this);
        
        listaCliente = new ClienteArrayList();
        listaCliente.RecuperararDeArchivo();
        listaMascotas = new MascotaListaEnlazada();
        listaMascotas = MascotaListaEnlazada.RecuperarDeArchivo();
        lista = new CitaHashTable();
        lista = CitaHashTable.RecuperarDeArchivo();
        ProcesosForma05.MostrarDatos(vista, lista);
        ProcesosForma05.AgregarServicio(vista.cbxServicio);
        arbol = new PersonalArbol();
        arbol = PersonalArbol.RecuperarDeArchivo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Guardar Cita
        if (e.getSource() == vista.btnAgregar) {
            Cita cita = ProcesosForma05.LeerCita(vista);
            lista.AgregarCita(cita);
            CitaHashTable.GuardarEnArchivo(lista);
            ProcesosForma05.MostrarDatos(vista, lista);
            ProcesosForma05.LimpiarEntradas(vista);
        }

        //Buscar Cita
        if (e.getSource() == vista.btnBuscar) {
            String codigo = vista.txtBuscar.getText();
            actual = lista.ObtenerCita(codigo);
            vista.txtCodigo.setText(actual.getCodigo());
            vista.txtNomCliente.setText(actual.getNomCliente());
            vista.cbxMascota.setSelectedItem(actual.getNomMascota());
            vista.cbxServicio.setSelectedItem(actual.getNomServicio());
            vista.txtNomPersonal.setText(actual.getNomPersonal());
            if (actual.isAtendida()) {
                vista.txtEstado.setText("Atendida");
            } else {
                if (actual.isCancelada()) {
                    vista.txtEstado.setText("Cancelada");
                } else {
                    vista.txtEstado.setText("Atendida");
                }
            }
        }

        //Editar Cita
        if (e.getSource() == vista.btnEditar) {
            Cita actualizado = ProcesosForma05.LeerCita(vista);
            lista.ActualizarCita(actualizado);
            CitaHashTable.GuardarEnArchivo(lista);
            ProcesosForma05.MostrarDatos(vista, lista);
            ProcesosForma05.LimpiarEntradas(vista);
        }

        //cambiar cita a cancelada
        if (e.getSource() == vista.btnCancelar) {
            ProcesosForma05.CancelarCita(actual);
            if (actual.isCancelada()) {
                vista.txtEstado.setText("Cancelada");
            } else {
                vista.txtEstado.setText("Pendiente");
            }
            CitaHashTable.GuardarEnArchivo(lista);
        }

        //metodo para buscar el nombre del cliente
        if (e.getSource() == vista.btnCliente) {
            String dni = Mensaje.Recibir("Ingrese el dni del cliente");
            listaCliente.RecuperararDeArchivo();
            posicion = ProcesosForma01.BuscarPorDni(listaCliente.Lista, dni, posicion);
            if (posicion != -1) {
                Cliente cli = listaCliente.RecuperarCliente(posicion);
                vista.txtNomCliente.setText(cli.getNombre());
            } else {
                Mensaje.Texto("Cliente no encontrado");
            }
        }

        //buscar mascotas por el nombre del dueño
        if (e.getSource() == vista.btnMascota) {
            String nombreDueño = vista.txtNomCliente.getText();
            ProcesosForma05.MostrarMascotasEnComboBox(vista.cbxMascota, listaMascotas, nombreDueño);
        }

        if (e.getSource() == vista.btnOrdenar) {
            CitaHashTable citasOrdenadas = ProcesosForma05.obtenerCitasOrdenadasPorCodigo(lista);
            // Mostrar los datos ordenados en la vista
            ProcesosForma05.MostrarDatos(vista, citasOrdenadas);
        }
        
        if (e.getSource() == vista.btnPersonal) {
            String dni = Mensaje.Recibir("Ingrese el DNI del Veterinario o Tecnico: ");
            actualPersonal = arbol.BuscarDni(dni);
            if (actualPersonal == null) {
                Mensaje.Error("No existe el personal", "Error");
            } else {
                vista.txtNomPersonal.setText(actualPersonal.getElemento().getNombre());
            }
        }

    }

}
