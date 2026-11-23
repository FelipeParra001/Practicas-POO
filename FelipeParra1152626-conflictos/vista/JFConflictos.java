package vista;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana de conflictos belicos. Solo tiene los componentes graficos.
 * 
 * @author Andres Felipe Parra Castellanos
 * @version 1.0
 */
public class JFConflictos extends JFrame
{
    // ------------------------------ Conflicto ------------------------------
    private JTextField txtNombreConflicto;
    private JTextField txtPais;
    private JComboBox<String> cbTipoConflicto;
    private JTextField txtMuertos;
    private JTextField txtHeridos;
    private JTextField txtDetalle;
    private JButton btnRegistrarConflicto;
    
    // ---------------------------- Grupo armado ----------------------------
    private JTextField txtCodigoGrupo;
    private JTextField txtNombreGrupo;
    private JTextField txtLider;
    private JTextField txtApoyos;
    private JButton btnRegistrarGrupo;
    
    // ------------------------------- Division -------------------------------
    private JTextField txtGrupoDivision;
    private JTextField txtConsecutivo;
    private JTextField txtBarcos;
    private JTextField txtAviones;
    private JTextField txtHombres;
    private JTextField txtTanques;
    private JTextField txtBajas;
    private JButton btnAgregarDivision;
    
    // ------------------------------- Reporte -------------------------------
    private JTextArea txtReporte;
    private JButton btnReporte;
    private JButton btnLimpiar;
    private JButton btnSalir;
    
    public JFConflictos()
    {
        setTitle("Conflictos belicos");
        setSize(950, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        JPanel panelDatos = new JPanel(new GridLayout(1, 3, 10, 10));
        panelDatos.add(crearPanelConflicto());
        panelDatos.add(crearPanelGrupo());
        panelDatos.add(crearPanelDivision());
        add(panelDatos, BorderLayout.NORTH);
        
        txtReporte = new JTextArea();
        txtReporte.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtReporte);
        scroll.setBorder(BorderFactory.createTitledBorder("Reporte"));
        add(scroll, BorderLayout.CENTER);
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnReporte = new JButton("Ver reporte");
        btnLimpiar = new JButton("Limpiar");
        btnSalir = new JButton("Salir");
        panelBotones.add(btnReporte);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);
        add(panelBotones, BorderLayout.SOUTH);
    }
    
    private JPanel crearPanelConflicto()
    {
        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Registrar conflicto"));
        panel.add(new JLabel("Nombre"));
        txtNombreConflicto = new JTextField();
        panel.add(txtNombreConflicto);
        panel.add(new JLabel("Pais"));
        txtPais = new JTextField();
        panel.add(txtPais);
        panel.add(new JLabel("Tipo"));
        cbTipoConflicto = new JComboBox<String>(new String[]{"Territorial", "Religioso", "Economico", "Racial"});
        panel.add(cbTipoConflicto);
        panel.add(new JLabel("Muertos"));
        txtMuertos = new JTextField();
        panel.add(txtMuertos);
        panel.add(new JLabel("Heridos"));
        txtHeridos = new JTextField();
        panel.add(txtHeridos);
        panel.add(new JLabel("Detalle (region, religion...)"));
        txtDetalle = new JTextField();
        panel.add(txtDetalle);
        panel.add(new JLabel(""));
        btnRegistrarConflicto = new JButton("Registrar conflicto");
        panel.add(btnRegistrarConflicto);
        return panel;
    }
    
    private JPanel crearPanelGrupo()
    {
        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Registrar grupo armado"));
        panel.add(new JLabel("Codigo"));
        txtCodigoGrupo = new JTextField();
        panel.add(txtCodigoGrupo);
        panel.add(new JLabel("Nombre"));
        txtNombreGrupo = new JTextField();
        panel.add(txtNombreGrupo);
        panel.add(new JLabel("Lider politico"));
        txtLider = new JTextField();
        panel.add(txtLider);
        panel.add(new JLabel("Apoyos del lider"));
        txtApoyos = new JTextField();
        panel.add(txtApoyos);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        btnRegistrarGrupo = new JButton("Registrar grupo");
        panel.add(btnRegistrarGrupo);
        return panel;
    }
    
    private JPanel crearPanelDivision()
    {
        JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Agregar division a un grupo"));
        panel.add(new JLabel("Codigo del grupo"));
        txtGrupoDivision = new JTextField();
        panel.add(txtGrupoDivision);
        panel.add(new JLabel("Consecutivo"));
        txtConsecutivo = new JTextField();
        panel.add(txtConsecutivo);
        panel.add(new JLabel("Barcos"));
        txtBarcos = new JTextField();
        panel.add(txtBarcos);
        panel.add(new JLabel("Aviones"));
        txtAviones = new JTextField();
        panel.add(txtAviones);
        panel.add(new JLabel("Hombres"));
        txtHombres = new JTextField();
        panel.add(txtHombres);
        panel.add(new JLabel("Tanques"));
        txtTanques = new JTextField();
        panel.add(txtTanques);
        panel.add(new JLabel("Bajas"));
        txtBajas = new JTextField();
        panel.add(txtBajas);
        panel.add(new JLabel(""));
        btnAgregarDivision = new JButton("Agregar division");
        panel.add(btnAgregarDivision);
        return panel;
    }
    
    // Limpia las cajas de texto
    public void limpiar()
    {
        txtNombreConflicto.setText("");
        txtPais.setText("");
        cbTipoConflicto.setSelectedIndex(0);
        txtMuertos.setText("");
        txtHeridos.setText("");
        txtDetalle.setText("");
        txtCodigoGrupo.setText("");
        txtNombreGrupo.setText("");
        txtLider.setText("");
        txtApoyos.setText("");
        txtGrupoDivision.setText("");
        txtConsecutivo.setText("");
        txtBarcos.setText("");
        txtAviones.setText("");
        txtHombres.setText("");
        txtTanques.setText("");
        txtBajas.setText("");
    }
    
    // ------------------------------- Getters -------------------------------
    public JTextField getTxtNombreConflicto() { return txtNombreConflicto; }
    public JTextField getTxtPais() { return txtPais; }
    public JComboBox<String> getCbTipoConflicto() { return cbTipoConflicto; }
    public JTextField getTxtMuertos() { return txtMuertos; }
    public JTextField getTxtHeridos() { return txtHeridos; }
    public JTextField getTxtDetalle() { return txtDetalle; }
    public JButton getBtnRegistrarConflicto() { return btnRegistrarConflicto; }
    
    public JTextField getTxtCodigoGrupo() { return txtCodigoGrupo; }
    public JTextField getTxtNombreGrupo() { return txtNombreGrupo; }
    public JTextField getTxtLider() { return txtLider; }
    public JTextField getTxtApoyos() { return txtApoyos; }
    public JButton getBtnRegistrarGrupo() { return btnRegistrarGrupo; }
    
    public JTextField getTxtGrupoDivision() { return txtGrupoDivision; }
    public JTextField getTxtConsecutivo() { return txtConsecutivo; }
    public JTextField getTxtBarcos() { return txtBarcos; }
    public JTextField getTxtAviones() { return txtAviones; }
    public JTextField getTxtHombres() { return txtHombres; }
    public JTextField getTxtTanques() { return txtTanques; }
    public JTextField getTxtBajas() { return txtBajas; }
    public JButton getBtnAgregarDivision() { return btnAgregarDivision; }
    
    public JTextArea getTxtReporte() { return txtReporte; }
    public JButton getBtnReporte() { return btnReporte; }
    public JButton getBtnLimpiar() { return btnLimpiar; }
    public JButton getBtnSalir() { return btnSalir; }
}
