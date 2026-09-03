package se.lexicon.model;


public record ShippingRequest(Destination destination, Speed speed, double weightKg) {
}
