package controller;

import model.TiposDocumentos;
import model.Transacciones;
import java.util.Collection;
import facade.TiposDocumentosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tiposDocumentosController")
@ViewScoped
public class TiposDocumentosController extends AbstractController<TiposDocumentos> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isTransaccionesCollectionEmpty;

    public TiposDocumentosController() {
        // Inform the Abstract parent controller of the concrete TiposDocumentos Entity
        super(TiposDocumentos.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsTransaccionesCollectionEmpty();
    }

    public boolean getIsTransaccionesCollectionEmpty() {
        return this.isTransaccionesCollectionEmpty;
    }

    private void setIsTransaccionesCollectionEmpty() {
        TiposDocumentos selected = this.getSelected();
        if (selected != null) {
            TiposDocumentosFacade ejbFacade = (TiposDocumentosFacade) this.getFacade();
            this.isTransaccionesCollectionEmpty = ejbFacade.isTransaccionesCollectionEmpty(selected);
        } else {
            this.isTransaccionesCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Transacciones entities
     * that are retrieved from TiposDocumentos and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Transacciones page
     */
    public String navigateTransaccionesCollection() {
        TiposDocumentos selected = this.getSelected();
        if (selected != null) {
            TiposDocumentosFacade ejbFacade = (TiposDocumentosFacade) this.getFacade();
            Collection<Transacciones> selectedTransaccionesCollection = ejbFacade.findTransaccionesCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Transacciones_items", selectedTransaccionesCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/transacciones/index";
    }

}
