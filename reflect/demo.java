package reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.net.URL;
import java.util.Arrays;

public class demo {
    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {
        Person person=new Person();
        System.out.println(person.getClass()==Person.class);//两种方式获得Class
        System.out.println(person.getClass().getName());//返回类名 包含包名
        Class cl=Class.forName("reflect.Person");//通过字符串 动态的方式创建Class 传入包名加类名
        System.out.println(cl.getName());
        System.out.println(int.class.getName());//基本类型也有class虽然不是对象
//        同一个类的Class是唯一的 一个类只有一个Class 子类和父类的class不相等 但instanceof可以
       Constructor<Person> constructor= cl.getConstructor();//获得构造函数的反射 通过传入构造参数获得不同
//        构造函数
       Person person1=constructor.newInstance();//调用构造函数进行实例化 如果构造函数是有参数的那么可以在这里传入
//        参数。
       person1.p(11);
        URL url=cl.getResource("1.txt");//通过class的getResource获得URL 相对路径 位置是这个类所在位置
        InputStream inputStream=cl.getResourceAsStream("1.txt");//获得流 没找到返回null 上面一样
        System.out.println(url.getPath());
        byte[] bytes=new byte[12];
        int len=inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        System.out.println(Student.class.getSuperclass().getName());
//        通过getSuperclass获得父类Class
        Field[] fields=cl.getDeclaredFields();//返回这个类全部字段 不包括 超类部分
        fields=cl.getFields();//返回公共部分字段 包括超类的
        for(Field field:fields) {
            field.setAccessible(true);
            System.out.println(field.getType());//返回字段类型
            System.out.println(field.getModifiers());//返回字段、方法、构造器修饰符代表的int
            System.out.println(Modifier.toString(field.getModifiers()));//将修饰符代表的int转换成字符
            System.out.println(field.getDeclaringClass());//返回定义这个字段、方法、构造器的类Class
//            如果是父类继承的Class就是父类
            Modifier.isPublic(field.getModifiers());//Modifier不仅可以返回修饰符字符串 还可以判断
        }
        Method[] methods=cl.getMethods();//返回超类和自身公共方法
        methods=cl.getDeclaredMethods();//返回全部方法不包括由超类继承的 继承的就是超类部分的
        for(Method m:methods){
            System.out.println(m.getExceptionTypes());//返回方法或者构造器抛出的异常Class只有 方法 构造器有
//            字段没有
            System.out.println(m.getParameterTypes());//返回方法或者构造器的参数Class 字段没有 字段getType
            System.out.println(m.getReturnType());//返回类型Class 只有方法有
        }
        Constructor[] constructors=cl.getConstructors();//返回公共构造器
        constructors=cl.getDeclaredConstructors();//返回所有构造器 构造器只有自身没有超类的
        Field field=cl.getDeclaredField("pr");//获取指定字段 没有s
        System.out.println(field.getName());
        field.setAccessible(true);//private 要修改要设置为true
        AccessibleObject.setAccessible(fields,true);//还可以一下修改全部的安全性 传入字段、方法、构造函数
//        数组 这个是AccessibleObject静态方法
        System.out.println(field.isAccessible());//查看安全性值
        field.set(person,2);//修改指定字段 传入对象和修改后的值 如果是private要设置安全性
        System.out.println(field.get(person));//获得private字段也要修改安全性 传入要查看的对象
       Person[] pes= (Person[]) Array.newInstance(Person.class,12);
//       通过反射类Array的newInstance 传入元素class和长度得到一个数组 返回Object 可以强转
        System.out.println(pes.getClass().getComponentType());//数组也是对象 通过数组类的getComponentType
//        获得数组的数组元素Class
        System.out.println(Arrays.toString(pes));
        Person[] people=Arrays.copyOf(pes,13);//也可以深拷贝
        Array.get(people,0);//返回对应索引上的值 传入数组对象和索引 还可以get基本类型
        Array.set(people,0,new Person());//对应索引设置值 这些都是反射动态的操作
//        也可以setxxx基本类型
        Array.getLength(people);//返回长度
        System.out.println(Arrays.toString(people));
       Method method= cl.getMethod("p", int.class);//得到指定公共方法或者继承的
        cl.getDeclaredMethod("p", int.class);//得到公共私有的指定不包括继承
//        而且要传入方法参数不必然有重写无法判断
        method.invoke(person1,1);//通过invoke 调用方法传入对象然后第二个参数传入方法的参数值
        method.invoke(null,1);//如果是静态方法对象可以传入null 当然也可以传入对象 因为静态方法嘛
//        字段也一样
        Constructor constructor1=cl.getConstructor(int.class);//获得公共指定构造函数 传入构造参数类型
        cl.getDeclaredConstructor(int.class);//获得公共私有指定构造函数
        constructor1.newInstance(1);//newInstance 创建实例 传入构造参数

    }
}
