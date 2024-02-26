package ar.edu.uade.tpbd2.persistence.model.mongo;

import java.util.List;

public class EstadoAnterior extends Estado {

    public EstadoAnterior(final List<Producto> productos) {
        super(productos);
    }

    @Override
    protected void actualizarEstado() {
        // TODO Auto-generated method stub

    }

}
