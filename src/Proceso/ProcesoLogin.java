package Proceso;

import javax.swing.*;
import Modelo.*;
import Vista.*;
import java.util.*;

public class ProcesoLogin {

    //Metodo que muestra la contraseña
    public static void MostrarPassword(JCheckBox cb, JPasswordField jp) {
        if (cb.isSelected()) {
            jp.setEchoChar((char) 0);
        } else {
            jp.setEchoChar('*');
        }
    }

    //Metodo que lee un nuevo usuario
    public static Usuario LeerUsuario(FormaLogin fl) {
        Usuario user = new Usuario();
        user.setUser(fl.txtRegistrarUser.getText());
        user.setPassword(fl.txtRegistrarPassword.getText());
        return user;
    }

    //metodo que limpia las entradas
    public static void LimpiarEntradas(FormaLogin fl) {
        fl.txtRegistrarUser.setText("");
        fl.txtRegistrarPassword.setText("");
        fl.txtUser.setText("");
        fl.txtPassword.setText("");
    }

    //Metodo que verifica los datos de los usuarios
    public static boolean VerificarDatos(ArrayList<Usuario> lista, String user, String password) {
        for(Usuario usuario : lista) {
            if (usuario.getUser().equals(user) && usuario.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
}
