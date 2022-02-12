package com.taurinustrading.exchangematchingengine.orders;

public class Order {
    private final OrderCore orderCore;
    private final long price;
    private final int initialQuantity;
    private int currentQuantity;
    private final boolean isBuySide;

    public Order(OrderCore orderCore, long price, int quantity, boolean isBuySide) {
        this.orderCore = orderCore;
        this.price = price;
        this.initialQuantity = quantity;
        this.currentQuantity = quantity;
        this.isBuySide = isBuySide;
    }

    public void increaseQuantity(int quantityDelta) {
        if (quantityDelta < 0) {
            throw new IllegalStateException(String.format(
                    "Quantity delta cannot be negative for orderId=%s", orderCore.orderId()));
        } else if (currentQuantity + quantityDelta >= Integer.MAX_VALUE) {
            throw new IllegalStateException(String.format(
                    "Quantity delta exceeds maximum allowable quantity for orderId=%s", orderCore.orderId()));
        }
        currentQuantity += quantityDelta;
    }

    public void decreaseQuantity(int quantityDelta) {
        if (quantityDelta < 0) {
            throw new IllegalStateException(String.format(
                    "Quantity delta cannot be negative for orderId=%s", orderCore.orderId()));
        } else if (currentQuantity - quantityDelta < 0) {
            throw new IllegalStateException(String.format(
                    "Insufficient quantity. Quantity delta > current quantity for orderId=%s", orderCore.orderId()));
        } else {
            currentQuantity -= quantityDelta;
        }
    }

    public OrderCore getOrderCore() {
        return orderCore;
    }

    public long getPrice() {
        return price;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public boolean isBuySide() {
        return isBuySide;
    }
}
