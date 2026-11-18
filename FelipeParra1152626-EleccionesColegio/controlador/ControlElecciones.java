package controlador;
import modelo.*;
import vista.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControlElecciones implements ActionListener
{
    private JFElecciones vista;
    private Eleccion modelo;

    public ControlElecciones(JFElecciones vista, Eleccion modelo){
        this.vista = vista;
        this.modelo = modelo;

        this.vista.getBtnRegistrarPersonero().addActionListener(this);
        this.vista.getBtnRegistrarRepresentante().addActionListener(this);
        this.vista.getBtnVotar().addActionListener(this);
        this.vista.getBtnVotoBlanco().addActionListener(this);
        this.vista.getBtnVotoNulo().addActionListener(this);
        this.vista.getBtnListar().addActionListener(this);
        this.vista.getBtnRF1().addActionListener(this);
        this.vista.getBtnRF2().addActionListener(this);
        this.vista.getBtnRF3().addActionListener(this);
        this.vista.getBtnRF4().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if(source == vista.getBtnRegistrarPersonero()){
            registrarPersonero();
        }
        else if(source == vista.getBtnRegistrarRepresentante()){
            registrarRepresentante();
        }
        else if(source == vista.getBtnVotar()){
            votar();
        }
        else if(source == vista.getBtnVotoBlanco()){
            votoBlanco();
        }
        else if(source == vista.getBtnVotoNulo()){
            votoNulo();
        }
        else if(source == vista.getBtnListar()){
            vista.getTxtSalida().setText(modelo.listarCandidatos());
        }
        else if(source == vista.getBtnRF1()){
            vista.getTxtSalida().setText(modelo.totalVotosPorCandidato());
        }
        else if(source == vista.getBtnRF2()){
            mostrarPersoneroElegido();
        }
        else if(source == vista.getBtnRF3()){
            mostrarMenorVotacion();
        }
        else if(source == vista.getBtnRF4()){
            mostrarPoblacionElectoral();
        }
    }

    // Convierte el texto a entero, devuelve -1 si no es un numero
    private int leerEntero(String texto){
        try{
            return Integer.parseInt(texto.trim());
        }
        catch(NumberFormatException ex){
            return -1;
        }
    }

    // ==================== REGISTRO DE CANDIDATOS ====================

    public void registrarPersonero(){
        String nombre = vista.getTxtNombreP().getText().trim();
        String apellido = vista.getTxtApellidoP().getText().trim();
        String grupo = vista.getTxtGrupoP().getText().trim();
        String lema = vista.getTxtLemaP().getText().trim();
        String idMascota = vista.getTxtIdMascota().getText().trim();
        String nombreMascota = vista.getTxtNombreMascota().getText().trim();
        String cualidades = vista.getTxtCualidades().getText().trim();
        String genero = (String) vista.getCbGenero().getSelectedItem();
        String tipo = (String) vista.getCbTipoMascota().getSelectedItem();

        if(nombre.isEmpty() || apellido.isEmpty() || grupo.isEmpty() || lema.isEmpty()
            || idMascota.isEmpty() || nombreMascota.isEmpty() || cualidades.isEmpty()){
            JOptionPane.showMessageDialog(vista, "Complete todos los campos");
            return;
        }

        int grado = leerEntero(vista.getTxtGradoP().getText());
        int tarjeton = leerEntero(vista.getTxtTarjetonP().getText());
        int edadMascota = leerEntero(vista.getTxtEdadMascota().getText());

        if(grado < 1 || grado > 11){
            JOptionPane.showMessageDialog(vista, "El grado debe ser un número de 1 a 11");
            return;
        }
        if(tarjeton <= 0){
            JOptionPane.showMessageDialog(vista, "El tarjetón debe ser un número mayor que 0");
            return;
        }
        if(edadMascota < 0){
            JOptionPane.showMessageDialog(vista, "La edad de la mascota debe ser un número entero");
            return;
        }

        Mascota mascota = modelo.crearMascota(tipo, idMascota, nombreMascota, genero, edadMascota, cualidades);
        if(mascota == null){
            JOptionPane.showMessageDialog(vista, "Ya existe una mascota con esa identificación");
            return;
        }

        if(modelo.registrarPersonero(nombre, apellido, grado, grupo, lema, tarjeton, mascota)){
            vista.getTxtSalida().setText("Candidato a personero registrado correctamente");
            vista.limpiarPersonero();
        }else{
            JOptionPane.showMessageDialog(vista, "Ya existe un candidato a personero con ese tarjetón");
        }
    }

    public void registrarRepresentante(){
        String nombre = vista.getTxtNombreR().getText().trim();
        String apellido = vista.getTxtApellidoR().getText().trim();
        String grupo = vista.getTxtGrupoR().getText().trim();
        String lema = vista.getTxtLemaR().getText().trim();
        String nombreFormula = vista.getTxtNombreFormula().getText().trim();
        String apellidoFormula = vista.getTxtApellidoFormula().getText().trim();

        if(nombre.isEmpty() || apellido.isEmpty() || grupo.isEmpty() || lema.isEmpty()
            || nombreFormula.isEmpty() || apellidoFormula.isEmpty()){
            JOptionPane.showMessageDialog(vista, "Complete todos los campos");
            return;
        }

        int grado = leerEntero(vista.getTxtGradoR().getText());
        int tarjeton = leerEntero(vista.getTxtTarjetonR().getText());

        if(grado < 1 || grado > 11){
            JOptionPane.showMessageDialog(vista, "El grado debe ser un número de 1 a 11");
            return;
        }
        if(tarjeton <= 0){
            JOptionPane.showMessageDialog(vista, "El tarjetón debe ser un número mayor que 0");
            return;
        }

        if(modelo.registrarRepresentante(nombre, apellido, grado, grupo, lema, tarjeton, nombreFormula, apellidoFormula)){
            vista.getTxtSalida().setText("Candidato a representante registrado correctamente");
            vista.limpiarRepresentante();
        }else{
            JOptionPane.showMessageDialog(vista, "Ya existe un candidato a representante con ese tarjetón");
        }
    }

    // ==================== VOTACION ====================

    public void votar(){
        String tipo = (String) vista.getCbTipoVoto().getSelectedItem();
        int tarjeton = leerEntero(vista.getTxtTarjetonVoto().getText());

        if(tarjeton <= 0){
            JOptionPane.showMessageDialog(vista, "Escriba un número de tarjetón válido");
            return;
        }

        boolean votoRegistrado = false;
        if("Personero".equals(tipo)){
            votoRegistrado = modelo.votarPersonero(tarjeton);
        }else{
            votoRegistrado = modelo.votarRepresentante(tarjeton);
        }

        if(votoRegistrado){
            vista.getTxtSalida().setText("Voto registrado para el tarjetón " + tarjeton + " (" + tipo + ")");
            vista.getTxtTarjetonVoto().setText("");
        }else{
            JOptionPane.showMessageDialog(vista, "No existe un candidato a " + tipo + " con ese tarjetón");
        }
    }

    public void votoBlanco(){
        String tipo = (String) vista.getCbTipoVoto().getSelectedItem();
        if("Personero".equals(tipo)){
            modelo.votarBlancoPersonero();
        }else{
            modelo.votarBlancoRepresentante();
        }
        vista.getTxtSalida().setText("Voto en blanco registrado (" + tipo + ")");
    }

    public void votoNulo(){
        String tipo = (String) vista.getCbTipoVoto().getSelectedItem();
        if("Personero".equals(tipo)){
            modelo.votarNuloPersonero();
        }else{
            modelo.votarNuloRepresentante();
        }
        vista.getTxtSalida().setText("Voto nulo registrado (" + tipo + ")");
    }

    // ==================== RESULTADOS RF2, RF3 Y RF4 ====================

    public void mostrarPersoneroElegido(){
        if(modelo.getPersoneros().isEmpty()){
            vista.getTxtSalida().setText("No hay candidatos a personero registrados");
            return;
        }
        if(modelo.hayEmpatePersonero()){
            vista.getTxtSalida().setText("Hay empate entre los candidatos con más votos, no hay personero elegido");
            return;
        }
        CandidatoPersonero elegido = modelo.personeroElegido();
        if(elegido == null){
            vista.getTxtSalida().setText("Todavía no hay votos para personero");
        }else{
            vista.getTxtSalida().setText("Personero elegido 2021:\n" + elegido.toString() + "\nVotos: " + elegido.getVotos());
        }
    }

    public void mostrarMenorVotacion(){
        CandidatoPersonero menor = modelo.personeroMenorVotacion();
        if(menor == null){
            vista.getTxtSalida().setText("No hay candidatos a personero registrados");
            return;
        }
        String texto = "Candidato a personería con menor votación:\n" + menor.toString() + "\nVotos: " + menor.getVotos();
        if(modelo.hayEmpateMenorVotacion()){
            texto += "\n(Hay otros candidatos con la misma votación)";
        }
        vista.getTxtSalida().setText(texto);
    }

    public void mostrarPoblacionElectoral(){
        String texto = "Población electoral (personería): " + modelo.poblacionElectoral() + "\n";
        texto += "   Votos en blanco: " + modelo.getVotosBlancoPersonero() + "\n";
        texto += "   Votos nulos: " + modelo.getVotosNulosPersonero() + "\n";
        texto += "Total votos representantes de grado: " + modelo.poblacionElectoralRepresentantes();
        vista.getTxtSalida().setText(texto);
    }
}//End class
