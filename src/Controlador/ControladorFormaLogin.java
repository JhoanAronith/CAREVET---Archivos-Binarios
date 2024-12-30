package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
import Proceso.*;
import Mensaje.*;

public class ControladorFormaLogin implements ActionListener {

    //Atributos
    FormaLogin vista;
    UsuarioArrayList lista;
    Usuario user;

    //Metodo principal
    public ControladorFormaLogin(FormaLogin flogin) {
        vista = flogin;

        vista.setTitle("Ingresar al sistema");
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.btnIngresar.addActionListener(this);
        vista.btnMostrar.addActionListener(this);
        vista.btnRegistrar.addActionListener(this);

        lista = new UsuarioArrayList();
        lista.RecuperararDeArchivo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //registrar nuevo usuario
        if (e.getSource() == vista.btnRegistrar) {
            user = ProcesoLogin.LeerUsuario(vista);
            lista.AgregarUsuario(user);
            lista.GuardarEnBinario();
            ProcesoLogin.LimpiarEntradas(vista);
            Mensaje.Texto("Usuario Registrado correctamente");
        }

        //Ingresar al menú principal
        if (e.getSource() == vista.btnIngresar) {
            String user = vista.txtUser.getText();
            String password = vista.txtPassword.getText();
            lista.RecuperararDeArchivo();
            boolean registrado = ProcesoLogin.VerificarDatos(lista.Lista, user, password);
            if (registrado) {
                ControladorMenu cm = new ControladorMenu(new FormaMenu());
                vista.setVisible(false);
                ProcesoLogin.LimpiarEntradas(vista);
            } else {
                Mensaje.Error("Usuario o contraseña incorrectos", "Error al iniciar");
                ProcesoLogin.LimpiarEntradas(vista);
            }
        }

        //Mostrar u ocultar contraseña
        if (e.getSource() == vista.btnMostrar) {
            ProcesoLogin.MostrarPassword(vista.btnMostrar, vista.txtPassword);
        }

    }

}
