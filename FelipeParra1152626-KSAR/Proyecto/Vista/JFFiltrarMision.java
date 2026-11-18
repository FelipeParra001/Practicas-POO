package Proyecto.Vista;
import Proyecto.Modelo.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Write a description of class JFFiltrarMision here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JFFiltrarMision extends JFrame
{
     public static final String TODOS = "Todos";
 
    private JComboBox<String> cmbEquipo;
    private JComboBox<String> cmbMunicipio;
    private DefaultTableModel modelo;
    private JLabel lblResumen;
    
    //Botones 
    private JButton btnFiltrar;
    private JButton btnLimpiar;
    private JButton btnCerrar;
    
 
    public JFFiltrarMision( ) {
        
        setTitle("Filtrar misiones");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(820, 480);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(crearNorte(), BorderLayout.NORTH);
        add(crearCentro(), BorderLayout.CENTER);
        add(crearSur(), BorderLayout.SOUTH);
        
    }
 
    private JPanel crearNorte() {
        JPanel norte = new JPanel();
        norte.setLayout(new BoxLayout(norte, BoxLayout.Y_AXIS));
 
        JPanel barra = new JPanel(new BorderLayout());
        barra.setBackground(new Color(15, 32, 68));
        barra.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        JLabel titulo = new JLabel("K-SAR ECID");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setForeground(Color.WHITE);
        JLabel subtitulo = new JLabel("Filtrar misiones por equipo y municipio");
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
 
        // Filtros
        JPanel filtros = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        filtros.setBackground(Color.WHITE);
        filtros.setBorder(BorderFactory.createTitledBorder("Filtros"));
 
        cmbEquipo = new JComboBox<>();
        
        
        cmbMunicipio = new JComboBox<>();
        cmbMunicipio.addItem(TODOS);
       
        btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setBackground(new Color(15, 32, 68));
        btnFiltrar.setForeground(Color.WHITE);
        btnFiltrar.setFocusPainted(false);
       
 
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setFocusPainted(false);
       
 
        filtros.add(Estilo.etiqueta("Equipo:"));
        filtros.add(cmbEquipo);
        filtros.add(Estilo.etiqueta("Municipio:"));
        filtros.add(cmbMunicipio);
        filtros.add(btnFiltrar);
        filtros.add(btnLimpiar);
 
        norte.add(barra);
        norte.add(filtros);
        return norte;
    }
 
    private JPanel crearCentro() {
        JPanel centro = new JPanel(new BorderLayout());
        centro.setBackground(Color.WHITE);
        String[] cols = {"Código", "Fecha", "Equipo", "Binomio", "Municipio", "Lugar",
                         "Horas", "Sobrevivientes", "Fallecidos"};
        modelo = new DefaultTableModel(cols, 0);
        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(22);
        centro.add(new JScrollPane(tabla), BorderLayout.CENTER);
        return centro;
    }
 
    private JPanel crearSur() {
        JPanel sur = new JPanel(new BorderLayout());
        sur.setBackground(Color.WHITE);
        sur.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12));
        lblResumen = new JLabel(" ");
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setFocusPainted(false);
        sur.add(lblResumen, BorderLayout.CENTER);
        sur.add(btnCerrar, BorderLayout.EAST);
        return sur;
    }
 
     public void mostrarMisiones(ArrayList<Mision> lista) {
        modelo.setRowCount(0);
        for (Mision m : lista) {
            Municipio mun = m.obtenerMunicipio();
            String lugar = (m.getEvento() != null && m.getEvento().getLugar() != null)
                    ? m.getEvento().getLugar().getNombre() : "-";
            modelo.addRow(new Object[]{
                m.getCodigo(),
                m.getFecha() != null ? m.getFecha().toString() : "-",
                m.getEquipo() != null ? m.getEquipo().getNombre() : "-",
                m.getBinomio() != null ? m.getBinomio().resumen() : "-",
                mun != null ? mun.getNombre() : "-",
                lugar,
                m.getHorasLabor(),
                m.getSobrevivientes(),
                m.getFallecidos()
            });
        }
   }
   
   //Start GetterSetterExtension Source Code

    /**GET Method Propertie cmbEquipo*/
    public JComboBox<String> getCmbEquipo(){
        return this.cmbEquipo;
    }//end method getCmbEquipo

    /**GET Method Propertie cmbMunicipio*/
    public JComboBox<String> getCmbMunicipio(){
        return this.cmbMunicipio;
    }//end method getCmbMunicipio

    /**GET Method Propertie lblResumen*/
    public JLabel getLblResumen(){
        return this.lblResumen;
    }//end method getLblResumen

    /**GET Method Propertie btnFiltrar*/
    public JButton getBtnFiltrar(){
        return this.btnFiltrar;
    }//end method getBtnFiltrar

    /**GET Method Propertie btnLimpiar*/
    public JButton getBtnLimpiar(){
        return this.btnLimpiar;
    }//end method getBtnLimpiar

    /**GET Method Propertie btnCerrar*/
    public JButton getBtnCerrar(){
        return this.btnCerrar;
    }//end method getBtnCerrar

   //End GetterSetterExtension Source Code
}