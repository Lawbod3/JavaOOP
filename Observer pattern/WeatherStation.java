import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements IObservable{
    private List<IObserver> observers;
    private int temperature;

    public WeatherStation(int temperature) {
        this.temperature = temperature;
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);

    }

    @Override
    public void notifyObservers() {
        for(IObserver observer : observers) {
            observer.update();
        }

    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }


}
