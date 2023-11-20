package programapetshop;

public class ClasseAnimal {

    //Atributos privados da classe
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String historicoMedico;
    private String tutor;

    //Construtor da ClasseAnimal
    public ClasseAnimal(String nome, String especie, String raca, int idade, String historicoMedico, String tutor) {

        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.historicoMedico = historicoMedico;
        this.tutor = tutor;

    }

    //Getters (servem para coletar a informação do atributo)
    public String getNome() {

        return nome;

    }

    public String getEspecie() {

        return especie;

    }

    public String getRaca() {

        return raca;

    }

    public int getIdade() {

        return idade;

    }

    public String getHistoricoMedico() {

        return historicoMedico;

    }

    public String getTutor() {
        return tutor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

}
