package com.kodilla.patterns.strategy.predictor;

public non-sealed class ConservativePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "Conservative buy";
    }
}
