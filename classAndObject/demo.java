package classAndObject;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class demo {
    private final String name;//类中的final常量属性必须在构造时就赋值 对象创建后就不能更改了 而对象不能指向其他对象
//    隐式参数就是在 方法参数中没有 而过程中用到的对象参数
//    静态工厂就是静态工厂类的静态方法创建对象 返回
    public demo(String name) {
        this.name = name;
    }

    public static void main(String args[]) {
        System.out.println(new Date());
        System.out.println(LocalDate.now());//一种新的日期类 操作比Date更简单
        LocalDate localDate=LocalDate.of(1999,12,31);//参数对应的年 月 日
        int year=localDate.getYear();
        int month=localDate.getMonthValue();
        int day=localDate.getDayOfMonth();
        DayOfWeek week=localDate.getDayOfWeek();//获得星期几

        System.out.println(year+month+day);
        System.out.println(week);
        LocalDate localDate1=localDate.plusDays(1000);//获得新的而不是更改自己
        System.out.println(localDate1);//增加天数
//        localDate相当于工具类 操作更简单
        localDate.minusDays(1000);
        System.out.println(localDate);
//        新增的var 万能类型只能用于方法中的局部变量
        String str=null;
        Objects.requireNonNull(str,"aou");//传入一个对象判断是否为空 为空就抛出异常 message可以自己传入
//         Objects工具类 对对象进行非空判断  不是Object 是Objects

    }
}
