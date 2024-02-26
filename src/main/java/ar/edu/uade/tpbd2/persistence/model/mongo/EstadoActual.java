package ar.edu.uade.tpbd2.persistence.model.mongo;

import java.util.List;

public class EstadoActual extends Estado {

    public EstadoActual(final List<Producto> productos) {
        super(productos);
    }

    @Override
    protected void actualizarEstado() {
        // TODO Auto-generated method stub

    }


}
