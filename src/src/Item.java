public class Item {
    private Fatura fatura;
    private Produto produto;
    private int quantidadeComprada;
    private double valorTotal;

    public Item(Fatura fatura, Produto produto) {
        this.fatura = fatura;
        this.produto = produto;
        this.valorTotal = produto.getPreco() * quantidadeComprada;
    }
}
