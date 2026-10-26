package enums;

public enum StatusPedidoEnum {
    PENDENTE ("Pendente"),
    PROCESSANDO ("Processando"),
    ENVIADO ("Enviado"),
    ENTREGUE ("Entregue"),
    CANCELADO ("Cancelado");

    private String statusPedido;

    StatusPedidoEnum(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }
}
