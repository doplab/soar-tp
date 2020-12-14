package ch.unil.doplab.wishlist;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Path("wishlist")
@RequestScoped
public class WishList {

    @Context
    private UriInfo context;

    private String wishList = "teddy bear\n" + "coloring book\n";

    public WishList() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        System.out.println("We're in getHtml() method");
        return "<html lang=\"en\"><body><h1>" + wishList + "</body></h1></html>";
    }
    
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
        System.out.println("We're in putHtml(...) method");
        wishList += content + "\n";
        System.out.println("Here's my new wishlist\n" + wishList);
    }
}
