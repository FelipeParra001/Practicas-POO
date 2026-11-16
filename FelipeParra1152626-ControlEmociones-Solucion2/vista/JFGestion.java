package vista;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

public class JFGestion extends JFrame
{
    private JLabel lblEmocion, lblRecuerdo, lblEvento ;
    private JButton btnEmocion, btnRecuerdo, btnEvento,btnListarRecuerdos, btrEmocionMas ,btnMasFuerte, btnLista5;
    private JTextArea campoTexto;
    private JPanel panelMedio;
    public JFGestion(){
        setTitle("Sistema de Gestion de Emociones");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);

       JPanel panelText = new JPanel(new GridLayout(3,2));
       
        lblEmocion = new JLabel("Agregar Emocion:");
        lblRecuerdo = new JLabel("Agregar Recuerdo: ");
        lblEvento = new JLabel("Agregar Evento");
        
         btnEmocion = new JButton("Agregar");
        btnRecuerdo = new JButton("Agregar");
         btnEvento = new JButton("Agregar");

        panelText.add(lblEmocion);
        panelText.add(btnEmocion);
        panelText.add(lblRecuerdo);
        panelText.add(btnRecuerdo);
        panelText.add(lblEvento);
        panelText.add(btnEvento);
        
        panelMedio = new JPanel(new GridLayout(1,1));
        campoTexto  = new JTextArea();
        campoTexto.setEditable(false);
        
        panelMedio.add(campoTexto);
        
        JPanel panelBotones  = new JPanel(new GridLayout(1,4));
            
        btnListarRecuerdos = new JButton("Listar Recuerdos");
        btrEmocionMas = new JButton("Estado Emocional");
        btnMasFuerte = new JButton("Emocion mas intensa");
        btnLista5 = new JButton("Ultimos Recuerdos");
        panelBotones.add(btnListarRecuerdos);
        panelBotones.add(btrEmocionMas);
        panelBotones.add(btnMasFuerte);
        panelBotones.add(btnLista5);
        
        add(panelBotones,BorderLayout.SOUTH);
        add(panelMedio,BorderLayout.CENTER);
        add(panelText,BorderLayout.NORTH);
        
        
        setVisible(true);
        revalidate();

    }
   
   public void reemplazarPanelCentral(JPanel nuevo){
       remove(panelMedio) ;
       panelMedio = nuevo ;
       add(panelMedio,BorderLayout.CENTER);
       this.setVisible(true);
       revalidate();
       repaint();
       //No se pq no se muestra bien los panelesss 
   }

//Start GetterSetterExtension Source Code

    /**GET Method Propertie lblEmocion*/
    public JLabel getLblEmocion(){
        return this.lblEmocion;
    }//end method getLblEmocion

    /**SET Method Propertie lblEmocion*/
    public void setLblEmocion(JLabel lblEmocion){
        this.lblEmocion = lblEmocion;
    }//end method setLblEmocion

    /**GET Method Propertie lblRecuerdo*/
    public JLabel getLblRecuerdo(){
        return this.lblRecuerdo;
    }//end method getLblRecuerdo

    /**SET Method Propertie lblRecuerdo*/
    public void setLblRecuerdo(JLabel lblRecuerdo){
        this.lblRecuerdo = lblRecuerdo;
    }//end method setLblRecuerdo

    /**GET Method Propertie lblEvento*/
    public JLabel getLblEvento(){
        return this.lblEvento;
    }//end method getLblEvento

    /**SET Method Propertie lblEvento*/
    public void setLblEvento(JLabel lblEvento){
        this.lblEvento = lblEvento;
    }//end method setLblEvento

    /**GET Method Propertie btnEmocion*/
    public JButton getBtnEmocion(){
        return this.btnEmocion;
    }//end method getBtnEmocion

    /**SET Method Propertie btnEmocion*/
    public void setBtnEmocion(JButton btnEmocion){
        this.btnEmocion = btnEmocion;
    }//end method setBtnEmocion

    /**GET Method Propertie btnRecuerdo*/
    public JButton getBtnRecuerdo(){
        return this.btnRecuerdo;
    }//end method getBtnRecuerdo

    /**SET Method Propertie btnRecuerdo*/
    public void setBtnRecuerdo(JButton btnRecuerdo){
        this.btnRecuerdo = btnRecuerdo;
    }//end method setBtnRecuerdo

    /**GET Method Propertie btnEvento*/
    public JButton getBtnEvento(){
        return this.btnEvento;
    }//end method getBtnEvento

    /**SET Method Propertie btnEvento*/
    public void setBtnEvento(JButton btnEvento){
        this.btnEvento = btnEvento;
    }//end method setBtnEvento

    /**GET Method Propertie btnListarRecuerdos*/
    public JButton getBtnListarRecuerdos(){
        return this.btnListarRecuerdos;
    }//end method getBtnListarRecuerdos

    /**SET Method Propertie btnListarRecuerdos*/
    public void setBtnListarRecuerdos(JButton btnListarRecuerdos){
        this.btnListarRecuerdos = btnListarRecuerdos;
    }//end method setBtnListarRecuerdos

    /**GET Method Propertie btrnEmocionMas*/
    public JButton getBtrEmocionMas(){
        return this.btrEmocionMas;
    }//end method getBtrnEmocionMas

    /**SET Method Propertie btrnEmocionMas*/
    public void setBtrEmocionMas(JButton btrnEmocionMas){
        this.btrEmocionMas = btrnEmocionMas;
    }//end method setBtrnEmocionMas

    /**GET Method Propertie btnLista5*/
    public JButton getBtnLista5(){
        return this.btnLista5;
    }//end method getBtnLista5

    /**SET Method Propertie btnLista5*/
    public void setBtnLista5(JButton btnLista5){
        this.btnLista5 = btnLista5;
    }//end method setBtnLista5

    /**GET Method Propertie campoTexto*/
    public JTextArea getCampoTexto(){
        return this.campoTexto;
    }//end method getCampoTexto

    /**SET Method Propertie campoTexto*/
    public void setCampoTexto(JTextArea campoTexto){
        this.campoTexto = campoTexto;
    }//end method setCampoTexto

    /**GET Method Propertie panelMedio*/
    public JPanel getPanelMedio(){
        return this.panelMedio;
    }//end method getPanelMedio

    /**SET Method Propertie panelMedio*/
    public void setPanelMedio(JPanel panelMedio){
        this.panelMedio = panelMedio;
    }//end method setPanelMedio

//End GetterSetterExtension Source Code



//Start GetterSetterExtension Source Code

    /**GET Method Propertie btnMasFuerte*/
    public JButton getBtnMasFuerte(){
        return this.btnMasFuerte;
    }//end method getBtnMasFuerte

//End GetterSetterExtension Source Code


}//End class