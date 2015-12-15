package com.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileWriter;

/**
 * User: andongxu
 * Time: 15-12-15 下午4:26
 */
@Path("/test")
public class TestController {

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Context HttpServletRequest request) {
        try {
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
