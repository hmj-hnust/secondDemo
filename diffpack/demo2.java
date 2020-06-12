package diffpack;

public class demo2 {
    public static void main(String args[]) {
            demo demo=new demo();//而且不同包继承了 那么这个包的其他类 访问这个子类就相当于在同一个包 就可以访问这个
//        子类的protected 这个子类继承了自己的也就是protected
            demo.p();
    }
}
