/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Me;

/**
 *
 * @author Aishu
 */
import me.leqada.rest.service.Calculator;
import org.apache.log4j.Logger;
import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class Application extends javax.ws.rs.core.Application {
    private final static Logger logger = Logger.getLogger(Application.class);

    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<>();

        try {
            resources.add(Calculator.class);
        }
        catch(Exception e) {
            logger.error(e.getStackTrace());
        }
        return resources;
    }
}
