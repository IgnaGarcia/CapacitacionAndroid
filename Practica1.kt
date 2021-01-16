/*
 * Curso de introduccion al desarrollo de aplicaciones para sistemas Android
 * 
 * Practrica Nro 1 - Ejercitacion en Kotlin
 * 
 * Autor: Ignacio Agustin Garcia Ravlic
*/

//--PARTE 1:
data class Ingrediente(val nombre : String,
                 var cant : Int = 0)

data class Tipo(val nombre : String){
    override fun toString() : String = "Nombre: "+this.nombre
}

data class Plato(val ingredientes : ArrayList<String>,
           val nombre : String,
           var categorias : ArrayList<Tipo> = ArrayList(),
           val esDulce : Boolean = false){
    override fun toString() : String = "Plato - "+this.nombre+" : \n\tEs Dulce? "+this.esDulce+"\n\tCategorias: "+this.categorias+"\n\tIngredientes: "+this.ingredientes
}


fun listarPlatos(lista : List<Plato>) {
    for(item in lista){
        println(item)
    }
}
    

fun main(){ 
    //Tipos
    val vegie = Tipo(nombre = "Vegetariano")
    val sintacc = Tipo(nombre = "Sin TACC")
    val sinlact = Tipo(nombre = "Sin Lactosa")
    
    //Platos
    //Salados 
    val choripan = Plato(ingredientes = arrayListOf("Lechuga", "Tomate", "Aceite", "Huevo", "Chorizo", "Pan"),
                           nombre = "Choripan Completo",
                           categorias = arrayListOf(sinlact))
    val hamburguesa = Plato(ingredientes = arrayListOf("Pan", "Carne Picada"),
                           nombre = "Hamburguesa Simple",
                           categorias = arrayListOf(sintacc))
    val ensaladaLyT = Plato(ingredientes = arrayListOf("Lechuga", "Tomate", "Aceite", "Huevo"),
                           nombre = "Ensalada de Lechuga y Tomate",
                           categorias = arrayListOf(vegie, sintacc, sinlact))
    val pollo = Plato(ingredientes = arrayListOf("Pollo", "Aceite"),
                          nombre = "Pollo al Plato",
                          categorias = arrayListOf(sintacc, sinlact))
    val churrasco = Plato(ingredientes = arrayListOf("Carne", "Lechuga", "Tomate", "Aceite", "Huevo"),
                          nombre = "Churrasco con Ensalada",
                          categorias = arrayListOf(sintacc, sinlact))
    val carneAsada = Plato(ingredientes = arrayListOf("Carne", "Lechuga", "Tomate", "Aceite", "Huevo"),
                          nombre = "Carne Asada con Ensalada",
                          categorias = arrayListOf(sintacc, sinlact))
    val hamburguesaCompleta = Plato(ingredientes = arrayListOf("Pan", "Carne Picada", "Queso", "Jamon", "Lechuga", "Tomate", "Huevo"),
                                   nombre = "Hamburguesa Completa",
                                   categorias = arrayListOf(sinlact))
    val milanesaAlPlato = Plato(ingredientes = arrayListOf("Pollo", "Pan Rallado", "Huevo", "Aceite", "Lechuga", "Tomate"),
                               nombre = "Milanesa de Pollo al Plato con Ensalada",
                               categorias = arrayListOf(sinlact))
    val milanesaNapolitana = Plato(ingredientes = arrayListOf("Salsa", "Jamon", "Queso", "Pollo", "Pan Rallado", "Huevo", "Aceite", "Lechuga", "Tomate"),
                               nombre = "Milanesa de Pollo Napolitana con Ensalada",
                               categorias = arrayListOf(sinlact))
    val sandwichMilanesa = Plato(ingredientes = arrayListOf("Pan", "Pollo", "Pan Rallado", "Huevo", "Aceite", "Lechuga", "Tomate"),
                               nombre = "Sandwich de Milanesa de Pollo",
                               categorias = arrayListOf(sinlact))
    //Dulces
    val flan = Plato(ingredientes = arrayListOf("Leche", "Huevo", "Azucar", "Dulce de Leche"),
                    nombre = "Flan con Dulce de Leche",
                    categorias = arrayListOf(sintacc),
                    esDulce = true)
    val brownie = Plato(ingredientes = arrayListOf("Agua", "Azucar", "Chocolate", "Harina", "Aceite"),
                    nombre = "Brownie",
                    categorias = arrayListOf(sinlact, vegie),
                    esDulce = true)
    val medialuna = Plato(ingredientes = arrayListOf("Leche", "Huevo", "Azucar", "Manteca", "Levadura", "Harina"),
                    nombre = "Medialuna de Manteca",
                    esDulce = true)
    val pastelito = Plato(ingredientes = arrayListOf("Tapa", "Dulce de Batata"),
                    nombre = "Pastelito de Batata",
                    categorias = arrayListOf(sinlact, vegie),
                    esDulce = true)
    val chocotorta = Plato(ingredientes = arrayListOf("Queso Crema", "Chocolina", "Dulce de Leche"),
                    nombre = "Chocotorta",
                    esDulce = true)
    
    
    var platos : ArrayList<Plato> = arrayListOf(chocotorta, pastelito, medialuna, brownie, flan, sandwichMilanesa, milanesaNapolitana,
                                               milanesaAlPlato, hamburguesaCompleta, carneAsada, churrasco, pollo, ensaladaLyT, 
                                               hamburguesa, choripan)
    
    
    //Listar los platos
    println("----Listar los 15 platos:")
    listarPlatos(platos)
    
    
    //Agregar un nuevo Plato dulce y listar
    println("\n----Listar nuevo plato dulce:")
	val chocolateRama = Plato(ingredientes = arrayListOf("Chocolate"),
                    nombre = "Chocoralte en Rama",
                    categorias = arrayListOf(sinlact, vegie, sintacc),
                    esDulce = true)
    println(chocolateRama)
    
    
    //Quitar platos sintacc y listar los restantes
    println("\n----Quitar los platos sintacc y listar restantes:")
    platos.add(chocolateRama)
    var platosConTACC : List<Plato> = platos.filter{ !it.categorias.contains(sintacc) }
    listarPlatos(platosConTACC)
    
    
    //Listar platos sintacc y sinlact sin tomate
    println("\n----Listar Platos Sintacc y SinLact sin tomate:")
	//Buscar con los filtros por separado
	var aptoCeliaco = platos.filter{ it.categorias.contains(sintacc) && !it.ingredientes.contains("Tomate") }
    if(aptoCeliaco.size == 0) println("\nNo se encuentran platos para celiacos") 
    else{
        println("\n--Platos aptos celiacos: ")
        listarPlatos(aptoCeliaco)
    }
    
    var aptoIntoler = platos.filter{ it.categorias.contains(sinlact) && !it.ingredientes.contains("Tomate") }
    if(aptoIntoler.size == 0) println("\nNo se encuentran platos para intolerantes a la lactosa") 
    else{
        println("\n--Platos aptos intolerantes a la lactosa: ")
        listarPlatos(aptoIntoler)
    } 

    
	
	//PARTE 2:
	//Restaurantes
	val rest1 = Restaurante(nombre = "El uno",
                           menu = arrayListOf(flan, brownie, choripan, carneAsada))
    val rest2 = Restaurante(nombre = "Parrilla Juan",
                           menu = arrayListOf(choripan, carneAsada, churrasco, pollo, ensaladaLyT, hamburguesaCompleta))
    val rest3 = Restaurante(nombre = "La Esquina",
                           menu = arrayListOf(sandwichMilanesa, milanesaNapolitana, milanesaAlPlato, chocotorta))
    val rest4 = Restaurante(nombre = "Lo de Tito",
                           menu = arrayListOf(chocotorta, carneAsada, churrasco),
                           aceptaMascotas = true)
    val rest5 = Restaurante(nombre = "Kenko",
                           menu = arrayListOf(ensaladaLyT, hamburguesa, hamburguesaCompleta, ),
                           aceptaMascotas = true)
    val rest6 = Restaurante(nombre = "Chesco",
                           menu = arrayListOf(chocotorta, pastelito, medialuna, brownie, flan),
                           aceptaMascotas = true)
    
    var restaurantes : ArrayList<Restaurante> = arrayListOf(rest1, rest2, rest3, rest4, rest5, rest6)
    
    //Ingredientes
    val lechuga = Ingrediente(nombre = "Lechuga")
    val tomate = Ingrediente(nombre = "Tomate")
    val huevo = Ingrediente(nombre = "Huevo")
    val queso = Ingrediente(nombre = "Queso")
    val pan = Ingrediente(nombre = "Pan")
    val chocolate = Ingrediente(nombre = "Chocolate")
    val azucar = Ingrediente(nombre = "Azucar")
    val aceite = Ingrediente(nombre = "Aceite")
    
    
    //Buscar restaurantes con x ingrediente
    println("\n\n----Buscar y mostrar restaurantes que usen x ingrediente")
    var result = buscarRestoCon(aceite, restaurantes)
	
    
    //Mostrar restaurantes con platos sintacc y sinlact, mas detalles
    println("\n----")
	mostrarRestosAptos(restaurantes)
}

//------------------------
//--PARTE 2:
data class Restaurante(var nombre : String,
                      var menu : ArrayList<Plato>,
                      var aceptaMascotas : Boolean = false)

fun buscarPlatosCon(ingrediente : Ingrediente, platos : List<Plato>) : List<Plato>{
    return platos.filter{ it.ingredientes.contains(ingrediente.nombre) }
}

fun buscarRestoCon(ingrediente : Ingrediente, restaurantes : List<Restaurante>) : List<Restaurante>{
    val platosResult = buscarPlatosCon(ingrediente, restaurantes.flatMap{ it.menu }).toSet().toList() //guardar los platos con tal ingrediente
    val result = restaurantes.filter{ it.menu.any{ it in platosResult }}
    
    mostrarRestos(result, platosResult)//llamar a funcion que muestra resultados
    return result
}

fun mostrarRestos(restaurantes : List<Restaurante>, platos : List<Plato>){
    //grupos 
    val agrupados = platos.groupingBy{ it.esDulce }
    
    //mostrar dulces
    val nDulces = if(agrupados.eachCount().contains(true)) agrupados.eachCount().getValue(true) else 0
    println("\nPlatos Dulces - "+ nDulces +" resultados encontrados")
    val dulces = restaurantes.filter{ it.menu.any{ it in platos.filter{ it.esDulce } }} 
    for(item in dulces){
        println("\n- Restaurante \""+item.nombre+"\"")
    }
    
    //mostrar salados
    val nSalados = if(agrupados.eachCount().contains(false)) agrupados.eachCount().getValue(false) else 0
    println("\n\nPlatos Salados - "+ nSalados +" resultados encontrados")
    val salados = restaurantes.filter{ it.menu.any{ it in platos.filter{ !it.esDulce } }}
    for(item in salados){
        println("\n- Restaurante \""+item.nombre+"\"")
    }
}



fun mostrarRestosAptos(restaurantes : List<Restaurante>){
    val sintacc = Tipo(nombre = "Sin TACC")
    val sinlact = Tipo(nombre = "Sin Lactosa")
    
    
    var platos = restaurantes.flatMap{ it.menu }.toSet().toList() //obtener los platos disponibles en la lista de restaurantes
    platos = platos.filter{ it.categorias.contains(sintacc) && it.categorias.contains(sinlact) } //quitar los platos que no sean sintacc y no sean sinlact
    
    var filtrados = restaurantes.filter{ it.menu.any{ it in platos } } //quitar los restaurantes que no tengan platos aptos
    
    if(filtrados.size == 0) println("No hay restaurantesa con platos Sin TACC y Sin Lactosa") else println("Restaurantes con platos Sin TACC y Sin Lactosa")
    
    for(item in filtrados){
        println("\n- "+item.nombre.toUpperCase())
        if(item.aceptaMascotas) println("*Acepta Mascotas*") else println("*No Acepta Mascotas*")
        
        var platosAptos = item.menu.filter{ it in platos } //filtrar platos del menu no aptos
        if(platosAptos.size < 2) println("Algunos platos: "+platosAptos.elementAt(0).nombre)
        else{
            println("Algunos platos: "+platosAptos.elementAt(0).nombre+", "+ platosAptos.elementAt(1).nombre+"...")
        }
    }
}