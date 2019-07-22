package C3_Observer;

/**
 * 观察者接口
 */
public interface MyObserver {

    /**
     * 更新天气的数据
     * @param temperature 温度
     * @param humidity 湿度
     * @param airpressure 气压
     */
    void upadate(float temperature,float humidity,float airpressure);
}
