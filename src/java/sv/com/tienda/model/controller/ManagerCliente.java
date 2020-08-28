
package sv.com.tienda.model.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sv.com.tienda.model.ejb.ClienteFacadeLocal;
import sv.com.tienda.model.entidades.Cliente;

@ManagedBean
@SessionScoped
public class ManagerCliente {
    
   @EJB
   private ClienteFacadeLocal clienteFacade;
   private List<Cliente> listCliente;
   private Cliente cliente;

    public List<Cliente> getListCliente() {
         this.listCliente = this.clienteFacade.findAll();
        return listCliente;
    }

    public void setListCliente(List<Cliente> listCliente) {
       
        this.listCliente = listCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @PostConstruct
    public void init(){
     this.cliente = new Cliente(); 
    }
}
