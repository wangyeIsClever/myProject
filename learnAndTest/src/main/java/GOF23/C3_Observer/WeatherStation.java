package GOF23.C3_Observer;

/**
 * 气象站
 */
public class WeatherStation implements MyObserver,MyDisplay {


    private float temperature;
    private float humidity; //
    private float airpressure;

    @Override
    public void display() {
        System.out.println("气象站观测的天气数据是：温度：" + this.temperature + " 湿度：" + this.humidity + " 气压：" + this.airpressure);
    }

    @Override
    public void upadate(float temperature, float humidity, float airpressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.airpressure = airpressure;
        this.display(); // 更新完成立马公告
    }
}
