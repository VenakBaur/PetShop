package programapetshop;

import DAO.DAOAnimal;
import DAO.DAOCliente;
import DAO.DAOServicos;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgramaPetShop {

    public static void main(String[] args) {

        menu();

    }

    public static void menu() {

        String textoMenu
                = "Pet Shop\n\n"
                + "1- Cadastrar Cliente\n"
                + "2- Cadastrar Animal\n"
                + "3- Servicos\n"
                + "4- Historico Servicos\n"
                + "5- Faturamento\n"
                + "6- Cadastros Clientes\n"
                + "7- Cadastros Pets\n"
                + "8- Encerrar Programa";

        int resposta = 0;

        do {

            resposta = Integer.parseInt(JOptionPane.showInputDialog(textoMenu));

            switch (resposta) {
                case 1:
                    clienteCadastro();
                    break;
                case 2:
                    animalCadastro();
                    break;
                case 3:
                    servicos();
                    break;
                case 4:
                    historicoServicos();
                    break;
                case 5:
                    totalFaturamento();
                    break;
                case 6:
                    exibirInformacoesClientes();
                    break;
                case 7:
                    exibirInformacoesAnimais();
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao Invalida");

            }

        } while (resposta != 8);

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
        boolean teste = false;
        String tutor = "";
        String nomearAnimal = "";
        String especieAnimal = "";
        String raca = "";
        int idade = 0;
        String historicoMedico = "";

        tutor = JOptionPane.showInputDialog("Digite o nome do cliente do pet");

        if (tutor != null && !tutor.trim().isEmpty()) {
            try (Connection conn = ConnectionFactory.getConnection()) {
                String sql = "SELECT * FROM cliente WHERE nomeCliente = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, tutor);
                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            // Exibir resultados usando JOptionPane
                            teste = true;
                            StringBuilder mensagem = new StringBuilder("Nome encontrado!\n");
                            mensagem.append("nomeCliente: ").append(rs.getString("nomeCliente")).append("\n");
                            mensagem.append("CPF: ").append(rs.getLong("CPF")).append("\n");
                            JOptionPane.showMessageDialog(null, mensagem.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Nome não encontrado.");
                            return;
                        }
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nome inválido.");
            return;
        }

        nomearAnimal = JOptionPane.showInputDialog("Digite o nome do pet");
        especieAnimal = JOptionPane.showInputDialog("Digite a especie do pet");
        raca = JOptionPane.showInputDialog("Digite a raca do pet");
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade em meses do pet"));
        historicoMedico = JOptionPane.showInputDialog("Historico do pet pode afetar em algum serviço do pet shop");

        ClasseAnimal a = new ClasseAnimal(nomearAnimal, especieAnimal, raca, idade, historicoMedico, tutor);

        a.setNome(nomearAnimal);
        a.setEspecie(especieAnimal);
        a.setRaca(raca);
        a.setIdade(idade);
        a.setHistoricoMedico(historicoMedico);
        a.setTutor(tutor);

        new DAOAnimal().cadastrarAnimal(a);

    }

    public static void servicos() {

        String servico = "";
        float preco = 0;
        String data = "";

        int escolhaServico = 0;
        String menuServicos
                = "Escolha o servico\n\n"
                + "1- Tosa Higiênica, 100\n"
                + "2- Desembolo, 85\n"
                + "3- Hidratação, 120\n"
                + "4- Tosa na Máquina, 150\n"
                + "5- Tosa na Tesoura, 160\n"
                + "6- Corte de Unha, 50\n"
                + "7- Escovação de Dentes, 35";

        escolhaServico = Integer.parseInt(JOptionPane.showInputDialog(menuServicos));

        switch (escolhaServico) {
            case 1:
                servico = "Tosa Higiênica";
                preco = 100;
                break;
            case 2:
                servico = "Desembolo";
                preco = 85;
                break;
            case 3:
                servico = "Hidratação";
                preco = 120;
                break;
            case 4:
                servico = "Tosa na Máquina";
                preco = 150;
                break;
            case 5:
                servico = "Tosa na Tesoura";
                preco = 160;
                break;
            case 6:
                servico = "Corte de Unha";
                preco = 50;
                break;
            case 7:
                servico = "Escovação de Dentes";
                preco = 35;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcao Invalida");
        }

        data = JOptionPane.showInputDialog("Digite a data do serviço (DD/MM/AAAA)");

        ClasseServicos s = new ClasseServicos(servico, preco, data);

        s.setNomeServico(servico);
        s.setPrecoServico(preco);
        s.setDataServico(data);

        new DAOServicos().registrarServico(s);

    }

    public static void historicoServicos() {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM servicos";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    exibirHistoricoServicos(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void exibirHistoricoServicos(ResultSet rs) {
        try {
            ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
            int numeroColunas = metaData.getColumnCount();

            StringBuilder historico = new StringBuilder("Histórico de Serviços:\n");

            while (rs.next()) {
                for (int i = 1; i <= numeroColunas; i++) {
                    historico.append(metaData.getColumnName(i)).append(": ").append(rs.getString(i)).append("\n");
                }
                historico.append("\n");
            }

            if (historico.length() > 0) {
                JOptionPane.showMessageDialog(null, historico.toString(), "Histórico de Serviços", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum serviço encontrado.", "Histórico de Serviços", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void totalFaturamento() {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT precoServico FROM servicos";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    float total = calcularFaturamento(rs);
                    JOptionPane.showMessageDialog(null, "Total de faturamento: " + total, "Total dos Serviços", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static float calcularFaturamento(ResultSet rs) {
        float total = 0;
        try {
            while (rs.next()) {
                float precoServico = rs.getFloat("precoServico");
                total += precoServico;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return total;
    }

    public static void exibirInformacoesClientes() {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM cliente";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    exibirResultado(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void exibirResultado(ResultSet rs) {
        try {
            StringBuilder resultado = new StringBuilder("Informações dos Clientes:\n");

            while (rs.next()) {
                resultado.append("ID: ").append(rs.getInt("IDCliente")).append("\n");
                resultado.append("Nome: ").append(rs.getString("nomeCliente")).append("\n");
                resultado.append("CPF: ").append(rs.getString("CPF")).append("\n");
                resultado.append("Endereço: ").append(rs.getString("enderecoCliente")).append("\n");
                resultado.append("Telefone: ").append(rs.getLong("telefoneCliente")).append("\n\n");
            }

            if (resultado.length() > 0) {
                JOptionPane.showMessageDialog(null, resultado.toString(), "Informações dos Clientes", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma informação de cliente encontrada.", "Informações dos Clientes", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void exibirInformacoesAnimais() {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM animal";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    exibirAnimais(rs); // Chame o método exibirAnimais, não exibirResultado
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void exibirAnimais(ResultSet rs) {
        try {
            StringBuilder resultado = new StringBuilder("Informações dos Animais:\n");

            while (rs.next()) {
                resultado.append("ID: ").append(rs.getInt("IDAnimal")).append("\n");
                resultado.append("Nome: ").append(rs.getString("nome")).append("\n");
                resultado.append("Espécie: ").append(rs.getString("especie")).append("\n");
                resultado.append("Raça: ").append(rs.getString("raca")).append("\n");
                resultado.append("Idade: ").append(rs.getInt("idade")).append("\n");
                resultado.append("Histórico Médico: ").append(rs.getString("historicoMedico")).append("\n");
                resultado.append("Tutor: ").append(rs.getString("Tutor")).append("\n\n");
            }

            if (resultado.length() > 0) {
                JOptionPane.showMessageDialog(null, resultado.toString(), "Informações dos Animais", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma informação de animal encontrada.", "Informações dos Animais", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
