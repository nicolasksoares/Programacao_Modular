import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aluno {

    private String nome;
    private int idade;
    private double coragem;
    private double inteligencia;
    private double ambicao;
    private double lealdade;
    private double estrategia;
    private double criatividade;
    private String casa;

    public Aluno( String nome, int idade, double corage, double inteligencia, double ambicao, double lealdade,  double estrategia, double criatividade) {
        this.nome = nome;
        this.idade = idade;
        this.coragem = corage;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.estrategia = estrategia;
        this.criatividade = criatividade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public double getCoragem() {
        return coragem;
    }
    public void setCoragem(double coragem) {
        this.coragem = coragem;
    }
    public double getInteligencia() {
        return inteligencia;
    }
    public void setInteligencia(double inteligencia) {
        this.inteligencia = inteligencia;
    }
    public double getAmbicao() {
        return ambicao;
    }
    public void setAmbicao(double ambicao) {
        this.ambicao = ambicao;
    }
    public double getLealdade() {
        return lealdade;
    }
    public void setLealdade(double lealdade) {
        this.lealdade = lealdade;
    }
    public double getEstrategia() {
        return estrategia;
    }
    public void setEstrategia(double estrategia) {
        this.estrategia = estrategia;
    }
    public double getCriatividade() {
        return criatividade;
    }
    public void setCriatividade(double criatividade) {
        this.criatividade = criatividade;
    }
    public String getCasa() {
        return casa;
    }

    public static void exibirInformacoes(Aluno aluno){
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Idade: " + aluno.getIdade());
        System.out.println("Coragem: " + aluno.getCoragem());
        System.out.println("Inteligencia: " + aluno.getInteligencia());
        System.out.println("Ambicao: " + aluno.getAmbicao());
        System.out.println("Lealdade: " + aluno.getLealdade());
    }

    public String calcularCasa() {

        double calculo_Grifinoria = (2 * this.coragem) + this.lealdade;
        double calculo_Sonserina = (2 * this.ambicao) + this.estrategia;
        double calculo_Corvinal = (2 * this.inteligencia) + this.criatividade;
        double calculo_Lufa = ((2 * this.lealdade) + this.coragem) / 3;

        if (calculo_Grifinoria > calculo_Corvinal && calculo_Grifinoria > calculo_Sonserina && calculo_Grifinoria > calculo_Lufa) {
            this.casa = "Grifinória " + calculo_Grifinoria;
            System.out.println("Sua casa é " + this.casa);
        } else if (calculo_Sonserina > calculo_Corvinal && calculo_Sonserina > calculo_Grifinoria && calculo_Sonserina > calculo_Lufa){
            this.casa = "Sonserina " + calculo_Sonserina;
            System.out.println("Casa: " + this.casa);
        } else if (calculo_Corvinal > calculo_Grifinoria && calculo_Corvinal > calculo_Sonserina && calculo_Corvinal > calculo_Lufa) {
            this.casa = "Corvinal " + calculo_Corvinal;
            System.out.println("Casa: " + this.casa);
        } else if (calculo_Lufa > calculo_Grifinoria && calculo_Lufa > calculo_Sonserina && calculo_Lufa > calculo_Corvinal) {
            this.casa = "Lufa-Lufa " + calculo_Lufa;
            System.out.println("Casa: " + this.casa);
        }

        return this.casa;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();

        String entrada = "";
        while(!entrada.equals("sair")){
            System.out.println("---------------------------------");
            System.out.println("Bem vindo a Hogwarts!");
            System.out.println("Vamos descobrir sua casa:");


            System.out.println("Digite seu nome:");
            String nome = scanner.nextLine();
            System.out.println("Digite sua idade:");
            int idade = scanner.nextInt();
            System.out.println("Digite sua coragem:");
            double coragem = scanner.nextDouble();
            System.out.println("Digite sua inteligencia:");
            double inteligencia = scanner.nextDouble();
            System.out.println("Digite sua ambicao:");
            double ambicao = scanner.nextDouble();
            System.out.println("Digite sua lealdade:");
            double lealdade = scanner.nextDouble();
            System.out.println("Digite sua estrategia:");
            double estrategia = scanner.nextDouble();
            System.out.println("Digite sua criatividade:");
            double criatividade = scanner.nextDouble();

            Aluno aluno = new Aluno(nome,idade,coragem,inteligencia,ambicao,lealdade,estrategia,criatividade);
            Aluno.exibirInformacoes(aluno);
            aluno.calcularCasa();
            alunos.add(aluno);

            scanner.nextLine();
            System.out.println("Para parar digite: 'sair'");
            System.out.println("Para parar continuar pressione: 'Enter'");
            entrada = scanner.nextLine();

        }

    }
}
