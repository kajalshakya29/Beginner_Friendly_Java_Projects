import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the original unit of measurement (C for Celsius, F for Fahrenheit, K for Kelvin): ");
        char originalUnit = scanner.next().charAt(0);

        double celsius, fahrenheit, kelvin;

        switch (originalUnit) {
            case 'C':
                celsius = temperature;
                fahrenheit = celsiusToFahrenheit(celsius);
                kelvin = celsiusToKelvin(celsius);
                break;
            case 'F':
                fahrenheit = temperature;
                celsius = fahrenheitToCelsius(fahrenheit);
                kelvin = fahrenheitToKelvin(fahrenheit);
                break;
            case 'K':
                kelvin = temperature;
                celsius = kelvinToCelsius(kelvin);
                fahrenheit = kelvinToFahrenheit(kelvin);
                break;
            default:
                System.out.println("Invalid unit of measurement. Please try again.");
                return;
        }

        System.out.printf("Original temperature: %.2f %c%n", temperature, originalUnit);
        System.out.printf("Celsius: %.2f°C%n", celsius);
        System.out.printf("Fahrenheit: %.2f°F%n", fahrenheit);
        System.out.printf("Kelvin: %.2f K%n", kelvin);
    }

    private static double celsiusToFahrenheit(double celsius) {
        return celsius * 9/5 + 32;
    }

    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    private static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    private static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    private static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5/9 + 273.15;
    }

    private static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9/5 + 32;
    }
}