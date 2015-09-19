package com.saltest.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.salttest.dao.BirdDAO;
import com.salttest.model.BirdBean;
import com.salttest.model.Properties;

public class TestBirdBeanService {

    BirdDAO birdDAO;

    @Before
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("cxf-spring.xml");
        this.birdDAO = (BirdDAO) context.getBean("birdDAO");
    }

    // @Test
    public void saveBirdBean() {
        BirdBean bird = new BirdBean();
        // bird.set$schema("http://json-schema.org/draft-04/schema#");
        bird.setTitle("POST /birds [request]");
        bird.setDescription("Add a new bird to the library");
        Properties prop = new Properties();
        prop.setName("Parrot");
        prop.setVisible(true);
        prop.setFamily("Indian");
        prop.setContinents(new String[] { "US", "UK" });
        bird.setProperties(prop);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
        prop.setAdded(simpleDateFormat.format(date));
        birdDAO.getMongoTemplate().save(bird);
    }

    @Test
    public void getAllBirdBeans() {
        System.out.println(birdDAO.getMongoTemplate().findAll(BirdBean.class));
    }

}
