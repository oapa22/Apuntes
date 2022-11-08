def isEven(k: Int) : Int = (k % 2) match {
  case 0 => 1
  case _ => 0
}
// s es una lista que dentro tiene enteros
def countEven(s: List[Int] ) : Int = s.map(isEven).sum
countEven(List(5,6,7,8,9))

/*

//una funcion dentro de una funcion (que define otra funcion)
countEven2(s1: List[Int]) : Int = {
  def isEven(k:Int): Int = (k % 2) match {
    case 0 => 1
    case _ => 0
  }
  s1.map(isEven).sum
}
countEven(List(5,6,7,8,9))

//funcion sin nombre dentro de funcion
countEven3(s3: List[Int]) : Int ={
  val isEven = (k:Int) => k % 2 match {
    case 0 => 1
    case _ => 0
  }
  s3.map(isEven).sum
}

countEven(List(5,6,7,8,9))
*/

//map se usa para hacer transformaciones

//mapear una lista de cadenas de texto a lista de enteros que representan la longitud del texto
val names : List[String] = List("Leo", "Cristiano", "Enner", "Felipe")
names.map(_.length)

val nums = names.map(_.length)


//dada una lista de numeros enteros, desarrollar las funciones necesarias que le permitan contar cuantos elementos de la lista son primos
val numbers = List(3,4,7,11,12)
val isPrime = (nro : Int) => (2 to nro-1).forall(nro % _ != 0)
numbers.map(isPrime(_) match {
  case true => 1
  case false => 0
}).sum

/*
funciones
sum
product
map
forall
-
max
min
size
exists
filter: devuelve una lista que contiene los valores que cumplen con el predicado
takeWhile: trunca la lista (recorta) cuando encuentra un valor que no cumple con el predicado
*/

val numbers2 = List(6,28,15,12,11,24)
numbers2.max
numbers2.min
numbers2.size

//predicado: funciones que devuelven un boolean

def isPrime2(nro : Int) : Boolean = !(2 until nro).exists(nro % _ == 0)
isPrime(6)

List(1,2,3,4,5).filter(k => k % 3 != 0)
List(1,2,3,4,5).takeWhile(k => k % 3 != 0)

// map/reduce
// transformar, una funcion toma una lista y devuelve otra
//            funciones: map, filter, etc
// agregar, toma una lista y devuelve un unico valor
//        funcinoes: max, sum, etc
// escribir programas que concatenan transfomaciones y agregaciones se conocen como programacion map/reduce


//dada una lista de numeros enteros, desarrollar las funciones necesarias que permitan contar
// el numero de elementos de la lista que son numeros perfectos, deficientes o abundantes



val numeros = List(6,28,15,12,11,24)
val sumDiv = (n : Int) => (1 until n).filter(div => n % div == 0).sum

numeros.filter(nro => nro == sumDiv(nro)).size
numeros.filter(nro => nro < sumDiv(nro)).size
numeros.filter(nro => nro > sumDiv(nro)).size

//factorial escalonado(funcion de agregacion)
def factorialEscalonado(n : Int ) : Int = {
  n % 2 match {
    case 0 => (2 to n by 2).product
    case _ => (1 to n by 2).product
  }
}
factorialEscalonado(8)
factorialEscalonado(9)

//contar pares e impares
val numbers5 = (1 to 20).toList

numbers5.filter(nro => nro % 2 == 0).size
numbers5.count(nro => nro % 2 == 0)

numbers5.filter(nro => nro % 2 != 0).size
numbers5.count(nro => nro % 2 != 0)

//contar primos

def contarPrimos(nros : List[Int]) : Int = {
  val isPrime5 = (n : Int) => (2 until n).forall(n % _ != 0)
  //nros.count(isPrime5)
  nros.count(n => isPrime5(n))
}
contarPrimos(numbers5)

//presentar 3 factores
def tresFactores(nros: List[Int]) : List[Int] = {
  val factores = (n : Int) => (2 until n).filter(n % _ == 0)
  nros.filter(nro => factores(nro).size == 3)
}
tresFactores((1 to 1000).toList)