package myBanke;

public class Conta {
    protected double saldo;

    public Conta(double saldoInicial) {
        if (saldoInicial < 0) {
            try {
                metodoQueLancaExcecao();
            } catch (Exception e) {
                System.out.println("Saldo inicial não pode ser negativo. " + e.getMessage());
            }
        }
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            try {
                metodoQueLancaExcecao();
            } catch (Exception e) {
                System.out.println("Valor de depósito deve ser positivo. " + e.getMessage());
            }
        } else {
            saldo += valor;
        }
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            try {
                metodoQueLancaExcecao();
            } catch (Exception e) {
                System.out.println("Valor de saque deve ser positivo. " + e.getMessage());
            }
        } else if (saldo < valor) {
            try {
                metodoQueLancaExcecao();
            } catch (Exception e) {
                System.out.println("Saldo insuficiente. " + e.getMessage());
            }
        } else {
            saldo -= valor;
        }
    }

    public void atualizarSaldo(double reajuste) {
        if (saldo < 0) {
            saldo += saldo * 0.08;
        }
    }

    @Override
    public String toString() {
        return "Saldo: " + saldo;
    }

    public static void metodoQueLancaExcecao() throws Exception {
        throw new Exception(" - Esta é uma exceção lançada");
    }

	
}
