package com.taurinustrading.exchangematchingengine.orders;

public class ModifyOrder {
    private final OrderCore orderCore;
    private final long modifyPrice;
    private final long modifyQuantity;
    private final boolean isBuySide;

    public ModifyOrder(OrderCore orderCore, long modifyPrice, int modifyQuantity, boolean isBuySide) {
        this.orderCore = orderCore;
        this.modifyPrice = modifyPrice;
        this.modifyQuantity = modifyQuantity;
        this.isBuySide = isBuySide;
    }

    public long getModifyPrice() {
        return modifyPrice;
    }

    public long getModifyQuantity() {
        return modifyQuantity;
    }

    public boolean isBuySide() {
        return isBuySide;
    }
}
