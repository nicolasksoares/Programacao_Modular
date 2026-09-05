import java.lang.Math;
import java.util.Scanner;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double IMC;

    public Pessoa(String nome, String sobrenome, int idade, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() {
        System.out.println(this.nome);
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getIMC() {
        return IMC;
    }

    public double calculaIMC(){
        this.IMC = this.peso/Math.pow(this.altura,2);
        System.out.printf("IMC: %.2f\n", this.IMC);
        return IMC;
    }

    public static void InformaObesidade(double IMC){

            if (IMC < 18.5){
                System.out.println("Abaixo do peso");
            } else if (IMC > 18.5 && IMC < 24.9 ){
                System.out.println("Peso Normal");
            } else if (IMC > 25 && IMC < 29.9 ){
                System.out.println("Sobrepeso");
            } else if (IMC > 30 && IMC < 34.9 ){
                System.out.println("Obesidade grau 1");
            } else if (IMC > 35 && IMC < 39.9 ){
                System.out.println("Obesidade grau 2");
            } else if (IMC > 40 ){
                System.out.println("Obesidade grau 3");

        }
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = ler.nextLine();

        System.out.println("Digite seu sobrenome: ");
        String sobrenome = ler.nextLine();

        System.out.println("Digite sua idade: ");
        int idade = ler.nextInt();

        System.out.println("Digite sua altura: ");

        double altura = ler.nextDouble();

        System.out.println("Digite sua peso: ");
        double peso = ler.nextDouble();

        Pessoa pessoa_1 = new Pessoa(nome, sobrenome, idade, altura, peso);

        double resultadoIMC = pessoa_1.calculaIMC();

        pessoa_1.InformaObesidade(resultadoIMC);
    }

}

