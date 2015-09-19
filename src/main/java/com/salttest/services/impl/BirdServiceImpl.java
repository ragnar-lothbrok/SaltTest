package com.salttest.services.impl;

import javax.ws.rs.core.Response;

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
    public Response getBirdsById(String birdId) {
        PageSupportor<Bird> ps = birdDAO.getBirdById(birdId);
        if (ps.getErrors().size() > 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.status(Response.Status.OK).entity(ps).build();
        }
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
    public Response saveBird(Bird bird) {
        PageSupportor<Bird> ps = birdDAO.saveBird(bird);
        if (ps.getErrors().size() > 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.status(Response.Status.CREATED).entity(ps).build();
        }
    }

    /**
     * Method will delete the bird if it is present in database.
     * 
     * @param birdId
     * @return
     */
    @Override
    public Response deleteBirdsById(String birdId) {
        int deleted = birdDAO.deleteBird(birdId);
        if (deleted == -1) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.status(Response.Status.OK).build();
        }
    }

}
