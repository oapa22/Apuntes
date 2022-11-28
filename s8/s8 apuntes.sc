//efectos colaterales
//las funciones no deberian tener efectos colaterales
//ejemplo de efecto colateral: (cambiar algo que este fuera)
int cont = 0;
void addOne() {
  cont = cont + 1;
}

//en lenguajes funcionales puros, en cada print se genera un nuevo estado
newState = print("hola") + oldState

//se considera que una funcion tiene efectos colaterales si:
//  modifica el valor de una variable o de una estructura de datos mutable
//  utiliza mecanismos de IO(entrada-salida: leer archivos, imprimir en pantalla)
//  lanza una excepcion
//  se detiene por error

//solucion a efectos colaterales
//EXCEPCIONES: dejar de usar efectos colaterales y codificarlos en el valor de retorno
//funcion con efectos colaterales
def division(n1: Double, n2: Double) =
  if(n2 == 0) throw new RuntimeException("División por 0")
  else n1 / n2
division(4, 0)

//funcion sin efectos colaterales
import scala.util.Try
def pureDivision(n1: Double, n2: Double): Try[Double] =
  Try{ division(n1, n2) }
pureDivision(5, 0)
//Try[Double] -> representa el error como estructura de datos
//               fenomenos representados como datos -> reificacion

val result = pureDivision(1, 3)
import scala.util.{Success, Failure}
result match {
  case Success(v) => println(v)
  case Failure(e) => println(e.getMessage)
}

//-option-some-none
//ejemplo en codigo java
String search(String id) {
  var students = List.of("1-Valencia", "2-Caicedo", "3-Galindez");
  for(var student : students) {
    if( student.startsWith(id) ) {
      return student;
    }
  }
  return null;
}

String split(String student) {
  student.split("-")[1];
}

split(search("1"))

//ejemplo scala
def toInt(s: String) : Option[Int] = {
  try {
    Some(Integer.parseInt(s))
  } catch {
    case e: Exception => None
  }
}

toInt("1")
toInt("Uno")
val txtNumbers = List("1", "2", "foo", "3", "bar")
txtNumbers.map(toInt)
txtNumbers.map(toInt).flatten//flatten quita some y los failure

//scala alternativa option
//si tiene la tentacion de usar un valor nulo piense en option
//option: representacion de valoers opcionales
//  posibles valoers instacias de:
//    some: se genera el valor existe
//    none: se genera el valor cuando no existe
def toInt21(s: String) : Option[Int] = {
  try {
    Some(Integer.parseInt(s))
  } catch {
    case e: Exception => None
  }
}
//otra forma
import scala.util.control.Exception._
def toInt2(s: String) : Option[Int] = allCatch.opt(s.toInt2)

//obtener valoers: getOrElse, foreach, match
val x = toInt("1").getOrElse(0)
toInt("1").foreach{ i => printf("Obtener un Int:%d", i)}
toInt("1") match {
  case Some(i) => println(i)
  case None => println("That didn't work.")
}

//-either/left/right
//el valor que se quiere obtener va a la derecha
def divideXByY(x: Int, y: Int): Either[String, Int] =
  if(y == 0) Left("No se puede dividir por 0")
  else Right(x / y)

val x = divideXByY(1, 1).right.getOrElse(0)
val x = divideXByY(1, 0).right.getOrElse(0)

divideXByY(1, 0) match {
  case Left(s) => println("Answer: " + s)
  case Right(i) => println("Answer: " + i)
}

val x = divideXByY(1, 0)
x.isLeft
x.left












