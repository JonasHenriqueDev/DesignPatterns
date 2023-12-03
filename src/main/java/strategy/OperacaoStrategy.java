package strategy;

interface OperacaoStrategy {
    double calcularOperacao(double a, double b);
}

class AdicaoStrategy implements OperacaoStrategy {
    @Override
    public double calcularOperacao(double a, double b) {
        return a + b;
    }
}

class SubtracaoStrategy implements OperacaoStrategy {
    @Override
    public double calcularOperacao(double a, double b) {
        return a - b;
    }
}

class MultiplicacaoStrategy implements OperacaoStrategy {
    @Override
    public double calcularOperacao(double a, double b) {
        return a * b;
    }
}

class DivisaoStrategy implements OperacaoStrategy {
    @Override
    public double calcularOperacao(double a, double b) {
        return a / b;
    }
}

class Calculadora {
    private OperacaoStrategy operacaoStrategy;

    public Calculadora(OperacaoStrategy operacaoStrategy) {
        this.operacaoStrategy = operacaoStrategy;
    }

    public void setOperacaoStrategy(OperacaoStrategy operacaoStrategy) {
        this.operacaoStrategy = operacaoStrategy;
    }

    public double calcularOperacao(double a, double b) {
        return operacaoStrategy.calcularOperacao(a, b);
    }
}

class Cliente {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora(new AdicaoStrategy());
        System.out.println("ADIÇÃO:");
        System.out.println(calculadora.calcularOperacao(10, 20));

        System.out.println("MULTIPLICAÇÃO");
        calculadora.setOperacaoStrategy(new MultiplicacaoStrategy());
        System.out.println(calculadora.calcularOperacao(5, 5));

        System.out.println("SUBTRAÇÃO");
        calculadora.setOperacaoStrategy(new SubtracaoStrategy());
        System.out.println(calculadora.calcularOperacao(50, 25));

        System.out.println("DIVISÃO");
        calculadora.setOperacaoStrategy(new DivisaoStrategy());
        System.out.println(calculadora.calcularOperacao(10, 5));

    }
}