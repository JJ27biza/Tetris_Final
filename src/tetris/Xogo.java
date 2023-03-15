package tetris;

import java.util.ArrayList;

/**
 *
 * @author a22javiermm
 */
public class Xogo {

    final static int LADO_CADRADO = 30;
    final int MAX_Y = 600;
    final int MAX_X = 300;
    boolean pausa;
    Ficha fichaActual;

    
    int numeroLinas = 0;
    VentanaPrincipal ventanaPrincipal;

    public Xogo(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    ArrayList<Cadrado> cadradosChan = new ArrayList<Cadrado>();

    public void moverFichaDereita() {
        boolean posicion = true;
        int i = 0;

        while (posicion == true && i < fichaActual.cadrados.size()) {
            posicion = ePosicionValida(fichaActual.cadrados.get(i).x + LADO_CADRADO, fichaActual.cadrados.get(i).y);
            i++;
        }
        if (posicion == true) {
            fichaActual.moverDereita();
        }
    }

    public void moverFichaEsquerda() {
        boolean posicion = true;
        int i = 0;

        while (posicion == true && i < fichaActual.cadrados.size()) {
            posicion = ePosicionValida(fichaActual.cadrados.get(i).x - LADO_CADRADO, fichaActual.cadrados.get(i).y);
            i++;
        }
        if (posicion == true) {
            fichaActual.moverEsquerda();
        }
    }

    public void moverFichaAbaixo() {
        boolean posicion = true;
        int i = 0;

        while (posicion == true && i < fichaActual.cadrados.size()) {
            posicion = ePosicionValida(fichaActual.cadrados.get(i).x, fichaActual.cadrados.get(i).y + LADO_CADRADO);
            i++;
        }
        if (posicion == true) {
            fichaActual.moverAbaixo();
        }
    }

    public void rotarFicha() {
        boolean posicion = true;
        int i = 0;

        while (posicion == true && i < fichaActual.cadrados.size()) {
            posicion = ePosicionValida(fichaActual.cadrados.get(i).x + LADO_CADRADO, fichaActual.cadrados.get(i).y + LADO_CADRADO);
            i++;
        }
        if (posicion == true) {
            this.ventanaPrincipal.timer.stop();

            if (fichaActual.posicion == 4) {
                fichaActual.posicion = 0;
            }
            fichaActual.rotar();
            fichaActual.posicion++;

            this.ventanaPrincipal.timer.restart();
        }
    }

    public void xerarNovaFicha() {
        int numero = (int) (Math.random() * 4);
        numero++;
        switch (numero) {

            case 1:
                FichaBarra novaFichaBarra = new FichaBarra();
                fichaActual = novaFichaBarra;
                break;
            case 2:
                FichaCadrada novaFichaCadrada = new FichaCadrada();
                fichaActual = novaFichaCadrada;
                break;
            case 3:
                FichaL novaFichaL = new FichaL();
                fichaActual = novaFichaL;
                break;
            case 4:
                FichaT novaFichaT = new FichaT();
                fichaActual = novaFichaT;
                break;
            default:
                System.out.println("erro");
                break;
        }
        for (int i = 0; i < fichaActual.cadrados.size(); i++) {
            ventanaPrincipal.pintarCadrado(fichaActual.cadrados.get(i).lblCadrado);
        }

    }

   
    public boolean ePosicionValida(int x, int y) {
        //Comproba bordes de dereita e izquierda
        boolean posicion = true;
        if (x >= MAX_X || x < 0) {
            posicion = false;
            //Comproba o borde inferior
        } else if (y >= MAX_Y) {
            posicion = false;
            chocaFichaCoChan();
            //Comproba co resto de cadrados    
        } else if (!cadradosChan.isEmpty()) {
            for (int i = 0; i < cadradosChan.size(); i++) {
                if (x == cadradosChan.get(i).x && y == cadradosChan.get(i).y) {
                    posicion = false;
                    chocaFichaCoChan();
                } else {
                    posicion = true;
                }
            }
        } else {
            posicion = true;
        }
        return posicion;
    }

    public void engadirFichaAoChan() {
        for (int i = 0; i < fichaActual.cadrados.size(); i++) {
            cadradosChan.add(fichaActual.cadrados.get(i));
        }
        
        finalXogo();
        borrarLina();
        xerarNovaFicha();
    }

    public boolean chocaFichaCoChan() {
        engadirFichaAoChan();
        return true;
    }

    public void borrarLina() {
        int cadrados;
        for (int i = 0; i < cadradosChan.size(); i++) {
            cadrados = 0;
            for (int j = 0; j < cadradosChan.size(); j++) {
                if (cadradosChan.get(i).y == cadradosChan.get(j).y) {
                    cadrados++;
                }

                if (cadrados == 10) {
                    borrarLinasCompletas(cadradosChan.get(i).y);
                    cadrados = 0;
                }
            }
        }
    }

    public void borrarLinasCompletas(int y) {
        for (int i = 0; i < cadradosChan.size(); i++) {
            if (cadradosChan.get(i).y == y) {
                ventanaPrincipal.borrarCadrado(cadradosChan.get(i).lblCadrado);
                cadradosChan.remove(i);
                i--;
            }

        }
        numeroLinas++;
        this.ventanaPrincipal.getPuntuacionLabel().setText(numeroLinas +" puntos");
        cambiarCadrados(y);

    }

    private void finalXogo() {
        for (int i = 0; i < cadradosChan.size(); i++) {
            if (cadradosChan.get(i).y <= 65) {
                System.out.println("perdiches");
                ventanaPrincipal.timer.stop();
            }
        }

    }

    private void cambiarCadrados(int altura) {
        
        for (int i = 0; i < cadradosChan.size(); i++) {
            if (cadradosChan.get(i).y < altura) {
              
                ventanaPrincipal.borrarCadrado(cadradosChan.get(i).lblCadrado);
                cadradosChan.get(i).y = cadradosChan.get(i).y + 30;
                cadradosChan.get(i).lblCadrado.setLocation(cadradosChan.get(i).lblCadrado.getX(), cadradosChan.get(i).lblCadrado.getY()+30);
                ventanaPrincipal.pintarCadrado(cadradosChan.get(i).lblCadrado);
                
            }
        }
    }
}
