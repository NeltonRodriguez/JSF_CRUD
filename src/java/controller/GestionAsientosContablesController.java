package controller;

import model.GestionAsientosContables;
import facade.GestionAsientosContablesFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "gestionAsientosContablesController")
@ViewScoped
public class GestionAsientosContablesController extends AbstractController<GestionAsientosContables> {

    @Inject
    private ClientesController idClienteController;
    @Inject
    private MobilePageController mobilePageController;

    public GestionAsientosContablesController() {
        // Inform the Abstract parent controller of the concrete GestionAsientosContables Entity
        super(GestionAsientosContables.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idClienteController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Clientes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCliente(ActionEvent event) {
        GestionAsientosContables selected = this.getSelected();
        if (selected != null && idClienteController.getSelected() == null) {
            idClienteController.setSelected(selected.getIdCliente());
        }
    }

}
