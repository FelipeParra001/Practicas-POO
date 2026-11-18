package vista;
import javax.swing.*;
import java.awt.*;

public class JFElecciones extends JFrame
{
    // Candidato a personero
    private JTextField txtNombreP, txtApellidoP, txtGradoP, txtGrupoP, txtLemaP, txtTarjetonP;
    private JTextField txtIdMascota, txtNombreMascota, txtEdadMascota, txtCualidades;
    private JComboBox<String> cbGenero, cbTipoMascota;
    private JButton btnRegistrarPersonero;

    // Candidato a representante
    private JTextField txtNombreR, txtApellidoR, txtGradoR, txtGrupoR, txtLemaR, txtTarjetonR;
    private JTextField txtNombreFormula, txtApellidoFormula;
    private JButton btnRegistrarRepresentante;

    // Votacion
    private JComboBox<String> cbTipoVoto;
    private JTextField txtTarjetonVoto;
    private JButton btnVotar, btnVotoBlanco, btnVotoNulo;

    // Resultados
    private JButton btnListar, btnRF1, btnRF2, btnRF3, btnRF4;

    private JTextArea txtSalida;

    public JFElecciones(){
        setTitle("Elecciones 2021 - Colegio La alegría de estudiar");
        setSize(650,650);
        setLayout(new BorderLayout(10,10));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane pestanas = new JTabbedPane();

        // ==================== PERSONERO ====================
        JPanel panelPersonero = new JPanel(new GridLayout(13,2,5,5));

        txtNombreP = new JTextField();
        txtApellidoP = new JTextField();
        txtGradoP = new JTextField();
        txtGrupoP = new JTextField();
        txtLemaP = new JTextField();
        txtTarjetonP = new JTextField();
        txtIdMascota = new JTextField();
        txtNombreMascota = new JTextField();
        cbGenero = new JComboBox<String>(new String[] {"Macho","Hembra"});
        txtEdadMascota = new JTextField();
        txtCualidades = new JTextField();
        cbTipoMascota = new JComboBox<String>(new String[] {"Aereo","Terrestre","Acuatico"});
        btnRegistrarPersonero = new JButton("Registrar personero");

        panelPersonero.add(new JLabel("Nombre")); panelPersonero.add(txtNombreP);
        panelPersonero.add(new JLabel("Apellido")); panelPersonero.add(txtApellidoP);
        panelPersonero.add(new JLabel("Grado (1 a 11)")); panelPersonero.add(txtGradoP);
        panelPersonero.add(new JLabel("Grupo")); panelPersonero.add(txtGrupoP);
        panelPersonero.add(new JLabel("Lema")); panelPersonero.add(txtLemaP);
        panelPersonero.add(new JLabel("Número de tarjetón")); panelPersonero.add(txtTarjetonP);
        panelPersonero.add(new JLabel("Identificación mascota")); panelPersonero.add(txtIdMascota);
        panelPersonero.add(new JLabel("Nombre mascota")); panelPersonero.add(txtNombreMascota);
        panelPersonero.add(new JLabel("Género mascota")); panelPersonero.add(cbGenero);
        panelPersonero.add(new JLabel("Edad mascota")); panelPersonero.add(txtEdadMascota);
        panelPersonero.add(new JLabel("Cualidades")); panelPersonero.add(txtCualidades);
        panelPersonero.add(new JLabel("Tipo de animal")); panelPersonero.add(cbTipoMascota);
        panelPersonero.add(new JLabel("")); panelPersonero.add(btnRegistrarPersonero);

        // ==================== REPRESENTANTE ====================
        JPanel panelRepresentante = new JPanel(new GridLayout(9,2,5,5));

        txtNombreR = new JTextField();
        txtApellidoR = new JTextField();
        txtGradoR = new JTextField();
        txtGrupoR = new JTextField();
        txtLemaR = new JTextField();
        txtTarjetonR = new JTextField();
        txtNombreFormula = new JTextField();
        txtApellidoFormula = new JTextField();
        btnRegistrarRepresentante = new JButton("Registrar representante");

        panelRepresentante.add(new JLabel("Nombre")); panelRepresentante.add(txtNombreR);
        panelRepresentante.add(new JLabel("Apellido")); panelRepresentante.add(txtApellidoR);
        panelRepresentante.add(new JLabel("Grado (1 a 11)")); panelRepresentante.add(txtGradoR);
        panelRepresentante.add(new JLabel("Grupo")); panelRepresentante.add(txtGrupoR);
        panelRepresentante.add(new JLabel("Lema")); panelRepresentante.add(txtLemaR);
        panelRepresentante.add(new JLabel("Número de tarjetón")); panelRepresentante.add(txtTarjetonR);
        panelRepresentante.add(new JLabel("Nombre fórmula")); panelRepresentante.add(txtNombreFormula);
        panelRepresentante.add(new JLabel("Apellido fórmula")); panelRepresentante.add(txtApellidoFormula);
        panelRepresentante.add(new JLabel("")); panelRepresentante.add(btnRegistrarRepresentante);

        // ==================== VOTACION ====================
        JPanel panelVotacion = new JPanel(new GridLayout(4,2,5,5));

        cbTipoVoto = new JComboBox<String>(new String[] {"Personero","Representante"});
        txtTarjetonVoto = new JTextField();
        btnVotar = new JButton("Votar por el tarjetón");
        btnVotoBlanco = new JButton("Voto en blanco");
        btnVotoNulo = new JButton("Voto nulo");

        panelVotacion.add(new JLabel("Votación de")); panelVotacion.add(cbTipoVoto);
        panelVotacion.add(new JLabel("Número de tarjetón")); panelVotacion.add(txtTarjetonVoto);
        panelVotacion.add(new JLabel("")); panelVotacion.add(btnVotar);
        panelVotacion.add(btnVotoBlanco); panelVotacion.add(btnVotoNulo);

        JPanel contenedorVotacion = new JPanel(new BorderLayout());
        contenedorVotacion.add(panelVotacion, BorderLayout.NORTH);

        // ==================== RESULTADOS ====================
        JPanel panelResultados = new JPanel(new GridLayout(5,1,5,5));

        btnListar = new JButton("Ver candidatos");
        btnRF1 = new JButton("RF1 - Total de votos por candidato");
        btnRF2 = new JButton("RF2 - Personero elegido");
        btnRF3 = new JButton("RF3 - Personero con menor votación");
        btnRF4 = new JButton("RF4 - Población electoral");

        panelResultados.add(btnListar);
        panelResultados.add(btnRF1);
        panelResultados.add(btnRF2);
        panelResultados.add(btnRF3);
        panelResultados.add(btnRF4);

        pestanas.addTab("Personero", panelPersonero);
        pestanas.addTab("Representante", panelRepresentante);
        pestanas.addTab("Votación", contenedorVotacion);
        pestanas.addTab("Resultados", panelResultados);

        txtSalida = new JTextArea(10,40);
        txtSalida.setEditable(false);

        add(pestanas, BorderLayout.CENTER);
        add(new JScrollPane(txtSalida), BorderLayout.SOUTH);
    }

    // ==================== METODOS DE LA VISTA ====================

    public void limpiarPersonero(){
        txtNombreP.setText("");
        txtApellidoP.setText("");
        txtGradoP.setText("");
        txtGrupoP.setText("");
        txtLemaP.setText("");
        txtTarjetonP.setText("");
        txtIdMascota.setText("");
        txtNombreMascota.setText("");
        txtEdadMascota.setText("");
        txtCualidades.setText("");
    }

    public void limpiarRepresentante(){
        txtNombreR.setText("");
        txtApellidoR.setText("");
        txtGradoR.setText("");
        txtGrupoR.setText("");
        txtLemaR.setText("");
        txtTarjetonR.setText("");
        txtNombreFormula.setText("");
        txtApellidoFormula.setText("");
    }

    // ==================== GET ====================

    public JTextField getTxtNombreP(){
        return this.txtNombreP;
    }

    public JTextField getTxtApellidoP(){
        return this.txtApellidoP;
    }

    public JTextField getTxtGradoP(){
        return this.txtGradoP;
    }

    public JTextField getTxtGrupoP(){
        return this.txtGrupoP;
    }

    public JTextField getTxtLemaP(){
        return this.txtLemaP;
    }

    public JTextField getTxtTarjetonP(){
        return this.txtTarjetonP;
    }

    public JTextField getTxtIdMascota(){
        return this.txtIdMascota;
    }

    public JTextField getTxtNombreMascota(){
        return this.txtNombreMascota;
    }

    public JTextField getTxtEdadMascota(){
        return this.txtEdadMascota;
    }

    public JTextField getTxtCualidades(){
        return this.txtCualidades;
    }

    public JComboBox<String> getCbGenero(){
        return this.cbGenero;
    }

    public JComboBox<String> getCbTipoMascota(){
        return this.cbTipoMascota;
    }

    public JButton getBtnRegistrarPersonero(){
        return this.btnRegistrarPersonero;
    }

    public JTextField getTxtNombreR(){
        return this.txtNombreR;
    }

    public JTextField getTxtApellidoR(){
        return this.txtApellidoR;
    }

    public JTextField getTxtGradoR(){
        return this.txtGradoR;
    }

    public JTextField getTxtGrupoR(){
        return this.txtGrupoR;
    }

    public JTextField getTxtLemaR(){
        return this.txtLemaR;
    }

    public JTextField getTxtTarjetonR(){
        return this.txtTarjetonR;
    }

    public JTextField getTxtNombreFormula(){
        return this.txtNombreFormula;
    }

    public JTextField getTxtApellidoFormula(){
        return this.txtApellidoFormula;
    }

    public JButton getBtnRegistrarRepresentante(){
        return this.btnRegistrarRepresentante;
    }

    public JComboBox<String> getCbTipoVoto(){
        return this.cbTipoVoto;
    }

    public JTextField getTxtTarjetonVoto(){
        return this.txtTarjetonVoto;
    }

    public JButton getBtnVotar(){
        return this.btnVotar;
    }

    public JButton getBtnVotoBlanco(){
        return this.btnVotoBlanco;
    }

    public JButton getBtnVotoNulo(){
        return this.btnVotoNulo;
    }

    public JButton getBtnListar(){
        return this.btnListar;
    }

    public JButton getBtnRF1(){
        return this.btnRF1;
    }

    public JButton getBtnRF2(){
        return this.btnRF2;
    }

    public JButton getBtnRF3(){
        return this.btnRF3;
    }

    public JButton getBtnRF4(){
        return this.btnRF4;
    }

    public JTextArea getTxtSalida(){
        return this.txtSalida;
    }
}//End class
