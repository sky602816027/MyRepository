package itheima_05;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        //获取Class对象
        Class<?> c = Class.forName("itheima_02.Student");

        //Method[] getMethods() 返回一个包含 方法对象的数组， 方法对象反映由该 Class对象表示的类或接口的所有公共方法，包括由类或接口声明的对象以及从超类和超级接口继承的类
        //Method[] getDeclaredMethods() 返回一个包含 方法对象的数组， 方法对象反映由 Class对象表示的类或接口的所有声明方法，包括public，protected，default（package）访问和私有方法，但不包括继承方法
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("----------------------------------");
        Method[] methods2 = c.getDeclaredMethods(); //getDeclaredMethods()只有本类，不包含继承的
        for (Method method : methods2) {
            System.out.println(method);
        }

        //Method getMethod(String name, Class<?>... parameterTypes) 返回一个 方法对象，该对象反映由该 Class对象表示的类或接口的指定公共成员方法
        //Method getDeclaredMethod(String name, Class<?>... parameterTypes) 返回一个 方法对象，它反映此表示的类或接口的指定声明的方法 Class对象
        Method m = c.getMethod("method1");//没有参数，就不用加,

        //获取无参构造
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();
//        obj.m(); 不能用对象.对象
        //在类或接口上提供有关单一方法的信息和访问权限
        //Object invoke(Object obj, Object... args) 在具有指定参数的指定对象上调用此 方法对象表示的基础方法
        //上面这个方法在Method类中
        m.invoke(obj);//因为没参，就不用,传参了
    }
}
