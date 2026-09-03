package se.lexicon.service;

import org.springframework.stereotype.Service;
import se.lexicon.model.ShippingRequest;

@Service
public class ShippingService {
    private final ShippingCalculatorFactory factory;

    public ShippingService(ShippingCalculatorFactory factory) {
        this.factory = factory;
    }

    public double quote(ShippingRequest req) {
        ShippingCostCalculator calc = factory.getCalculator(req);
        return calc.calculate(req);
    }
}
