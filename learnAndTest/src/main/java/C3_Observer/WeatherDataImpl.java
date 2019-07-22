package C3_Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataImpl implements WeatherData {

    private float temperature;
    private float humidity; //
    private float airpressure;

    private List<MyObserver> observers;

    WeatherDataImpl(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void deleteObserver(MyObserver observer) {
        int index;
        if ((index = this.observers.indexOf(observer)) != -1){
            this.observers.remove(index);
        }
    }

    @Override
    public void addObserver(MyObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (MyObserver observer : this.observers){
            observer.upadate(this.temperature,this.humidity,this.airpressure);
        }
    }

    @Override
    public void setWeatherData(float temperature, float humidity, float airpressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.airpressure = airpressure;
        this.notifyObservers();
    }
}
