//resolucion parcial 1
val nros = List(727.7, 1086.5, 1091.0, 1361.3, 1490.5, 1956.1)

def promedio(valores: List[Double]): Double = valores.sum /valores.size

def desvEst(valores : List[Double]) : Double = {
  val avg = promedio(valores)

  def varianza(valores: List[Double]) : Double =
    valores.map(x => Math.pow(x - avg, 2)).sum * (1.0 / (valores.size-1))

  Math.sqrt(varianza(valores))
}

desvEst(nros)

//unit = para cuando solo se imprima algo
def clasifica(valores : List[Double]) : Unit = {
  val s = desvEst(valores)
  val avg = promedio(valores)

  (1 to 3).foreach(i =>
    println(valores.count(x =>
      x >= (avg - i * s) && x <= (avg + i * s) ) ) )
}

clasifica(nros)

//tuplas: contenedor de dato donde cada elemento puede ser de diferente tipo
//desde 1 elemento hasta 22
//para mas de 22: una clase
val par = (1, "Abad Ana") //los parentesis indican una tupla
//se puede acceder a cada elemento de forma independiente, utilizando punto, guion bajo y un indice
println(par._1)
println(par._2)

val student2 = (1, "Abad Ana")
val datos = ("jorgaf", 'M', 45, 95.2, true)

//para agregar tipo de dato
val student2: Tuple2[Int, String]
val datos: Tuple5[String, Char, Int, Double, Boolean]

val student = (1, "Abad Ana")
val (edad, nombre) = student
print(edad)
print(nombre)

student.swap

student.canEqual((1, "Abad Ana"))

//https://www.scala-lang.org/api/3.x/scala/collection/immutable/List.html#

//conjuntos: listado de valores unicos
//listas: listado de valoers
//mapas: listado de pares (claves/valor)

//LISTAS
//son inmutables, no se puede agregar un elemento, para eso desaperece la anterior y se crea una nueva
//las listas se representan como listas enlazadas
val values = List(42, 31, 36, 40, 43)
val names = List("Jorge", "Rene", "Ma. del Carmen", "Nelson")
val fruit : List[String] = List("apple", "orange", "pears")
val nos : List[Int] = List(1, 2, 3)

//dentro de las listas se pueden realizar algunas operaciones
//count, exists, filter, forall, length, map, max, maxby, min, minby, produc, size

val myList = List(10, 20, 30, 40, 50, 60)
myList.isEmpty
myList.drop(2) //dropear valores que esten en la pos 1 y 2, borrar los 2 primeros
myList.dropWhile(_ < 45) //borra los que son menor a 45
myList.slice(2, 4) //una nueva lista desde el 3 hasta el 4
myList.tail
myList.head
myList.take(3) //toma los 3 primeros
myList.takeWhile(_ < 30)
myList.sorted //ordena numeros de forma ascendente
myList.sorted(Ordering.Int.reverse) //ordena numeros de forma descendente

//foldLeft: aplica un operador binario a un valore inicial y a todos los elementos de esta secuencia, de izquierda a derecha
myList.foldLeft(0) ( (x, y) => x + y)// x: acumulador, y: valor actual
myList.foldLeft(0) (_ + _)

myList.foldRight(0) ( (x, y) => x + y)// y: acumulador, x: valor actual

//crear una funcion para calcular el promedio de los elementos de una lista de numeros reales

def average(valores : List[Double]) : Double = { //        sumatoria     elementos que cuenta
  val t = valores.foldLeft((0.0, 0)) ((acc, currVal) => (acc._1 + currVal, acc._2 + 1))
  //0.0: acumulador, 0: valor
  t._1 / t._2
  // sumatoria / cantidad de elementos
}

def average2(valores: List[Double]) : Double = {
  val t = valores.foldLeft((0.0, 0)) { (acc, currVal) =>
    val sum = acc._1 + currVal
    val cont = acc._2 + 1
    printf("suma: %f - contador: %d%n", sum, cont)
    (sum, cont)
  }
  t._1 / t._2
}
average2(nros)

//zip: se usa para funsionar una coleccion con la actual y el resultado es una coleccion de tuplas de 2 con elementos de ambas colecciones

val myList2 = List(10, 20, 30, 40, 50, 60)
val names2 = List("Guido", "Armando", "Patricio", "Manuel","Germania", "Fanny")
names.zip(myList)

//unzip: convierte esta coleccion tuplas de 2 en dos colecciones de la primera y la segunda mitad de cada par

val zippedList: List[(String, Int)] =
  List(("Guido", 10), ("Armando", 20), ("Patricio", 30), ("Manuel", 40), ("Germania", 50), ("Fanny", 60))

val unzippedLists: (List[String], List[Int]) = zippedList.unzip

unzippedLists._1
unzippedLists._2

val goleadores = List(
  ("Oscar Becerra", 17),
  ("Luis Amarilla", 16),
  ("Michael Estrada", 16),
  ("Fidel Martinez", 16),
  ("Gonzalo Mastriani", 13),
  ("Leonel Vides", 13),
  ("Rodrigo Aguirre", 12),
  ("Carlos Garces", 12),
  ("Jonathan Borja", 11))
