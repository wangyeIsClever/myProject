package C8_Memento;


public class Client {


    private static MementoCaretaker mementoCaretaker = new MementoCaretaker();

    public static void main(String[] args) {
        ChessMan chessMan = new ChessMan();
        chessMan.setColor(Color.WHITE);
        chessMan.setX(1);
        chessMan.setY(1);
        play(chessMan);
        chessMan.setY(2);
        play(chessMan);
        chessMan.setX(2);
        play(chessMan);
        chessMan.setColor(Color.BLACK);
        chessMan.setX(3);
        play(chessMan);
        chessMan.setY(3);
        play(chessMan);

        undo();
        undo();
        redo();
        redo();


        undo();
        undo();
        chessMan.setX(4);
        play(chessMan);
        redo();
        redo();


    }

    /**
     * 下棋
     * @param chessMan 棋子
     */
    public static void play(ChessMan chessMan){
        mementoCaretaker.goOn(chessMan);
        chessMan.show();
    }

    /**
     * 悔棋
     */
    public static void undo(){
        ChessMan chess = mementoCaretaker.undo();
        if (chess != null){
            System.out.print("悔棋成功,");
            chess.show();
        } else {
            System.out.println("悔棋失败,当前没有下棋，不可以悔棋，请下棋");
        }

    }

    /**
     * 恢复悔棋
     */
    public static void redo(){
        ChessMan chessMan = mementoCaretaker.redo();
        if (chessMan != null){
            System.out.print("恢复成功,");
            chessMan.show();
        } else {
            System.out.println("恢复失败,请继续下棋，没有可以恢复的状态");
        }

    }
}
