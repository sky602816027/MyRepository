package itheima_05;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    练习：
        Student s = new Student();
        s.method1();
        s.method2("林青霞");
        String ss = s.method3("林青霞"，30);
        System.out.println(ss)
        s.function();
 */
public class ReflectDemo02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("itheima_02.Student");

        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();

        Method m = c.getMethod("method1");
        m.invoke(obj);

        Method m2 = c.getMethod("method2", String.class);
        m2.invoke(obj,"林青霞");

        Method m3 = c.getMethod("method3", String.class, int.class);
        Object s = m3.invoke(obj, "林青霞", 30);
        String ss = (String)s;
        System.out.println(ss);

        //Method m4 = c.getMethod("function"); NoSuchMethodException 看到这个就要想到这个方法可能不是公共的
        //我们getMethod只能找到公共的

        Method m4 = c.getDeclaredMethod("function");//又因为这个方法是私有的，不能直接访问
        m4.setAccessible(true);//所以要暴力访问
        m4.invoke(obj);

        //所以不知道是不是私有的，就直接用getDeclaredMethod，如果要用invoke，前面默认加个setAccessible（true）就行了
    }
}
