package com.sparrow.spring.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 诉衷情の麻雀
 * @Description: TODO
 * @DateTime: 2024/4/29 9:55
 **/
public class SpaSpringApplicationContext {
    private Class configClass;
    //ioc存放的就是通过反射创建对象(基于注解方式)
    private final ConcurrentHashMap<String, Object> ioc = new ConcurrentHashMap<>();
    public SpaSpringApplicationContext(Class configClass) {
        this.configClass = configClass;
        System.out.println("this.configClass = " + this.configClass);
        //1.获取要扫描的包
        ComponentScan componentScan = (ComponentScan) this.configClass.getDeclaredAnnotation(ComponentScan.class);
        //2.通过componentScan的value=>即要扫描的包
        String path = componentScan.value();
        System.out.println("要扫描的包=" + path);

        //1.得到类的加载器
        ClassLoader classLoader = SpaSpringApplicationContext.class.getClassLoader();
        path = path.replace(".", "/");

        URL resource = classLoader.getResource(path);
        System.out.println("resource=" + resource);

        File file = new File(resource.getFile());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                System.out.println("============");
                String fileAbsolutePath = f.getAbsolutePath();
                //这里我们只处理.class文件
                if (fileAbsolutePath.endsWith(".class")) {
                    String className = fileAbsolutePath.substring(fileAbsolutePath.lastIndexOf("\\") + 1, fileAbsolutePath.indexOf(".class"));
                    System.out.println("className =" + className);
                    //2.获取类的完整路径
                    String classFullName = path.replace("/", ".") + "." + className;
                    System.out.println("className = " + classFullName);
                    //3. 判断该.class该类是不是需要注入到容器中，就看该类是不是有注解
                    try {
                        Class<?> aClass = classLoader.loadClass(classFullName);
                        if (aClass.isAnnotationPresent(Component.class) || aClass.isAnnotationPresent(Controller.class) || aClass.isAnnotationPresent(Service.class) || aClass.isAnnotationPresent(Repository.class)) {
                            Class<?> clazz = Class.forName(classFullName);
                            Object newInstance = clazz.newInstance();
                            ioc.put(StringUtils.uncapitalize(className), newInstance);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                }

            }
        }
    }

    public Object getBean(String name) {
        return ioc.get(name);
    }

    public ConcurrentHashMap<String, Object> getIoc() {
        return ioc;
    }
}
