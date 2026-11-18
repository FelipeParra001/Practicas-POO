package Proyecto.Vista;
import javax.swing.*;
import java.awt.*;


/**
 * Write a description of class Estilo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Estilo
{
    
    public static JLabel etiqueta(String texto) {
        JLabel l = new JLabel(texto);
        l.setFont(new Font("Arial", Font.BOLD, 12));
        return l;
    }
    
}