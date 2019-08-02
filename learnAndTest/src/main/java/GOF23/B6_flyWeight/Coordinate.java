package GOF23.B6_flyWeight;

/**
 * 围棋的位置
 * x 表示 横坐标
 * y 表示 纵坐标
 */
public class Coordinate {
    private int x ,y;

    Coordinate(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
