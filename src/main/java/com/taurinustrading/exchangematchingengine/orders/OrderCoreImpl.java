package com.taurinustrading.exchangematchingengine.orders;

public class OrderCoreImpl implements OrderCore {
    private long orderId;
    private String username;
    private int securityId;

    public OrderCoreImpl() {}

    public OrderCoreImpl(long orderId, String username, int securityId) {
        this.orderId = orderId;
        this.username = username;
        this.securityId = securityId;
    }

    @Override
    public long orderId() {
        return orderId;
    }

    @Override
    public String username() {
        return username;
    }

    @Override
    public int securityId() {
        return securityId;
    }
}
