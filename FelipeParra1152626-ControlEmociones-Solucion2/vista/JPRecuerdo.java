package vista;
import javax.swing.*;
import java.awt.*;

public class JPRecuerdo extends JPanel
{   
    private JLabel lblEmociones, lblDescripcion , lblFecha , lblEvento; 
    private JTextField txtDescripcion, txtFecha;
    private JComboBox cbEmociones , cbEventos;
    private JButton btnAgregar ;
    private JTextArea campoTexto ;
    public JPRecuerdo(){
       setLayout(new BorderLayout());

       JPanel panelText = new JPanel(new GridLayout(4,2));
    
        lblDescripcion = new JLabel("Descripcion");
        lblFecha = new JLabel("Fecha");
        lblEmociones= new JLabel("Emociones");
        lblEvento = new JLabel("Evento");
        
        txtDescripcion = new JTextField();
        txtFecha= new JTextField();
        
        cbEmociones = new JComboBox() ;
        cbEventos = new JComboBox();
        
        panelText.add(lblDescripcion);
        panelText.add(txtDescripcion);
        panelText.add(lblFecha);
        panelText.add(txtFecha);
        panelText.add(lblEmociones);
        panelText.add(cbEmociones);
        panelText.add(lblEvento);
        panelText.add(cbEventos);
        
        
        campoTexto  = new JTextArea();
        campoTexto.setEditable(false);
        
        btnAgregar = new JButton("Agregar");
        
        add(panelText,BorderLayout.NORTH);
        add(campoTexto,BorderLayout.CENTER);
        add(btnAgregar,BorderLayout.SOUTH);
        revalidate();
   }





//Start GetterSetterExtension Source Code

    /**GET Method Propertie lblEmociones*/
    public JLabel getLblEmociones(){
        return this.lblEmociones;
    }//end method getLblEmociones

    /**SET Method Propertie lblEmociones*/
    public void setLblEmociones(JLabel lblEmociones){
        this.lblEmociones = lblEmociones;
    }//end method setLblEmociones

    /**GET Method Propertie lblDescripcion*/
    public JLabel getLblDescripcion(){
        return this.lblDescripcion;
    }//end method getLblDescripcion

    /**SET Method Propertie lblDescripcion*/
    public void setLblDescripcion(JLabel lblDescripcion){
        this.lblDescripcion = lblDescripcion;
    }//end method setLblDescripcion

    /**GET Method Propertie lblFecha*/
    public JLabel getLblFecha(){
        return this.lblFecha;
    }//end method getLblFecha

    /**SET Method Propertie lblFecha*/
    public void setLblFecha(JLabel lblFecha){
        this.lblFecha = lblFecha;
    }//end method setLblFecha

    /**GET Method Propertie lblEvento*/
    public JLabel getLblEvento(){
        return this.lblEvento;
    }//end method getLblEvento

    /**SET Method Propertie lblEvento*/
    public void setLblEvento(JLabel lblEvento){
        this.lblEvento = lblEvento;
    }//end method setLblEvento

    /**GET Method Propertie txtDescripcion*/
    public JTextField getTxtDescripcion(){
        return this.txtDescripcion;
    }//end method getTxtDescripcion

    /**SET Method Propertie txtDescripcion*/
    public void setTxtDescripcion(JTextField txtDescripcion){
        this.txtDescripcion = txtDescripcion;
    }//end method setTxtDescripcion

    /**GET Method Propertie txtFecha*/
    public JTextField getTxtFecha(){
        return this.txtFecha;
    }//end method getTxtFecha

    /**SET Method Propertie txtFecha*/
    public void setTxtFecha(JTextField txtFecha){
        this.txtFecha = txtFecha;
    }//end method setTxtFecha

    /**GET Method Propertie cbEmociones*/
    public JComboBox getCbEmociones(){
        return this.cbEmociones;
    }//end method getCbEmociones

    /**SET Method Propertie cbEmociones*/
    public void setCbEmociones(JComboBox cbEmociones){
        this.cbEmociones = cbEmociones;
    }//end method setCbEmociones

    /**GET Method Propertie cbEventos*/
    public JComboBox getCbEventos(){
        return this.cbEventos;
    }//end method getCbEventos

    /**SET Method Propertie cbEventos*/
    public void setCbEventos(JComboBox cbEventos){
        this.cbEventos = cbEventos;
    }//end method setCbEventos

    /**GET Method Propertie btnAgregar*/
    public JButton getBtnAgregar(){
        return this.btnAgregar;
    }//end method getBtnAgregar

    /**SET Method Propertie btnAgregar*/
    public void setBtnAgregar(JButton btnAgregar){
        this.btnAgregar = btnAgregar;
    }//end method setBtnAgregar

    /**GET Method Propertie campoTexto*/
    public JTextArea getCampoTexto(){
        return this.campoTexto;
    }//end method getCampoTexto

    /**SET Method Propertie campoTexto*/
    public void setCampoTexto(JTextArea campoTexto){
        this.campoTexto = campoTexto;
    }//end method setCampoTexto

//End GetterSetterExtension Source Code


}//End class