package com.kodilla.patterns.strategy.predictor;

public sealed interface BuyPredictor permits AggressivePredictor, BalancedPredictor, ConservativePredictor {

    String predictWhatToBuy();
}
