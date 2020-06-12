package ClassTransfer;

import java.util.Objects;

public abstract class text {
    static{//加载类时调用
    }
    {//创建对象时调用

    }
//    设计类时要保证私有或者公有不能不写权限
//    优先使用返回不可变的类 就是调用方法更改返回的是一个新对象 而不是更改本身的
    public String name;
    private String age;//private就算是继承的子类 也不能访问  子类内部不能 创建子类对象也不能 总之只能父类访问
    protected String num;//这个就只能自身和继承的子类访问 子类内部可以 创建的子类对象也可以访问 但只能同一包下
//    不同包不行 但不同包继承的可以 而且这个包其他类可以访问这个继承的protected 在这个类中就像当于同一个包
//    自身也是protected

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public text() {
        this.age="18";
        this.num="22";
    }

    public text(String name) {
            this();//调用自身的无参构造
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract void abs();//有抽象方法的类必须定义成抽象类 加上abstract

    @Override
    public boolean equals(Object obj) {
        text t =(text)obj;
        return ((text) obj).getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getName());//确保equals为true时 hashCode相等
//        Objects确保空指针时为0
    }
}
