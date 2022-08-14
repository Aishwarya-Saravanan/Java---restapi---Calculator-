/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author Aishu
 */
import me.leqada.rest.model.ActInfo;
import org.apache.log4j.Logger;

public class Logic {
    private final static Logger logger = Logger.getLogger(Logic.class);

    /**
     * Get double values from Strings. First element of paramsText is always arithmetic operation type
     * */
    public double[] parseToNum(String[] paramsText) {
        logger.info("Trying to parse parameters ...");
        double[] params = new double[3];

        for (int i = 0; i < 3; i++) {
            try {
                params[i] = Double.parseDouble(paramsText[i + 1]);
                logger.info("params[" + i + "] = " + params[i]);
            } catch (NumberFormatException ignored) {
                logger.warn("Number format exception. Returning null");
                return null;
            }
        }
        logger.info("Parameters are parsed successfully");

        return params;
    }

    /**
     * Calling arithmetic operation method depending on the action
     * */
    public ActInfo act(String action, double[] params) {
        ActInfo resultInfo = new ActInfo();
        logger.info(action + " of params: " + params[0] + ", " + params[1] + ", " + params[2]);
        switch (action) {
            // I removed other operation cases for compactness
            case "multiplication": {
                resultInfo.setResult(mult(params));
                if (Double.isInfinite(resultInfo.getResult())) {
                    logger.warn("Result number is too big. Returning 402 error");
                    resultInfo.setError(402, "Too big number");
                    resultInfo.setResult(0);
                }
                break;
            }
        }

        return resultInfo;
    }

    private double mult(double[] arr) {
        return arr[0] * arr[1] * arr[2];
    }
}