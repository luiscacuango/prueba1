/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.mil.spp.ws.bdd.service;

import ec.mil.spp.ws.bdd.SoxpOpciperf;
import ec.mil.spp.ws.bdd.SoxpOpciperfPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Cbop. Cacuango Luis
 */
@Stateless
@Path("ec.mil.spp.ws.bdd.soxpopciperf")
public class SoxpOpciperfFacadeREST extends AbstractFacade<SoxpOpciperf> {
    @PersistenceContext(unitName = "parteMovilWebPU")
    private EntityManager em;

    private SoxpOpciperfPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;opcSecuen=opcSecuenValue;pxsSecuen=pxsSecuenValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.mil.spp.ws.bdd.SoxpOpciperfPK key = new ec.mil.spp.ws.bdd.SoxpOpciperfPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> opcSecuen = map.get("opcSecuen");
        if (opcSecuen != null && !opcSecuen.isEmpty()) {
            key.setOpcSecuen(new java.lang.Integer(opcSecuen.get(0)));
        }
        java.util.List<String> pxsSecuen = map.get("pxsSecuen");
        if (pxsSecuen != null && !pxsSecuen.isEmpty()) {
            key.setPxsSecuen(new java.lang.Integer(pxsSecuen.get(0)));
        }
        return key;
    }

    public SoxpOpciperfFacadeREST() {
        super(SoxpOpciperf.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(SoxpOpciperf entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, SoxpOpciperf entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        ec.mil.spp.ws.bdd.SoxpOpciperfPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public SoxpOpciperf find(@PathParam("id") PathSegment id) {
        ec.mil.spp.ws.bdd.SoxpOpciperfPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<SoxpOpciperf> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<SoxpOpciperf> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
