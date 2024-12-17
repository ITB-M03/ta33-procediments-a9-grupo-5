package controllers

import org.example.controllers.billetSenzill
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class Maquina_Metro_Test {

@Test
 fun billetSenzillTest() {
  val esperat = 2.4
 val opcion1 = 1
 val opcion2 = 1
 val msgS = " "
 assertEquals(esperat, billetSenzill(opcion1, opcion2, msgS))
 }
}