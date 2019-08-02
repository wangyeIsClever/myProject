package GOF23.C3_Observer;

public class ObserverTest {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherDataImpl();

        weatherData.addObserver(new WeatherStation());
        weatherData.addObserver(new MeteorologicalStatisticsBureau());

        weatherData.setWeatherData(30,82,128);
    }
}
