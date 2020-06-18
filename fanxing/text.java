package fanxing;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class text {
    public static   void main(String args[]) {
        Logger.getGlobal().info("213");//可以用全局日志代替syso 取消的时候设置全局日志等级就可以了
        new Exception().printStackTrace();//直接打印 不用syso
        System.out.println(demo.class==new demo<String,Integer>().getClass());
//        有泛型和无泛型时的class都是同一个 泛型不影响class 而且instanceof 第二个参数 不能加泛型 要用普通的
        ArrayList<? extends Exception> arrayList=new ArrayList<>();//定义通配符 代表这个类的泛型是Exception子类
//        或本身 可以根据实际判读
        //arrayList.add(new Exception());//extends 不能调用传入泛型的方法 因为传入的实际泛型可能是参数的子类
//        不满足多态
        ArrayList<? super Exception> arrayList1=new ArrayList<Object>();//代表是Exception的父类 或本身
//        这些只是加限制 让实际传进来的泛型有个限制 根据后面实际动态判断
//        ？通配符是在定义变量时先代替实际泛型传入 再后续操作 而类中的泛型限制extends 是定义类 时泛型操作根据extends
//        进行编译
        ArrayList<?> arrayList2=new ArrayList<String>();
//        arrayList2.add(new Object());  无泛型的可以
// 设置为?的任何变量都不能传入参数是泛型的 因为?不知道泛型 但可以null
// 而有限制的知道限制范围 知道泛型可以传入
        arrayList2.add(null);
        arrayList1.add(new IOException());//因为编译器只知道是Exception的父类 并不知道具体的 只能传入
//        Exception的本身或者子类 才满足一定多态 但new实例时 泛型必须是Exception父类 虽然泛型是父类
//        但传入方法的可以是接收参数的子类  这两者并不影响
        Object a=arrayList1.get(0);//返回是因为只知道是父类 如果用别的接收 可能返回这个的父类 因此只能用Object
//        通过extends 和super可以影响泛型的实例和内部方法调用限制
// 而内部的泛型extends是影响泛型类代码的调用和默认类是什么和同样的限制泛型实例
//        接收 因为Object没有父类
//        String.class实际上就是Class<String>
    }
}
class demo<T,U extends Object & Comparable>{//定义泛型 在类名后面大写字母<>
//    定义泛型时还可以加限制 这里就是继承限制 可以定义是谁的子类或者接口 定义超类的要在前 &拼接
//    这样传入的U就必须是Object子类并实现Comparable接口
//    泛型再类中实际运用都是当作超类和实现接口如果没有就Object 其他的编译不通过
// 没有传入泛型就默认用超类和接口没超类就Object和接口
    T nums;//用泛型定义类的变量
//   static U str;不能在静态属性 方法引用类的 泛型 因为调用静态方法没有实例化 不知道泛型
//    而泛型方法 是单独给方法设置泛型可以静态不依赖类
    public void p(T num,Class<T> c) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {//还可以方法参数用泛型
        //catch (T e){//泛型不能捕获异常 也不能方法throws T 但内部throw (T)e 可以 throws T
        this.<String>getTi("ds");
        getTi("1");//
//        new T();不能实例化 泛型 因为编译并不知道泛型类型 默认调用限制超类的new
        c.getConstructor().newInstance();//但可以通过传入Class 知道T类型 再反射创建实例 要传入class才行
    }
    public   <Z> Z getTi(Z a){//定义方法泛型 可以在普通类中定义 传入时如果可以根据参数判断类型 就不用加<> 不然就加<>
//        然后加<>要有调用对象 静态加类名
//        一个类不能同时作为不同泛型接口的实现类 包括子类的实现
//        不同泛型 就算泛型类型是父子 但两个类没有任何关系 但可以将有泛型的赋值给无泛型变量 或者有泛型的类赋值给这个类的
//        父类 就多态同样有效
        Throwable[] as=new Exception[2];//而数组不同 数组元素是父子的话可以赋值对象

        return a;

    }
}
