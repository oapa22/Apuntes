//valor inmutable: se asigna el valor una unica vez y no va a cambiar
val cedula = "1108765321"
cedula = "1108765320"
// var: se puede cambiar el valor (variable, mutable)
var cedula2 = "1108765322"
cedula2 = "1108765323"

//funciones orden superior
//----------una funcion se puede asignar a un valor
//f(x) = -x^2 + 8x -12
(x : Double) => -Math.pow(x,2) + 8 * x - 12
val f1 = (x : Double) => -Math.pow(x,2) + 8 * x - 12
val f1Val = f1(12)
f1(12) * 9 / 8 + 3
((x : Double) => -Math.pow(x,2) + 8 * x - 12) (12) //otra manera de invocar

//----------una funcion se envia como parametro
// I=(integral:a-b) f(x) dx ; 3 PARAMETROS: a: limite inferior, b: limite superior, f(x)
// f(x) parametro: informacion que recibe (la x)
//      devuelve: cualquier tipo de dato, recomendable con double
//f(x) recible un double como parametro y devuelve (mapea =>) otro double
//   PARAMETROS:   1       2            3
def integracion(a: Int, b: Int, f: Double => Double) = {
  val intermedio = ((a+b) / 2.0)
  val fa = f(a)
  val fi = f(intermedio)
  val fb = f(b)
  (b-a) * (fa + 4 * fi + fb) / 6
}

//----------una funcion que devuelve una funcion
//calculadora para sumar numeros enteros
//       funcion         devuelve(tipo de dato)    funcion que recibe dos enteros y devuelve double
def select(option: Char)     :            (Int, Int) => Double = {
  option match {
  //devuelve una funcion que recibe como parametro: a, b y devuelve a + b
    case '+' => (a: Int, b: Int) => a + b
    case '-' => (a: Int, b: Int) => a - b
    case '*' => (a: Int, b: Int) => a * b
    case '/' => (a: Int, b: Int) => a / b
    case _ => (a: Int, b: Int) => 0 / (a+b)
    //case _ : default
  } // este codigo no ejecuta nada, solo devuelve una funcion con el codigo a ejecutarse
}

select('+')(2,1) //a la funcion que devuelve el select se le envian los parametros 2 y 1
val operation = select('+')
operation(2,1)

//-------------------------obtener datos de secuencias-----------
//de una lista de enteros cuales son pares
//[5,6,7,8,9]
// todos % 2
// residuo 1 = 0, residuo 0 = 1/
// sumatoria [0,1,0,1,0] = 2

// countEven(L) = sumatoria isEven(k)

//isEven funcion auxiliar, ayuidan a escribir facilmente la funcion countEve
// k = un numero de la lista
val isEven2 = (k: Int) => if(k % 2 == 0) 1 else 0

def isEven(k: Int) : Int = (k % 2) match {
  case 0 => 1
  case _ => 0
}
def countEven(s: List[Int] ) : Int = s.map(isEven).sum
countEven(List(5,6,7,8,9))

//una funcion dentro de una funcion (que define otra funcion)
countEven3(s2: List[Int]) : Int = {
  def isEven(k:Int): Int = (k % 2 ) match {
    case 0 => 1
    case _ => 0
  }
  s2.map(isEven).sum
}
countEven(List(5,6,7,8,9))

List(5,6,7,8,9).sum

//sum: un metodo calcula la suma de todos los numeros de la lista
//map: un metodo con una funcion como su segundo argumento y aplica esa funcion a
//     cada elemento de la lista y cada resultado lo ubica en una nueva lista
//map siempre devuelve una lista
List(1,2,3).map(x=> x * x + 100 * x)

def func1(x: Int) : Int = x * x + 100 * x
List(1,2,3).map(func1)

List(1,2,3) map func1

List(5,6,7,8,9).map(x => if(x%2==0) 1 else 0).sum

//ejemplos
val nums = List(1,2,3)
nums.map(x => x + 1)

def add1(a: Int) : Int = a+1
nums.map(add1)
nums.map(x => add1(x))
nums.map(add1(_))

val sumaDos = (a: Int, b: Int) => a+b
nums.map(x => sumaDos(x, x))
