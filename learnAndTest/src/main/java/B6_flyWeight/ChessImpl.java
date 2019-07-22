package B6_flyWeight;

public class ChessImpl implements Chess{


    private Color color;

    ChessImpl(Color color){
        this.color = color;
    }

    @Override
    public void setColor(Color c) {
        this.color = c;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void display(Coordinate c) {
        System.out.println("棋子颜色："+this.getColor().getColorDesc());
        System.out.println("棋子位置：x：" + c.getX() + " y:" + c.getY());
    }
}
