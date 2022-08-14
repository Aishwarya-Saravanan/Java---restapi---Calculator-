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
import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;
import org.apache.log4j.Logger;
import java.util.Arrays;

public class Cache {
    private final static Logger logger = Logger.getLogger(Cache.class);

    public static ActInfo get (String[] paramsText, Logic logic) {
        ActInfo resultInfo = new ActInfo();
        String action = paramsText[0];
        double[] params;
        int key =  Arrays.deepHashCode(paramsText);

        logger.info("Trying to get information from cache ...");
        logger.info(action + "|" + paramsText[1] + "|" + paramsText[2] + "|" + paramsText[3]);
        logger.info("Generated key is: " + key);

        try {
            JCS cache = JCS.getInstance("default");
            ActInfo cachedData = (ActInfo)cache.get(key);

            if (cachedData != null) {
                logger.info("Value found in cache. Returning: " + cachedData.getResult());
                // The cachedData is valid and can be used
                return cachedData;
            }
            else{
                logger.info("Value not found in cache. Trying to parse doubles from input ...");
                params = logic.parseToNum(paramsText);

                if (params == null) {
                    logger.warn("Parameter problem. Returning 400 code.");
                    resultInfo.setError(400, "Invalid parameter");

                } else {
                    for (double param : params) {
                        // If passed parameter is not fit to double
                        if (Double.isInfinite(param)){
                            logger.info("Result number is too big. Returning 402 error");
                            resultInfo.setError(402, "Too big number");
                            resultInfo.setResult(0);
                            return resultInfo;
                        }
                    }
                    logger.info("Calling act method to calculate final result ...");
                    resultInfo = logic.act(action, params);
                }
                logger.info("Final result calculated. Adding to cache and returning: " +
                        resultInfo.getResult());

                cache.put(key, resultInfo);
                return resultInfo;

            }
        } catch (CacheException e) {
            logger.error(e.getMessage());
            resultInfo.setError(500, "Server error");
            return resultInfo;
        }
    }
}
