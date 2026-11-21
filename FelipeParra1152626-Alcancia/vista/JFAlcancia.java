package vista;

import javax.swing.*;
import java.awt.*;

public class JFAlcancia extends JFrame
{
    // Atributos
    private JLabel lblImagen;
    private JLabel lblSaldo;
    private JLabel lbl50;
    private JLabel lbl100;
    private JLabel lbl200;
    private JLabel lbl500;
    private JLabel lbl1000;
    private JLabel lblTotal;
    private ImageIcon iconoNormal;
    private ImageIcon iconoLlena;
    private ImageIcon iconoRota;
    private JButton btn50;
    private JButton btn100;
    private JButton btn200;
    private JButton btn500;
    private JButton btn1000;
    private JButton btnVaciar;

    // Constructor
    public JFAlcancia()
    {
        setTitle("Mi Alcancia - POO I");
        setSize(520, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        iconoNormal = cargar("imagen/cerdito.png");
        iconoLlena = cargar("imagen/cerdo.png");
        iconoRota = cargar("imagen/rota.png");

        crearArriba();
        crearCentro();
        crearAbajo();
    }

    public ImageIcon cargar(String ruta)
    {
        return new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
    }

    public void crearArriba()
    {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("MI ALCANCIA", SwingConstants.CENTER);
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 28));
        lblImagen = new JLabel(iconoNormal, SwingConstants.CENTER);
        lblImagen.setPreferredSize(new Dimension(160, 160));
        lblSaldo = new JLabel("$ 0", SwingConstants.CENTER);
        lblSaldo.setFont(new Font("Times New Roman", Font.BOLD, 28));
        JLabel texto = new JLabel("Saldo disponible", SwingConstants.CENTER);
        JPanel saldo = new JPanel(new GridLayout(2, 1));
        saldo.add(texto);
        saldo.add(lblSaldo);
        panel.add(titulo, BorderLayout.NORTH);
        panel.add(lblImagen, BorderLayout.CENTER);
        panel.add(saldo, BorderLayout.SOUTH);
        add(panel, BorderLayout.NORTH);
    }

    public void crearCentro()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tituloMonedas = new JLabel("INGRESAR MONEDAS");
        tituloMonedas.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tituloMonedas.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloMonedas);

        JPanel botones = new JPanel(new FlowLayout());
        btn50 = new JButton("$50");
        btn100 = new JButton("$100");
        btn200 = new JButton("$200");
        btn500 = new JButton("$500");
        btn1000 = new JButton("$1000");
        botones.add(btn50);
        botones.add(btn100);
        botones.add(btn200);
        botones.add(btn500);
        botones.add(btn1000);
        panel.add(botones);

        JLabel tituloDetalle = new JLabel("DETALLE DE MONEDAS");
        tituloDetalle.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tituloDetalle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloDetalle);

        JPanel detalle = new JPanel(new GridLayout(2, 5));
        detalle.add(new JLabel("$50", SwingConstants.CENTER));
        detalle.add(new JLabel("$100", SwingConstants.CENTER));
        detalle.add(new JLabel("$200", SwingConstants.CENTER));
        detalle.add(new JLabel("$500", SwingConstants.CENTER));
        detalle.add(new JLabel("$1000", SwingConstants.CENTER));
        lbl50 = new JLabel("0", SwingConstants.CENTER);
        lbl100 = new JLabel("0", SwingConstants.CENTER);
        lbl200 = new JLabel("0", SwingConstants.CENTER);
        lbl500 = new JLabel("0", SwingConstants.CENTER);
        lbl1000 = new JLabel("0", SwingConstants.CENTER);
        detalle.add(lbl50);
        detalle.add(lbl100);
        detalle.add(lbl200);
        detalle.add(lbl500);
        detalle.add(lbl1000);
        panel.add(detalle);

        lblTotal = new JLabel("Total monedas: 0", SwingConstants.CENTER);
        lblTotal.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblTotal);
        add(panel, BorderLayout.CENTER);
    }

    public void crearAbajo()
    {
        JPanel panel = new JPanel(new FlowLayout());
        btnVaciar = new JButton("Vaciar alcancia");
        panel.add(btnVaciar);
        add(panel, BorderLayout.SOUTH);
    }

    // Cambia la imagen a la alcancia llena
    public void mostrarLlena()
    {
        lblImagen.setIcon(iconoLlena);
    }

    // Cambia la imagen a la alcancia rota
    public void mostrarRota()
    {
        lblImagen.setIcon(iconoRota);
    }

    // Getters
    public JLabel getLblSaldo()
    {
        return lblSaldo;
    }

    public JLabel getLbl50()
    {
        return lbl50;
    }

    public JLabel getLbl100()
    {
        return lbl100;
    }

    public JLabel getLbl200()
    {
        return lbl200;
    }

    public JLabel getLbl500()
    {
        return lbl500;
    }

    public JLabel getLbl1000()
    {
        return lbl1000;
    }

    public JLabel getLblTotal()
    {
        return lblTotal;
    }

    public JButton getBtn50()
    {
        return btn50;
    }

    public JButton getBtn100()
    {
        return btn100;
    }

    public JButton getBtn200()
    {
        return btn200;
    }

    public JButton getBtn500()
    {
        return btn500;
    }

    public JButton getBtn1000()
    {
        return btn1000;
    }

    public JButton getBtnVaciar()
    {
        return btnVaciar;
    }
}
