package myBanke;

import javax.swing.JOptionPane;

public class MenuConta {
    private ContaCorrente contaCC;
    private ContaPoupanca contaCP;
    private int opcao;
    private boolean sair = false;

    public MenuConta() {
        contaCC = new ContaCorrente(500, 1000);
        contaCP = new ContaPoupanca(5000, 0.01);
    }

    public void executarMenu() {
        while (!sair) {
            String[] option = {"Conta Corrente", "Conta Poupança", "Exit"};
            opcao = JOptionPane.showOptionDialog(null, "Escolha", "Sua Conta", 0, JOptionPane.DEFAULT_OPTION, null, option, option[0]);

            if (opcao == 2) {
                sair = true;
                System.out.println("Encerrando o programa...");
            } else {
                avaliarOpcaoEscolhida();
            }
        }
    }

    private void avaliarOpcaoEscolhida() {
        switch (opcao) {
            case 0:
                operarContaCC();
                break;
            case 1:
                operarContaCP();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    private void operarContaCC() {
        do {
            String[] option = {"Consultar Saldo", "Depositar", "Sacar", "Atualizar Saldo", "VOLTAR", "EXIT"};
            opcao = JOptionPane.showOptionDialog(null, "Escolha", "Conta Corrente", 0, JOptionPane.DEFAULT_OPTION, null, option, option[0]);

            switch (opcao) {
                case 0:
                    JOptionPane.showMessageDialog(null, contaCC.toString(), "Saldo da Conta Corrente", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1: // Depósito
                    String valorDeposito = JOptionPane.showInputDialog("Insira o valor para depósito:");

                    
                    if (valorDeposito == null || valorDeposito.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Operação de depósito cancelada.", "Depósito", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }

                    try {
                        double valorDepositoDouble = Double.parseDouble(valorDeposito);
                        contaCC.depositar(valorDepositoDouble);
                        JOptionPane.showMessageDialog(null, "Valor depositado: " + valorDepositoDouble, "Depósito", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2: // Saque
                    String valorSaque = JOptionPane.showInputDialog("Insira o valor para saque:");

                  
                    if (valorSaque == null || valorSaque.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Operação de saque cancelada.", "Saque", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }

                    try {
                        double valorSaqueDouble = Double.parseDouble(valorSaque);

                        contaCC.sacar(valorSaqueDouble);

                        if (contaCC.semOperar) {
                            JOptionPane.showMessageDialog(null, "Valor sacado: " + valorSaqueDouble, "Saque", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível sacar o valor de: " + valorSaqueDouble, "Saque", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 3:
                    contaCC.atualizarSaldo(0);
                    JOptionPane.showMessageDialog(null, "Saldo atualizado!", "Atualização de Saldo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4: // Voltar
                    executarMenu();
                    return; 
                case 5: // Exit
                    System.exit(0); 
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opcao != 5); 
    }



    private void operarContaCP() {
        do {
            String[] option = {"Consultar Saldo", "Depositar", "Sacar", "Atualizar Saldo", "VOLTAR", "EXIT"};
            opcao = JOptionPane.showOptionDialog(null, "Escolha", "Conta Poupança", 0, JOptionPane.DEFAULT_OPTION, null, option, option[0]);

            switch (opcao) {
                case 0:
                    JOptionPane.showMessageDialog(null, contaCP.toString(), "Saldo da Conta Poupança", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1: // Depósito
                    String valorDeposito = JOptionPane.showInputDialog("Insira o valor para depósito:");

                    
                    if (valorDeposito == null || valorDeposito.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Operação de depósito cancelada.", "Depósito", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }

                    try {
                        double valorDepositoDouble = Double.parseDouble(valorDeposito);
                        contaCP.depositar(valorDepositoDouble);
                        JOptionPane.showMessageDialog(null, "Valor depositado: " + valorDepositoDouble, "Depósito", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2: // Saque
                    String valorSaque = JOptionPane.showInputDialog("Insira o valor para saque:");

                  
                    if (valorSaque == null || valorSaque.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Operação de saque cancelada.", "Saque", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }

                    try {
                        double valorSaqueDouble = Double.parseDouble(valorSaque);
                        contaCP.sacar(valorSaqueDouble);
                        if (contaCP.semOperar) {
                            JOptionPane.showMessageDialog(null, "Valor sacado: " + valorSaqueDouble, "Saque", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível sacar o valor de: " + valorSaqueDouble, "Saque", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 3:
                    String reajuste = JOptionPane.showInputDialog("Insira o valor de reajuste (%):");

                    if (reajuste == null || reajuste.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Operação de atualização cancelada.", "Atualização de Saldo", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }

                    try {
                        double reajusteDouble = Double.parseDouble(reajuste);
                        contaCP.atualizarSaldo(reajusteDouble);
                        JOptionPane.showMessageDialog(null, "Saldo atualizado com o reajuste de: " + reajusteDouble + "%", "Atualização de Saldo", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 4: // Voltar
                    executarMenu();
                    return; 
                case 5: // Exit
                    System.exit(0); 
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opcao != 5); 
    }

    public static void main(String[] args) {
        MenuConta menu = new MenuConta();
        menu.executarMenu();
    }
}