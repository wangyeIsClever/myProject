package B5_composite;



public class MyFile implements AbstractFile {

    private String name;

    private AbstractFile parentFolder;

    private int level = 1;

    MyFile(String name,AbstractFile parentFolder){
        this.name = name;
        this.parentFolder = parentFolder;

    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public boolean hasParent() {
        return parentFolder != null;
    }

    @Override
    public AbstractFile getParent() {
        return parentFolder;
    }

    @Override
    public void addFile(AbstractFile file) {
        System.out.println("文件不支持此项添加文件操作");
    }

    @Override
    public void deleteFile(AbstractFile file) {
        System.out.println("文件不支持此项删除文件操作");
    }

    @Override
    public AbstractFile getChilds(int i) {
        return null;
    }

    @Override
    public void operation() {
        System.out.print("我是文件，文件名是："+ this.getName()+"\n");
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
