package learn.spring.ioc.overview.container;

import learn.spring.ioc.overview.dependency.lookup.DependencyLookupDemo;
import learn.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class AnnotationDrivenIoCContainerDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AnnotationDrivenIoCContainerDemo.class);

        annotationConfigApplicationContext.refresh();
        DependencyLookupDemo.lookupListByType(annotationConfigApplicationContext);
    }

    @Bean
    User user(){
        User user = new User();
        user.setId(1L);
        user.setName("Yam");
        return user;
    }
}
