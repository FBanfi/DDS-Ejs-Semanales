package qmpIt5;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private List<Guardarropa> guardarropas = new ArrayList<>();
  private List<Recomendacion> recomendacionesPendientes = new ArrayList<>();
  private List<Recomendacion> recomendacionesAceptadas = new ArrayList<>();

  public void recomendarAgregarPrenda(Usuario usuario, Prenda prenda, Guardarropa guardarropa) {
    usuario.agregarARecomendacionesPendientes(new RecomendacionAgregado(prenda, guardarropa));
  }

  public void recomendarQuitarPrenda(Usuario usuario, Prenda prenda, Guardarropa guardarropa) {
    usuario.agregarARecomendacionesPendientes(new RecomendacionQuitado(prenda, guardarropa));
  }

  public void agregarARecomendacionesPendientes(Recomendacion recomendacion) {
    recomendacionesPendientes.add(recomendacion);
  }

  public void determinarEstado(Recomendacion recomendacion, EstadoRecomendacion estado){
    if (estado == EstadoRecomendacion.ACEPTADA) {
      recomendacionesAceptadas.add(recomendacion);
      recomendacion.obtenerResultado();
    }
    else {
      recomendacionesPendientes.remove(recomendacion);
    }
  }

  ...
}

public class Guardarropa {
  private List<Usuario> usuariosDelGuardarropas = new ArrayList<>();
  private List<Prenda> prendas = new ArrayList<>();

  public void agregar(Prenda prenda) {
    prendas.add(prenda);
  }

  public void remover(Prenda prenda) {
    prendas.remove(prenda);
  }

  ...
}

public class Prenda {
  ...
}

public interface Recomendacion {
  void obtenerResultado();
}

public class RecomendacionAgregado implements Recomendacion {
  private Prenda prenda;
  private Guardarropa guardarropa;

  public RecomendacionAgregado(Prenda prenda, Guardarropa guardarropa) {
    this.prenda = prenda;
    this.guardarropa = guardarropa;
  }

  @Override
  public void obtenerResultado() {
    guardarropa.agregar(prenda);
  }
}

public class RecomendacionQuitado implements Recomendacion {
  private Prenda prenda;
  private Guardarropa guardarropa;

  public RecomendacionQuitado(Prenda prenda, Guardarropa guardarropa) {
    this.prenda = prenda;
    this.guardarropa = guardarropa;
  }

  @Override
  public void obtenerResultado() {
    guardarropa.remover(prenda);
  }
}

public enum EstadoRecomendacion {
  ACEPTADA,
  RECHAZADA
}