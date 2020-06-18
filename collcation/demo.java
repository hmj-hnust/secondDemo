package collcation;

import java.util.*;

public class demo {
    public static void main(String args[]) {
//        如如果收集的没有上限用链表 不然ArrayList 更加高效
      ArrayList arrayList=new ArrayList();
        arrayList.add(1);
        arrayList.iterator().forEachRemaining(event-> System.out.println(event));
        Iterator iterator=arrayList.iterator();//看实现的源代码
        arrayList.contains("@31");//判断有无这个元素
        iterator.next();
        iterator.remove();//remove删除上一次调用next获得的元素 要remove必须先next
      for(Object a:arrayList){
//          foreach可以循环实现了iterable的类
      }
      arrayList.add("231");//在迭代器当前位置添加元素
       arrayList.listIterator().add("21");//也是在迭代器当前位置添加 不过是获得listIterator接口调用方法
      arrayList.add(0,2);//list接口中定义的方法
        LinkedList linkedList=new LinkedList();//很多个元素没有上限 要频繁指定位置添加删除时用这个
        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.add(1);
        linkedList.add(0,1);//几个方法添加
        linkedList.get(2);
        linkedList.set(0,1);//get set方法随机访问每个元素不适合链表 随机访问链表元素效率低  但头尾没事 插入效率高
        HashSet hashSet=new HashSet();//hashSet的元素必须实现hashCode 而且要满足equals为truehashCode相等
//        set不能有重复的
        TreeSet treeSet=new TreeSet();//会对插入的元素进行排序 这个的元素必须实现Comparable或者传入
//        Comparator
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(3);
        System.out.println(treeSet);
        PriorityQueue priorityQueue=new PriorityQueue();//优先队列 每次都保证最小的在第一个 后续不保证顺序
//        删除就删除第一个 再把最小放第一个 元素也必须实现Comparable或者传入一个Comparator
        priorityQueue.add("431");
        priorityQueue.add("123");
        priorityQueue.add("223");
        priorityQueue.remove();
        System.out.println(priorityQueue);

    }
}
