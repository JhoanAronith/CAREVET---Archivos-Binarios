package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
import Proceso.*;
import Mensaje.*;

public class ControladorForma02 implements ActionListener {

    //Atributos
    MascotaListaEnlazada Lista;
    Forma02 vista;
    MascotaNodo actual;
    ClienteArrayList listaCliente;
    int posicion;

    //Metodo de la clase
    public ControladorForma02(Forma02 f2) {
        vista = f2;
        vista.btnAgregar.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        vista.btnAlergias.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnDueño.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);
        vista.btnVacunas.addActionListener(this);

        listaCliente = new ClienteArrayList();
        listaCliente.RecuperararDeArchivo();
        Lista = MascotaListaEnlazada.RecuperarDeArchivo();
        ProcesosForma02.AgregarSexo(f2.cbxSexo);
        ProcesosForma02.MostrarDatosGenerales(vista.tblsMascotas, Lista);
        actual = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Agregar Mascota
        if (e.getSource() == vista.btnAgregar) {
            Mascota nuevaMascota = ProcesosForma02.LeerMascota(vista);
            if (nuevaMascota == null) {
                Mensaje.Error("Error al leer los datos de la mascota.", "Error");
                return;
            }
            MascotaNodo nuevoNodo = new MascotaNodo(nuevaMascota);
            Lista.AgregarNodoFinal(nuevoNodo);
            MascotaListaEnlazada.GuardarEnArchivo(Lista);
            ProcesosForma02.MostrarDatosGenerales(vista.tblsMascotas, Lista);
            ProcesosForma02.LimpiarEntradas(vista);
            actual = nuevoNodo;
        }

        //Agregar vacuna
        if (e.getSource() == vista.btnVacunas) {
            ProcesosForma02.AgregarVacuna(vista, actual.getMas());
            ProcesosForma02.MostrarDatosVacunas(vista.tblVacunas, actual.getMas().getVacunas());
            MascotaListaEnlazada.GuardarEnArchivo(Lista);
        }

        //Agregar alergias
        if (e.getSource() == vista.btnAlergias) {
            ProcesosForma02.AgregarAlergia(vista, actual.getMas());
            MascotaListaEnlazada.GuardarEnArchivo(Lista);
            ProcesosForma02.MostrarDatosAlergias(vista.tblAlergias, actual.getMas().getAlergias());
        }

        //Limpiar entradas
        if (e.getSource() == vista.btnLimpiar) {
            ProcesosForma02.LimpiarEntradas(vista);
        }

        //Buscar mascota
        if (e.getSource() == vista.btnBuscar) {
            String nombre = vista.txtBuscar.getText();
            actual = Lista.BuscarMascota(nombre);
            if (actual == null) {
                Mensaje.Error(nombre + " no existe.", "Error al buscar");
            } else {
                ProcesosForma02.MostrarDatosNodo(actual, vista);
                ProcesosForma02.MostrarDatosVacunas(vista.tblVacunas, actual.getMas().getVacunas());
                ProcesosForma02.MostrarDatosAlergias(vista.tblAlergias, actual.getMas().getAlergias());
                vista.txtBuscar.setText("");
            }
        }

        //Eliminar Mascota
        if (e.getSource() == vista.btnEliminar) {
            if (actual != null) {
                int respuesta = Mensaje.Confirmar("¿Desea eliminar a " + actual.mas.getNombre() + "?", "Confirmar");
                if (respuesta == 0) {
                    Lista.EliminarMascota(actual);
                    ProcesosForma02.MostrarDatosGenerales(vista.tblsMascotas, Lista);
                    ProcesosForma02.LimpiarEntradas(vista);
                    ProcesosForma02.MostrarDatosVacunas(vista.tblVacunas, actual.getMas().getVacunas());
                    ProcesosForma02.MostrarDatosAlergias(vista.tblAlergias, actual.getMas().getAlergias());
                    MascotaListaEnlazada.GuardarEnArchivo(Lista);
                }
            }
        }

        //Editar mascota
        if (e.getSource() == vista.btnEditar) {
            Mascota actualizado = ProcesosForma02.LeerMascota(vista);
            Lista.ActualizarMascota(actual, actualizado);
            ProcesosForma02.MostrarDatosGenerales(vista.tblsMascotas, Lista);
            MascotaListaEnlazada.GuardarEnArchivo(Lista);
            ProcesosForma02.LimpiarEntradas(vista);
        }

        //Buscar dueño de la mascota
        if (e.getSource() == vista.btnDueño) {
            String dni = Mensaje.Recibir("Ingrese el dni del dueño");
            listaCliente.RecuperararDeArchivo();
            posicion = ProcesosForma01.BuscarPorDni(listaCliente.Lista, dni, posicion);
            if (posicion != -1) {
                Cliente cli = listaCliente.RecuperarCliente(posicion);
                vista.txtDueño.setText(cli.getNombre());
            } else {
                Mensaje.Texto("Cliente no encontrado");
            }
        }

        //Ordenar datos a - z
        if (e.getSource() == vista.btnOrdenar) {
            Lista.ordenarPorNombre();
            ProcesosForma02.MostrarDatosGenerales(vista.tblsMascotas, Lista);
            MascotaListaEnlazada.GuardarEnArchivo(Lista);
        }

    }

}
