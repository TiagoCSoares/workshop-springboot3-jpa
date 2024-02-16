package com.tiagocsoares.course.entities;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    //Esse método é necessário para que seja possível instanciar um objeto do tipo OrderStatus
    //Devudi ai (1)... em frente ao status
    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    // Passa um código e retorna a String correspondente
    public static OrderStatus valueOf(int code) {
        // Percorre todas as possibilidades do enum
        for (OrderStatus value : OrderStatus.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        // Caso o código não exista no enum
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}


