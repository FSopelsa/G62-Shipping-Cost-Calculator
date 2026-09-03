package se.lexicon.calculator;

import org.springframework.stereotype.Component;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

@Component
public class ExpressInternationalShipping implements ShippingCostCalculator {

    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.INTERNATIONAL && r.speed() == Speed.EXPRESS;
    }

    public double calculate(ShippingRequest r) {
        return 25 + 4.5 * r.weightKg();
    }
}
