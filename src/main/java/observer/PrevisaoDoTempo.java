package observer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

interface PrevisaoDoTempoObserver {
    void notify(String clima);
}

interface PrevisaoDoTempoSubject {
    void registerObserver(PrevisaoDoTempoObserver observer);
}

class Console implements PrevisaoDoTempoObserver{
    @Override
    public void notify(String clima) {
        System.out.println("CONSOLE: " + clima);
    }
}

class InterfaceGrafica implements PrevisaoDoTempoObserver {
    @Override
    public void notify(String clima) {
        JOptionPane.showMessageDialog(null, clima);
    }
}

class ClimaMananger implements PrevisaoDoTempoSubject {
    List<PrevisaoDoTempoObserver> previsaoDoTempoObservers = new ArrayList<>();

    public void novoClima(String clima) {
        notifyObservers(clima);
    }

    @Override
    public void registerObserver(PrevisaoDoTempoObserver observer) {
        previsaoDoTempoObservers.add(observer);
    }

    private void notifyObservers(String clima) {
        for (PrevisaoDoTempoObserver observer : previsaoDoTempoObservers) {
            observer.notify(clima);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Console console = new Console();
        InterfaceGrafica interfaceGrafica = new InterfaceGrafica();

        ClimaMananger climaMananger = new ClimaMananger();

        climaMananger.registerObserver(console);
        climaMananger.registerObserver(interfaceGrafica);

        climaMananger.novoClima("30 GRAUS CELSIUS AMANHÃ");
    }
}

/**
 * O padrão Observer foi útil nesse programa para poder encapsular o comportamento do código e flexibilizar adições
 * futuras de código.
 * Por exemplo: seria possível chegar a este mesmo resultado criando um método para notificar via console e um método
 * para notificar via interface gráfica, mas imagine isso em um programa com 50 vias de notificações de clima? Ficaria
 * inviável.
 * O padrão Observer chega para encapsular e organizar o código. Caso seja necessário adicionar uma notificação
 * por e-mail, é preciso apenas implementar a interface observer e registrar no mananger.
 */