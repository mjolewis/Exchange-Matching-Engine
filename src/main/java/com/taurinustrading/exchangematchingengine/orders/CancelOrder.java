package com.taurinustrading.exchangematchingengine.orders;

public class CancelOrder {
    private final OrderCore orderCore;

    public CancelOrder(OrderCore orderCore) {
        this.orderCore = orderCore;
    }
}
