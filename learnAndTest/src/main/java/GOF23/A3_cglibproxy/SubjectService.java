package GOF23.A3_cglibproxy;

/**
 * 被代理的某一个类，注意，没有实现任何的一个接口
 */
public class SubjectService {

    public String doSomethings(String needTool){
        System.out.println("用" + needTool + "做一些事情");
        return "调用成功";
    }
}
