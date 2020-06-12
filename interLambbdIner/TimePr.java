package interLambbdIner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class TimePr implements ActionListener,Comparator<Integer>,Cloneable {//如果要调用定时器 要实现这个监听器
    @Override
    public void actionPerformed(ActionEvent e) {//重写方法 这个方法中的操作就是定时器每隔一段时间操作
        System.out.println(1);
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }

    public static void main(String args[]) throws CloneNotSupportedException {
        TimePr timePr=new TimePr();//创建自己的定时器类
        Timer r=new Timer(1000,timePr);//创建定时器传入时间和自己实现的类
        r.start();//开始 每隔一段时间执行一次
        r.stop();//停止

        Arrays.sort(new Integer[2],new TimePr());//还可以传入定义好的工具类(实现类Comparator的类来定义排序规则)
        TimePr a=(TimePr) timePr.clone();
        System.out.println(a);
        new int[2].clone();//数组都有重写一个clone方法 但这个不能重新定义长度
    }

    @Override//重写可以改修饰符 和返回方法
//    Object的clone默认是protected 但如果是protected那么在其他包创建这个类对象就不能调用clone 因此要改成public
//    如果重写了clone就要实现Cloneable接口 这个接口只是一个标记不用重写任何方法 没有的话抛出异常
        public Object clone() throws CloneNotSupportedException {
        return super.clone();//可以自己实现深拷贝 属性一个个调用clone或者自己重新引用到新对象 还要调用超类拷贝
//        浅拷贝是属性可能引用同一个 只是对象不同一个
    }
}
