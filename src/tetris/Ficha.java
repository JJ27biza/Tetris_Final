package tetris;

import java.util.ArrayList;

/**
 *
 * @author a22javiermm
 */
public abstract class Ficha {

    ArrayList<Cadrado> cadrados = new ArrayList<Cadrado>();
    int posicion;
    public boolean moverDereita() {
        for (int i = 0; i < cadrados.size(); i++) {
            cadrados.get(i).lblCadrado.setLocation(cadrados.get(i).x = cadrados.get(i).x + 30, cadrados.get(i).y);
        }
        return true;
    }

    public boolean moverAbaixo() {
        for (int i = 0; i < cadrados.size(); i++) {
            cadrados.get(i).lblCadrado.setLocation(cadrados.get(i).x, cadrados.get(i).y = cadrados.get(i).y + 30);
        }
        return true;
    }

    public boolean moverEsquerda() {
        for (int i = 0; i < cadrados.size(); i++) {
            cadrados.get(i).lblCadrado.setLocation(cadrados.get(i).x = cadrados.get(i).x - 30, cadrados.get(i).y);
        }
        return true;
    }

    public abstract boolean rotar();



}
