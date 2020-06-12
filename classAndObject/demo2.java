package classAndObject;

import ClassTransfer.*;
import diffpack.demo;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import static java.lang.Math.*;//静态导入 让静态方法和属性不用再加类名 要具体到方法和属性 而导入只要具体到类
public class demo2 {

    /**
     * @param args 注释参数
     * @throws  Exception 注释抛出异常
     * @return 注释返回
     * @author 注释作者
     * @version 注释版本
     * @see java.util.Random 注释文档链接 可以去看其他文档
     * */
    public static void main(String args[]) {
        Random random=new Random();
        System.out.println(random.nextInt(9));//0-8随机整数
        System.out.println(PI);
        System.out.println(pow(2,2));
        System.out.println( (new demo() instanceof text));
//        instanceof 第一个参数是对象 第二个是类 判断对象是不是这个类本身或者子类
        System.out.println(new Integer(1).hashCode());
        System.out.println(new Integer(1).hashCode());
//包装类和 string的hashCode 都是根据值生成 但默认hashCode从存储地址获得
//        要确保hashCode相等 equals就一定为true 反过来一样
        System.out.println(Objects.hashCode(123));//Objects工具类的hashCode 传入对象会当为null时返回0
//        而自身的hashCode 为null报空指针异常
        ArrayList arrayList=new ArrayList<Integer>();//有泛型的可以赋值给无泛型的 但无泛型的赋值给有泛型的会抛出异常
//       基本类型不能<> 要包装类
        arrayList.add(1);
        arrayList.ensureCapacity(100);//增加容量确保之后不重新分配数组
        arrayList.trimToSize();//缩小容量至当前大小
        System.out.println(arrayList);
        System.out.println(arrayList.toArray());//可以返回一个数组 数组的查询更高效 Object[]
    }
}
