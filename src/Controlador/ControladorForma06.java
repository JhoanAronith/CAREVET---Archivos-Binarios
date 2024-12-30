package Controlador;

import Modelo.*;
import Vista.Forma06;
import java.awt.event.*;
import Proceso.*;

public class ControladorForma06 implements ActionListener {

    Forma06 vista;
    CitaHashTable lista;
    Cita actual;
    ClienteArrayList listaCliente;
    MascotaListaEnlazada listaMascotas;
    MascotaNodo actualMascota;

    public ControladorForma06(Forma06 f6) {
        vista = f6;
        vista.btnCitaAtendida.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnInfoMascota.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);

        listaCliente = new ClienteArrayList();
        listaCliente.RecuperararDeArchivo();
        listaMascotas = new MascotaListaEnlazada();
        listaMascotas = MascotaListaEnlazada.RecuperarDeArchivo();
        lista = new CitaHashTable();
        lista = CitaHashTable.RecuperarDeArchivo();
        ProcesosForma06.EvitarEdicion(f6);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnCitaAtendida) {
            ProcesosForma06.MostrarResumen(vista);
            actual = lista.ObtenerCita(vista.txtCodigoCita.getText());
            ProcesosForma06.AtenderCita(actual);
            MascotaListaEnlazada.GuardarEnArchivo(listaMascotas);
            vista.txaDiagnostico.setText("");
            vista.txaMedicinas.setText("");
            vista.txaRecomendaciones.setText("");
            vista.txaRecomendaciones.setText("");
        }
        
        if (e.getSource() == vista.btnBuscar) {
            String codigo = vista.txtBuscarCodigo.getText();
            actual = lista.ObtenerCita(codigo);
            vista.txtCodigoCita.setText(actual.getCodigo());
            vista.txtFechaCita.setText(actual.getFechaHora());
            vista.txtNombreCliente.setText(actual.getNomCliente());
            vista.txtNombreMascota.setText(actual.getNomMascota());
            vista.txtPersonalCita.setText(actual.getNomPersonal());
            vista.txtServicioCita.setText(actual.getNomServicio());
        }
        
        if (e.getSource() == vista.btnInfoMascota) {
            String nombre = vista.txtNombreMascota.getText();
            actualMascota = listaMascotas.BuscarMascota(nombre);
            ProcesosForma06.MostrarDatosNodoMascota(actualMascota, vista);
        }
        
        if (e.getSource() == vista.btnLimpiar) {
            ProcesosForma06.LimpiarInformacion(vista);
        }

    }

}
