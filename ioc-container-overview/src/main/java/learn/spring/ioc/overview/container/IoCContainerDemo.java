package learn.spring.ioc.overview.container;

import learn.spring.ioc.overview.annotation.Super;
import learn.spring.ioc.overview.dependency.lookup.DependencyLookupDemo;
import learn.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class IoCContainerDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //加载配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "META-INF/dependency-injection-context.xml";
        int beanDefinitionCount = reader.loadBeanDefinitions(location);
        System.out.println(beanDefinitionCount);

        DependencyLookupDemo.lookupByAnnotation(beanFactory);

    }


}
