package controller;

import model.Clientes;
import model.Balances;
import model.GestionAsientosContables;
import model.Transacciones;
import java.util.Collection;
import facade.ClientesFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "clientesController")
@ViewScoped
public class ClientesController extends AbstractController<Clientes> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isBalancesCollectionEmpty;
    private boolean isGestionAsientosContablesCollectionEmpty;
    private boolean isTransaccionesCollectionEmpty;

    public ClientesController() {
        // Inform the Abstract parent controller of the concrete Clientes Entity
        super(Clientes.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsBalancesCollectionEmpty();
        this.setIsGestionAsientosContablesCollectionEmpty();
        this.setIsTransaccionesCollectionEmpty();
    }

    public boolean getIsBalancesCollectionEmpty() {
        return this.isBalancesCollectionEmpty;
    }

    private void setIsBalancesCollectionEmpty() {
        Clientes selected = this.getSelected();
        if (selected != null) {
            ClientesFacade ejbFacade = (ClientesFacade) this.getFacade();
            this.isBalancesCollectionEmpty = ejbFacade.isBalancesCollectionEmpty(selected);
        } else {
            this.isBalancesCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Balances entities that
     * are retrieved from Clientes and returns the navigation outcome.
     *
     * @return navigation outcome for Balances page
     */
    public String navigateBalancesCollection() {
        Clientes selected = this.getSelected();
        if (selected != null) {
            ClientesFacade ejbFacade = (ClientesFacade) this.getFacade();
            Collection<Balances> selectedBalancesCollection = ejbFacade.findBalancesCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Balances_items", selectedBalancesCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/balances/index";
    }

    public boolean getIsGestionAsientosContablesCollectionEmpty() {
        return this.isGestionAsientosContablesCollectionEmpty;
    }

    private void setIsGestionAsientosContablesCollectionEmpty() {
        Clientes selected = this.getSelected();
        if (selected != null) {
            ClientesFacade ejbFacade = (ClientesFacade) this.getFacade();
            this.isGestionAsientosContablesCollectionEmpty = ejbFacade.isGestionAsientosContablesCollectionEmpty(selected);
        } else {
            this.isGestionAsientosContablesCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of GestionAsientosContables
     * entities that are retrieved from Clientes and returns the navigation
     * outcome.
     *
     * @return navigation outcome for GestionAsientosContables page
     */
    public String navigateGestionAsientosContablesCollection() {
        Clientes selected = this.getSelected();
        if (selected != null) {
            ClientesFacade ejbFacade = (ClientesFacade) this.getFacade();
            Collection<GestionAsientosContables> selectedGestionAsientosContablesCollection = ejbFacade.findGestionAsientosContablesCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GestionAsientosContables_items", selectedGestionAsientosContablesCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/gestionAsientosContables/index";
    }

    public boolean getIsTransaccionesCollectionEmpty() {
        return this.isTransaccionesCollectionEmpty;
    }

    private void setIsTransaccionesCollectionEmpty() {
        Clientes selected = this.getSelected();
        if (selected != null) {
            ClientesFacade ejbFacade = (ClientesFacade) this.getFacade();
            this.isTransaccionesCollectionEmpty = ejbFacade.isTransaccionesCollectionEmpty(selected);
        } else {
            this.isTransaccionesCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Transacciones entities
     * that are retrieved from Clientes and returns the navigation outcome.
     *
     * @return navigation outcome for Transacciones page
     */
    public String navigateTransaccionesCollection() {
        Clientes selected = this.getSelected();
        if (selected != null) {
            ClientesFacade ejbFacade = (ClientesFacade) this.getFacade();
            Collection<Transacciones> selectedTransaccionesCollection = ejbFacade.findTransaccionesCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Transacciones_items", selectedTransaccionesCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/transacciones/index";
    }

}
