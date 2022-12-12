package br.com.eguadorodrigo.kafkastarterproject;

public enum Topics {
    
    ECOMMERCE_NEW_ORDER(Constants.ECOMMERCE_NEW_ORDER_VALUE),
    LOJA_NOVO_PEDIDO(Constants.LOJA_NOVO_PEDIDO_VALUE),
    QUICKSTART(Constants.QUICKSTART_VALUE);

    
    private Topics(String value) {
        this.value = value;
    }
    
    private final String value;

    public String getValue() {
        return this.value;
    }

    private static class Constants{
        public static final String ECOMMERCE_NEW_ORDER_VALUE = "ECOMMERCE_NEW_ORDER";
        public static final String LOJA_NOVO_PEDIDO_VALUE = "LOJA_NOVO_PEDIDO";
        public static final String QUICKSTART_VALUE = "quickstart";

    }
}
