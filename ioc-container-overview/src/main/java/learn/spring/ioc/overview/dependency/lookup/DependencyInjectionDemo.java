package learn.spring.ioc.overview.dependency.lookup;

import learn.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjectionDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        
        injectByType(beanFactory);

        injectBeanFactory(beanFactory);

        injectApplicationObjectFactory(beanFactory);
    }


    private static void injectApplicationObjectFactory(BeanFactory beanFactory) {
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
        System.out.println("注入的ObjectFactory的ApplicationConext与容器是否一致："+String.valueOf(userRepository.getApplicationContextObjectFactory().getObject() == beanFactory));
        System.out.println("注入的ObjectFactory的BeanFactory与容器是否一致："+String.valueOf(userRepository.getBeanFactoryObjectFactory().getObject() == beanFactory));
        System.out.println("注入的ObjectFactory的BeanFactory与注入的BeanFactory是否一致："+String.valueOf(userRepository.getBeanFactoryObjectFactory().getObject() ==  userRepository.getBeanFactory()));


    }

    private static void injectBeanFactory(BeanFactory beanFactory) {
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
        System.out.println("注入的BeanFactory和容器BeanFactory是否一致:"+String.valueOf(userRepository.getBeanFactory() == beanFactory));
    }

    private static void injectByType(BeanFactory beanFactory) {
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
        System.out.println(userRepository);
    }


}
