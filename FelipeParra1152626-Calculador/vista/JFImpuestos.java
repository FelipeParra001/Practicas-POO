package vista;

import modelo.CalculadorImpuestos;
import modelo.Vehiculo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFImpuestos extends JFrame implements ActionListener
{
    // ---------- ATRIBUTOS ----------
    private CalculadorImpuestos calculador;

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
        calculador = new CalculadorImpuestos();

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

        mostrarVehiculo();
        setVisible(true);
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
        botonPrimero.addActionListener(this);
        botonAnterior.addActionListener(this);
        botonSiguiente.addActionListener(this);
        botonUltimo.addActionListener(this);

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
        botonBuscarLinea.addActionListener(this);
        botonBuscarMarca.addActionListener(this);
        botonBuscarCaro.addActionListener(this);

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
        botonCalcular.addActionListener(this);
        botonOpcion1.addActionListener(this);
        botonOpcion2.addActionListener(this);

        JPanel zona = new JPanel(new GridLayout(1, 3, 8, 4));
        zona.setBorder(BorderFactory.createTitledBorder("Opciones"));
        zona.setBackground(Color.WHITE);
        zona.add(botonCalcular);
        zona.add(botonOpcion1);
        zona.add(botonOpcion2);
        return zona;
    }

    // ---------- LOGICA DE LOS BOTONES ----------
    // Muestra en pantalla el vehiculo actual
    private void mostrarVehiculo()
    {
        Vehiculo v = calculador.getVehiculoActual();
        campoMarca.setText(v.getMarca());
        campoLinea.setText(v.getLinea());
        campoModelo.setText("" + v.getModelo());
        campoValor.setText("$ " + String.format("%,d", v.getPrecio()));
        foto.setIcon(cargarVehiculo(v.getImagen(), 220, 150));
    }

    public void actionPerformed(ActionEvent e)
    {
        Object boton = e.getSource();

        if (boton == botonPrimero)
        {
            calculador.irAlPrimero();
            mostrarVehiculo();
        }
        else if (boton == botonAnterior)
        {
            calculador.irAlAnterior();
            mostrarVehiculo();
        }
        else if (boton == botonSiguiente)
        {
            calculador.irAlSiguiente();
            mostrarVehiculo();
        }
        else if (boton == botonUltimo)
        {
            calculador.irAlUltimo();
            mostrarVehiculo();
        }
        else if (boton == botonBuscarLinea)
        {
            buscarPorLinea();
        }
        else if (boton == botonBuscarMarca)
        {
            buscarPorMarca();
        }
        else if (boton == botonBuscarCaro)
        {
            calculador.buscarMasCaro();
            mostrarVehiculo();
        }
        else if (boton == botonCalcular)
        {
            calcular();
        }
        // Opcion 1 y Opcion 2 todavia no hacen nada
    }

    private void buscarPorLinea()
    {
        String linea = busquedaLinea.getText().trim();
        if (linea.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Escriba la linea que desea buscar");
        }
        else if (calculador.buscarPorLinea(linea))
        {
            mostrarVehiculo();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "No se encontro un vehiculo con esa linea");
        }
    }

    private void buscarPorMarca()
    {
        String marca = busquedaMarca.getText().trim();
        if (marca.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Escriba la marca que desea buscar");
        }
        else if (calculador.buscarPorMarca(marca))
        {
            mostrarVehiculo();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "No se encontro un vehiculo con esa marca");
        }
    }

    private void calcular()
    {
        double total = calculador.calcularTotal(checkProntoPago.isSelected(),
                                                checkServicioPublico.isSelected(),
                                                checkTraslado.isSelected());
        JOptionPane.showMessageDialog(this, "El valor total a pagar es: $ " + String.format("%,.0f", total));
    }
}
