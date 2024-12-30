package Controlador;

import Vista.*;
import java.awt.event.*;
import javax.swing.*;
import Mensaje.*;
import Proceso.*;

public class ControladorMenu implements ActionListener {

    //Atributos
    FormaMenu vista;
    JMenuItem clientes, mascotas, servicios, personal, registrarcita, atendercita, salir;
    JMenuItem Opcion1, Opcion2, Opcion3, Opcion4, Opcion5, Opcion6, Opcion7;

    //Metodo princial
    public ControladorMenu(FormaMenu fmenu) {
        vista = fmenu;
        vista.setVisible(true);
        vista.setTitle("Veterinaria CAREVET");
        vista.setLocationRelativeTo(null);

        clientes = ProcesoMenu.MostrarOpciones(clientes, vista.mbMenu, "Clientes", this);
        Opcion2 = ProcesoMenu.MostrarOpciones(mascotas, vista.mbMenu, "Mascotas", this);
        Opcion3 = ProcesoMenu.MostrarOpciones(servicios, vista.mbMenu, "Servicios", this);
        Opcion4 = ProcesoMenu.MostrarOpciones(personal, vista.mbMenu, "Personal", this);
        Opcion5 = ProcesoMenu.MostrarOpciones(registrarcita, vista.mbMenu, "Registrar cita", this);
        Opcion6 = ProcesoMenu.MostrarOpciones(atendercita, vista.mbMenu, "Atender cita", this);
        Opcion7 = ProcesoMenu.MostrarOpciones(salir, vista.mbMenu, "Salir", this);
    }

    //Metodo que muestra la vista menu
    public void MostrarForma(JInternalFrame internal) {
        vista.dspEscritorio.removeAll();
        vista.dspEscritorio.add(internal);
        internal.setVisible(true);
        vista.dspEscritorio.repaint();
        internal.setLocation(0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Opcion Clientes
        if (e.getSource() == clientes) {
            Forma01 f1 = new Forma01();
            ControladorForma01 cf1 = new ControladorForma01(f1);
            f1.setTitle("Clientes");
            MostrarForma(f1);
        }

        //Opcion Mascotas
        if (e.getSource() == Opcion2) {
            Forma02 f2 = new Forma02();
            ControladorForma02 cf2 = new ControladorForma02(f2);
            f2.setTitle("Mascotas");
            MostrarForma(f2);
        }

        //Opcion Servicios
        if (e.getSource() == Opcion3) {
            Forma03 f3 = new Forma03();
            ControladorForma03 cf3 = new ControladorForma03(f3);
            f3.setTitle("Servicios");
            MostrarForma(f3);
        }

        //Opcion Personal
        if (e.getSource() == Opcion4) {
            Forma04 f4 = new Forma04();
            ControladorForma04 cf4 = new ControladorForma04(f4);
            f4.setTitle("Personal");
            MostrarForma(f4);
        }

        //Opcion Registrar Cita
        if (e.getSource() == Opcion5) {
            Forma05 f5 = new Forma05();
            ControladorForma05 cf5 = new ControladorForma05(f5);
            f5.setTitle("Registrar Cita");
            MostrarForma(f5);
        }

        //Opcion Atender Cita
        if (e.getSource() == Opcion6) {
            Forma06 f6 = new Forma06();
            ControladorForma06 cf6 = new ControladorForma06(f6);
            f6.setTitle("Atender Cita");
            MostrarForma(f6);
        }

        //Opcion Cerrar Sesion
        if (e.getSource() == Opcion7) {
            int respuesta = Mensaje.Confirmar("¿Desea cerrar sesión?", "Confirmar - Cerrar sesión");
            if (respuesta == 0) {
                ControladorFormaLogin login = new ControladorFormaLogin(new FormaLogin());
                vista.setVisible(false);
            }
        }

    }

}
