import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

class Cliente {
    String nome;
    String endereco;
    String telefone;
    String informacoesContato;
    Animal[] animais;

    public Cliente(String nome, String endereco, String telefone, String informacoesContato) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.informacoesContato = informacoesContato;
        this.animais = new Animal[10]; // Pode ajustar o tamanho 
    }
}

class Animal {
    String nome;
    String especie;
    String raca;
    int idade;
    String historicoMedico;

    public Animal(String nome, String especie, String raca, int idade, String historicoMedico) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.historicoMedico = historicoMedico;
    }
}

class Servico {
    String descricao;
    double preco;

    public Servico(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }
}

class Consulta {
    String data;
    String horario;
    Animal animal;
    Servico servico;

    public Consulta(String data, String horario, Animal animal, Servico servico) {
        this.data = data;
        this.horario = horario;
        this.animal = animal;
        this.servico = servico;
    }
}

public class PetShop {
    
    static int numClientes = 0;
    static Cliente[] clientes = new Cliente[100]; // Pode ajustar o tamanho 
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        

        ArrayList<Consulta> consultasAgendadas = new ArrayList<>();

        Servico[] servicos = {
            new Servico("Tosa Higiênica", 100),
            new Servico("Desembolo", 85),
            new Servico("Hidratação", 120),
            new Servico("Tosa na Máquina", 150),
            new Servico("Tosa na Tesoura", 160),
            new Servico("Corte de Unha", 50),
            new Servico("Escovação de Dentes", 35)
        };

        // Menu principal
        while (true) {
            String menu = "Menu Principal:\n" +
                    "1. Cadastro de Cliente\n" +
                    "2. Cadastro de Animal de Estimação\n" +
                    "3. Registro de Serviço Prestado\n" +
                    "4. Agendamento de Consultas e Serviços\n" +
                    "5. Faturamento\n" +
                    "6. Relatórios\n" +
                    "7. Sair\n" +
                    "Escolha uma opção: ";
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    // Cadastro de Cliente
                    cadastroCliente();
                    break;
                case 2:
                    // Cadastro de Animal de Estimação
                    String nomeClienteAnimal = JOptionPane.showInputDialog("Digite o nome do cliente:");

                    // Encontre o cliente com base no nome do cliente
                    Cliente clienteDoAnimal = null;
                    for (Cliente cliente : clientes) {
                        if (cliente != null && cliente.nome.equals(nomeClienteAnimal)) {
                            clienteDoAnimal = cliente;
                            break;
                        }
                    }

                    if (clienteDoAnimal != null) {
                        String nomeAnimal = JOptionPane.showInputDialog("Digite o nome do animal:");
                        String especieAnimal = JOptionPane.showInputDialog("Digite a espécie do animal:");
                        String racaAnimal = JOptionPane.showInputDialog("Digite a raça do animal:");
                        int idadeAnimal = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do animal:"));
                        String historicoMedicoAnimal = JOptionPane.showInputDialog("Digite o histórico médico do animal:");

                        Animal novoAnimal = new Animal(nomeAnimal, especieAnimal, racaAnimal, idadeAnimal, historicoMedicoAnimal);
                        clienteDoAnimal.animais[numClientes] = novoAnimal;
                        JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    }
                    break;
                case 3:
                    // Registro de Serviço Prestado
                    String nomeClienteServico = JOptionPane.showInputDialog("Digite o nome do cliente:");

                    // Encontre o cliente com base no nome do cliente
                    Cliente clienteDoServico = null;
                    for (Cliente cliente : clientes) {
                        if (cliente != null && cliente.nome.equals(nomeClienteServico)) {
                            clienteDoServico = cliente;
                            break;
                        }
                    }

                    if (clienteDoServico != null) {
                        // Lista de serviços disponíveis
                        StringBuilder servicosDisponiveis = new StringBuilder("Serviços Disponíveis:\n");
                        for (int i = 0; i < servicos.length; i++) {
                            servicosDisponiveis.append(i + 1).append(". ").append(servicos[i].descricao).append(" - R$").append(servicos[i].preco).append("\n");
                        }
                        int escolhaServico = Integer.parseInt(JOptionPane.showInputDialog(servicosDisponiveis + "Escolha o número do serviço:"));

                        Consulta servicoRegistrado = new Consulta("Serviço", "Registrado", null, servicos[escolhaServico - 1]);
                        consultasAgendadas.add(servicoRegistrado);
                        JOptionPane.showMessageDialog(null, "Serviço registrado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    }
                    break;
                case 4:
                    // Agendamento de Consultas e Serviços
                    String dataAgendamento = JOptionPane.showInputDialog("Digite a data (dd/mm/yyyy):");
                    String horarioAgendamento = JOptionPane.showInputDialog("Digite o horário (hh:mm):");

                    // Lista de serviços disponíveis
                    StringBuilder servicosDisponiveis = new StringBuilder("Serviços Disponíveis:\n");
                    for (int i = 0; i < servicos.length; i++) {
                        servicosDisponiveis.append(i + 1).append(". ").append(servicos[i].descricao).append(" - R$").append(servicos[i].preco).append("\n");
                    }
                    int escolhaServico = Integer.parseInt(JOptionPane.showInputDialog(servicosDisponiveis + "Escolha o número do serviço:"));
                    String nomeAnimal = JOptionPane.showInputDialog("Digite o nome do animal:");

                    // Encontre o cliente com base no nome do animal (isso pode ser melhorado)
                clienteDoAnimal = null;
                    for (Cliente cliente : clientes) {
                        if (cliente != null) {
                            for (Animal animal : cliente.animais) {
                                if (animal != null && animal.nome.equals(nomeAnimal)) {
                                    clienteDoAnimal = cliente;
                                    break;
                                }
                            }
                        }
                    }

                    if (clienteDoAnimal != null) {
                        Animal animalAgendado = null;
                        for (Animal animal : clienteDoAnimal.animais) {
                            if (animal != null && animal.nome.equals(nomeAnimal)) {
                                animalAgendado = animal;
                                break;
                            }
                        }

                        if (animalAgendado != null) {
                            Consulta consultaAgendada = new Consulta(dataAgendamento, horarioAgendamento, animalAgendado, servicos[escolhaServico - 1]);
                            consultasAgendadas.add(consultaAgendada);
                            JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Animal não encontrado.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    }
                    break;
                case 5:
                    // Cálculo do Faturamento
                    double faturamento = 0;
                    for (Consulta consulta : consultasAgendadas) {
                        faturamento += consulta.servico.preco;
                    }
                    JOptionPane.showMessageDialog(null, "Faturamento total: R$" + faturamento);
                    break;
                case 6:
                    // Relatórios
                    String relatorioMenu = "Relatórios:\n" +
                            "1. Histórico de Serviços Prestados\n" +
                            "2. Lista de Consultas Agendadas\n" +
                            "3. Informações de Contato dos Clientes\n" +
                            "Escolha um relatório:";
                    int escolhaRelatorio = Integer.parseInt(JOptionPane.showInputDialog(relatorioMenu));

                    switch (escolhaRelatorio) {
                        case 1:
                            // Histórico de Serviços Prestados
                            StringBuilder historicoServicos = new StringBuilder("Histórico de Serviços Prestados:\n");
                            for (Consulta consulta : consultasAgendadas) {
                                if (consulta.animal != null) {
                                    historicoServicos.append("Data: ").append(consulta.data).append("\n");
                                    historicoServicos.append("Horário: ").append(consulta.horario).append("\n");
                                    historicoServicos.append("Cliente: ").append(consulta.animal.nome).append("\n");
                                    historicoServicos.append("Serviço: ").append(consulta.servico.descricao).append("\n\n");
                                }
                            }
                            JOptionPane.showMessageDialog(null, historicoServicos.toString());
                            break;
                        case 2:
                            // Lista de Consultas Agendadas
                            StringBuilder listaConsultas = new StringBuilder("Consultas Agendadas:\n");
                            for (Consulta consulta : consultasAgendadas) {
                                listaConsultas.append("Data: ").append(consulta.data).append("\n");
                                listaConsultas.append("Horário: ").append(consulta.horario).append("\n");
                                if (consulta.animal != null) {
                                    listaConsultas.append("Cliente: ").append(consulta.animal.nome).append("\n");
                                    listaConsultas.append("Animal: ").append(consulta.animal.nome).append("\n");
                                }
                                listaConsultas.append("Serviço: ").append(consulta.servico.descricao).append("\n\n");
                            }
                            JOptionPane.showMessageDialog(null, listaConsultas.toString());
                            break;
                        case 3:
                            // Informações de Contato dos Clientes
                            StringBuilder informacoesClientes = new StringBuilder("Informações de Contato dos Clientes:\n");
                            for (Cliente cliente : clientes) {
                                if (cliente != null) {
                                    informacoesClientes.append("Nome: ").append(cliente.nome).append("\n");
                                    informacoesClientes.append("Endereço: ").append(cliente.endereco).append("\n");
                                    informacoesClientes.append("Telefone: ").append(cliente.telefone).append("\n");
                                    informacoesClientes.append("Informações de Contato: ").append(cliente.informacoesContato).append("\n\n");
                                }
                            }
                            JOptionPane.showMessageDialog(null, informacoesClientes.toString());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida.");
                            break;
                    }
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        }
    }
    
    public static void cadastroCliente () {
        
         // Cadastro de Cliente
                    String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
                    String enderecoCliente = JOptionPane.showInputDialog("Digite o endereço do cliente:");
                    String telefoneCliente = JOptionPane.showInputDialog("Digite o telefone do cliente:");
                    String informacoesContatoCliente = JOptionPane.showInputDialog("Digite informações de contato do cliente:");

                    Cliente novoCliente = new Cliente(nomeCliente, enderecoCliente, telefoneCliente, informacoesContatoCliente);
                    clientes[numClientes] = novoCliente;
                    numClientes++;
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.");
        
    }
    
    public static void cadastroPet() {
        // Cadastro de Animal de Estimação
                    String nomeClienteAnimal = JOptionPane.showInputDialog("Digite o nome do cliente:");

                    // Encontre o cliente com base no nome do cliente
                    Cliente clienteDoAnimal = null;
                    for (Cliente cliente : clientes) {
                        if (cliente != null && cliente.nome.equals(nomeClienteAnimal)) {
                            clienteDoAnimal = cliente;
                            break;
                        }
                    }

                    if (clienteDoAnimal != null) {
                        String nomeAnimal = JOptionPane.showInputDialog("Digite o nome do animal:");
                        String especieAnimal = JOptionPane.showInputDialog("Digite a espécie do animal:");
                        String racaAnimal = JOptionPane.showInputDialog("Digite a raça do animal:");
                        int idadeAnimal = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do animal:"));
                        String historicoMedicoAnimal = JOptionPane.showInputDialog("Digite o histórico médico do animal:");

                        Animal novoAnimal = new Animal(nomeAnimal, especieAnimal, racaAnimal, idadeAnimal, historicoMedicoAnimal);
                        clienteDoAnimal.animais[numClientes] = novoAnimal;
                        JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    }
        
    }
    
}