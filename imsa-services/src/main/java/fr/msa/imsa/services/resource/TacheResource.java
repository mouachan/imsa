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

    @Channel("initt1OK")
    Emitter<String> initt1OKRequestEmitter;


    @Channel("initt1KO")
    Emitter<String> initt1KORequestEmitter;

    @Channel("initt2OK")
    Emitter<String> initt2OKRequestEmitter;
    @Channel("initt2KO")
    Emitter<String> initt2KORequestEmitter;

    @POST
    @Path("/tache")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createDossier(Dossier dossier) {
        
        
        JsonObject json = new JsonObject()
                                    .put("specversion", CloudEventMetadata.CE_VERSION_1_0)
                                    .put("type", "msaReq")
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



    @POST
    @Path("/event/t1/{numsecu}/init")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initt1Event(String id, @PathParam("numsecu") String  numsecu) {
        LOGGER.infof("num secu recu %s", numsecu);

              
        JsonObject json = new JsonObject()
        .put("specversion", CloudEventMetadata.CE_VERSION_1_0)
        .put("type", "initt1OK")
        .put("id", id)
        .put("source", "/event/t1/{numsecu}/init")
        .put("datacontenttype", "application/json")
        .put("time", "2020-07-23T09:12:34Z")
        .put("data",  numsecu+"-t1")
        .put("kogitoprocrefid", id)
        .put("kogitoprocid","imsaProcess")
        .put("kogitoprocinstanceid",id);

        initt1OKRequestEmitter.send(json.encode());
        LOGGER.infof("Cloudevent %s produced into the topic initt1",json.encode() );

        return Response.ok(numsecu+"-t1").build();
    }

       
    @POST
    @Path("/event/t2/{numsecu}/init")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initt2Event(String id, @PathParam("numsecu") String  numsecu) {

        JsonObject json = new JsonObject()
        .put("specversion", CloudEventMetadata.CE_VERSION_1_0)
        .put("type", "initt1OK")
        .put("id", id)
        .put("source", "/event/t2/{numsecu}/init")
        .put("datacontenttype", "application/json")
        .put("time", "2020-07-23T09:12:34Z")
        .put("data",  numsecu+"-t2")
        .put("kogitoprocrefid", id)
        .put("kogitoprocid","imsaProcess")
        .put("kogitoprocinstanceid",id);

        initt2OKRequestEmitter.send(json.encode());
        LOGGER.infof("Cloudevent %s produced into the topic initt2",json.encode() );   
        return Response.ok(numsecu+"-t2").build();
    }

       
    @POST
    @Path("/event/t3/{numsecu}/init")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initt3Event(String id, @PathParam("numsecu") String  numsecu) {
        LOGGER.infof("num secu recu %s", numsecu);
        return Response.ok(numsecu+"-t3").build();
    }
}
