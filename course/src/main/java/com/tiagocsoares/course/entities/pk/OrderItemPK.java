package com.tiagocsoares.course.entities.pk;

import com.tiagocsoares.course.entities.Order;
import com.tiagocsoares.course.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

//Classe auxiliar para representar a chave primária composta da classe OrderItem
@Embeddable // Indica que a classe é um subtipo de outra entidade
public class OrderItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id") // A coluna na tabela do banco de dados que armazenará a chave estrangeira para o produto será nomeada como "product_id".
    private Product product;

    // Essa classe não possui construtores, por se tratar de uma chave composta
    // de duas entidades
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemPK that)) return false;
        return Objects.equals(getOrder(), that.getOrder()) && Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrder(), getProduct());
    }
}
