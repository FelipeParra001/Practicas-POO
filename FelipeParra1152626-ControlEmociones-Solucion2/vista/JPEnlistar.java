package vista;
import java.awt.*;
import javax.swing.*;
import javax.swing.*;

public class JPEnlistar extends JPanel
{
   private JLabel lblPregunta;
   private JComboBox cbEmocion;
   private JButton btnEnlistar ;
   private JTextArea campoTexto;
   
   public JPEnlistar(){
       setLayout(new BorderLayout());

       JPanel panelText = new JPanel(new GridLayout(1,2));
       
        lblPregunta = new JLabel("Seleccione la emocion: ");
        
        cbEmocion = new JComboBox() ;
      
        panelText.add(lblPregunta);
        panelText.add(cbEmocion);
        
        btnEnlistar = new JButton("Enlistar");
        
        campoTexto  = new JTextArea();
        campoTexto.setEditable(false);
      
        add(panelText,BorderLayout.NORTH);
        add(new JScrollPane(campoTexto),BorderLayout.CENTER);
        add(btnEnlistar,BorderLayout.SOUTH);
    }

//Start GetterSetterExtension Source Code

    /**GET Method Propertie lblPregunta*/
    public JLabel getLblPregunta(){
        return this.lblPregunta;
    }//end method getLblPregunta

    /**SET Method Propertie lblPregunta*/
    public void setLblPregunta(JLabel lblPregunta){
        this.lblPregunta = lblPregunta;
    }//end method setLblPregunta

    /**GET Method Propertie cbEmocion*/
    public JComboBox getCbEmocion(){
        return this.cbEmocion;
    }//end method getCbEmocion

    /**SET Method Propertie cbEmocion*/
    public void setCbEmocion(JComboBox cbEmocion){
        this.cbEmocion = cbEmocion;
    }//end method setCbEmocion

    /**GET Method Propertie campoTexto*/
    public JTextArea getCampoTexto(){
        return this.campoTexto;
    }//end method getCampoTexto

    /**SET Method Propertie campoTexto*/
    public void setCampoTexto(JTextArea campoTexto){
        this.campoTexto = campoTexto;
    }//end method setCampoTexto

//End GetterSetterExtension Source Code



//Start GetterSetterExtension Source Code

    /**GET Method Propertie btnEnlistar*/
    public JButton getBtnEnlistar(){
        return this.btnEnlistar;
    }//end method getBtnEnlistar

//End GetterSetterExtension Source Code


}//End class