package learn.spring.ioc.overview.dependency.lookup;

import learn.spring.ioc.overview.annotation.Super;
import learn.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class DependencyLookupDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");


        lookupByName(beanFactory);

        lookupByNameLazy(beanFactory);

        lookupListByType(beanFactory);

        lookupByType(beanFactory);

          //报错：找不到BeanFactory类型的Bean
//        lookupByTypeOfBeanFactory(beanFactory);

         //报错：找不到ApplicationContext类型的Bean
//        lookupByTypeOfApplicationContext(beanFactory);

        lookupByAnnotation(beanFactory);

    }

    public static void lookupByTypeOfApplicationContext(BeanFactory beanFactory) {
        ApplicationContext applicationContext = beanFactory.getBean(ApplicationContext.class);
        System.out.println("通过类型查找ApplicatonContext:"+applicationContext);

    }

    public static void lookupByTypeOfBeanFactory(BeanFactory beanFactory) {
        BeanFactory targetBeanFactory = beanFactory.getBean(BeanFactory.class);
        System.out.println("通过类型查找BeanFactory："+targetBeanFactory);
    }

    public static void lookupByAnnotation(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String,User> userMap = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
        System.out.println("通过注解查找Bean:"+userMap);
    }

    public static void lookupListByType(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String,User> userMap = listableBeanFactory.getBeansOfType(User.class);
        System.out.println("通过类型查找多个Bean:"+userMap);
    }

    public static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("通过类型查找Primary Bean："+user);
    }

    public static void lookupByNameLazy(BeanFactory beanFactory) {
        ObjectFactory<User> userObjectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user1 = userObjectFactory.getObject();
        System.out.println("通过名称懒加载查找Bean"+user1.toString());
        User user2 = userObjectFactory.getObject();
        System.out.println("通过名称懒加载查找的Bean是不是同一个："+ String.valueOf(user1==user2));
    }

    public static void lookupByName(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("通过名称查找Bean:"+user.toString());
    }
}
