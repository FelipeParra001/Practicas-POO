package vista;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Producto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmPedido extends JFrame implements ActionListener
{
    // Pedido
    public JTextField txtNumeroPedido;

    // Cliente
    public JTextField txtCedula;
    public JTextField txtNombreCliente;

    // Producto
    public JTextField txtCodigoProducto;
    public JTextField txtNombreProducto;
    public JTextField txtPrecio;

    // Botones
    public JButton btnAgregarProducto;
    public JButton btnEliminarProducto;
    public JButton btnNuevoPedido;
    public JButton btnLimpiar;
    public JButton btnSalir;

    // Tabla
    public JTable tablaProductos;
    public DefaultTableModel modeloTabla;

    // Total
    public JLabel lblTotal;

    // Modelo
    private ArrayList<Pedido> pedidos;
    private Pedido pedidoActual;
    private int siguienteNumero;

    // Constructor
    public FrmPedido()
    {
        pedidos = new ArrayList<Pedido>();
        siguienteNumero = 1;
        pedidoActual = new Pedido(siguienteNumero);
        pedidos.add(pedidoActual);

        setTitle("Gestion de Pedidos");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        crearTitulo();
        crearPanelCentral();
        crearPanelInferior();
        mostrar();
        setVisible(true);
    }

    private void crearTitulo()
    {
        JLabel lblTitulo = new JLabel("GESTION DE PEDIDOS", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(new Color(70, 130, 180));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        add(lblTitulo, BorderLayout.NORTH);
    }

    private void crearPanelCentral()
    {
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panelCentral.add(crearPanelPedidoCliente());
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(crearPanelProducto());
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(crearPanelTabla());
        add(panelCentral, BorderLayout.CENTER);
    }

    private JPanel crearPanelPedidoCliente()
    {
        JPanel panel = new JPanel(new GridLayout(1, 2, 15, 0));

        JPanel panelPedido = new JPanel(new GridBagLayout());
        panelPedido.setBorder(BorderFactory.createTitledBorder("Datos del Pedido"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelPedido.add(new JLabel("Numero de pedido:"), gbc);
        txtNumeroPedido = new JTextField(12);
        txtNumeroPedido.setEditable(false);
        gbc.gridx = 1;
        panelPedido.add(txtNumeroPedido, gbc);

        JPanel panelCliente = new JPanel(new GridBagLayout());
        panelCliente.setBorder(BorderFactory.createTitledBorder("Datos del Cliente"));
        GridBagConstraints gbcCliente = new GridBagConstraints();
        gbcCliente.insets = new Insets(5, 10, 5, 10);
        gbcCliente.gridx = 0;
        gbcCliente.gridy = 0;
        panelCliente.add(new JLabel("Cedula:"), gbcCliente);
        txtCedula = new JTextField(15);
        gbcCliente.gridx = 1;
        panelCliente.add(txtCedula, gbcCliente);
        gbcCliente.gridx = 0;
        gbcCliente.gridy = 1;
        panelCliente.add(new JLabel("Nombre:"), gbcCliente);
        txtNombreCliente = new JTextField(15);
        gbcCliente.gridx = 1;
        panelCliente.add(txtNombreCliente, gbcCliente);

        panel.add(panelPedido);
        panel.add(panelCliente);
        return panel;
    }

    private JPanel crearPanelProducto()
    {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
        panel.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));
        panel.add(new JLabel("Codigo:"));
        txtCodigoProducto = new JTextField(8);
        panel.add(txtCodigoProducto);
        panel.add(new JLabel("Nombre:"));
        txtNombreProducto = new JTextField(15);
        panel.add(txtNombreProducto);
        panel.add(new JLabel("Precio:"));
        txtPrecio = new JTextField(10);
        panel.add(txtPrecio);
        btnAgregarProducto = new JButton("Agregar Producto");
        btnAgregarProducto.addActionListener(this);
        panel.add(btnAgregarProducto);
        return panel;
    }

    private JPanel crearPanelTabla()
    {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Productos del Pedido"));
        String[] columnas = {"Codigo", "Nombre", "Precio"};
        modeloTabla = new DefaultTableModel(columnas, 0)
        {
            public boolean isCellEditable(int fila, int columna)
            {
                return false;
            }
        };
        tablaProductos = new JTable(modeloTabla);
        tablaProductos.setRowHeight(25);
        panel.add(new JScrollPane(tablaProductos), BorderLayout.CENTER);
        btnEliminarProducto = new JButton("Eliminar Producto");
        btnEliminarProducto.addActionListener(this);
        JPanel panelEliminar = new JPanel();
        panelEliminar.add(btnEliminarProducto);
        panel.add(panelEliminar, BorderLayout.EAST);
        return panel;
    }

    private void crearPanelInferior()
    {
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));
        JPanel panelTotal = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblTextoTotal = new JLabel("TOTAL DEL PEDIDO:");
        lblTextoTotal.setFont(new Font("Arial", Font.BOLD, 18));
        lblTotal = new JLabel("$ 0");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 24));
        panelTotal.add(lblTextoTotal);
        panelTotal.add(lblTotal);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        btnNuevoPedido = new JButton("Nuevo Pedido");
        btnLimpiar = new JButton("Limpiar Campos");
        btnSalir = new JButton("Salir");
        btnNuevoPedido.addActionListener(this);
        btnLimpiar.addActionListener(this);
        btnSalir.addActionListener(this);
        panelBotones.add(btnNuevoPedido);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);

        panelInferior.add(panelTotal);
        panelInferior.add(panelBotones);
        add(panelInferior, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object boton = e.getSource();
        if (boton == btnAgregarProducto)
        {
            agregar();
        }
        else if (boton == btnEliminarProducto)
        {
            eliminar();
        }
        else if (boton == btnNuevoPedido)
        {
            nuevoPedido();
        }
        else if (boton == btnLimpiar)
        {
            txtCodigoProducto.setText("");
            txtNombreProducto.setText("");
            txtPrecio.setText("");
        }
        else if (boton == btnSalir)
        {
            System.exit(0);
        }
    }

    private void guardarCliente()
    {
        String cedula = txtCedula.getText().trim();
        String nombre = txtNombreCliente.getText().trim();
        pedidoActual.setCliente(new Cliente(cedula, nombre));
    }

    private void agregar()
    {
        String codigo = txtCodigoProducto.getText().trim();
        String nombre = txtNombreProducto.getText().trim();
        String textoPrecio = txtPrecio.getText().trim();
        if (codigo.equals("") || nombre.equals("") || textoPrecio.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Complete codigo, nombre y precio");
            return;
        }
        double precio = Double.parseDouble(textoPrecio);
        guardarCliente();
        pedidoActual.agregarProducto(new Producto(codigo, nombre, precio));
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        txtPrecio.setText("");
        mostrar();
    }

    private void eliminar()
    {
        int fila = tablaProductos.getSelectedRow();
        if (fila < 0)
        {
            JOptionPane.showMessageDialog(this, "Seleccione un producto");
            return;
        }
        pedidoActual.eliminarProducto(fila);
        mostrar();
    }

    private void nuevoPedido()
    {
        guardarCliente();
        siguienteNumero = siguienteNumero + 1;
        pedidoActual = new Pedido(siguienteNumero);
        pedidos.add(pedidoActual);
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        txtPrecio.setText("");
        mostrar();
    }

    private void mostrar()
    {
        txtNumeroPedido.setText(String.valueOf(pedidoActual.getNumero()));
        if (pedidoActual.getCliente() != null)
        {
            txtCedula.setText(pedidoActual.getCliente().getCedula());
            txtNombreCliente.setText(pedidoActual.getCliente().getNombre());
        }
        else
        {
            txtCedula.setText("");
            txtNombreCliente.setText("");
        }
        modeloTabla.setRowCount(0);
        for (int i = 0; i < pedidoActual.getCantidad(); i++)
        {
            Producto p = pedidoActual.getProducto(i);
            modeloTabla.addRow(new Object[]{p.getCodigo(), p.getNombre(), p.getPrecio()});
        }
        lblTotal.setText("$ " + pedidoActual.getTotal());
    }
}
