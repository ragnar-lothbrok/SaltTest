package com.salttest.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.cxf.spring.model.Bird;
import com.cxf.spring.services.BirdService;
import com.salttest.dao.BirdDAO;
import com.salttest.utility.PageSupportor;

public class BirdServiceImpl implements BirdService {

    static Logger log = Logger.getLogger(BirdServiceImpl.class.getName());

    @Autowired
    BirdDAO birdDAO;

    /**
     * Method will return Bird for a Given Bird Id
     * 
     * @param birdId
     * @return Bird
     */
    @Override
    public PageSupportor<Bird> getBirdsById(String birdId) {
        return birdDAO.getBirdById(birdId);
    }

    /**
     * Method will return all Birds present in database
     * 
     * @return List<Bird>
     */
    @Override
    public PageSupportor<Bird> getAllBirds() {
        return birdDAO.getBirds();
    }

    /**
     * Method will save Bird and return Bird with Id.
     * 
     * @param bird
     * @return Bird
     */
    @Override
    public PageSupportor<Bird> saveBird(Bird bird) {
        return birdDAO.saveBird(bird);
    }

    /**
     * Method will delete the bird if it is present in database.
     * 
     * @param birdId
     * @return
     */
    @Override
    public Map<String, Boolean> deleteBirdsById(String birdId) {
        Map<String, Boolean> resultMap = new HashMap<String, Boolean>();
        if (birdDAO.deleteBird(birdId) == 1) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

}
