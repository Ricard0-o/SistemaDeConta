package myBanke;

public class Principal {

    public static void main(String[] args) {
        try {
            MenuConta menu = new MenuConta();
            menu.executarMenu();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }

}

// Coisas arrumar 
//  
