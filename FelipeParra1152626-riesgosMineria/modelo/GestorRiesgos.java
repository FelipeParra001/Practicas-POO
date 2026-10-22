package modelo;

import java.util.ArrayList;

public class GestorRiesgos {
    private ArrayList<Riesgo> lista;

    public GestorRiesgos() {
        lista = new ArrayList<>();
    }

    public boolean agregarRiesgo(Riesgo r) {
        for (Riesgo riesgo : lista) {
            if (riesgo.getCodigo().equals(r.getCodigo())) {
                return false; // Código duplicado
            }
        }
        lista.add(r);
        return true;
    }

    public Riesgo buscarPorCodigo(String codigo) {
        for (Riesgo riesgo : lista) {
            if (riesgo.getCodigo().equals(codigo)) {
                return riesgo;
            }
        }
        return null;
    }

    public boolean eliminarRiesgo(String codigo) {
        Riesgo r = buscarPorCodigo(codigo);
        if (r != null) {
            lista.remove(r);
            return true;
        }
        return false;
    }

    public String listarRiesgos() {
        if (lista.isEmpty()) return "No hay riesgos registrados.";
        String resultado = "";
        for (Riesgo r : lista) {
            resultado += r.toString() + "\n\n";
        }
        return resultado;
    }
}