import enums.CategoriaEnum;
import enums.StatusPedidoEnum;
import exceptions.PedidoInvalidoException;
import exceptions.ValorInvalidoException;

public abstract class Pedido {
    private String id;
    private double valor;
    private String nomeCliente;
    Enum<StatusPedidoEnum> status;
    Enum<CategoriaEnum> categoria;

    public Pedido(String id, String nomeCliente) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        if(valor <=0){
            throw new ValorInvalidoException("Valor invalido");
        }
    }

    public String getId() {return id;}

    public double getValor() {return valor;}
    public void setValor(double valor) {}

    public String getNomeCliente() {return nomeCliente;}
    public void setNomeCliente(String nomeCliente) {}

    public Enum<StatusPedidoEnum> getStatus() {return status;}
    public void setStatus(Enum<StatusPedidoEnum> status) {}

    public Enum<CategoriaEnum> getCategoria() {return categoria;}
    public void setCategoria(Enum<CategoriaEnum> categoria) {}

    public void processaPedido(){
        try
        {

        } catch (PedidoInvalidoException pedidoInvalido) {
            throw new RuntimeException(pedidoInvalido);
        }
    }

}
