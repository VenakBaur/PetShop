package programapetshop;

public class ClasseFuncionario {

    //Atributos privados da classe
    private String nomeFuncionario;
    private String CPF;
    private String enderecoCliente;
    private int telefoneCliente;

    //Construtor da ClasseFuncionario
    public ClasseFuncionario(String nomeFuncionario, String CPF, String enderecoCliente, int telefoneCliente) {

        this.nomeFuncionario = nomeFuncionario;
        this.CPF = CPF;
        this.enderecoCliente = enderecoCliente;
        this.telefoneCliente = telefoneCliente;

    }

    //Getters (servem para coletar a informação do atributo)
    public String getNomeFuncionario() {

        return nomeFuncionario;

    }

    public String CPF() {

        return CPF;

    }

    public String enderecoCliente() {

        return enderecoCliente;

    }

    public int telefoneCliente() {

        return telefoneCliente;

    }

}
