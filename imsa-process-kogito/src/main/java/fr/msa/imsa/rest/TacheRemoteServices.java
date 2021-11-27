
package fr.msa.imsa.rest;



import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;



import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/event")
@RegisterRestClient
public interface TacheRemoteServices {

    @POST
    @Path("/t1/{numsecu}/init")
    @Produces("application/json")
    public String initt1(String id, @PathParam("numsecu") String  numsecu);

       
    @POST
    @Path("/t2/{numsecu}/init")
    @Produces("application/json")
    public String initt2(String id, @PathParam("numsecu") String  numsecu);

       
    @POST
    @Path("/t3/{numsecu}/init")
    @Produces("application/json")
    public String initt3(String id, @PathParam("numsecu") String  numsecu);
}
