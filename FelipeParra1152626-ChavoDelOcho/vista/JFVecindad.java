package vista;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JFVecindad extends JFrame
{
    // Registro de personajes
    private JLabel lblNombre, lblEdad, lblPersonalidad, lblRol;
    private JTextField txtNombre, txtEdad, txtPersonalidad, txtRol;
    private JButton btnRegistrar, btnVerPersonajes;

    // Interaccion entre personajes
    private JLabel lblPersonaje1, lblPersonaje2, lblTipoRelacion;
    private JComboBox<String> cbPersonaje1, cbPersonaje2, cbTipoRelacion;
    private JButton btnInteractuar, btnRelacionar;

    // Jugador
    private JLabel lblUbicacion, lblLugar, lblObjeto;
    private JComboBox<String> cbLugar, cbObjeto;
    private JButton btnMover, btnUsarObjeto;

    private JTextArea txtSalida;

    public JFVecindad(){
        setTitle("La vecindad del Chavo del Ocho");
        setSize(750,650);
        setLayout(new BorderLayout(10,10));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ==================== REGISTRO DE PERSONAJES ====================
        JPanel panelRegistro = new JPanel(new GridLayout(5,2,5,5));
        panelRegistro.setBorder(BorderFactory.createTitledBorder("Personajes"));

        lblNombre = new JLabel("Nombre");
        lblEdad = new JLabel("Edad");
        lblPersonalidad = new JLabel("Personalidad");
        lblRol = new JLabel("Rol en la vecindad");

        txtNombre = new JTextField();
        txtEdad = new JTextField();
        txtPersonalidad = new JTextField();
        txtRol = new JTextField();

        btnRegistrar = new JButton("Registrar personaje");
        btnVerPersonajes = new JButton("Ver personajes");

        panelRegistro.add(lblNombre); panelRegistro.add(txtNombre);
        panelRegistro.add(lblEdad); panelRegistro.add(txtEdad);
        panelRegistro.add(lblPersonalidad); panelRegistro.add(txtPersonalidad);
        panelRegistro.add(lblRol); panelRegistro.add(txtRol);
        panelRegistro.add(btnRegistrar); panelRegistro.add(btnVerPersonajes);

        // ==================== INTERACCION ====================
        JPanel panelInteraccion = new JPanel(new GridLayout(4,2,5,5));
        panelInteraccion.setBorder(BorderFactory.createTitledBorder("Interacción entre personajes"));

        lblPersonaje1 = new JLabel("Personaje 1");
        lblPersonaje2 = new JLabel("Personaje 2");
        lblTipoRelacion = new JLabel("Tipo de relación");

        cbPersonaje1 = new JComboBox<String>();
        cbPersonaje2 = new JComboBox<String>();
        cbTipoRelacion = new JComboBox<String>(new String[] {"Amistad","Rivalidad"});

        btnInteractuar = new JButton("Interactuar");
        btnRelacionar = new JButton("Crear relación");

        panelInteraccion.add(lblPersonaje1); panelInteraccion.add(cbPersonaje1);
        panelInteraccion.add(lblPersonaje2); panelInteraccion.add(cbPersonaje2);
        panelInteraccion.add(lblTipoRelacion); panelInteraccion.add(cbTipoRelacion);
        panelInteraccion.add(btnInteractuar); panelInteraccion.add(btnRelacionar);

        // ==================== JUGADOR ====================
        JPanel panelJugador = new JPanel(new GridLayout(3,3,5,5));
        panelJugador.setBorder(BorderFactory.createTitledBorder("Jugador"));

        lblUbicacion = new JLabel("Ubicación: ");
        lblLugar = new JLabel("Ir a");
        lblObjeto = new JLabel("Objeto");

        cbLugar = new JComboBox<String>();
        cbObjeto = new JComboBox<String>();

        btnMover = new JButton("Moverse");
        btnUsarObjeto = new JButton("Interactuar");

        panelJugador.add(lblUbicacion); panelJugador.add(new JLabel("")); panelJugador.add(new JLabel(""));
        panelJugador.add(lblLugar); panelJugador.add(cbLugar); panelJugador.add(btnMover);
        panelJugador.add(lblObjeto); panelJugador.add(cbObjeto); panelJugador.add(btnUsarObjeto);

        JPanel panelSuperior = new JPanel(new GridLayout(1,2,10,10));
        panelSuperior.add(panelRegistro);
        panelSuperior.add(panelInteraccion);

        JPanel panelNorte = new JPanel(new BorderLayout(10,10));
        panelNorte.add(panelSuperior, BorderLayout.NORTH);
        panelNorte.add(panelJugador, BorderLayout.SOUTH);

        txtSalida = new JTextArea();
        txtSalida.setEditable(false);

        add(panelNorte, BorderLayout.NORTH);
        add(new JScrollPane(txtSalida), BorderLayout.CENTER);
    }

    // ==================== METODOS DE LA VISTA ====================

    public void llenarPersonajes(ArrayList<String> nombres){
        cbPersonaje1.removeAllItems();
        cbPersonaje2.removeAllItems();
        for(String n : nombres){
            cbPersonaje1.addItem(n);
            cbPersonaje2.addItem(n);
        }
    }

    public void llenarLugares(ArrayList<String> nombres){
        cbLugar.removeAllItems();
        for(String n : nombres){
            cbLugar.addItem(n);
        }
    }

    public void llenarObjetos(ArrayList<String> nombres){
        cbObjeto.removeAllItems();
        for(String n : nombres){
            cbObjeto.addItem(n);
        }
    }

    public void mostrarUbicacion(String lugar){
        lblUbicacion.setText("Ubicación: " + lugar);
    }

    public void limpiar(){
        txtNombre.setText("");
        txtEdad.setText("");
        txtPersonalidad.setText("");
        txtRol.setText("");
    }

    // ==================== GET ====================

    public JTextField getTxtNombre(){
        return this.txtNombre;
    }

    public JTextField getTxtEdad(){
        return this.txtEdad;
    }

    public JTextField getTxtPersonalidad(){
        return this.txtPersonalidad;
    }

    public JTextField getTxtRol(){
        return this.txtRol;
    }

    public JButton getBtnRegistrar(){
        return this.btnRegistrar;
    }

    public JButton getBtnVerPersonajes(){
        return this.btnVerPersonajes;
    }

    public JComboBox<String> getCbPersonaje1(){
        return this.cbPersonaje1;
    }

    public JComboBox<String> getCbPersonaje2(){
        return this.cbPersonaje2;
    }

    public JComboBox<String> getCbTipoRelacion(){
        return this.cbTipoRelacion;
    }

    public JButton getBtnInteractuar(){
        return this.btnInteractuar;
    }

    public JButton getBtnRelacionar(){
        return this.btnRelacionar;
    }

    public JComboBox<String> getCbLugar(){
        return this.cbLugar;
    }

    public JComboBox<String> getCbObjeto(){
        return this.cbObjeto;
    }

    public JButton getBtnMover(){
        return this.btnMover;
    }

    public JButton getBtnUsarObjeto(){
        return this.btnUsarObjeto;
    }

    public JTextArea getTxtSalida(){
        return this.txtSalida;
    }
}//End class
