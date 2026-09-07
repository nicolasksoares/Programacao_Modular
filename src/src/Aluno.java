import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Aluno {

    // ---------- Configuração ----------
    private static final int MAX_ALUNOS = 10;
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final Scanner LER = new Scanner(System.in);

    // Vetor de alunos e contador de quantos já foram cadastrados
    private static Aluno[] alunos = new Aluno[MAX_ALUNOS];
    private static int totalAlunos = 0;

    // ---------- Atributos ----------
    private String nome;
    private String sobrenome;
    private double coragem;
    private double inteligencia;
    private double ambicao;
    private double lealdade;
    private double estrategia;
    private double criatividade;
    private String casa;
    private LocalDate dataNascimento;
    private String codigoMatricula;

    // ---------- Construtor ----------
    public Aluno(String nome, String sobrenome, double coragem, double inteligencia,
                 double ambicao, double lealdade, double estrategia, double criatividade,
                 LocalDate dataNascimento) {
        setNome(nome);
        setSobrenome(sobrenome);
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.estrategia = estrategia;
        this.criatividade = criatividade;
        this.dataNascimento = dataNascimento;
    }

    // ---------- Getters e Setters ----------
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = formatarPalavra(nome);
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = formatarPalavra(sobrenome);
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

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(String codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    // ---------- Métodos da classe ----------

    /**
     * Normaliza uma palavra: primeira letra maiúscula, resto minúsculo.
     * "HARRY" / "harry" / "hArRy"  ->  "Harry"
     */
    private String formatarPalavra(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "";
        }
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }

    /**
     * 1. Calcula a idade a partir da data de nascimento.
     */
    public int calcularIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    /**
     * 2. Um bruxo é considerado adulto aos 17 anos.
     */
    public boolean verificarMaioridadeMagica() {
        return calcularIdade() >= 17;
    }

    /**
     * 3. Retorna o nome da casa em letras maiúsculas.
     */
    public String formatarCasa() {
        if (this.casa == null) {
            return "";
        }
        return this.casa.toUpperCase();
    }

    /**
     * 4. Login = primeira letra do nome + sobrenome completo, tudo minúsculo.
     * Harry Potter -> hpotter
     */
    public String gerarNomeUsuario() {
        return (this.nome.substring(0, 1) + this.sobrenome).toLowerCase();
    }

    /**
     * 5. Matrícula = iniciais - ano atual - posição de cadastro.
     * Harry Potter, 1º cadastrado em 2026 -> HP-2026-01
     */
    public String gerarCodigoMatricula(int posicao) {
        String iniciais = this.nome.substring(0, 1).toUpperCase()
                + this.sobrenome.substring(0, 1).toUpperCase();
        int anoAtual = LocalDate.now().getYear();
        this.codigoMatricula = iniciais + "-" + anoAtual + "-" + String.format("%02d", posicao);
        return this.codigoMatricula;
    }

    /**
     * 6. Verifica se o aluno pertence à casa informada (ignora maiúsculas/minúsculas).
     */
    public boolean verificacaoDaCasa(String casaInformada) {
        if (this.casa == null || casaInformada == null) {
            return false;
        }
        return this.casa.equalsIgnoreCase(casaInformada.trim());
    }

    /**
     * 7. Verifica se o sobrenome contém o texto informado.
     * "Black" em "Black Lestrange" -> true
     */
    public boolean verificarPresencaDePalavra(String palavra) {
        if (this.sobrenome == null || palavra == null) {
            return false;
        }
        return this.sobrenome.toLowerCase().contains(palavra.trim().toLowerCase());
    }

    /**
     * Calcula a pontuação de cada casa e define a casa do aluno (a de maior pontuação).
     * Em caso de empate, vence a primeira da ordem de comparação.
     */
    public String calcularCasa() {
        double pontosGrifinoria = (2 * this.coragem) + this.lealdade;
        double pontosSonserina  = (2 * this.ambicao) + this.estrategia;
        double pontosCorvinal   = (2 * this.inteligencia) + this.criatividade;
        double pontosLufaLufa   = ((2 * this.lealdade) + this.coragem) / 3;

        double maiorPontuacao = pontosGrifinoria;
        this.casa = "Grifinória";

        if (pontosSonserina > maiorPontuacao) {
            maiorPontuacao = pontosSonserina;
            this.casa = "Sonserina";
        }
        if (pontosCorvinal > maiorPontuacao) {
            maiorPontuacao = pontosCorvinal;
            this.casa = "Corvinal";
        }
        if (pontosLufaLufa > maiorPontuacao) {
            maiorPontuacao = pontosLufaLufa;
            this.casa = "Lufa-Lufa";
        }

        return this.casa;
    }

    /**
     * Exibe todos os dados do aluno.
     */
    public void exibirInformacoes() {
        System.out.println("--------------------------------");
        System.out.println("Matrícula .......: " + this.codigoMatricula);
        System.out.println("Nome ............: " + this.nome + " " + this.sobrenome);
        System.out.println("Login ...........: " + gerarNomeUsuario());
        System.out.println("Nascimento ......: " + this.dataNascimento.format(FORMATO_DATA));
        System.out.println("Idade ...........: " + calcularIdade() + " anos");
        System.out.println("Maioridade mágica: " + (verificarMaioridadeMagica() ? "Sim" : "Não"));
        System.out.println("Casa ............: " + formatarCasa());
        System.out.println("Coragem .........: " + this.coragem);
        System.out.println("Inteligência ....: " + this.inteligencia);
        System.out.println("Ambição .........: " + this.ambicao);
        System.out.println("Lealdade ........: " + this.lealdade);
        System.out.println("Estratégia ......: " + this.estrategia);
        System.out.println("Criatividade ....: " + this.criatividade);
    }

    // ==================================================================
    //                              MAIN
    // ==================================================================
    public static void main(String[] args) {

        while (true) {
            exibirMenu();
            int opcao = lerInteiro("Escolha uma opção: ");

            if (opcao == 8) {
                System.out.println("\nAlunos cadastrados até o momento:");
                listarTodos();
                System.out.println("\nEncerrando o Chapéu Seletor. Até logo!");
                break;
            }

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    listarTodos();
                    break;
                case 3:
                    exibirPorCasaEscolhida();
                    break;
                case 4:
                    exibirAgrupadoPorCasa();
                    break;
                case 5:
                    exibirPorMaioridade(true);
                    break;
                case 6:
                    exibirPorMaioridade(false);
                    break;
                case 7:
                    buscarPorSobrenome();
                    break;
                default:
                    System.out.println("Opção inválida. Escolha um número de 1 a 8.");
            }
        }
    }

    // ---------- Menu ----------
    private static void exibirMenu() {
        System.out.println("\n=================================");
        System.out.println("     HOGWARTS - CHAPÉU SELETOR");
        System.out.println("=================================");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Listar todos os alunos");
        System.out.println("3 - Exibir alunos de uma casa");
        System.out.println("4 - Exibir alunos por casa (todas)");
        System.out.println("5 - Exibir alunos maiores de idade");
        System.out.println("6 - Exibir alunos menores de idade");
        System.out.println("7 - Buscar aluno por sobrenome");
        System.out.println("8 - Encerrar");
    }

    // ---------- Opção 1 ----------
    private static void cadastrarAluno() {
        if (totalAlunos >= MAX_ALUNOS) {
            System.out.println("\nLimite de " + MAX_ALUNOS + " alunos atingido. Não é possível cadastrar mais.");
            return;
        }

        System.out.println("\n--- Cadastro de aluno (" + (totalAlunos + 1) + " de " + MAX_ALUNOS + ") ---");

        String nome         = lerTexto("Nome: ");
        String sobrenome    = lerTexto("Sobrenome: ");
        double coragem      = lerDouble("Coragem: ");
        double inteligencia = lerDouble("Inteligência: ");
        double ambicao      = lerDouble("Ambição: ");
        double lealdade     = lerDouble("Lealdade: ");
        double estrategia   = lerDouble("Estratégia: ");
        double criatividade = lerDouble("Criatividade: ");
        LocalDate nascimento = lerData("Data de nascimento (dd/MM/yyyy): ");

        Aluno aluno = new Aluno(nome, sobrenome, coragem, inteligencia, ambicao,
                lealdade, estrategia, criatividade, nascimento);

        aluno.calcularCasa();
        aluno.gerarCodigoMatricula(totalAlunos + 1);

        alunos[totalAlunos] = aluno;
        totalAlunos++;

        System.out.println("\nAluno cadastrado com sucesso!");
        aluno.exibirInformacoes();
    }

    // ---------- Opção 2 ----------
    private static void listarTodos() {
        if (totalAlunos == 0) {
            System.out.println("\nNenhum aluno cadastrado ainda.");
            return;
        }
        System.out.println("\nTotal de alunos: " + totalAlunos);
        for (int i = 0; i < totalAlunos; i++) {
            alunos[i].exibirInformacoes();
        }
    }

    // ---------- Opção 3 ----------
    private static void exibirPorCasaEscolhida() {
        if (totalAlunos == 0) {
            System.out.println("\nNenhum aluno cadastrado ainda.");
            return;
        }

        String casaEscolhida = lerTexto("Digite o nome da casa (Grifinória, Sonserina, Corvinal, Lufa-Lufa): ");
        int total = 0;

        System.out.println("\nAlunos da casa " + casaEscolhida.toUpperCase() + ":");
        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].verificacaoDaCasa(casaEscolhida)) {
                alunos[i].exibirInformacoes();
                total++;
            }
        }

        if (total == 0) {
            System.out.println("Nenhum aluno encontrado nessa casa.");
        } else {
            System.out.println("\nTotal de alunos na casa " + casaEscolhida.toUpperCase() + ": " + total);
        }
    }

    // ---------- Opção 4 ----------
    private static void exibirAgrupadoPorCasa() {
        if (totalAlunos == 0) {
            System.out.println("\nNenhum aluno cadastrado ainda.");
            return;
        }

        String[] casas = {"Grifinória", "Sonserina", "Corvinal", "Lufa-Lufa"};

        for (int c = 0; c < casas.length; c++) {
            System.out.println("\n===== " + casas[c].toUpperCase() + " =====");
            int total = 0;

            for (int i = 0; i < totalAlunos; i++) {
                if (alunos[i].verificacaoDaCasa(casas[c])) {
                    System.out.println("- " + alunos[i].getNome() + " " + alunos[i].getSobrenome()
                            + " (" + alunos[i].getCodigoMatricula() + ")");
                    total++;
                }
            }

            if (total == 0) {
                System.out.println("(nenhum aluno)");
            } else {
                System.out.println("Total: " + total);
            }
        }
    }

    // ---------- Opções 5 e 6 ----------
    private static void exibirPorMaioridade(boolean maiores) {
        if (totalAlunos == 0) {
            System.out.println("\nNenhum aluno cadastrado ainda.");
            return;
        }

        System.out.println(maiores ? "\nAlunos maiores de idade (17+):" : "\nAlunos menores de idade:");
        int total = 0;

        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].verificarMaioridadeMagica() == maiores) {
                alunos[i].exibirInformacoes();
                total++;
            }
        }

        if (total == 0) {
            System.out.println("Nenhum aluno encontrado.");
        } else {
            System.out.println("\nTotal: " + total);
        }
    }

    // ---------- Opção 7 ----------
    private static void buscarPorSobrenome() {
        if (totalAlunos == 0) {
            System.out.println("\nNenhum aluno cadastrado ainda.");
            return;
        }

        String busca = lerTexto("Digite o sobrenome (ou parte dele): ");
        int total = 0;

        System.out.println("\nResultados para \"" + busca + "\":");
        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].verificarPresencaDePalavra(busca)) {
                alunos[i].exibirInformacoes();
                total++;
            }
        }

        if (total == 0) {
            System.out.println("Nenhum aluno encontrado com esse sobrenome.");
        } else {
            System.out.println("\nTotal encontrado: " + total);
        }
    }

    // ---------- Leitura de entrada com validação ----------
    private static String lerTexto(String pergunta) {
        String texto = "";
        while (texto.isEmpty()) {
            System.out.print(pergunta);
            texto = LER.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Não pode ficar em branco. Tente novamente.");
            }
        }
        return texto;
    }

    private static int lerInteiro(String pergunta) {
        while (true) {
            System.out.print(pergunta);
            String entrada = LER.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double lerDouble(String pergunta) {
        while (true) {
            System.out.print(pergunta);
            String entrada = LER.nextLine().trim().replace(",", ".");
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido (ex: 8 ou 8.5).");
            }
        }
    }

    private static LocalDate lerData(String pergunta) {
        while (true) {
            System.out.print(pergunta);
            String entrada = LER.nextLine().trim();
            try {
                LocalDate data = LocalDate.parse(entrada, FORMATO_DATA);
                if (data.isAfter(LocalDate.now())) {
                    System.out.println("A data não pode estar no futuro.");
                    continue;
                }
                return data;
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Use dd/MM/yyyy (ex: 31/07/1980).");
            }
        }
    }
}