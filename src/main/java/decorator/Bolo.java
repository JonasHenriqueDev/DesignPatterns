package decorator;

import java.util.HashMap;

//Component
interface IBolo {
    int preco();
}

//ConcreteComponent
class Bolo implements IBolo {
    HashMap<String, Integer> ingredientes;

    public Bolo() {}

    public Bolo(HashMap<String, Integer> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public int preco() {
        int valor = 0;
        for(Integer i : ingredientes.values()) {
            valor += 1;
        }
        return valor;
    }
}

//Decorator
abstract class BoloDecorator implements IBolo {
    IBolo boloDecorado;

    public BoloDecorator(IBolo bolo) {
        boloDecorado = bolo;
    }
}

class Chocolate extends BoloDecorator {

    public Chocolate(IBolo bolo) {
        super(bolo);
    }

    @Override
    public int preco(){
        return boloDecorado.preco() + 10;
    }
}

class Chantily extends BoloDecorator {

    public Chantily(IBolo bolo) {
        super(bolo);
    }

    @Override
    public int preco() {
        return boloDecorado.preco() + 15;
    }
}

class Cereja extends BoloDecorator {

    public Cereja(IBolo bolo) {
        super(bolo);
    }

    @Override
    public int preco() {
        return boloDecorado.preco() + 5;
    }
}

class Confeitaria {
    public static void main(String[] args) {
        HashMap<String, Integer> ingredientes = new HashMap<>();

        ingredientes.put("Trigo", 10);
        ingredientes.put("Ovo", 5);
        ingredientes.put("Fermento", 5);
        ingredientes.put("Leite", 3);

        IBolo bolo = new Bolo(ingredientes);

        IBolo boloDeChocolate = new Chocolate(bolo);

        System.out.println("Bolo de chocolate: " + boloDeChocolate.preco());

        IBolo boloDeCholocateComChantily = new Chocolate(new Chantily(bolo));

        System.out.println("Bolo de cholocate com chantily: " + boloDeCholocateComChantily.preco());
    }
}