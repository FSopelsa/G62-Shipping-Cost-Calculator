# Shipping Cost Calculator

A small Java console application that calculates a shipping price from the package destination, delivery speed, and weight.

Currently supported shipping rules:

- Domestic standard: `5 + 1.2 * weightKg`
- International express: `25 + 4.5 * weightKg`

The original workshop brief is available in [Workshop.md](Workshop.md).

## Spring refactor

The original application created calculators, the factory, and the service manually in `Main`. It now uses Spring Core instead:

- `AppConfig` configures component scanning for `se.lexicon`.
- The calculators and factory are Spring components; `ShippingService` is a Spring service.
- Spring injects all `ShippingCostCalculator` implementations into `ShippingCalculatorFactory` through its constructor.
- `Main` creates the Spring container and retrieves `ShippingService` from it.

The shipping rules themselves are unchanged. No database, web server, or external configuration is required.

## Run on a new Windows device

1. Install JDK 25 and Maven 3.9 or later, then confirm both are available:

   ```powershell
   java -version
   mvn.cmd -version
   ```

2. Clone the repository and open a terminal in its root directory.

3. Build the project. Maven downloads Spring automatically on the first build:

   ```powershell
   mvn.cmd clean package
   ```

4. Run the console application:

   ```powershell
   mvn.cmd exec:java '-Dexec.mainClass=se.lexicon.Main'
   ```

Alternatively, open the project in IntelliJ IDEA, set the Project SDK to JDK 25, and run `se.lexicon.Main`.

Expected output:

```text
Shipping cost: 17.0
Shipping cost: 92.5
Shipping cost: 11.0
Shipping cost: 115.0
```
