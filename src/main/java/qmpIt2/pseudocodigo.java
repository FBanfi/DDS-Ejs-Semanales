package qmpIt2;

import java.util.List;
import java.util.stream.Collectors;


class Usuario {
    private List<Prenda> prendasCargadas;
    private List<Prenda> borradores;

    private void cargarPrenda(TipoPrenda tipo, TipoMaterial material, TipoTrama trama, Color colorPrincipal, Color colorSecundario) {
        prendasCargadas.add(new Prenda(tipo, material, trama, colorPrincipal, colorSecundario));
    }

    private void guardarBorrador(Prenda unaPrenda) {
        borradores.add(unaPrenda);
    }
}

class Prenda {
    private TipoPrenda tipo;
    private TipoMaterial material;
    private Color colorPrincipal;
    private Color colorSecundario;

    public Prenda(TipoPrenda tipo, TipoMaterial material, TipoTrama trama, Color colorPrincipal, Color colorSecundario) {
        this.tipo = tipo;
        this.material = material;
        validarTrama(trama);
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        validarCamposObligatorios();
    }

    private void validarTrama(TipoTrama trama) {
        if ( trama != null) {
            this.material.setTrama(trama);
        }
    }

    private void validarCamposObligatorios() {
        if (this.tipo == null)
            throw new ExcepcionAtributoNulo("Debe ingresar un tipo");

        if (this.material == null)
            throw new ExcepcionAtributoNulo("Debe ingresar un material");

        if (this.colorPrincipal == null)
            throw new ExcepcionAtributoNulo("Debe ingresar un color primario");
    }
}

enum TipoMaterial {
    SEDA,
    ALGODON,
    NYLON;

    TipoTrama trama = TipoTrama.LISA;

    public void setTrama(TipoTrama trama) {
        this.trama = trama;
    }

    public TipoTrama getTrama() {
        return this.trama;
    }
}

enum TipoTrama {
    LISA,
    RAYADA,
    LUNARES,
    CUADROS,
    ESTAMPADO
}

// ESTO ES LO DE LA ITERACION PASADA QUE ACA NO SE USA
enum TipoPrenda {
    ZAPATOS(Categoria.ACCESORIOS),
    CAMISA_LARGA(Categoria.PARTE_SUPERIOR),
    CAMISA_CORTA(Categoria.PARTE_SUPERIOR),
    REMERA(Categoria.PARTE_SUPERIOR),
    PANTALON(Categoria.PARTE_INFERIOR),
    LENTES(Categoria.ACCESORIOS);

    private Categoria categoria;

    TipoPrenda (Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }
}

enum Categoria {
    CALZADO,
    PARTE_SUPERIOR,
    PARTE_INFERIOR,
    ACCESORIOS
}

class ExcepcionAtributoNulo extends RuntimeException {
    public ExcepcionAtributoNulo(String mensaje) {
        super(mensaje);
    }
}

class Color {
    private int red;
    private int green;
    private int blue;
}