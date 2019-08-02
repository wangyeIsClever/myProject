package GOF23.B6_flyWeight;

/**
 * 享元模式是为了节省内存的模式
 * 内存属于稀缺资源，不要随便浪费。如果有很多个完全相同或相似的
 * 对象，我们可以通过享元模式，节省内存.
 *
 * 享元模式以共享的方式高效地支持大量细粒度对象的重用。
 * 享元对象能做到共享的关键是区分了内部状态和外部状态。
 *  • 内部状态：可以共享，不会随环境变化而改变
 *  • 外部状态：不可以共享，会随环境变化而改变
 *
 *
 *  下面是享元类要实现的接口
 */
public interface Chess {

    void setColor(Color c);
    Color getColor();
    void display(Coordinate c);

}
