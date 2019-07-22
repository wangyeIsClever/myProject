package C8_Memento;

/**
 * 备忘录，备忘录需要覆盖原发器的属性
 */
public class ChessMemento {

    private Color color; // 棋子颜色

    private int x; // 棋子横坐标

    private int y; // 棋子纵坐标

    ChessMemento(Color color,int x,int y){
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
