package enums;

public enum CategoriaEnum {
    ELETRONICO ("Eletrônico"),
    ROUPA ("Roupa"),
    ALIMENTO ("Alimento");

    private String categoria;

    CategoriaEnum(String categoria) {
        this.categoria = categoria;
    }
    public String getCategoria() {
        return categoria;
    }
}
