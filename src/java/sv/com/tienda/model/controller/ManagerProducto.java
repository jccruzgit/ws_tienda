
package sv.com.tienda.model.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sv.com.tienda.model.ejb.ProductoFacadeLocal;
import sv.com.tienda.model.entidades.Producto;

@ManagedBean
@SessionScoped
public class ManagerProducto implements Serializable{
     @EJB
    private ProductoFacadeLocal productoFacade;
    private List<Producto> listProductos;
    private Producto producto;

    public List<Producto> getListProductos() {
        this.listProductos = productoFacade.findAll();
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    @PostConstruct
    public void init(){
     this.producto = new Producto();
    }
}
