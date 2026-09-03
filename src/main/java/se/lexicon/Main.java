package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingService;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {
            ShippingService shippingService = context.getBean(ShippingService.class);

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
}
