package A3_cglibproxy;

import net.sf.cglib.proxy.Enhancer;

public class CglibTest {

    public static void main(String[] args) {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(SubjectService.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new SubjectMethodInterceptor());
        // 创建代理对象（增强对象）
        SubjectService proxy= (SubjectService)enhancer.create();
        // 通过代理对象调用目标方法
        proxy.doSomethings("锤子");

    }

}
