package ClassTransfer;
enum Size{S,M,L};//定义枚举类型 用的时候只能是这里面的值 枚举相当于定义一个类 不能局部定义
public class Demo {
    public static void main(String args[]) {
        long numL=0x100l;//十六进制前缀
        int bnum=0b101;//二进制
        int textNum=1_1_1;//允许下划线分割
        double dou=1.1;//默认浮点类型是double
        float   fl=1.1f;//加f才是float
//        可以通过包装类 获得这个类型的最大最小值
        System.out.println(2.0-1.1);//浮点类型的运算不是精确的 要精确的要用BigDecimal
        System.out.println(numL);//输出的是十进制
        char a='1';//字符类型 但一般不用 而是用String
        final String textStr="123";
        final text t=new text("123") {
            @Override
            public void abs() {
            }
        };//定义了final 常量基本类型后就不能更改值 而对象的话就不能指向其他对象 但
//        可以更改属性成员 如果属性不是final
        t.setName("234");
        System.out.println(t.getName());
        System.out.println(textStr);
        System.out.println(a);
        System.out.println(bnum);
        System.out.println(textNum);
        Size s=Size.S;//取枚举类型中的值 类型名依然是枚举类型的名字 枚举就相当于类
        System.out.println(s);
        System.out.println(Math.sqrt(1.1));//平方根 返回double
        System.out.println(Math.pow(1,2));//x的y次方返回double Math包含一系列数学运算函数 和Pi E等数学常量
        int n=123456789;
        float f=1.23456792E8f;//可以用En代表十的n次方 这样int转换成float可以转换成浮点数加上十的n次方 f代表float类型
//        float精度没有double 不能double转换为float
        f=n;
        System.out.println(f);
        System.out.println((int)Math.round(9.9));//四舍五入 返回long ()加类型 强转 但如果强转超出范围就损失值
        Siza sa=Siza.MEDIUM;
        System.out.println(sa.getName());
        System.out.println(Siza.values());//返回这个枚举全部实例的数组
        System.out.println(sa.ordinal());//返回枚举常量的位置
        Siza sa1=Enum.valueOf(Siza.class,"SMALL");//另一种方式赋值枚举常量 通过传入枚举类 然后常量的名字
//        调用Enum的valueOf赋值
        System.out.println(sa1);
    }
}
enum Siza{
    SMALL("S"),MEDIUM("M");//这里相当于实例化好 然后后面调用时就直接调用这个实例 这里就是实例 枚举的就是这些实例
//    不用再自己创建实例 每个实例都调用构造函数
    private String name;

    Siza(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
