package B5_composite;

public class CompositeTest {


    public static void main(String[] args) {
        MyFolder root = new MyFolder("/",null);
        root.addFile(new MyFile("readme.txt",root));
        root.addFile(new MyFile("ohMyGod.mp4",root));
        root.addFile(new MyFile("如何三天成为帅哥.pdf",root));


        MyFolder temp = new MyFolder("/tmp",root);
        temp.addFile(new MyFile("temp.txt",temp));
        temp.addFile(new MyFile("ohMyLady.mp4",temp));
        temp.addFile(new MyFile("如何三天成为美女.pdf",temp));
        root.addFile(temp);

        root.operation();
    }
}
