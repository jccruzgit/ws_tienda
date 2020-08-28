
package sv.com.tienda.model.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.tienda.model.entidades.Orden;

/**
 *
 * @author jcriv
 */
@Stateless
public class OrdenFacade extends AbstractFacade<Orden> implements OrdenFacadeLocal {

    @PersistenceContext(unitName = "ws-tiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenFacade() {
        super(Orden.class);
    }
    
}
