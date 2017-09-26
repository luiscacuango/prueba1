/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.spp.ws;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ec.mil.spp.ws.ParteMovilResource.class);
        resources.add(ec.mil.spp.ws.bdd.service.SaudAuditoriaFacadeREST.class);
        resources.add(ec.mil.spp.ws.bdd.service.ScatCatalogoFacadeREST.class);
        resources.add(ec.mil.spp.ws.bdd.service.ScaudConfAuditoriaFacadeREST.class);
        resources.add(ec.mil.spp.ws.bdd.service.SdcaDconfAuditoriaFacadeREST.class);
        resources.add(ec.mil.spp.ws.bdd.service.SopcOpcionFacadeREST.class);
        resources.add(ec.mil.spp.ws.bdd.service.SoxpOpciperfFacadeREST.class);
        resources.add(ec.mil.spp.ws.bdd.service.SpxsPerfilFacadeREST.class);
        resources.add(ec.mil.spp.ws.bdd.service.SsisSistemaFacadeREST.class);
        resources.add(ec.mil.spp.ws.bdd.service.SusuUsuarioFacadeREST.class);
        resources.add(ec.mil.spp.ws.bdd.service.parte.SeguridadWs.class);
    }
    
}
