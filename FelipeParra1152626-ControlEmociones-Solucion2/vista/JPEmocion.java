package vista;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPEmocion extends JPanel
{
   private JLabel lblNombre, lblIntensidad, lblTipo, lblAccion , lblEstado;
   private JTextField txtNombre, txtIntensidad, txtAccion, txtEstado;
   private JComboBox cbTipo;
   private JTextArea campoTexto;
   private JButton btnAgregar ;
   
   public JPEmocion(){
       revalidate();
       setSize(300,200);
       setLayout(new BorderLayout());

       JPanel panelText = new JPanel(new GridLayout(5,2));
       
        lblNombre = new JLabel("Nombre");
        lblIntensidad = new JLabel("Intensidad: (1 a 10)");
        lblTipo = new JLabel("Tipo: ");
        lblAccion = new JLabel("Accion: ");
        lblEstado = new JLabel("Estado: ");
        
        txtNombre = new JTextField();
        cbTipo = new JComboBox() ;
        cbTipo.addItem("Positiva");
        cbTipo.addItem("Negativa"); 
        
        txtIntensidad = new JTextField();
        txtAccion = new JTextField();
        txtEstado = new JTextField();
        
        
        panelText.add(lblNombre);
        panelText.add(txtNombre);
        panelText.add(lblIntensidad);
        panelText.add(txtIntensidad);
        panelText.add(lblTipo);
        panelText.add(cbTipo);
        panelText.add(lblAccion);
        panelText.add(txtAccion);
        panelText.add(lblEstado);
        panelText.add(txtEstado);
        
        campoTexto  = new JTextArea();
        campoTexto.setEditable(false);
        
        btnAgregar = new JButton("Agregar");
        
        add(panelText,BorderLayout.NORTH);
        add(campoTexto,BorderLayout.CENTER);
        add(btnAgregar,BorderLayout.SOUTH);
        
   }

//Start GetterSetterExtension Source Code

    /**GET Method Propertie lblNombre*/
    public JLabel getLblNombre(){
        return this.lblNombre;
    }//end method getLblNombre

    /**SET Method Propertie lblNombre*/
    public void setLblNombre(JLabel lblNombre){
        this.lblNombre = lblNombre;
    }//end method setLblNombre

    /**GET Method Propertie lblIntensidad*/
    public JLabel getLblIntensidad(){
        return this.lblIntensidad;
    }//end method getLblIntensidad

    /**SET Method Propertie lblIntensidad*/
    public void setLblIntensidad(JLabel lblIntensidad){
        this.lblIntensidad = lblIntensidad;
    }//end method setLblIntensidad

    /**GET Method Propertie lblTipo*/
    public JLabel getLblTipo(){
        return this.lblTipo;
    }//end method getLblTipo

    /**SET Method Propertie lblTipo*/
    public void setLblTipo(JLabel lblTipo){
        this.lblTipo = lblTipo;
    }//end method setLblTipo

    /**GET Method Propertie lblAccion*/
    public JLabel getLblAccion(){
        return this.lblAccion;
    }//end method getLblAccion

    /**SET Method Propertie lblAccion*/
    public void setLblAccion(JLabel lblAccion){
        this.lblAccion = lblAccion;
    }//end method setLblAccion

    /**GET Method Propertie lblEstado*/
    public JLabel getLblEstado(){
        return this.lblEstado;
    }//end method getLblEstado

    /**SET Method Propertie lblEstado*/
    public void setLblEstado(JLabel lblEstado){
        this.lblEstado = lblEstado;
    }//end method setLblEstado

    /**GET Method Propertie txtNombre*/
    public JTextField getTxtNombre(){
        return this.txtNombre;
    }//end method getTxtNombre

    /**SET Method Propertie txtNombre*/
    public void setTxtNombre(JTextField txtNombre){
        this.txtNombre = txtNombre;
    }//end method setTxtNombre

    /**GET Method Propertie txtIntensidad*/
    public JTextField getTxtIntensidad(){
        return this.txtIntensidad;
    }//end method getTxtIntensidad

    /**SET Method Propertie txtIntensidad*/
    public void setTxtIntensidad(JTextField txtIntensidad){
        this.txtIntensidad = txtIntensidad;
    }//end method setTxtIntensidad

    /**GET Method Propertie txtAccion*/
    public JTextField getTxtAccion(){
        return this.txtAccion;
    }//end method getTxtAccion

    /**SET Method Propertie txtAccion*/
    public void setTxtAccion(JTextField txtAccion){
        this.txtAccion = txtAccion;
    }//end method setTxtAccion

    /**GET Method Propertie txtEstado*/
    public JTextField getTxtEstado(){
        return this.txtEstado;
    }//end method getTxtEstado

    /**SET Method Propertie txtEstado*/
    public void setTxtEstado(JTextField txtEstado){
        this.txtEstado = txtEstado;
    }//end method setTxtEstado

    /**GET Method Propertie cbTipo*/
    public JComboBox getCbTipo(){
        return this.cbTipo;
    }//end method getCbTipo

    /**SET Method Propertie cbTipo*/
    public void setCbTipo(JComboBox cbTipo){
        this.cbTipo = cbTipo;
    }//end method setCbTipo

    /**GET Method Propertie campoTexto*/
    public JTextArea getCampoTexto(){
        return this.campoTexto;
    }//end method getCampoTexto

    /**SET Method Propertie campoTexto*/
    public void setCampoTexto(JTextArea campoTexto){
        this.campoTexto = campoTexto;
    }//end method setCampoTexto

    /**GET Method Propertie btnAgregar*/
    public JButton getBtnAgregar(){
        return this.btnAgregar;
    }//end method getBtnAgregar

    /**SET Method Propertie btnAgregar*/
    public void setBtnAgregar(JButton btnAgregar){
        this.btnAgregar = btnAgregar;
    }//end method setBtnAgregar

//End GetterSetterExtension Source Code


}//End class