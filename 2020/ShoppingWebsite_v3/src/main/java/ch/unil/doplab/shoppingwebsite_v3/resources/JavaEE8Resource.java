package ch.unil.doplab.shoppingwebsite_v3.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Path("javaee8")
public class JavaEE8Resource {

    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }
}
