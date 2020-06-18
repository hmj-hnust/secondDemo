package lambdaAndinnerClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class demo03 {
    public int nums=0;
    public static int snums=2;
    public static void main(String args[]) {
        String[] strs=new String[1];

        Arrays.sort(strs,new Comparator(){//匿名内部类的方式

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        Arrays.sort(strs,(String a,String b)->a.length()-b.length());//lambda表达式 参数扩起来
//        然后->后指定操作 如果只有一行不用加{}
        Arrays.sort(strs,(a,b)->{return a.length()-b.length();});
//        但如果多行操作要加{} lambda 会根据上下文判断 返回类型 加了{} 要返回的话就必须return
//        lambda参数的类型可以推断出来的时候不用加类型 直接名字
        ActionListener listener=event-> System.out.println(1);//如果参数只有一个时且类型知道 可以不用括号
//        lambda一般用于只有一个方法没有实现的接口和抽象类
        demo03 demo03=new demo03();
        //demo03.p("@31");
        inner inner=demo03.new inner();//new 内部类
        inner.p();
        sinner sinner=new demo03.sinner();//创建静态内部类 不用new外部类 直接外部类.静态内部类
        assert strs==null : strs;//断言 默认关闭 如果断言表达式为false 抛出异常 并将第二个参数传入异常
    }
    public void p(String path){
        ActionListener listener=event-> {System.out.println(path);//方法结束时参数没了 这个变量还有 lambda在
//            内部拷贝了
            //lambda中能引用局部变量 但这些引用的值都是不能改变的
            //        包括内部 方法中都不能改变这个值 而且lambda中的变量包括lambda的参数不能和局部变量同名
            System.out.println(this.nums);};
//         但是通过this引用的外部变量就没事 是可以改变的
        new javax.swing.Timer(1000,listener).start();
        class jubuClass{//局部类 局部类就只能这个局部访问 而且局部类可以访问局部变量 但局部变量一样不能改变
//            但引用外部字段时 可以改变 lambda也一样
            public void p(){
                System.out.println(path);
                System.out.println(demo03.this.nums);//引用外部类属性 这里的this不再和lambda一样指向外部类
//                而是指向自身类 要指向外部加类名 和内部类一样 都有外部类实例
            }
        }
        ActionListener listener1=new ActionListener() {//定义匿名内部类 匿名内部类没有构造器 因为没有类名
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(path);//和lambda一样 不能改变
                System.out.println(demo03.this.nums);//也可以引用外部类属性 这里的this不再和lambda一样指向外部类
//                而是指向自身类 要指向外部加类名 和内部类一样 都有外部类实例
            }
        };
//局部的类中都可以访问局部变量 但不能改变 和外部类属性
    }
    class inner{
        int nums=1;
        public void p(){
            System.out.println(demo03.this.nums);//内部类通过 外部类.this 访问外部类属性成员 可以访问实例
            System.out.println(inner.this.nums);//内部类.this 访问内部类属性成员
        }
    }
    static class sinner{
        public void p(){
            System.out.println(demo03.snums);//静态内部类 就只能访问外部类的 静态部分了 因为没有外部类实例
            // 其实所有类都可以访问静态部分
        }
    }
}
class MyException extends IOException{//自定义异常类  处理IOException的也可以处理这个 因为IOException有的
//    这个都有
    public MyException() {
        Throwable throwable=new Exception();//Exception 的父类是Throwable
    }

    public MyException(String message) throws IOException {
        super(message);
        try(Scanner s=new Scanner(System.in);){//try()中定义的会自动结束时关闭 但这个资源类要实现Closeable并
//            实现方法close 而且这个资源只在try中有效 可以指定多个; 分割

        }
        catch (Exception e){
           IOException exception=new IOException();
           exception.initCause(e);//给自己创建的异常设置原始异常
            exception.getCause();//获取原始异常
            exception.printStackTrace();//Throwable类的方法 Exception继承的Throwable 所以所有异常都有这个方法
//            就是打印异常相关信息
           throw exception;//继续抛出异常 方法也要

        }
        finally {
//            里面的内容一定会执行 一般用来关闭资源 但在try()中定义的如果实现了Closeable 会自动关闭
        }
    }
//    对于异常 捕获知道怎么处理的 传播不知道怎么处理的
//    捕获多个异常时 特殊的在前面 因为父类可以捕获自身和子类
}
