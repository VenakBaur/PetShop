package programapetshop;

public class ClasseCliente {

    //Atributos privados da classe    
    private String nomeCliente;
    private String CPF;
    private String enderecoCliente;
    private int telefoneCliente;

    //Construtor da ClassePessoa
    public ClasseCliente(String nome, String CPF, String enderecoCLiente, int telefoneCliente) {

        this.nomeCliente = nomeCliente;
        this.CPF = CPF;
        this.enderecoCliente = enderecoCliente;
        this.telefoneCliente = telefoneCliente;

    }

    //Getters (servem para coletar a informação do atributo)
    public String getNomeCliente() {

        return nomeCliente;

    }

    public String getCPF() {

        return CPF;

    }

    public String getEnderecoCliente() {

        return enderecoCliente;

    }

    public int geTelefoneCliente() {

        return telefoneCliente;

    }

}
