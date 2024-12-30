package Mensaje;

import javax.swing.JOptionPane;

public class Mensaje {
    
    //Mensaje de error
    public static void Error(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }
    
    //Mensaje para confirmar
    public static int Confirmar(String mensaje, String titulo) {
        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION);
        return respuesta;
    }
    
    //Mensaje normal
    public static void Texto(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    //Mensaje para recibir datos
    public static String Recibir(String mensaje) {
        String input = JOptionPane.showInputDialog(null, mensaje);
        return input;
    }
    
}

