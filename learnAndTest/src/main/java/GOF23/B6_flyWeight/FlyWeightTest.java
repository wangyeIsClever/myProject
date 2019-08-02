package GOF23.B6_flyWeight;

public class FlyWeightTest {

    public static void main(String[] args) {
        System.out.println("没有获取棋子时，棋子工厂大小" + ChessFactory.size());
        System.out.println();

        Chess whiteChess1 = ChessFactory.getChess(Color.WHITE);
        System.out.println("1.获取第一颗白棋子时，棋子工厂大小" + ChessFactory.size());
        whiteChess1.display(new Coordinate(2,3));
        System.out.println();

        Chess whiteChess2 = ChessFactory.getChess(Color.WHITE);
        System.out.println("2.获取第二颗白棋子时，棋子工厂大小" + ChessFactory.size());
        whiteChess2.display(new Coordinate(2,3));
        System.out.println();

        System.out.println("第一颗白棋子和第二颗白棋子是否是一个对象" + (whiteChess1.hashCode() == whiteChess2.hashCode()));
        System.out.println();

        Chess blackChess1 = ChessFactory.getChess(Color.BLACK);
        System.out.println("3.获取第一颗黑棋子时，棋子工厂大小" + ChessFactory.size());
        blackChess1.display(new Coordinate(4,3));
        System.out.println();

        Chess blackChess2 = ChessFactory.getChess(Color.BLACK);
        System.out.println("4.获取第二颗黑棋子时，棋子工厂大小" + ChessFactory.size());
        blackChess2.display(new Coordinate(5,3));
        System.out.println();

        System.out.println("第一颗黑棋子和第二颗黑棋子是否是一个对象" + (blackChess1.hashCode() == blackChess2.hashCode()));
        System.out.println();

    }
}
