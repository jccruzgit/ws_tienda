
package sv.com.tienda.model.controller;

import com.sun.xml.rpc.processor.schema.Facet;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sv.com.tienda.model.ejb.OrdenFacadeLocal;
import sv.com.tienda.model.entidades.Cliente;
import sv.com.tienda.model.entidades.Orden;
import sv.com.tienda.model.entidades.Producto;

@ManagedBean
@SessionScoped
public class ManagerOrden implements Serializable{
    @EJB
    private OrdenFacadeLocal ordenFacade;  
    private List<Orden> listOrden;
    private Orden orden;
    private Cliente cliente;
    private Producto producto;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Orden> getListOrden() {
        this.listOrden = ordenFacade.findAll();
        return listOrden;
    }

    public void setListOrden(List<Orden> listOrden) {
        this.listOrden = listOrden;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @PostConstruct
    public void init(){
     this.cliente = new Cliente();
     this.orden = new Orden();
     this.producto = new Producto();
    }
    
     public void botonGuardar(){
        try {
            this.orden.setIdCliente(cliente);
            this.orden.setIdProducto(producto);
            this.ordenFacade.create(orden);
            this.mensaje = "Orden creada correctamente";
            init();
            
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Fallo al momento de guardar registro" + e.getMessage();            
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }
     
     public void eliminarOrden(Orden eli){
         try {
             this.ordenFacade.remove(eli);
             this.mensaje ="Registro eliminado exitosamente";
         } catch (Exception e) {
             this.mensaje = "Fallo al momento de eliminar registro" + e.getMessage();
         }
          FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
     }
     
     public void cargarDatos(Orden ord){
         try {
             this.cliente.setId(ord.getIdCliente().getId());
             this.producto.setId(ord.getIdProducto().getId());
             this.orden = ord;
         } catch (Exception e) {
         }
     }
     
     public void limpiarData(){
     this.cliente = new Cliente();
     this.orden = new Orden();
     this.producto = new Producto();
     }
     
     public void actualizarOrden(){
          try {
            this.orden.setIdCliente(cliente);
            this.orden.setIdProducto(producto);
            this.ordenFacade.edit(orden);
            this.mensaje = "Orden actualizada correctamente";
            init();
            
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Fallo al momento de actualizar registro" + e.getMessage();            
        }
        FacesMessage msj = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msj);
     }
}
