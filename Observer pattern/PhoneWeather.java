public class PhoneWeather implements IObserver {
    WeatherStation station;
    private int currentTemperature = 0;

    public PhoneWeather(WeatherStation station) {
        this.station = station;
    }
    @Override
    public void update() {
        currentTemperature = station.getTemperature();

    }

    public void display() {
        System.out.println("Current temperature in lagos : " + currentTemperature);
    }


}
