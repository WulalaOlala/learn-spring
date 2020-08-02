package learn.spring.ioc.overview.domain;

import learn.spring.ioc.overview.annotation.Super;

@Super
public class SuperUser extends User{

    String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "role='" + role + '\'' +
                "} " + super.toString();
    }
}
