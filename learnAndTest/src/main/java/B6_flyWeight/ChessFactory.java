package B6_flyWeight;


import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 */
public class ChessFactory {

    private static Map<Color,Chess> chessMap = new HashMap<>();

    public static int size(){
        return chessMap.size();
    }

    /**
     * 如果有同意颜色的棋子就返回，如果没有就创建后put再返回
     * @param color 棋子 颜色
     * @return 棋子
     */
    public static Chess getChess(Color color){
        if (chessMap.get(color) != null){
            return chessMap.get(color);
        } else {
            Chess chess = new ChessImpl(color);
            chessMap.put(color,chess);
            return chess;
        }

    }
}
