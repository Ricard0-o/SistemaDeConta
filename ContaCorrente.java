package myBanke;

public class ContaCorrente extends Conta {
    private double limiteEspecial;
    public boolean semOperar = true;
    public double limiteEspecialI = limiteEspecial;
    
    
    public ContaCorrente(double saldoInicial, double limiteEspecial) {
        super(saldoInicial);
        this.limiteEspecial = limiteEspecial;
        limiteEspecialI = limiteEspecial;
        
    }
    
    
    
    
    @Override
    public void sacar(double valor) {
    	double valorI = valor;
    	
    	if (valor <= 0) {
            try {
                metodoQueLancaExcecao();
            } catch (Exception e) {
                System.out.println("Valor de saque deve ser positivo. " + e.getMessage());
            }
            semOperar = false;
        } else if (saldo - valor < -limiteEspecial) {
            try {
                metodoQueLancaExcecao();
            } catch (Exception e) {
                System.out.println("Limite especial excedido. " + e.getMessage());
            }
            semOperar = false;
        } else {
            saldo -= valor;
            semOperar = true;
        }
        
       
    	if (saldo < 0) {
            limiteEspecialI = limiteEspecial + saldo; // saldo negativo será descontado do limite especial
        } else {
            limiteEspecialI = limiteEspecial; // Se o saldo estiver positivo, o limite especial está intacto
        }
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            try {
                metodoQueLancaExcecao();
            } catch (Exception e) {
                System.out.println("Valor de depósito deve ser positivo. " + e.getMessage());
            }
        } else {
           
            if (saldo < 0) {
                double restante = -saldo; 
                if (valor >= restante) {
                    saldo = 0;
                    valor -= restante;
                    saldo += valor;  
                    limiteEspecialI = limiteEspecial;  
                } else {
                    saldo += valor;  
                    limiteEspecialI = limiteEspecial + saldo; 
                }
            } else {
                
                saldo += valor;
            }
        }
    }
    
    
    @Override
    public String toString() {
        return super.toString() + ", Limite Especial: " + (limiteEspecialI);
    }
}