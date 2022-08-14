/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Aishu
 */
import me.leqada.rest.logic.Cache;
import me.leqada.rest.logic.Logic;
import me.leqada.rest.model.ActInfo;
import me.leqada.rest.model.Output;
import org.apache.log4j.Logger;
import me.leqada.rest.model.Error;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
@Produces("application/json")
public class Calculator {
    private final static Logger logger = Logger.getLogger(Calculator.class);
    private Output output;
    private ActInfo resultInfo = new ActInfo();
    private final Error error = new Error();
    private final Logic logic = new Logic();

    @GET
    @Path("multiply/{a}/{b}/{c}")
    public Response multiplication(
            @PathParam("a") String textA,
            @PathParam("b") String textB,
            @PathParam("c") String textC) {
        logger.info("Requested multiplication: " + textA + " " + textB + " " + textC);
        String[] paramsText = {"multiplication", textA, textB, textC};
        // Trying to get result from cache
        // If there is no result for this parameters
        // then we need to calculate it
        resultInfo = Cache.get(paramsText, logic);
        // If error code = 0 then there is no problem with params
        if (resultInfo.getErrorCode() == 0) {
            logger.info("Returning: " + resultInfo.getResult());
            output = new Output("multiplication", resultInfo.getResult());
            return Response.status(200).entity(output).build();
        }
        else {
            logger.info("Returning Error: " + resultInfo.getErrorCode() + "|" + resultInfo.getErrorText());
            error.setError(resultInfo.getErrorCode(), resultInfo.getErrorText());
            return Response.status(400).entity(error).build();
        }
    }
}