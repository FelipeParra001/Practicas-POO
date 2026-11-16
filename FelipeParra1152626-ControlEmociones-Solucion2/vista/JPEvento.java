package vista;
import javax.swing.*;
import java.awt.*;


public class JPEvento extends JPanel
{
    private JLabel lblNombre, lblTipo , lblEmocion , lblNivelCambio , lblTipoCambio; 
    private JTextField txtNombre, txtNivelCambio;
    private JComboBox cbTipo, cbTipoCambio, cbEmocion ;
    private JButton btnAgregar ;
    private JTextArea campoTexto ;
    public JPEvento(){
       setLayout(new BorderLayout());

       JPanel panelText = new JPanel(new GridLayout(5,2));
        lblNombre = new JLabel("Nombre");
        lblTipo = new JLabel("Tipo de Evento");
        lblEmocion = new JLabel("Emocion Asociada");
        lblNivelCambio = new JLabel("Cambio en la emocion");
        lblTipoCambio = new JLabel("Tipo de Cambio");
        
        txtNombre = new JTextField();
        txtNivelCambio = new JTextField();
        
        cbEmocion = new JComboBox() ;
        cbTipo = new JComboBox();
        cbTipoCambio = new JComboBox();
        
        cbTipoCambio.addItem("Positivo");
        cbTipoCambio.addItem("Negativo");
        
        cbTipo.addItem("Social");
        cbTipo.addItem("Escolar");
        cbTipo.addItem("Familiar");
        
        panelText.add(lblNombre);
        panelText.add(txtNombre);
        panelText.add(lblTipo);
        panelText.add(cbTipo);
        panelText.add(lblEmocion);
        panelText.add(cbEmocion);
        panelText.add(lblNivelCambio);
        panelText.add(txtNivelCambio);
        panelText.add(lblTipoCambio);
        panelText.add(cbTipoCambio);
        
        
        campoTexto  = new JTextArea();
        campoTexto.setEditable(false);
        
        btnAgregar = new JButton("Agregar");
        
        add(panelText,BorderLayout.NORTH);
        add(campoTexto,BorderLayout.CENTER);
        add(btnAgregar,BorderLayout.SOUTH);
        revalidate();
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

    /**GET Method Propertie lblTipo*/
    public JLabel getLblTipo(){
        return this.lblTipo;
    }//end method getLblTipo

    /**SET Method Propertie lblTipo*/
    public void setLblTipo(JLabel lblTipo){
        this.lblTipo = lblTipo;
    }//end method setLblTipo

    /**GET Method Propertie lblEmocion*/
    public JLabel getLblEmocion(){
        return this.lblEmocion;
    }//end method getLblEmocion

    /**SET Method Propertie lblEmocion*/
    public void setLblEmocion(JLabel lblEmocion){
        this.lblEmocion = lblEmocion;
    }//end method setLblEmocion

    /**GET Method Propertie lblNivelCambio*/
    public JLabel getLblNivelCambio(){
        return this.lblNivelCambio;
    }//end method getLblNivelCambio

    /**SET Method Propertie lblNivelCambio*/
    public void setLblNivelCambio(JLabel lblNivelCambio){
        this.lblNivelCambio = lblNivelCambio;
    }//end method setLblNivelCambio

    /**GET Method Propertie lblTipoCambio*/
    public JLabel getLblTipoCambio(){
        return this.lblTipoCambio;
    }//end method getLblTipoCambio

    /**SET Method Propertie lblTipoCambio*/
    public void setLblTipoCambio(JLabel lblTipoCambio){
        this.lblTipoCambio = lblTipoCambio;
    }//end method setLblTipoCambio

    /**GET Method Propertie txtNombre*/
    public JTextField getTxtNombre(){
        return this.txtNombre;
    }//end method getTxtNombre

    /**SET Method Propertie txtNombre*/
    public void setTxtNombre(JTextField txtNombre){
        this.txtNombre = txtNombre;
    }//end method setTxtNombre

    /**GET Method Propertie txtNivelCambio*/
    public JTextField getTxtNivelCambio(){
        return this.txtNivelCambio;
    }//end method getTxtNivelCambio

    /**SET Method Propertie txtNivelCambio*/
    public void setTxtNivelCambio(JTextField txtNivelCambio){
        this.txtNivelCambio = txtNivelCambio;
    }//end method setTxtNivelCambio

    /**GET Method Propertie cbTipo*/
    public JComboBox getCbTipo(){
        return this.cbTipo;
    }//end method getCbTipo

    /**SET Method Propertie cbTipo*/
    public void setCbTipo(JComboBox cbTipo){
        this.cbTipo = cbTipo;
    }//end method setCbTipo

    /**GET Method Propertie cbTipoCambio*/
    public JComboBox getCbTipoCambio(){
        return this.cbTipoCambio;
    }//end method getCbTipoCambio

    /**SET Method Propertie cbTipoCambio*/
    public void setCbTipoCambio(JComboBox cbTipoCambio){
        this.cbTipoCambio = cbTipoCambio;
    }//end method setCbTipoCambio

    /**GET Method Propertie cbEmocion*/
    public JComboBox getCbEmocion(){
        return this.cbEmocion;
    }//end method getCbEmocion

    /**SET Method Propertie cbEmocion*/
    public void setCbEmocion(JComboBox cbEmocion){
        this.cbEmocion = cbEmocion;
    }//end method setCbEmocion

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