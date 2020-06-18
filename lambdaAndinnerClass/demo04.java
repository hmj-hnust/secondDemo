package lambdaAndinnerClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class demo04 {
    public static void main(String args[]) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Logger.getGlobal().setLevel(Level.OFF);//关闭全局的日志 全局日志只有一个 后面创建的和这个无关
        Logger.getGlobal().info("213");//输出日志
        Logger my=Logger.getLogger("lambdaAndinnerClass.demo04");
        my.setLevel(Level.INFO);//每个日志都有相应级别 都可以关闭 设置之后用这个日志就会根据级别显示信息
        my.info("231");
        my.warning("2");
        Object[] nums=new Object[2];
        for(int i=0;i<2;i++){
            Integer a=i+6;
            traceHandler traceHandler=new traceHandler(a);
         Object p=Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Comparable.class},traceHandler);
//         这个代理类 的任何方法调用都会调用处理器包括Object的方法 所以toString就是调用了处理器
//            在调用处理器中的Integer执行的 反正就是获得这个代理类 这个代理类执行方法都会去调用处理器
//            而处理器中可以传入对象 通过对象invoke来实现代理 就相当于那个对象调用方法不过自己有一些操作
//            当然并不一定要有对象 可以无对象static方法 也可以不invoke
                    nums[i]=p;
        }
        System.out.println(nums[0].getClass());//同一个类加载器和接口类 创建的Proxy是同一个代理类的不同对象
//      处理器不影响类的种类
        System.out.println(Proxy.getProxyClass(ClassLoader.getSystemClassLoader(),Comparator.class));
//        和getClass一样获得代理类class
        System.out.println(((Comparable)nums[0]).compareTo(2));//可以转换成代理类中Class数组中的类再调用方法
        System.out.println(Arrays.binarySearch(nums,7));

    }
}
class traceHandler implements InvocationHandler{//调用处理器
    private Object object;

    public traceHandler(Object object) {//传入一个对象
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        当代理类调用方法时就触发这个操作 通过传入的对象invoke 调用方法 Object的方法也可以这样调用
        System.out.println(-1);
        return method.invoke(object,args);
    }
}
