package com.saltest.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxf.spring.model.Bird;
import com.salttest.dao.BirdDAO;
import com.salttest.utility.PageSupportor;

public class TestBirdService {

    BirdDAO birdDAO;

    @Before
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("cxf-spring.xml");
        this.birdDAO = (BirdDAO) context.getBean("birdDAO");
    }

    @Test
    public void saveBird() {
        Bird bird = new Bird(null, "Parrot", 12, "Green");
        PageSupportor<Bird> ps = birdDAO.saveBird(bird);
        Assert.assertEquals(0, ps.getErrors().size());
    }

    @Test
    public void fetchird() {
        PageSupportor<Bird> ps = birdDAO.getBirdById("55fd0624c830365a21845f14");
        Assert.assertEquals(1, ps.getErrors().size());
    }

    @Test
    public void deleteird() {
        int deleted = birdDAO.deleteBird("55fcff05c8301f75d02343a2");
        Assert.assertEquals(1, deleted);
    }

    @Test
    public void getAllBirds() {
        PageSupportor<Bird> ps = birdDAO.getBirds();
        Assert.assertEquals(0, ps.getErrors().size());
    }

}
