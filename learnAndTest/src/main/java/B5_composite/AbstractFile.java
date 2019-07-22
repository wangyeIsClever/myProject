package B5_composite;



/**
 *
 */
public interface AbstractFile {

    boolean isFile();

    boolean hasParent();

    AbstractFile getParent();

    void addFile(AbstractFile file);

    void deleteFile(AbstractFile file);

    AbstractFile getChilds(int i);

    void operation();

    void setLevel(int i);

    int getLevel();
}
