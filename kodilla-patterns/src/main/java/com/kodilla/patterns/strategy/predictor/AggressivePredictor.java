package com.kodilla.patterns.strategy.predictor;

public non-sealed class AggressivePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "Aggressive buy";
    }
}
