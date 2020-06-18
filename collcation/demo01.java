package collcation;

import ClassTransfer.Demo2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class demo01 {
    enum size{S,M,L}
    public static void main(String args[]) throws IOException {
        HashMap<String,String> hashMap=new HashMap<>();
        TreeMap treeMap=new TreeMap();//TreeMap是有序的添加 对键进行排序 所以必须实现Comparable或者传入Comparator
        treeMap.put("1","1");
        treeMap.put("0","1");
        treeMap.forEach((k,v)-> System.out.println(k));
        hashMap.get("Weq");
        hashMap.put("weiewi","hmj");
        hashMap.putAll(treeMap);//还可以传入其他map
        System.out.println(hashMap.getOrDefault("eq","@1"));
//        返回键对应的值 如果没有值 返回第二个参数的默认值 而不会返回null
        hashMap.forEach((k,v)-> System.out.println(k+""+v));
//        forEach对里面的键值进行操作 传入的lambda表达式 两个参数 然后操作
        Set set=hashMap.entrySet();//返回键的set
        Collection collection=hashMap.values();//返回值的集合
        Set<Map.Entry<String,String>> set1=hashMap.entrySet();//返回entry的set entry类型是一个包括
//        键值的类型 entry是map的内部静态类 必须调用Map获得
        for(Map.Entry<String,String> a:set1){
            System.out.println(a);//可以遍历set 获得每一个entry map不能被for遍历 map没有实现iterable
        }
        WeakHashMap weakHashMap=new WeakHashMap();//弱引用map 保证键在只有weakHashMap引用时进行垃圾回收
//        并将值删除
        EnumSet enumSet=EnumSet.allOf(size.class);//枚举中全部值
        enumSet=EnumSet.noneOf(size.class);//初始为空的枚举set
        enumSet=EnumSet.range(size.S,size.L);//指定枚举范围值
        enumSet=EnumSet.of(size.S);//对应的枚举值
//        定义枚举set
        ArrayList arrayList=new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        Collection arrayList1=arrayList.subList(0,1);//返回一个子范围的list
        arrayList1.clear();//将这个Collection清除 同时会影响父范围
//        而set和map都是无序的没有子范围 但有序的SortedSet和Map可以
        Collections.unmodifiableList(arrayList);
        Collections.unmodifiableMap(hashMap);
        Collections.unmodifiableSet(set);//可以通过Collections工具类的方法获得不可修改的视图 还有其他的集合
//        链表访问可以通过迭代器 一步步访问 遍历所有
        LinkedList linkedList=new LinkedList();
        linkedList.add(1);
        linkedList.get(0);//列表的随机访问效率低 迭代器操作可以
        Collections.sort(arrayList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });//还可以通过这个工具类排序 第二个参数可以传入比较器 不然元素就要实现比较器
        Collections.shuffle(arrayList,new Random(231));//这个是将list随机打乱 第二个可以传入种子
//        也可以不传
        arrayList.sort((a,b)->2);//内部也有sort 可以传比较器
        Collections.binarySearch(arrayList,2);//二分法查找对应元素 但要实现比较器 也可以传入比较器
        Collections.replaceAll(arrayList,"2","!");//将所有老的替换成新的
        Collections.reverse(arrayList);//翻转
//        反正Collections一堆集合操作 还可以判断两个集合共同元素等
        Object[] objects=arrayList.toArray();//可以转换成数组 但只能Object[] 且不能强转成其他数组
        ArrayList<String> arrayList2=new ArrayList<>();
        String[] strings=arrayList2.toArray(new String[2]);//而toArray传入new 数组类型就可以转换成对应数组
//        而且指定大小可以保证创建数组时 不会创建多次数组 来扩展大小
        System.out.println(System.getProperties());//获得系统的properties配置
        System.getProperty("2");//对应系统单个properties配置
        Properties properties=new Properties();
        properties.load(new InputStreamReader( new FileInputStream("/d")));
//        properties还可以加载 properties文件的流 来获得
        properties.setProperty("@31","@31");
        System.out.println(properties.getProperty("@31"));
        Stack<String> stack=new Stack();//创建一个栈
        stack.push("@");//推入元素到顶部
        stack.peek();//获取顶部的元素
        stack.pop();//删除顶部元素并获取
    }
}
