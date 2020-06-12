package interLambbdIner;

public interface Idemo {
//    接口中所有方法都是public 不用提供修饰符 接口不会有实例字段 所有字段都是public static final 不能更改
    int i=1;//接口中字段默认 public static final 可以不加
    public static void p(){//接口可以实现静态方法 实现的方法必须是静态方法 而没有实现的必须是非静态
//        如果是静态没有实现 那么一个类实现了 那不全都实现了 所以必须非静态
        System.out.println(1);
    }
    public default void a(){//还可以添加默认实现 加default修饰 没有实现时就用默认实现
//        如果实现类的超类实现了同名的这个方法 那么这个默认实现不生效 而是用超类的 如果实现类实现两个接口有同名的方法
//       那么必须实现这个方法 就算一个有默认实现也必须在实现类中重新实现这个方法
//        如果实现类没有重写方法的情况下 同名超类的实现总比接口默认实现优先
        System.out.println(1);
    }
}
