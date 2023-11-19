package programapetshop;

import DAO.DAOCliente;
import javax.swing.JOptionPane;

public class ProgramaPetShop {

    public static void main(String[] args) {

        menu();

    }

    public static void menu() {

        String textoMenu
                = "Pet Shop\n\n"
                + "1- Cadastrar cliente\n"
                + "2- Encerrar programa";

        int resposta = 0;
        
        do {

            resposta = Integer.parseInt(JOptionPane.showInputDialog(textoMenu));

            switch (resposta) {
                case 1:
                    clienteCadastro();
                    break;
                case 2:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao Invalida");

            }

        } while (resposta != 2);

    }

    public static void clienteCadastro() {

        String nomearCliente = "";
        String CPFCliente = "";
        String endereco = "";
        long telefone = 0L;

        nomearCliente = JOptionPane.showInputDialog("Digite o nome do cliente");
        CPFCliente = JOptionPane.showInputDialog("Digite o CPF do cliente");
        endereco = JOptionPane.showInputDialog("Digite o endereco do cliente");
        telefone = Long.parseLong(JOptionPane.showInputDialog("Digite o telefone do cliente"));

        ClasseCliente c = new ClasseCliente("nome", "CPF", "endereco", 20);
        c.setNomeCliente(nomearCliente);
        c.setCPF(CPFCliente);
        c.setEnderecoCliente(endereco);
        c.setTelefoneCliente(telefone);

        new DAOCliente().cadastrarCliente(c);

    }
    
    public static void animalCadastro() {
        
        String nomearAnimal = "";
        String especieAnimal = "";
        String raca = "";
        int idade = 0;
        String historicoMedico = "";
        
        nomearAnimal = JOptionPane.showInputDialog("Digite o nome do pet");
        especieAnimal = JOptionPane.showInputDialog("Digite a especie do pet");
        raca = JOptionPane.showInputDialog("Digite a raca do pet");
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade em meses do pet"));        
        historicoMedico = ("Historico do pet pode afetar em algum serviço do pet shop");
        
    }

}