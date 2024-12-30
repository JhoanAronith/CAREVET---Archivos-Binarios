package Proceso;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class ProcesoMenu{
    
    //Metodo que muestra las opciones en el menu principal
    public static JMenuItem MostrarOpciones(JMenuItem opcion, JMenuBar mbMenu, String titulo, ActionListener listener) {
        Color celeste = new Color(0, 183, 183);
        Color blanco = new Color(255, 255 ,255);
        opcion = new JMenuItem(titulo);
        mbMenu.add(opcion);
        opcion.addActionListener(listener);
        opcion.setBackground(celeste);
        opcion.setForeground(blanco);
        Dimension tamanoMenuItem = new Dimension(150, 30);
        opcion.setPreferredSize(tamanoMenuItem);
        Border borde = BorderFactory.createLineBorder(blanco, 1);
        opcion.setBorder(borde);
        opcion.setHorizontalAlignment(SwingConstants.CENTER);
        return opcion;
    }
    
}
