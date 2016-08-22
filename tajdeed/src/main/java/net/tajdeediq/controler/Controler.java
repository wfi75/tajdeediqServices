
package net.tajdeediq.controler;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import net.tajdeediq.helper.DBHandler;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class Controler {

    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET
    @Produces("text/plain")
    @Path("/test")
    public String getIt() {
        return "Hi there!";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addme")
    public JSONObject addNewUser(JSONObject jsonReqData) {
        try {
            String username = (String) jsonReqData.get("username");
            String password = (String) jsonReqData.get("password");
            String email = (String) jsonReqData.get("email");
            DBHandler.addUesr(username, password, email);
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
