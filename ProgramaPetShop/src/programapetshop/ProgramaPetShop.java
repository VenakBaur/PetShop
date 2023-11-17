package programapetshop;

import javax.swing.JOptionPane;

public class ProgramaPetShop {

    public static void main(String[] args) {
        
        menu();
        
    }

    public static void menu() {

        String textoMenu = "Pet Shop\n\n"
                + "1- Cadastrar cliente";
        int resposta = 0;

        resposta = Integer.parseInt(JOptionPane.showInputDialog(null, textoMenu));

    }
    
    public static void clienteCadastro() {
        
        ClasseCliente c = new ClasseCliente();
        c.setNomeCliente(nomeCliente);
        c.setCPF(CPF);
        c.setEnderecoCliente(enderecoCliente);
        c.setTelefoneCliente(0);
        
    }

}
