package learn.spring.ioc.overview.repository;

import learn.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

public class UserRepository {

    Collection<User> users;

    BeanFactory beanFactory;

    ObjectFactory<BeanFactory> beanFactoryObjectFactory;

    ObjectFactory<ApplicationContext> applicationContextObjectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<BeanFactory> getBeanFactoryObjectFactory() {
        return beanFactoryObjectFactory;
    }

    public void setBeanFactoryObjectFactory(ObjectFactory<BeanFactory> beanFactoryObjectFactory) {
        this.beanFactoryObjectFactory = beanFactoryObjectFactory;
    }

    public ObjectFactory<ApplicationContext> getApplicationContextObjectFactory() {
        return applicationContextObjectFactory;
    }

    public void setApplicationContextObjectFactory(ObjectFactory<ApplicationContext> applicationContextObjectFactory) {
        this.applicationContextObjectFactory = applicationContextObjectFactory;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                "\n, beanFactory=" + beanFactory +
                "\n, beanFactoryObjectFactory=" + beanFactoryObjectFactory.getObject() +
                "\n, applicationContextObjectFactory=" + applicationContextObjectFactory.getObject() +
                '}';
    }

}
