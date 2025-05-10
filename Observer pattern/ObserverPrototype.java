public class ObserverPrototype {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation(34);

        PhoneWeather phoneWeather = new PhoneWeather(weatherStation);
        phoneWeather.display();
        weatherStation.addObserver(phoneWeather);
        weatherStation.notifyObservers();
        phoneWeather.display();
        weatherStation.setTemperature(25);
        weatherStation.notifyObservers();
        phoneWeather.display();
    }
}
