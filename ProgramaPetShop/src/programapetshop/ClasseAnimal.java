package programapetshop;

public class ClasseAnimal {

    //Atributos privados da classe
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String historicoMedico;

    //Construtor da ClasseAnimal
    public ClasseAnimal(String nome, String especie, String raca, int idade, String historicoMedico) {

        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.historicoMedico = historicoMedico;

    }

    //Getters (servem para coletar a informação do atributo)
    public String getNome() {

        return nome;

    }

    public String getEspecie() {

        return especie;

    }

    public String gerRaca() {

        return raca;

    }

    public int getIdade() {

        return idade;

    }

    public String getHistoricoMedico() {

        return historicoMedico;

    }

}
