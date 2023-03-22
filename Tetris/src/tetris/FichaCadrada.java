package tetris;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author a22javiermm
 */
public class FichaCadrada extends Ficha {

    //ArrayList<Cadrado> cadrados = new ArrayList<Cadrado>();

    Cadrado cadrado0 = new Cadrado(120, 0, Color.blue);
    Cadrado cadrado1 = new Cadrado(150, 0, Color.blue);
    Cadrado cadrado2 = new Cadrado(120, 30, Color.blue);
    Cadrado cadrado3 = new Cadrado(150, 30, Color.blue);
    Border borde;

    public FichaCadrada() {
        cadrados.add(cadrado0);
        cadrados.add(cadrado1);
        cadrados.add(cadrado2);
        cadrados.add(cadrado3);
        for (int i = 0; i < cadrados.size(); i++) {
            borde = BorderFactory.createLineBorder(Color.black);
            cadrados.get(i).lblCadrado = new JLabel();
            cadrados.get(i).lblCadrado.setBorder(borde);
            cadrados.get(i).lblCadrado.setBackground(Color.blue);
            cadrados.get(i).lblCadrado.setOpaque(true);
            cadrados.get(i).lblCadrado.setSize(30, 30);
            cadrados.get(i).lblCadrado.setLocation(cadrados.get(i).x, cadrados.get(i).y);

        }

    }

    

    public boolean rotar() {
        return true;
    }

}
