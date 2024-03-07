package com.kodilla.patterns.strategy.predictor;

public non-sealed class BalancedPredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "Balanced buy";
    }
}
