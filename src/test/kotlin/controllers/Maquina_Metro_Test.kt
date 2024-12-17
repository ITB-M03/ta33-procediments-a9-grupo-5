package controllers

import org.example.controllers.NombreBillete
import org.example.controllers.calcularPreu
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class Maquina_Metro_Test {

@Test
 fun calculPreuTest1() {
  val esperat = 2.4
 val opcion1 = 2.4
 val opcion2 = 1
 assertEquals(esperat, calcularPreu(opcion1, opcion2))
 }
  @Test
  fun calculPreuTest2() {
   val esperat = 14.896875
   val opcion1 = 11.35
   val opcion2 = 2
   assertEquals(esperat, calcularPreu(opcion1, opcion2))
  }
  @Test
  fun calculPreuTest3() {
   val esperat = 147.544
   val opcion1 = 80.0
   val opcion2 = 3
   assertEquals(esperat, calcularPreu(opcion1, opcion2))
  }

  @Test
  fun nombreBilletTest1() {
   val esperat = "TCasual"
   val opcion1 = 2
   assertEquals(esperat, NombreBillete(opcion1))
  }

  @Test
  fun nombreBilletTest2() {
   val esperat = "TUsual"
   val opcion1 = 3
   assertEquals(esperat, NombreBillete(opcion1))
  }

  @Test
  fun nombreBilletTest3() {
   val esperat = "TJove"
   val opcion1 = 5
   assertEquals(esperat, NombreBillete(opcion1))
  }

}