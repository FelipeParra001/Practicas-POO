package vista;

import javax.swing.*;
import java.awt.*;

public class JFImpuestos extends JFrame
{
    // ---------- ATRIBUTOS ----------
    // datos del vehiculo
    private JLabel foto;
    private JTextField campoMarca;
    private JTextField campoLinea;
    private JTextField campoModelo;
    private JTextField campoValor;

    // botones de navegacion
    private JButton botonPrimero;
    private JButton botonAnterior;
    private JButton botonSiguiente;
    private JButton botonUltimo;

    // busquedas
    private JTextField busquedaLinea;
    private JTextField busquedaMarca;
    private JButton botonBuscarLinea;
    private JButton botonBuscarMarca;
    private JButton botonBuscarCaro;

    // descuentos
    private JCheckBox checkProntoPago;
    private JCheckBox checkServicioPublico;
    private JCheckBox checkTraslado;

    // opciones
    private JButton botonCalcular;
    private JButton botonOpcion1;
    private JButton botonOpcion2;

    // ---------- CONSTRUCTOR ----------
    public JFImpuestos()
    {
        setTitle("Calculo impuestos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel principal = new JPanel(new BorderLayout());
        principal.setBackground(new Color(245, 246, 248));
        principal.add(crearBanner(), BorderLayout.NORTH);

        JPanel cuerpo = new JPanel();
        cuerpo.setLayout(new BoxLayout(cuerpo, BoxLayout.Y_AXIS));
        cuerpo.setBorder(BorderFactory.createEmptyBorder(6, 8, 8, 8));
        cuerpo.setBackground(new Color(245, 246, 248));
        cuerpo.add(crearDatos());
        cuerpo.add(Box.createVerticalStrut(6));
        cuerpo.add(crearBusquedas());
        cuerpo.add(Box.createVerticalStrut(6));
        cuerpo.add(crearDescuentos());
        cuerpo.add(Box.createVerticalStrut(6));
        cuerpo.add(crearOpciones());
        principal.add(cuerpo, BorderLayout.CENTER);

        setContentPane(principal);
        setSize(760, 700);
        setLocationRelativeTo(null);
    }

    // ---------- ZONAS DE LA VENTANA ----------
    private ImageIcon cargar(String ruta, int ancho, int alto)
    {
        ImageIcon original = new ImageIcon(ruta);
        Image escalada = original.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(escalada);
    }

    private ImageIcon cargarVehiculo(String ruta, int ancho, int alto)
    {
        ImageIcon original = new ImageIcon(ruta);
        double escala = Math.min((double) ancho / original.getIconWidth(),
                                 (double) alto / original.getIconHeight());
        int nuevoAncho = (int) (original.getIconWidth() * escala);
        int nuevoAlto = (int) (original.getIconHeight() * escala);
        Image escalada = original.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        return new ImageIcon(escalada);
    }

    private JTextField casilla()
    {
        JTextField campo = new JTextField();
        campo.setEditable(false);
        campo.setBackground(new Color(214, 232, 245));
        campo.setHorizontalAlignment(JTextField.CENTER);
        campo.setFont(new Font("Dialog", Font.PLAIN, 14));
        return campo;
    }

    private JPanel crearBanner()
    {
        JLabel banner = new JLabel(cargar("imagen/banner.jpg", 740, 150));
        banner.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel zona = new JPanel(new BorderLayout());
        zona.setBackground(new Color(168, 216, 234));
        zona.add(banner, BorderLayout.CENTER);
        return zona;
    }

    private JPanel crearDatos()
    {
        JPanel zona = new JPanel(new BorderLayout(8, 6));
        zona.setBorder(BorderFactory.createTitledBorder("Datos del vehiculo"));
        zona.setBackground(Color.WHITE);

        foto = new JLabel();
        foto.setPreferredSize(new Dimension(220, 150));
        foto.setHorizontalAlignment(SwingConstants.CENTER);
        zona.add(foto, BorderLayout.WEST);

        campoMarca = casilla();
        campoLinea = casilla();
        campoModelo = casilla();
        campoValor = casilla();

        JPanel datos = new JPanel(new GridLayout(4, 2, 10, 6));
        datos.setBackground(Color.WHITE);
        datos.add(new JLabel("Marca"));
        datos.add(campoMarca);
        datos.add(new JLabel("Linea"));
        datos.add(campoLinea);
        datos.add(new JLabel("Modelo"));
        datos.add(campoModelo);
        datos.add(new JLabel("Valor"));
        datos.add(campoValor);
        zona.add(datos, BorderLayout.CENTER);

        botonPrimero = new JButton("<<");
        botonAnterior = new JButton("<");
        botonSiguiente = new JButton(">");
        botonUltimo = new JButton(">>");

        JPanel flechas = new JPanel(new GridLayout(1, 4, 4, 4));
        flechas.add(botonPrimero);
        flechas.add(botonAnterior);
        flechas.add(botonSiguiente);
        flechas.add(botonUltimo);
        zona.add(flechas, BorderLayout.SOUTH);
        return zona;
    }

    private JPanel crearBusquedas()
    {
        busquedaLinea = new JTextField();
        busquedaMarca = new JTextField();
        botonBuscarLinea = new JButton("Buscar por linea");
        botonBuscarMarca = new JButton("Buscar por marca");
        botonBuscarCaro = new JButton("Buscar vehiculo mas caro");

        JPanel zona = new JPanel(new GridLayout(3, 2, 8, 6));
        zona.setBorder(BorderFactory.createTitledBorder("Busquedas"));
        zona.setBackground(Color.WHITE);
        zona.add(busquedaLinea);
        zona.add(botonBuscarLinea);
        zona.add(busquedaMarca);
        zona.add(botonBuscarMarca);
        zona.add(new JLabel(""));
        zona.add(botonBuscarCaro);
        return zona;
    }

    private JPanel crearDescuentos()
    {
        checkProntoPago = new JCheckBox("Pronto pago");
        checkServicioPublico = new JCheckBox("Servicio publico");
        checkTraslado = new JCheckBox("Traslado de cuenta");

        JPanel zona = new JPanel(new GridLayout(2, 2, 8, 4));
        zona.setBorder(BorderFactory.createTitledBorder("Descuentos"));
        zona.setBackground(Color.WHITE);
        zona.add(checkProntoPago);
        zona.add(checkTraslado);
        zona.add(checkServicioPublico);
        zona.add(new JLabel(""));
        return zona;
    }

    private JPanel crearOpciones()
    {
        botonCalcular = new JButton("Calcular");
        botonOpcion1 = new JButton("Opcion 1");
        botonOpcion2 = new JButton("Opcion 2");

        JPanel zona = new JPanel(new GridLayout(1, 3, 8, 4));
        zona.setBorder(BorderFactory.createTitledBorder("Opciones"));
        zona.setBackground(Color.WHITE);
        zona.add(botonCalcular);
        zona.add(botonOpcion1);
        zona.add(botonOpcion2);
        return zona;
    }

    // ---------- METODOS PARA EL CONTROLADOR ----------
    // Muestra en pantalla los datos de un vehiculo
    public void mostrarVehiculo(String marca, String linea, String modelo, String valor, String imagen)
    {
        campoMarca.setText(marca);
        campoLinea.setText(linea);
        campoModelo.setText(modelo);
        campoValor.setText(valor);
        foto.setIcon(cargarVehiculo(imagen, 220, 150));
    }

    // ---------- GETTERS ----------
    public JButton getBotonPrimero()
    {
        return botonPrimero;
    }

    public JButton getBotonAnterior()
    {
        return botonAnterior;
    }

    public JButton getBotonSiguiente()
    {
        return botonSiguiente;
    }

    public JButton getBotonUltimo()
    {
        return botonUltimo;
    }

    public JTextField getBusquedaLinea()
    {
        return busquedaLinea;
    }

    public JTextField getBusquedaMarca()
    {
        return busquedaMarca;
    }

    public JButton getBotonBuscarLinea()
    {
        return botonBuscarLinea;
    }

    public JButton getBotonBuscarMarca()
    {
        return botonBuscarMarca;
    }

    public JButton getBotonBuscarCaro()
    {
        return botonBuscarCaro;
    }

    public JCheckBox getCheckProntoPago()
    {
        return checkProntoPago;
    }

    public JCheckBox getCheckServicioPublico()
    {
        return checkServicioPublico;
    }

    public JCheckBox getCheckTraslado()
    {
        return checkTraslado;
    }

    public JButton getBotonCalcular()
    {
        return botonCalcular;
    }

    public JButton getBotonOpcion1()
    {
        return botonOpcion1;
    }

    public JButton getBotonOpcion2()
    {
        return botonOpcion2;
    }
}
