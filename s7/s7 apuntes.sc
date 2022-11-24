val goleadores = List(
  ("Francisco Fydriszewski", 10),
  ("Joaquin Verges", 9),
  ("Santiago Giordana", 9),
  ("Ismael Diaz", 9),
  ("Tomas Molina", 7),
  ("Danny Luna", 7),
  ("Cristian Martinez", 7),
  ("Gabriel Cortez", 7),
  ("Leonardo Villagra", 6),
  ("Michael Hoyos", 6))

//genera una nueva lista que se almacena en goles
val goles = goleadores.map(_._2).map(_.toDouble)
val average = (values : List[Double]) => values.sum / values.length
val avgGol = average(goles)

//para que traiga solo el nombre
goleadores.maxBy(_._2)._1
goleadores.minBy(_._2)._1

//goles mayores/menores al promedio
val mayoresAvg = goleadores.filter(_._2 > avgGol).map(_._1)
val menoresAvg = goleadores.filter(_._2 < avgGol).map(_._1)

//para poner tupla como parametro
List[(String, Int)]

//CONJUNTOS: set --- los conjuntos solo tienen valores unicos
val cons : Set[Int] = Set()
val conjuntos : Set[Int] = Set(1, 1, 2, 2, 2, 3)

//algunas funciones
//agregar un elemento al conjunto, al final
//union
val conjunto : Set[Int] = Set(1, 2, 3)
val conNuevo = conjunto + 6

val conjunto2 : Set[Int] = Set(1, 2, 3)
val conNuevo2 = conjunto2.concat(List(2, 3, 4, 5))

//interseccion
val conjunto3 : Set[Int] = Set(1, 2, 3)
val conNuevo3 = conjunto3.concat(List(2, 3, 4, 5))
conNuevo3.intersect(conjunto3)

//MAPAS o direccionarios, solo dos elementos
//key + value -- palabra + significado
Map[K, V]
// K representa las claves
// V represneta valores

//todos tienen que tener los mismos tipos de datos
Map(("apples", 3), ("oranges", 2), ("pears", 0))
Map("apples" -> 3, "oranges" -> 2, "pears" -> 0)

//convertir lista de tupla a un mapa: metodo toMap
List(("apples", 3), ("oranges", 2), ("pears", 0)).toMap

//no convertir listas de 3
List((1,2,3), (4,5,6)).toMap

//transformar un mapa a una secuencia de pares(tuplas2)
Map(("apples", 3), ("oranges", 2), ("pears", 0)).toSeq

//obtener una lista en donde esten el numero de unidades multiplicado por dos
val fruitBasket = Map(("apples", 3), ("oranges", 2), ("pears", 0))
fruitBasket.map(data => data match {
  case (fruit, count) => count * 2
}) //el data sera una combinacion de clave y valor, se trabaja con el operador match

fruitBasket.map{ case(fruit, count) => count * 2 }
fruitBasket.map{ case(fruit, count) => (fruit, count * 2) }

fruitBasket.map{ case(fruit, count) => (fruit, count, count*2) }.map{
  case (fruit, _, count2) => (fruit, count2 / 2)}.toMap

//filter en mapas
val fruitBasket2 = Map(("apples", 3), ("oranges", 2), ("pears", 0))
fruitBasket2.filter { case (fruit, count) => count > 0}

//groupby, reorganiza una secuencia en un mapa donde algunos elementos de la secuencia original se agrupan en subsecuencias
//por ejemplo, dada una secuencia de palabras, podemos agrupar todas las palabras que comienzan con la letra 'y' en una subsecuencia y todas las demas palabras en otra subsecuencia
Seq("wombat", "xanthan", "yogurt", "zebra").groupBy( s => if (s startsWith "y") 1 else 2)
//el argumento del groupby es una funcion que calcula el key de cada elemento de secuencia
//asigna cada clave a la subsecuencia de valoers que tienen esa clave, en el ejemplo actual el mapa es Map(Int, Seq[String])

List(1, 2, 3, 4, 5).groupBy( k => k % 3)
//las claves serian 0, 1, 2: el resultado de la operacion modulo


val goleadores3 = List(
  ("Francisco Fydriszewski", 10),
  ("Joaquin Verges", 9),
  ("Santiago Giordana", 9),
  ("Ismael Diaz", 8),
  ("Tomas Molina", 7),
  ("Danny Luna", 7),
  ("Cristian Martinez", 7),
  ("Gabriel Cortez", 7),
  ("Leonardo Villagra", 6),
  ("Michael Hoyos", 6))

//cuantos jugadores han marcado el mismo numero de goles
goleadores3.groupBy{ case(_, goals) => goals}

goleadores3.groupBy( row => row match {
  case (_, goals) => goals
}).map(row => row match {
  case(goles, lista) => (goles, lista.size)
}).toList.sortBy(_._2)

goleadores3.groupBy {
  case (_, goals) => goals
}.map {
  case(goles, lista) => (goles, lista.size)
}.toList.sortBy(_._2)

goleadores3.groupBy( row => row match {
  case (_, goals) => goals
}).map(row => row match {
  case(goles, lista) => (goles, lista.size)
}).toList.sortBy(_._2).reverse

goleadores3.groupBy( row => row match {
  case (_, goals) => goals
}).map(row => row match {
  case(goles, lista) => (goles, lista.size)
}).toList.sortWith(_._2 < _._2)
























