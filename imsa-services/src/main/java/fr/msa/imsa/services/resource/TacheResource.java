package src.main.java.fr.msa.imsa.services.resource;

import java.util.UUID;


import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import io.vertx.kafka.client.serialization.JsonObjectSerializer;
import io.vertx.core.json.JsonObject;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.ce.CloudEventMetadata;

import io.smallrye.reactive.messaging.ce.IncomingCloudEventMetadata;
import org.jboss.logging.Logger;

import fr.msa.imsa.model.Dossier;

import org.eclipse.microprofile.reactive.messaging.Message;
import javax.ws.rs.core.Response;

import io.vertx.core.json.JsonObject;

@Path("/api")
public class TacheResource {
    private static final Logger LOGGER = Logger.getLogger(TacheResource.class);

    @Channel("msaReq")
    Emitter<String> msaReqRequestEmitter;

    @Channel("initt1")
    Emitter<String> initt1RequestEmitter;

    @Channel("initt2")
    Emitter<String> initt2RequestEmitter;

    @POST
    @Path("/tache")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createDossier(Dossier dossier) {
        
        
        JsonObject json = new JsonObject()
                                    .put("specversion", CloudEventMetadata.CE_VERSION_1_0)
                                    .put("type", "start")
                                    .put("id", "12345")
                                    .put("source", "/tache")
                                    .put("subject", "generated task")
                                    .put("datacontenttype", "application/json")
                                    .put("time", "2020-07-23T09:12:34Z")
                                    .put("data", dossier);

        msaReqRequestEmitter.send(json.encode());
        LOGGER.infof("Dossier %s produced into the topic start",json.encode());
        return "OK";
    }

   
    @GET
    @Path("/t1/{numsecu}/init")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initt1(@PathParam("numsecu") String  numsecu) {
        LOGGER.infof("num secu recu %s", numsecu);
        return Response.ok(numsecu+"-t1").build();
    }

       
    @GET
    @Path("/t2/{numsecu}/init")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initt2(@PathParam("numsecu") String  numsecu) {
        LOGGER.infof("num secu recu %s", numsecu);
        return Response.ok(numsecu+"-t2").build();
    }

       
    @GET
    @Path("/t3/{numsecu}/init")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initt3(@PathParam("numsecu") String  numsecu) {
        LOGGER.infof("num secu recu %s", numsecu);
        return Response.ok(numsecu+"-t3").build();
    }



    @GET
    @Path("/event/t1/event/{numsecu}/init")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initt1Event(String id, @PathParam("numsecu") String  numsecu) {
        LOGGER.infof("num secu recu %s", numsecu);

              
        JsonObject json = new JsonObject()
        .put("specversion", CloudEventMetadata.CE_VERSION_1_0)
        .put("type", "initt1OK")
        .put("id", id)
        .put("source", "/event/t1/event/{numsecu}/init")
        .put("datacontenttype", "application/json")
        .put("time", "2020-07-23T09:12:34Z")
        .put("data",  numsecu+"-t1")
        .put("kogitoprocrefid", id)
        .put("kogitoprocid","imsa_process")
        .put("kogitoprocinstanceid",id);

        initt1RequestEmitter.send(json.encode());
        return Response.ok(numsecu+"-t1").build();
    }

       
    @GET
    @Path("/event/t2/{numsecu}/init")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initt2Event(String id, @PathParam("numsecu") String  numsecu) {

        JsonObject json = new JsonObject()
        .put("specversion", CloudEventMetadata.CE_VERSION_1_0)
        .put("type", "initt1OK")
        .put("id", id)
        .put("source", "/event/t2/event/{numsecu}/init")
        .put("datacontenttype", "application/json")
        .put("time", "2020-07-23T09:12:34Z")
        .put("data",  numsecu+"-t2")
        .put("kogitoprocrefid", id)
        .put("kogitoprocid","imsa_process")
        .put("kogitoprocinstanceid",id);
        LOGGER.infof("num secu recu %s", numsecu);
        return Response.ok(numsecu+"-t2").build();
    }

       
    @GET
    @Path("/event/t3/{numsecu}/init")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initt3Event(String id, @PathParam("numsecu") String  numsecu) {
        LOGGER.infof("num secu recu %s", numsecu);
        return Response.ok(numsecu+"-t3").build();
    }
}
