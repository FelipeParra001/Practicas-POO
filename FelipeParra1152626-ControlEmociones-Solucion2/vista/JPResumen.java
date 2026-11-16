package vista;
import javax.swing.*;
import java.awt.*;

public class JPResumen extends JPanel
{
    private JTextArea campoResumen ;
    
    public JPResumen(){
        setLayout(new GridLayout());
        campoResumen = new JTextArea();
        campoResumen.setEditable(false);
        add(new JScrollPane(campoResumen),BorderLayout.CENTER);
    }
    

//Start GetterSetterExtension Source Code

    /**GET Method Propertie campoResumen*/
    public JTextArea getCampoResumen(){
        return this.campoResumen;
    }//end method getCampoResumen

    /**SET Method Propertie campoResumen*/
    public void setCampoResumen(JTextArea campoResumen){
        this.campoResumen = campoResumen;
    }//end method setCampoResumen

//End GetterSetterExtension Source Code


}//End class