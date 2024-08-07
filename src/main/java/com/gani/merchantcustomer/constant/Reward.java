package com.gani.merchantcustomer.constant;

public enum Reward {
    REWARD_A(20), REWARD_B(40);
    private final Integer price;

    Reward(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
