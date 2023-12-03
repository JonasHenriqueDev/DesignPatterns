package observer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

interface LeilaoObserver {
    void notify(String lance);
}

interface LeilaoSubject {
    void registerObserver(LeilaoObserver observer);
}

class Terminal implements LeilaoObserver {
    @Override
    public void notify(String lance) {
        System.out.println("TERMINAL: " + lance);
    }
}

class InterfaceGraficaUsuario implements LeilaoObserver {
    @Override
    public void notify(String lance) {
        JOptionPane.showMessageDialog(null, lance);
    }
}

class LeilaoMananger implements LeilaoSubject{
    List<LeilaoObserver> observers = new ArrayList<>();

    public void novoObserver(String lance) {
        notifyObservers(lance);
    }

    @Override
    public void registerObserver(LeilaoObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(String lance) {
        for (LeilaoObserver observer: observers) {
            observer.notify(lance);
        }
    }
}

class Leilao {
    public static void main(String[] args) {
        LeilaoMananger mananger = new LeilaoMananger();

        Terminal terminal = new Terminal();
        InterfaceGraficaUsuario interfaceGraficaUsuario = new InterfaceGraficaUsuario();

        mananger.registerObserver(terminal);
        mananger.registerObserver(interfaceGraficaUsuario);

        mananger.novoObserver("50 REAIS");
    }
}