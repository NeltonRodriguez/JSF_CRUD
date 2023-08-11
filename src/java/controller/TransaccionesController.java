package controller;

import model.Transacciones;
import facade.TransaccionesFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "transaccionesController")
@ViewScoped
public class TransaccionesController extends AbstractController<Transacciones> {

    @Inject
    private TiposDocumentosController idTipoDocumentoController;
    @Inject
    private ClientesController idClienteController;
    @Inject
    private MobilePageController mobilePageController;

    public TransaccionesController() {
        // Inform the Abstract parent controller of the concrete Transacciones Entity
        super(Transacciones.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoDocumentoController.setSelected(null);
        idClienteController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TiposDocumentos controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoDocumento(ActionEvent event) {
        Transacciones selected = this.getSelected();
        if (selected != null && idTipoDocumentoController.getSelected() == null) {
            idTipoDocumentoController.setSelected(selected.getIdTipoDocumento());
        }
    }

    /**
     * Sets the "selected" attribute of the Clientes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCliente(ActionEvent event) {
        Transacciones selected = this.getSelected();
        if (selected != null && idClienteController.getSelected() == null) {
            idClienteController.setSelected(selected.getIdCliente());
        }
    }

}
