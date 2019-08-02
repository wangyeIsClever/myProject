package GOF23.A3_cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class SubjectMethodInterceptor implements MethodInterceptor {

    /**
     * obj：cglib生成的代理对象 "this", the enhanced object(增强的对象)
     * method：被代理对象方法 intercepted Method 拦截（代理）的方法
     * args：方法入参 argument array; primitive types are wrapped （参数数组，原始类型被包装）
     * proxy: 代理方法 用户调用super的非拦截（没有代理）的方法，但是是可能被调用
     */
    public Object intercept(Object obj, java.lang.reflect.Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("======做某事之前准备======");
        Object object = proxy.invokeSuper(obj, args);
        System.out.println("======做某事之后收尾======");
        return object;
    }
}
