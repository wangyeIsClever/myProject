package C3_Observer;



/**
 * 天气数据是被观察者
 */
public interface WeatherData {

    /**
     * 添加天气的观察者
     * @param observer 观察者
     */
    void deleteObserver(MyObserver observer);

    /**
     * 删除天气的观察者
     * @param observer 观察者
     */
    void addObserver(MyObserver observer);

    /**
     * 通知观察者
     */
    void notifyObservers();

    /**
     * 设置天气数据
     */
    void setWeatherData(float temperature,float humidity,float airpressure);
}
