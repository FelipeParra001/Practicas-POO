package vista;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.ScrollPane;

public class JFPrincipal extends JFrame
{
    private JLabel lblCodigo, lblDescripcion, lblFecha, lblEmocion, LblEvento;
    private JTextField txtCodigo, txtDescripcion, txtFecha, txtEmocion, txtEvento;
    private JButton btnAgregarRecuerdo,btnAgregarEmocion,btnAgregarEvento;
    
    private JLabel lblNombre, lblIntensidad, lblTipo, lblAccion, lblEstado;
    private JTextField txtNombre, txtIntensidad, txtTipo, txtAccion, txtEstado;
    
    private JComboBox<String> cTipoEvento, cTipo;
    
    private JLabel lblNombreEvento, lblImpacto, lblTipoEvento;
    private JTextField txtNombreEvento, txtImpacto;
    
    private JTextArea txtSalida;
    
    public JFPrincipal(){
        setTitle("Agregar Recuerdo");
        setSize(600,800);
        setLayout(new BorderLayout(10,10));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel Recuerdo = new JPanel(new GridLayout(5,2,5,5));
        
        lblCodigo = new JLabel("Codigo");
        lblDescripcion = new JLabel("Descripcion");
        lblFecha = new JLabel("Fecha");
        lblEmocion = new JLabel("Emocion");
        LblEvento = new JLabel("Evento");
        
        txtCodigo = new JTextField();
        txtDescripcion = new JTextField();
        txtFecha = new JTextField();
        txtEmocion = new JTextField();
        txtEvento = new JTextField();
        
        Recuerdo.add(lblCodigo);Recuerdo.add(txtCodigo);
        Recuerdo.add(lblDescripcion);Recuerdo.add(txtDescripcion);
        Recuerdo.add(lblFecha);Recuerdo.add(txtFecha);
        Recuerdo.add(lblEmocion);Recuerdo.add(txtEmocion);
        Recuerdo.add(LblEvento);Recuerdo.add(txtEvento);
        
        JPanel PanelRecuerdo = new JPanel(new GridLayout(1,3,5,5));
        
        JLabel tituloRecuerdo = new JLabel("Recuerdo");
        btnAgregarRecuerdo = new JButton("Agregar");
        
        PanelRecuerdo.add(tituloRecuerdo);
        PanelRecuerdo.add(Recuerdo);
        PanelRecuerdo.add(btnAgregarRecuerdo);
        
        JPanel Emocion = new JPanel(new GridLayout(5,2,5,5));
        
        lblNombre = new JLabel("Nombre");
        lblIntensidad = new JLabel("Intensidad");
        lblTipo = new JLabel("Tipo");
        lblAccion = new JLabel("Accion");
        lblEstado = new JLabel("Estado Actual");
        
        txtNombre = new JTextField();
        txtIntensidad = new JTextField();
        cTipo = new JComboBox<String>(new String[] {"Positiva","Negativa"});
        txtAccion = new JTextField();
        txtEstado = new JTextField();
        
        Emocion.add(lblNombre);Emocion.add(txtNombre);
        Emocion.add(lblIntensidad);Emocion.add(txtIntensidad);
        Emocion.add(lblTipo);Emocion.add(cTipo);
        Emocion.add(lblAccion);Emocion.add(txtAccion);
        Emocion.add(lblEstado);Emocion.add(txtEstado);
        
        JPanel PanelEmocion = new JPanel(new GridLayout(1,3,5,5));
        
        JLabel tituloEmocion = new JLabel("Emocion");
        btnAgregarEmocion = new JButton("Agregar");
        
        PanelEmocion.add(tituloEmocion);
        PanelEmocion.add(Emocion);
        PanelEmocion.add(btnAgregarEmocion);
        
        JPanel Evento = new JPanel(new GridLayout(3,2,5,5));
        
        lblNombreEvento = new JLabel("Nombre");
        lblTipoEvento = new JLabel("Tipo");
        lblImpacto = new JLabel("Impacto Emocional");
        
        txtNombreEvento = new JTextField();
        cTipoEvento = new JComboBox<String>(new String[] {"Social","Escolar","Familiar"});
        txtImpacto = new JTextField();
        
        Evento.add(lblNombreEvento);Evento.add(txtNombreEvento);
        Evento.add(lblTipoEvento);Evento.add(cTipoEvento);
        Evento.add(lblImpacto);Evento.add(txtImpacto);
        
        JPanel PanelEvento = new JPanel(new GridLayout(1,3,5,5));
        
        JLabel tituloEvento = new JLabel("Evento");
        btnAgregarEvento = new JButton("Agregar");
        
        PanelEvento.add(tituloEvento);
        PanelEvento.add(Evento);
        PanelEvento.add(btnAgregarEvento);
        
        JPanel panelSuperior = new JPanel(new GridLayout(3,1,20,20));
        
        panelSuperior.add(PanelRecuerdo);
        panelSuperior.add(PanelEmocion);
        panelSuperior.add(PanelEvento);
        
        txtSalida = new JTextArea();
        txtSalida.setEditable(false);
        
        add(panelSuperior, BorderLayout.NORTH);
        add(txtSalida, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    public JButton getBtnAgregarRecuerdo(){
        return btnAgregarRecuerdo;
    }
    
    public JButton getBtnAgregarEmocion(){
        return this.btnAgregarEmocion;
    }

    public JButton getBtnAgregarEvento(){
        return this.btnAgregarEvento;
    }

    public JTextField getTxtCodigo(){
        return this.txtCodigo;
    }//end method getTxtCodigo

    public JTextField getTxtDescripcion(){
        return this.txtDescripcion;
    }//end method getTxtDescripcion

    public JTextField getTxtFecha(){
        return this.txtFecha;
    }//end method getTxtFecha

    public JTextField getTxtEmocion(){
        return this.txtEmocion;
    }//end method getTxtEmocion

    public JTextField getTxtEvento(){
        return this.txtEvento;
    }//end method getTxtEvento

    public JTextField getTxtNombre(){
        return this.txtNombre;
    }//end method getTxtNombre

    public JTextField getTxtIntensidad(){
        return this.txtIntensidad;
    }//end method getTxtIntensidad

    public JTextField getTxtTipo(){
        return this.txtTipo;
    }//end method getTxtTipo

    public JTextField getTxtNombreEvento(){
        return this.txtNombreEvento;
    }//end method getTxtNombreEvento

    public JTextField getTxtImpacto(){
        return this.txtImpacto;
    }//end method getTxtImpacto

    public JComboBox<String> getCTipoEvento(){
        return this.cTipoEvento;
    }//end method getCTipoEvento

//End GetterSetterExtension Source Code



//Start GetterSetterExtension Source Code

    /**GET Method Propertie txtSalida*/
    public JTextArea getTxtSalida(){
        return this.txtSalida;
    }//end method getTxtSalida

//End GetterSetterExtension Source Code



//Start GetterSetterExtension Source Code

    /**GET Method Propertie txtAccion*/
    public JTextField getTxtAccion(){
        return this.txtAccion;
    }//end method getTxtAccion


    /**GET Method Propertie txtEstado*/
    public JTextField getTxtEstado(){
        return this.txtEstado;
    }//end method getTxtEstado


    /**GET Method Propertie cTipo*/
    public javax.swing.JComboBox<java.lang.String> getCTipo(){
        return this.cTipo;
    }//end method getCTipo




}//End class