package Proyecto.Vista;
import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class JFListarGuia_Perro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JFListarGuia_Perro extends JFrame 
{

    private JComboBox<String> cmbGuia;
    private JTextArea txtResultado;
    
    //Botones
    private JButton btnPerros;
    private JButton btnTodos;
    private JButton btnCerrar;

    public JFListarGuia_Perro( ) {
       
        setTitle("Listar guías y perros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(560, 560);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(crearNorte(), BorderLayout.NORTH);
        add(crearCentro(), BorderLayout.CENTER);
        add(crearSur(), BorderLayout.SOUTH);
       
    }
    
    private JPanel crearNorte() {
        JPanel barra = new JPanel(new BorderLayout());
        barra.setBackground(new Color(15, 32, 68));
        barra.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        JLabel titulo = new JLabel("K-SAR ECID");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setForeground(Color.WHITE);
        JLabel subtitulo = new JLabel("Listar guías y perros");
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 11));
        subtitulo.setForeground(new Color(200, 210, 230));
        JPanel textos = new JPanel();
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));
        textos.setOpaque(false);
        textos.add(titulo);
        textos.add(subtitulo);
        ImageIcon icono = new ImageIcon("imagen/logo.png");
        Image img = icono.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(img));
        logo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        JPanel izquierda = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        izquierda.setOpaque(false);
        izquierda.add(logo);
        izquierda.add(textos);
        barra.add(izquierda, BorderLayout.WEST);
        return barra;
    }

     private JPanel crearCentro() {
        JPanel centro = new JPanel(new BorderLayout());
        centro.setBackground(Color.WHITE);

        
        JPanel porGuia = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        porGuia.setBackground(Color.WHITE);
        porGuia.setBorder(BorderFactory.createTitledBorder("Perros por guía"));
        cmbGuia = new JComboBox<>();
        
        btnPerros = new JButton("Listar perros del guía");
        btnPerros.setFocusPainted(false);
        
        porGuia.add(new JLabel("Guía:"));
        porGuia.add(cmbGuia);
        porGuia.add(btnPerros);

        txtResultado = new JTextArea(18, 40);
        txtResultado.setEditable(false);
        txtResultado.setLineWrap(true);
        txtResultado.setWrapStyleWord(true);
        txtResultado.setBackground(new Color(245, 245, 245));

        centro.add(porGuia, BorderLayout.NORTH);
        centro.add(new JScrollPane(txtResultado), BorderLayout.CENTER);
        return centro;
    }

      private JPanel crearSur() {
        JPanel sur = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 8));
        sur.setBackground(Color.WHITE);
        btnTodos = new JButton("Listar todos");
        btnTodos.setBackground(new Color(15, 32, 68));
        btnTodos.setForeground(Color.WHITE);
        btnTodos.setFocusPainted(false);
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setFocusPainted(false);
        
        sur.add(btnTodos);
        sur.add(btnCerrar);
        return sur;
    }
    
    //Start GetterSetterExtension Source Code

    /**GET Method Propertie cmbGuia*/
    public JComboBox<String> getCmbGuia(){
        return this.cmbGuia;
    }//end method getCmbGuia

    /**GET Method Propertie txtResultado*/
    public JTextArea getTxtResultado(){
        return this.txtResultado;
    }//end method getTxtResultado

    /**GET Method Propertie btnPerros*/
    public JButton getBtnPerros(){
        return this.btnPerros;
    }//end method getBtnPerros

    /**GET Method Propertie btnTodos*/
    public JButton getBtnTodos(){
        return this.btnTodos;
    }//end method getBtnTodos

    /**GET Method Propertie btnCerrar*/
    public JButton getBtnCerrar(){
        return this.btnCerrar;
    }//end method getBtnCerrar

   //End GetterSetterExtension Source Code

 
}