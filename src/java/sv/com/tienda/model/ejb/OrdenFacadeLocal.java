/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tienda.model.ejb;

import java.util.List;
import javax.ejb.Local;
import sv.com.tienda.model.entidades.Orden;

/**
 *
 * @author jcriv
 */
@Local
public interface OrdenFacadeLocal {

    void create(Orden orden);

    void edit(Orden orden);

    void remove(Orden orden);

    Orden find(Object id);

    List<Orden> findAll();

    List<Orden> findRange(int[] range);

    int count();
    
}
