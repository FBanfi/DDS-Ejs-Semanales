package qmpIt1;

import java.util.List;

class Guardarropas {
    private Usuario usuario;
    private List<Prenda> prendas;

    public Guardarropas (Usuario usuario) {
        this.usuario = usuario;
    }

    public void agregarPrenda(Prenda nuevaPrenda) {
        prendas.add(nuevaPrenda);
    }
}

class Prenda {
    private TipoPrenda tipo;
    private TipoMaterial material;
    private Color colorPrincipal;
    private Color colorSecundario;

    public Prenda (TipoPrenda tipo, TipoMaterial material, Color colorPrincipal, Color colorSecundario)	{
        this.tipo = tipo;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        validarCamposObligatorios();
    }

    private void validarCamposObligatorios() {
        if (this.tipo == null)
            throw new RuntimeException("Debe ingresar un tipo");

        if (this.material == null)
            throw new RuntimeException("Debe ingresar un material");

        //no hace falta checkear la categoria porque si hay tipo entonces si o si va a tener categoria
        //ademas no puede pasar que un pantalon tenga categoria "parte superior" porque esta predefinido en el enum

        if (this.colorPrincipal == null)
            throw new RuntimeException("Debe ingresar un color primario");
    }

    //TODO getters and setters
}

//Usar un enum es mejor porque son valores predefinidos
//Hacerlo como string podría generar que se equivoque al tipear un usuario
//Hacer clases para cada valor estaría raro porque serían muchas y sin comport
enum TipoPrenda {
    ZAPATOS("Calzado"),
    CAMISA_LARGA("Parte Superior"),
    CAMISA_CORTA("Parte Superior"),
    REMERA("Parte Superior"),
    PANTALON("Parte Inferior"),
    LENTES("Accesorios");

    //esto si vale la pena hacerlo como string
    //porque lo hace mas simple y es algo que NO va a ingresar el usuario
    private String categoria;

    TipoPrenda (String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return this.categoria;
    }
}

enum TipoMaterial {	//me suena raro hacerlo como enum
    SEDA,			//no nos dan indicios de que tipos puede haber
    ALGODON,		//pero no se me ocurre otra forma y esta seria la mejor
    NYLON
}

class Color {
    private int red;
    private int green;
    private int blue;
}

class Usuario {
    //TODO
}