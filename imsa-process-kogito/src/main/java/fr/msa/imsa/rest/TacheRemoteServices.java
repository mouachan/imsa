
package fr.msa.imsa.rest;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;



import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/event")
@RegisterRestClient
public interface TacheRemoteServices {

    @GET
    @Path("/t1/{numsecu}/init")
    @Produces("application/json")
    public String initt1(String id, @PathParam("numsecu") String  numsecu);

       
    @GET
    @Path("/t2/{numsecu}/init")
    @Produces("application/json")
    public String initt2(String id, @PathParam("numsecu") String  numsecu);

       
    @GET
    @Path("/t3/{numsecu}/init")
    @Produces("application/json")
    public String initt3(String id, @PathParam("numsecu") String  numsecu);
}
