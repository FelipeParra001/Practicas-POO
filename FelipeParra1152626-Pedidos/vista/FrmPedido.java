package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FrmPedido extends JFrame
{
    // Pedido
    private JTextField txtNumeroPedido;

    // Cliente
    private JTextField txtCedula;
    private JTextField txtNombreCliente;

    // Producto
    private JTextField txtCodigoProducto;
    private JTextField txtNombreProducto;
    private JTextField txtPrecio;

    // Botones
    private JButton btnAgregarProducto;
    private JButton btnEliminarProducto;
    private JButton btnNuevoPedido;
    private JButton btnLimpiar;
    private JButton btnSalir;

    // Tabla
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;

    // Total
    private JLabel lblTotal;

    // Constructor
    public FrmPedido()
    {
        setTitle("Gestion de Pedidos");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        crearTitulo();
        crearPanelCentral();
        crearPanelInferior();
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
        panelBotones.add(btnNuevoPedido);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);

        panelInferior.add(panelTotal);
        panelInferior.add(panelBotones);
        add(panelInferior, BorderLayout.SOUTH);
    }

    // Limpia los campos del producto
    public void limpiarProducto()
    {
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        txtPrecio.setText("");
    }

    // Getters
    public JTextField getTxtNumeroPedido()
    {
        return txtNumeroPedido;
    }

    public JTextField getTxtCedula()
    {
        return txtCedula;
    }

    public JTextField getTxtNombreCliente()
    {
        return txtNombreCliente;
    }

    public JTextField getTxtCodigoProducto()
    {
        return txtCodigoProducto;
    }

    public JTextField getTxtNombreProducto()
    {
        return txtNombreProducto;
    }

    public JTextField getTxtPrecio()
    {
        return txtPrecio;
    }

    public JButton getBtnAgregarProducto()
    {
        return btnAgregarProducto;
    }

    public JButton getBtnEliminarProducto()
    {
        return btnEliminarProducto;
    }

    public JButton getBtnNuevoPedido()
    {
        return btnNuevoPedido;
    }

    public JButton getBtnLimpiar()
    {
        return btnLimpiar;
    }

    public JButton getBtnSalir()
    {
        return btnSalir;
    }

    public JTable getTablaProductos()
    {
        return tablaProductos;
    }

    public DefaultTableModel getModeloTabla()
    {
        return modeloTabla;
    }

    public JLabel getLblTotal()
    {
        return lblTotal;
    }
}
