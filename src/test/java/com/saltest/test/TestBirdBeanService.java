package com.saltest.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.salttest.dao.BirdDAO;
import com.salttest.model.BirdBean;
import com.salttest.model.Properties;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cxf-spring.xml")
public class TestBirdBeanService {

    @Autowired
    BirdDAO birdDAO;

    // @Before
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("cxf-spring.xml");
        this.birdDAO = (BirdDAO) context.getBean("birdDAO");
    }

//    @Test
    public void saveBirdBean() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
        Properties prop = new Properties();
        prop.setName("Crow");
        prop.setVisible(true);
        prop.setFamily("UK");
        prop.setContinents(new String[] { "EUROPE", "CANADA" });
        Date date = new Date();
        prop.setAdded(simpleDateFormat.format(date));
        birdDAO.getMongoTemplate().save(prop);
        BirdBean bird = new BirdBean();
        // bird.set$schema("http://json-schema.org/draft-04/schema#");
        bird.setTitle("POST /birds [request]");
        bird.setDescription("Add a new bird to the library");
        bird.setProperties(prop);
        birdDAO.getMongoTemplate().save(bird);
    }

     @Test
    public void getAllBirdBeans() {
        System.out.println(birdDAO.getMongoTemplate().getCollectionNames());
        System.out.println(birdDAO.getMongoTemplate().findAll(BirdBean.class));
    }

}
