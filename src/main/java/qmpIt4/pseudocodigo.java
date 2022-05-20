// Punto 1
AccuWeatherAPI apiClima = new AccuWeatherAPI();
List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather(“Buenos Aires, Argentina”);
condicionesClimaticas.get(0).get("PrecipitationProbability");

// Punto 2
class Atuendo {
	List<Prenda> prendas;
	
	public Atuendo(List<Prenda> prendas){
	}
	
	public void agregarPrenda(Prenda prenda){
		this.prendas.add(prenda);
	}
}

// Punto 3 y 4 (NO SE ME OCURRIO OTRA FORMA - PERO NO ME GUSTA)
class GeneradorDeSugerencias {
	private List<Prenda> prendasTotalesDisponibles = new ArrayList<>();
	private List<Map<String, Object>> condicionesClimaticas = new ArrayList<>();
	private List<Atuendo> atuendos = new ArrayList<>();
	
	public GeneradorDeSugerencias(AccuWeatherAPI apiClima){
		condicionesClimaticas = apiClima.getWeather(“Buenos Aires, Argentina”);
	}
	
	public Atuendo generarSugerencia() {
		Atuendo atuendoGenerado = new Atuendo([sugerenciaParteSuperior(), sugerenciaParteInferior(), sugerenciaCalzado(), sugerenciaAccesorio()]);
		atuendos.add(atuendoGenerado);
		return atuendoGenerado;
	}
	
	public Prenda sugerenciaParteSuperior(){
		return obtenerPrendaPorCategoria(Categoria.SUPERIOR)
	}
	
	public Prenda sugerenciaParteInferior(){
		return obtenerPrendaPorCategoria(Categoria.INFERIOR)
	}
	
	public Prenda sugerenciaCalzado(){
		return obtenerPrendaPorCategoria(Categoria.CALZADO)
	}
	
	public Prenda sugerenciaAccesorio(){
		return obtenerPrendaPorCategoria(Categoria.ACCESORIO)
	}
	
	public Prenda obtenerPrendaPorCategoria(Categoria categoria){
		return prendasTotalesDisponibles.stream().findAny(prenda -> prenda.categoriaEs(categoria));
	}
	public List<Map<String, Object>> getCondicionesClimaticas(){return condicionesClimaticas;}
}

class GeneradorDeSugerenciasPrecipitaciones extends GeneradorDeSugerencias {
	@Override
	public Prenda obtenerPrendaPorCategoria(Categoria categoria){
		Prenda sugerencia = prendasTotalesDisponibles.stream().findAny(prenda -> condicionPrecipitaciones(categoria,prenda));
		return
	}
	
	public boolean condicionPrecipitaciones(Categoria categoria, Prenda prenda){
		return prenda.categoriaEs(categoria) && prenda.aptaPara(condicionesClimaticas.get(0).get("PrecipitationProbability"));
	}
}
class GeneradorDeSugerenciasCaluroso extends GeneradorDeSugerencias {
	...
	// Lo mismo que el GeneradorDeSugerenciasPrecipitaciones pero para este caso
}
class GeneradorDeSugerenciasFrio extends GeneradorDeSugerencias {
	...
	// Lo mismo que el GeneradorDeSugerenciasPrecipitaciones pero para este caso
}
class GeneradorDeSugerenciasNevada extends GeneradorDeSugerencias {
	...
	// Lo mismo que el GeneradorDeSugerenciasPrecipitaciones pero para este caso
}