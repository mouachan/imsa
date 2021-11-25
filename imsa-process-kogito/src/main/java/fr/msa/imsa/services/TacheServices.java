
package fr.msa.imsa.services;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import fr.msa.imsa.rest.TacheRemoteServices;

import org.eclipse.microprofile.rest.client.inject.RestClient;



@ApplicationScoped
public class TacheServices {

    @Inject
    @RestClient
    TacheRemoteServices tacheRemoteServices;

    public String initt1(String id, String  numsecu){
        return tacheRemoteServices.initt1(id, numsecu);
    }

    public String initt2(String id, String  numsecu){
        return tacheRemoteServices.initt2(id, numsecu);
    }

    public String initt3(String id, String  numsecu){
        return tacheRemoteServices.initt3(id, numsecu);
    }
    
}
