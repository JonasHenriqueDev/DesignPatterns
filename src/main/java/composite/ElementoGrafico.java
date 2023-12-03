package composite;

import java.util.ArrayList;
import java.util.List;

interface ElementoGrafico {
    void desenhar();
}

class Circulo implements ElementoGrafico {
    @Override
    public void desenhar() {
        System.out.println("DESENHANDO UM CIRCULO");
    }
}

class Quadrado implements ElementoGrafico {
    @Override
    public void desenhar() {
        System.out.println("DESENHANDO UM QUADRADO");
    }
}

class Figuras2D implements ElementoGrafico {
    List<ElementoGrafico> elementos = new ArrayList<>();

    public void addElemento(ElementoGrafico elemento) {
        elementos.add(elemento);
    }

    @Override
    public void desenhar() {
        System.out.println("DESENHANDO FIGURAS 2D:");
        for (ElementoGrafico elemento: elementos) {
            elemento.desenhar();
        }
    }
}

class Esfera implements ElementoGrafico {
    @Override
    public void desenhar() {
        System.out.println("DESENHANDO UMA ESFERA");
    }
}

class Figuras3D implements ElementoGrafico {
    List<ElementoGrafico> elementos = new ArrayList<>();

    public void addElemento(ElementoGrafico elemento) {
        elementos.add(elemento);
    }

    @Override
    public void desenhar() {
        System.out.println("DESENHANDO FIGURAS 3D: ");
        for (ElementoGrafico elemento: elementos) {
            elemento.desenhar();
        }
    }
}

class DesenharElemento {
    public static void main(String[] args) {
        Circulo circulo = new Circulo();
        Quadrado quadrado = new Quadrado();
        Esfera esfera = new Esfera();

        Figuras2D figuras2D = new Figuras2D();

        figuras2D.addElemento(circulo);
        figuras2D.addElemento(quadrado);

        Figuras3D figuras3D = new Figuras3D();

        figuras3D.addElemento(esfera);

        System.out.println("DESENHANDO AS FOLHAS:");

        circulo.desenhar();
        esfera.desenhar();
        quadrado.desenhar();

        System.out.println("DESENHANDO OS GRUPOS: ");

        figuras2D.desenhar();

        System.out.println("------");

        figuras3D.desenhar();
    }
}