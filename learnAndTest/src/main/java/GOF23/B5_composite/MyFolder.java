package GOF23.B5_composite;


import java.util.ArrayList;
import java.util.List;

public class MyFolder implements AbstractFile {

    private String path;

    private List<AbstractFile> chlids = new ArrayList<>();

    private AbstractFile parentFolder;

    private int level = 1;




    MyFolder(String path,AbstractFile parentFolder){
        this.path = path;
        this.parentFolder = parentFolder;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean hasParent() {
        return this.parentFolder != null;
    }

    @Override
    public AbstractFile getParent() {
        return parentFolder;
    }

    @Override
    public void addFile(AbstractFile file) {
        if (this.hasParent()){
            file.setLevel(file.getLevel() + 1);
        }
        chlids.add(file);
    }

    @Override
    public void deleteFile(AbstractFile file) {
        chlids.remove(file);
    }

    @Override
    public AbstractFile getChilds(int i) {
        return chlids.get(i);
    }

    @Override
    public void operation() {
        System.out.print("我是文件夹，在我路径" + this.path +"下，有以下文件或者文件夹:\n" );
        for (AbstractFile file : chlids){
            for (int i = 0 ; i < file.getLevel();i++){
                System.out.print("----");
            }
            file.operation();
        }
    }

    @Override
    public void setLevel(int i) {
        this.level = i;
    }

    @Override
    public int getLevel() {
        return this.level;
    }
}
