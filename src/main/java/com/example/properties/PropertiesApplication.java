package com.example.properties;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import java.util.List;

public class PropertiesApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("context.xml");
    }
}


class ListingInitializingBean implements InitializingBean {

    public List<ValueHoldingObject> getAll() {
        return all;
    }

    public void setAll(List<ValueHoldingObject> all) {
        this.all = all;
    }

    private List<ValueHoldingObject> all;

    @Override
    public void afterPropertiesSet() throws Exception {
        for (ValueHoldingObject valueHoldingObject : all)
            System.out.println(valueHoldingObject.toString());

    }
}

@Configuration
@Profile("a")
@PropertySource("classpath:/a.properties")
class AConfig {

    @PostConstruct
    public void hi() {
        System.out.println("A!");
    }
}

@Configuration
@Profile("b")
@PropertySource("classpath:/b.properties")
class BConfig {

    @PostConstruct
    public void hi() {
        System.out.println("B!");
    }
}
