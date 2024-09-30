package myBanke;

import javax.swing.JOptionPane;

public class ContaPoupanca extends Conta {
    private double reajusteMensal;
    public boolean semOperar = true;

    public ContaPoupanca(double saldoInicial, double reajusteMensal) {
        super(saldoInicial);
        this.reajusteMensal = reajusteMensal;
    }

    @Override
    public void atualizarSaldo(double reajuste) {
        if (reajuste <= 0) {
            try {
                metodoQueLancaExcecao();
            } catch (Exception e) {
                System.out.println("Reajuste deve ser positivo. " + e.getMessage());
            }
        } else {
            saldo += saldo * (reajuste / 100);
        }
    }
    
    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            
            semOperar = false;
            System.out.println("Valor de saque deve ser positivo!");
        } else if (saldo < valor) {
            
            semOperar = false;
            System.out.println("Saldo insuficiente para realizar o saque!");
        } else {
           
            saldo -= valor;
            semOperar = true;
        }
    }
    

    @Override
    public String toString() {
        return super.toString() + ", Reajuste Mensal: " + reajusteMensal;
    }
}