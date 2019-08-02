package GOF23.C8_Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责人，管理备忘录的
 */
public class MementoCaretaker {

    //维护一个备忘录的集合
    private List<ChessMemento> mementoList = new ArrayList<>();

    private int index = -1;


    /**
     * 继续 前进
     */
    public void goOn(ChessMan chessMan){
        index++;
        this.mementoList.add(index,chessMan.saveToMemento());
        // 如果是悔棋多步下棋，那么就把前面的记录清空
        if(index < this.mementoList.size() - 1 ){
            for (int i = index + 1 ; i < this.mementoList.size() ; i++){
                this.mementoList.remove(i);
            }
        }
    }

    /**
     * 悔棋
     * @return 上一步棋子
     */
    public ChessMan undo(){
        ChessMan chessMan = new ChessMan();
        if (index >= 0){
            chessMan.restoreToMemento(this.mementoList.get(--index));
        } else {
            chessMan = null;
        }
        return chessMan;
    }

    /**
     * 恢复悔棋
     */
    public ChessMan redo(){
        ChessMan chessMan = new ChessMan();
        index++;
        if (index < this.mementoList.size()){
            chessMan.restoreToMemento(this.mementoList.get(index));
        } else {
            chessMan = null;
        }
        return chessMan;
    }


}
