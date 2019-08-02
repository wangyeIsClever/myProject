package GOF23.C8_Memento;


/**
 * 棋子类，这是原发器，被保存的对象
 */
public class ChessMan {

    private Color color; // 棋子颜色

    private int x; // 棋子横坐标

    private int y; // 棋子纵坐标

    /**
     * 保存到备忘录
     * @return 棋子的备忘录
     */
    public ChessMemento saveToMemento(){
        return new ChessMemento(this.color,this.x,this.y);
    }

    /**
     * 从备忘录恢复棋子的状态
     * @param chessMemento 备忘录
     */
    public void restoreToMemento(ChessMemento chessMemento){
        this.color = chessMemento.getColor();
        this.x = chessMemento.getX();
        this.y = chessMemento.getY();

    }

    public void show(){
        System.out.println("当前棋子是 " + this.color.getColorDesc() + "棋子 ，位置： 横坐标 ：" + this.x + " 纵坐标 ：" + this.y);
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
