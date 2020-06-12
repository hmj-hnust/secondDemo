package diffpack;
import ClassTransfer.text2;
import ClassTransfer.*;
public final  class demo extends text{//加了final代表这个类阻止被其他类继承 而且所有方法都会加上final
    public demo() {
        super();//调用父类构造器
        super.toString();//调用父类方法
//        在子类中要调用父类就用super
    }

    public final void p(){//这个加final 就是不允许被子类覆盖
        System.out.println(num);//就算是不同包 继承了父类还是可以访问protected
        System.out.println(name);
    }

    public  void abs(){}//继承抽象类就必须实现抽象方法或者继续抽象这个方法 将这个类也定义成抽象类

    public static void main(String args[]) {
        demo demo=new demo();
       text text=new demo();//父类可以引用子类 而且调用父类的方法实际上调用的是子类的 这就是多态 调用方法看实际引用
//        但编译时要确保父类有这个方法
        demo.p();
        text text1=new text() {//抽象类的new 要覆盖抽象方法 可以这样new一个匿名类
            @Override
            public void abs() {

            }
        };
    }

    @Override
    public boolean equals(Object obj) {
        super.equals(obj);//重写equals时不要忘记 调用父类的equals 父类equals传入子类也可以判断 因为子类有
//        父类的属性
        return super.equals(obj);
    }
    public void asd(int a,int[] num,String ...aa ){
//        可变参数必须最后一个 而数组可以 随便哪一个 但数组传入必须数组形式 而可变参数可以一个个传
    }
}
