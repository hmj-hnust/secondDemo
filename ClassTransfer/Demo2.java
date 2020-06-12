package ClassTransfer;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Demo2 {
    enum Size{S,M,N}
    public static void main(String args[]) throws Exception {
        System.out.println(110>>3);
        System.out.println(text.class instanceof Object);
//        instanceof 判断一个类是另一个类的本身 或者子类
        System.out.println(String.join("|","a","b","c"));
//        用第一个字符 将后面的字符数组拼接
        System.out.println("hmj".substring(0,2));//截取字符串
        System.out.println("hmj".equals("HMJ"));//判断是否相等
        System.out.println("hmj".equalsIgnoreCase("HMJ"));//忽略大小写判断
        System.out.println("hm峻".codePointCount(0,3));//返回码点数量 有些字符有两个代码单元 中文不是
//        所以码点数量才是真正字符数量 .length是获得代码单元
        System.out.println("h$j".offsetByCodePoints(0,3));//返回对应码点的下标
//        两个代码单元的码点会占用两个下标
        System.out.println("hmj".codePointAt(2));
        System.out.println(Character.isSupplementaryCodePoint(0x1d546));//查看对应的码点是不是一个代码单元可以表示
//        如果要两个代码单元表示一个码点的话 那么码点的长度就是2
//        码点就是数字 代表字符 而两个代码单元的码点 对应的也是两个char 代码单元对应char
        System.out.println(Character.isSurrogate('1'));//判断字符是不是两个代码单元 前面是判断码点、
        System.out.println("hmj".codePoints().toArray());//获得所有码点的数组 codePoints返回码点的流
        StringBuilder builder=new StringBuilder();
//        普通的String 每次拼接字符串 都会创建一个新的字符串 而StringBuilder就不会 而是追加完后通过toString
//        才得到一个新的字符串 而StringBuffer 也是一样但效率低 但是能支持多线程追加删除字符
        builder.append("3213");
        builder.append("333");
        builder.setCharAt(1,'h');//一般操作的都是字符 也就是代码单元 操作码点少
        // 只是有的unicode字符是两个代码
//        单元 两个char 有一个辅助字符
        builder.insert(0,"hmj");
        builder.delete(3,4);
        System.out.println(builder);
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();//空格就能结尾 nextLine换行结尾
         System.out.println(scanner.hasNext());//判断输入流中还有没有
        System.out.println(name);
//        Console cons= System.console(); 可以与控制台交互 才返回对象 不然返回null
//        char[] username=cons.readPassword("user");这样输入可以****遮密码
//        System.out.println(new String(username));
        Scanner in= new Scanner(new File(Paths.get("src/ClassTransfer/text.text").toUri()),"UTF-8");
        System.out.println(in.nextLine());//从文件读取内容 不过一般用Input输入流 但是这个实现也是InputStream
//        以后看怎么用吧
        PrintWriter out=new PrintWriter(Paths.get("src/ClassTransfer/text2.text").toFile(),"UTF-8");
//        用的OutputStream 流输出
        out.println("wrwr");//全部删除再输入 append就是追加
        out.flush();//一定要flush
        String str="213";
        switch(str){//switch可以判断数字基本类型和字符char和枚举类型还有字符串
            case "213":
                System.out.println("1");
                break;
        }
        Size s=Size.S;
        switch (s){
            case S://case中判断枚举时可以不用加Size这个枚举类名 直接S
                System.out.println("s");
        }
        cycs:
        while(1==1){
            System.out.println(1);
//            continue;跳过当前循环
            break cycs;//跳出整个循环 名字:指定循环 break指定名字 跳出指定循环
             //大多数时候continue和break都可以用逻辑代替
        }
        BigInteger a=BigInteger.valueOf(123);
        BigInteger b=new BigInteger("1234");
        System.out.println(a.add(b));
//        BigInteger大数 能进行更大长度的计算
        BigDecimal c=BigDecimal.valueOf(2);
//        BigDecimal 能进行精确的浮点运算 比double精确 double的计算是不精确的 不要用double计算
// 浮点的计算都用BigDecimal
        BigDecimal d=new BigDecimal("1.1");
        System.out.println(c.subtract(d));
//        multiply乘 divide除 mod余数 都是和对应的Big操作而不是基本类型 还有compareTo操作
        System.out.println(2-1.1);
        int n=2;
        int[] nums=new int[n];//数组长度可以变量 但创建好了之后长度并不能更改 除非用list map set等容器
        System.out.println(nums.length);
        int[] nums2={1,23,3};
        nums2=new int[]{6,3,4,5};//也可以这样定义
        System.out.println(Arrays.toString(nums2));//Arrays操作类 对数组操作
//        创建一个数组没有赋值那么数字就是0 boolean就是false
        for(int temp:nums2){//这样遍历 可以数组和容器
            System.out.println(temp);
        }
        int[] nums3=Arrays.copyOf(nums2,20);//这样Arrays工具类拷贝 才是新数组 直接=是指向同一个数组
//        第二个参数可以给新长度
        System.out.println(Arrays.toString(nums3));
        Arrays.sort(nums2);//给数组排序 影响本身 不返回
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.binarySearch(nums2,7));//二分法查找值 找到了返回下标没找到 返回负数值r
//         -r-1就是这个值应该插入的位置来保证有序
        System.out.println(nums2.equals(nums3));//长度相等对应元素相等才true
        int[][][] numss=new int[2][][];//定义多维数组时 可以不定义长度 也可以定义统一长度 但最高维必须有长度
        numss[0]=new int[2][];//定义没有长度的三维时 先要创建二维的数组 反正没有长度的 要依次下来创建 不能没有
//        二维长度就创建一维了
        numss[0][0]=new int[3];//单独定义长度
        numss[0][1]=new int[2];
    }
}
