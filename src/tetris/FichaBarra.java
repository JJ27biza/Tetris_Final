package tetris;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author a22javiermm
 */
public class FichaBarra extends Ficha {

    //ArrayList<Cadrado> cadrados = new ArrayList<Cadrado>();
    Cadrado cadrado0 = new Cadrado(120, 0, Color.YELLOW);
    Cadrado cadrado1 = new Cadrado(120, 30, Color.yellow);
    Cadrado cadrado2 = new Cadrado(120, 60, Color.yellow);
    Cadrado cadrado3 = new Cadrado(120, 90, Color.yellow);
    Border borde;

    public FichaBarra() {
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);
        for (int i = 0; i < cadrados.size(); i++) {
            borde = BorderFactory.createLineBorder(Color.black);
            cadrados.get(i).lblCadrado = new JLabel();
            cadrados.get(i).lblCadrado.setBorder(borde);
            cadrados.get(i).lblCadrado.setBackground(Color.yellow);
            cadrados.get(i).lblCadrado.setOpaque(true);
            cadrados.get(i).lblCadrado.setSize(30, 30);
            cadrados.get(i).lblCadrado.setLocation(cadrados.get(i).x, cadrados.get(i).y);

        }

    }

    public boolean rotar() {
        if (posicion == 0) {
            cadrados.get(0).lblCadrado.setLocation(cadrados.get(0).x = cadrados.get(0).x - 30, cadrados.get(0).y = cadrados.get(0).y + 30);
            cadrados.get(2).lblCadrado.setLocation(cadrados.get(2).x = cadrados.get(2).x + 30, cadrados.get(2).y = cadrados.get(2).y - 30);
            cadrados.get(3).lblCadrado.setLocation(cadrados.get(3).x = cadrados.get(3).x + 60, cadrados.get(3).y = cadrados.get(3).y - 60);
        } else if (posicion == 1) {
            cadrados.get(0).lblCadrado.setLocation(cadrados.get(0).x = cadrados.get(0).x + 30, cadrados.get(0).y = cadrados.get(0).y - 30);
            cadrados.get(2).lblCadrado.setLocation(cadrados.get(2).x = cadrados.get(2).x - 30, cadrados.get(2).y = cadrados.get(2).y + 30);
            cadrados.get(3).lblCadrado.setLocation(cadrados.get(3).x = cadrados.get(3).x - 60, cadrados.get(3).y = cadrados.get(3).y + 60);
        } else if (posicion == 2) {
            cadrados.get(0).lblCadrado.setLocation(cadrados.get(0).x = cadrados.get(0).x - 30, cadrados.get(0).y = cadrados.get(0).y + 30);
            cadrados.get(2).lblCadrado.setLocation(cadrados.get(2).x = cadrados.get(2).x + 30, cadrados.get(2).y = cadrados.get(2).y - 30);
            cadrados.get(3).lblCadrado.setLocation(cadrados.get(3).x = cadrados.get(3).x + 60, cadrados.get(3).y = cadrados.get(3).y - 60);
        } else if (posicion == 3) {
            cadrados.get(0).lblCadrado.setLocation(cadrados.get(0).x = cadrados.get(0).x + 30, cadrados.get(0).y = cadrados.get(0).y - 30);
            cadrados.get(2).lblCadrado.setLocation(cadrados.get(2).x = cadrados.get(2).x - 30, cadrados.get(2).y = cadrados.get(2).y + 30);
            cadrados.get(3).lblCadrado.setLocation(cadrados.get(3).x = cadrados.get(3).x - 60, cadrados.get(3).y = cadrados.get(3).y + 60);
        }
        return true;
    }

}
