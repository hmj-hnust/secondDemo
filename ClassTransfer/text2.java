package ClassTransfer;

public class text2  extends text {
    public void p(){
        System.out.println(name);
        System.out.println(num);
    }

    @Override
    public void abs() {

    }

    public static void main(String args[]) {
        text2 text2=new text2();
        text2.p();
        System.out.println(text2.name);
//        System.out.println(text2.age);
        System.out.println(text2.num);
    }
}
