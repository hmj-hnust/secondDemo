package interLambbdIner;

import java.util.Arrays;
import java.util.Comparator;
//一个类可以实现多个接口
public class Employee implements Comparable<Employee>,Idemo {//这个是定义自身方法比较 调用Arrays.sort的数组元素
//    必须实现这个 基本类型 包装类 字符串默认实现
    @Override
    public int compareTo(Employee o) {
//        比较规则 自身和传入的比较小于返回负数
        return 0;
    }
}
class Employ implements Comparator<Employ>{//这个是实现工具类 让其他的可以调用工具类方法传入两个进行比较
//
    @Override
    public int compare(Employ o1, Employ o2) {
//        传入的两个比较
        Integer.compare(1,2);//包装类自己定义的compare没有实现Comparator 而是实现Comparable

        return 0;
    }

    public static void main(String args[]) {
        Arrays.sort(new Employee[1]);//实现了Comparable才能调用sort
        Idemo idemo=new Employee();//接口也可以相当于父类一样 引用实现接口的类
        System.out.println(idemo instanceof Idemo);//实现的类也可以instanceof到接口
    }
}
