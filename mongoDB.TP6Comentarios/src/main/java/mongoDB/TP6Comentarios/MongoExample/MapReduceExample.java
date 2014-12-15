package mongoDB.TP6Comentarios.MongoExample;

import mongoDB.TP6Comentarios.MongoConexion.Usuario;
import mongodbService.Collection;
import mongodbService.SistemDB;
import net.vz.mongodb.jackson.MapReduceOutput;

public class MapReduceExample {
	
	public static void main(String[] args) {
//		Collection<Usuario> coll = SistemDB.instance().collection(Usuario.class);
//		String mapPorZona = "function() {"+
//	            "for (var idx = 0; idx < this.precios.length; idx++) {"+
//	            	"var value = {"+
//	                        "cantidad: 1,"+
//	                        "precio: this.precios[idx].precio"+
//	                      "};"+
//	                  "var key = {producto: {nombre: this.nombre, marca:this.marca}, zona:this.precios[idx].zona};"+
//	                "emit(key , value);"+
//	            "}"+
//	         "};";
//		
//		String mapPorProducto = "function() {"+
//	            "for (var idx = 0; idx < this.precios.length; idx++) {"+
//	            	"var value = {"+
//	                        "cantidad: 1,"+
//	                        "precio: this.precios[idx].precio"+
//	                      "};"+
//	                  "var key = {producto: {nombre: this.nombre, marca:this.marca}};"+
//	                "emit(key , value);"+
//	            "}"+
//	         "};";
//	         
//	         
//	         String reduceFunction = "function(key, precios) {"+
//	             "reducedVal = { cantidad: 0, precio: 0 };"+
//	             "for (var idx = 0; idx < precios.length; idx++) {"+
//	                 "reducedVal.cantidad += precios[idx].cantidad;"+
//	                 "reducedVal.precio+= precios[idx].precio;"+
//	             "}"+
//	             "return reducedVal;"+
//	          "};";
//			
//	          String finalizeFunction = "function (key, reducedVal) {"+
//	              "var value = {"+
//	                  "cantidad: reducedVal.cantidad,"+
//	                  "precioPromedio: reducedVal.precio/reducedVal.cantidad"+
//	                "};"+
//	              "return value;"+
//	           "};";
//	           
//			MapReduceOutput<PromedioDePreciosPorProducto, PromedioDePreciosPorProducto> mapReduce = coll.mapReduce(mapPorProducto, reduceFunction, finalizeFunction, PromedioDePreciosPorProducto.class, PromedioDePreciosPorProducto.class);
//			for (PromedioDePreciosPorProducto string : mapReduce.results()) {
//				System.out.println(string);
//			}

	}

}
