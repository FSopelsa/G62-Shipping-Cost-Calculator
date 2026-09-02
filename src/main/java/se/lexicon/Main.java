package se.lexicon;

import se.lexicon.calculator.ExpressInternationalShipping;
import se.lexicon.calculator.StandardDomesticShipping;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCalculatorFactory;
import se.lexicon.service.ShippingCostCalculator;
import se.lexicon.service.ShippingService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Manual object creation (composition root)
        List<ShippingCostCalculator> calculators = List.of(
                new StandardDomesticShipping(),
                new ExpressInternationalShipping()
        );


        ShippingCalculatorFactory factory = new ShippingCalculatorFactory(calculators);
        
        ShippingService shippingService = new ShippingService(factory);

        ShippingRequest domesticStandardRequest = new ShippingRequest(Destination.DOMESTIC, Speed.STANDARD, 10.0);
        System.out.println("Shipping cost: " + shippingService.quote(domesticStandardRequest));

        ShippingRequest internationalExpressRequest = new ShippingRequest(Destination.INTERNATIONAL, Speed.EXPRESS, 15.0);
        System.out.println("Shipping cost: " + shippingService.quote(internationalExpressRequest));

        ShippingRequest lightDomesticRequest = new ShippingRequest(Destination.DOMESTIC, Speed.STANDARD, 5.0);
        System.out.println("Shipping cost: " + shippingService.quote(lightDomesticRequest));

        ShippingRequest heavyInternationalExpressRequest = new ShippingRequest(Destination.INTERNATIONAL, Speed.EXPRESS, 20.0);
        System.out.println("Shipping cost: " + shippingService.quote(heavyInternationalExpressRequest));
    }
}
