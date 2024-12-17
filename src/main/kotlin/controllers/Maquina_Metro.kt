package org.example.controllers

import java.util.*

fun main() {
    val scanner = abrirScanner()
    val opcion1 = menu1("Escull quin títol vols comprar: \n" +
            "(1) Bitllet senzill............2.40€ (1a zona) \n" +
            "(2) TCasual.................11.35€ (1a zona) \n" +
            "(3) TUsual...................40.00€ (1a zona) \n" +
            "(4) TFamiliar...............10.00€ (1a zona) \n" +
            "(5) TJove.....................80.00€ (1a zona)", scanner)

    val opcion2 = menu2(opcion1, "Escull en quina zona vols viatjar: \n"
        + "(1) Zona 1 \n(2) Zona 2 \n(3) Zona 3", scanner)

    menu3(opcion1, opcion2, scanner, compra = mutableListOf())

    cerrarScanner(scanner)
}
/**
 * Abre un nuevo objeto Scanner para leer la entrada estándar.
 * @author Anmolpreet Singh
 *
 * @return Un nuevo objeto Scanner.
 */
fun abrirScanner(): Scanner {
    return Scanner(System.`in`)
}

/**
 * Cierra el objeto Scanner proporcionado.
 * @author Anmolpreet Singh
 *
 * @param scanner El objeto Scanner a cerrar.
 */

fun cerrarScanner(scanner: Scanner) {
    scanner.close()
}

/**
 * Mostra el menú amb les opcions de compra i retorna l'opció seleccionada pel usuari.
 *@author Anmolpreet Singh
 *
 * @param msg El missatge que es mostra al menú.
 * @param scanner L'objecte [Scanner] utilitzat per llegir l'entrada de l'usuari.
 * @return L'opció seleccionada pel usuari com un [Int].
 */

fun menu1(msg: String, scanner: Scanner):Int{
    println(msg)
    val opcion = scanner.nextInt()
    return opcion
}

/**
 * Mostra el menú de selecció de zona i retorna l'opció seleccionada pel usuari.
 *@author Anmolpreet Singh
 *
 * @param opcion1 L'opció seleccionada prèviament al menú de bitllets.
 * @param msg El missatge que es mostra al menú.
 * @param scanner L'objecte [Scanner] utilitzat per llegir l'entrada de l'usuari.
 * @return L'opció de zona seleccionada com un [Int].
 */

fun menu2(opcion1:Int, msg:String, scanner:Scanner): Int{
    println(msg)
    val opcionZona = scanner.nextInt()
    return opcionZona
}

/**
 * Gestiona el flux de compra, on l'usuari pot seleccionar diversos bitllets i zones.
 * El procés continua fins que l'usuari decideixi no seguir comprant o es superi el límit d'intents.
 *@author Anmolpreet Singh
 *
 * @param opcion1 L'opció de bitllet seleccionada per l'usuari.
 * @param opcion2 La zona seleccionada per l'usuari.
 * @param scanner L'objecte [Scanner] utilitzat per llegir l'entrada de l'usuari.
 * @param compra La llista mutable que emmagatzema les compres realitzades.
 */

fun menu3(opcion1: Int, opcion2: Int, scanner: Scanner, compra:MutableList<String>){
    var intento = 0
    var seguir = true
    var opcionOriginal = opcion1
    var zonaOriginal = opcion2
    var preuFinal = 0.0
        while (seguir && intento < 2) {
            println("Has escollit la opcio: ${NombreBillete(opcionOriginal)}, zona $zonaOriginal")
            val preu = mostrarPreu(opcionOriginal, zonaOriginal)
            preuFinal += preu
            compra.add("${NombreBillete(opcionOriginal)} zona $zonaOriginal - Preu: ${"%.2f".format(preu)}€")

            println("Vols seguir comprant? [S,N]")
            scanner.nextLine()
            val opcion3 = scanner.nextLine().uppercase()

            if (opcion3 == "S") {
                menuSeguir(opcionOriginal, zonaOriginal)
                opcionOriginal = scanner.nextInt()
                scanner.nextLine()
                menuSegui2(opcionOriginal, zonaOriginal)

                zonaOriginal = scanner.nextInt()
                intento++
                seguir = true
            } else {
                seguir = false
            }
        }
    compra(preuFinal,compra)
    }

/**
 * Mostra el preu del bitllet basat en l'opció de bitllet i la zona seleccionada pel usuari.
 *@author Anmolpreet Singh
 *
 * @param opcion L'opció de bitllet seleccionada pel usuari.
 * @param zona La zona seleccionada pel usuari.
 * @return El preu calculat per al bitllet en funció de la zona seleccionada.
 */

fun mostrarPreu(opcion: Int, zona: Int):Double {
    val preu = when (opcion) {
        1 -> calcularPreu(2.40, zona) // Bitllet senzill
        2 -> calcularPreu(11.35, zona) // TCasual
        3 -> calcularPreu(40.00, zona) // TUsual
        4 -> calcularPreu(10.00, zona) // TFamiliar
        5 -> calcularPreu(80.00, zona) // TJove
        else -> 0.0
    }
    println("El preu del bitllet és ${"%.2f".format(preu)}€")
    return preu
}

/**
 * Calcula el preu final d'un bitllet basat en el preu base i la zona seleccionada.
 *@author Anmolpreet Singh
 *
 * @param preuBase El preu base del bitllet.
 * @param zona La zona seleccionada pel usuari.
 * @return El preu calculat en funció de la zona seleccionada.
 */

fun calcularPreu(preuBase: Double, zona: Int): Double {
    return when (zona) {
        1 -> preuBase
        2 -> preuBase * 1.3125
        3 -> preuBase * 1.8443
        else -> preuBase
    }
}

/**
 * Retorna el nom del bitllet basat en l'opció seleccionada pel usuari.
 *@author Anmolpreet Singh
 *
 * @param opcion L'opció seleccionada pel usuari.
 * @return El nom del bitllet corresponent a l'opció seleccionada.
 */

fun NombreBillete(opcion: Int): String {
    return when (opcion) {
        1 -> "Bitllet senzill"
        2 -> "TCasual"
        3 -> "TUsual"
        4 -> "TFamiliar"
        5 -> "TJove"
        else -> "Desconegut"
    }
}

/**
 * Mostra el menú d'opcions per seguir comprant un bitllet.
 *@author Anmolpreet Singh
 *
 * @param opcion1 L'opció de bitllet seleccionada prèviament.
 * @param opcion2 La zona seleccionada prèviament.
 */

fun menuSeguir(opcion1: Int, opcion2: Int){
    println("Escull quin títol vols comprar: \n" +
            "(1) Bitllet senzill............2.40€ (1a zona) \n" +
            "(2) TCasual.................11.35€ (1a zona) \n" +
            "(3) TUsual...................40.00€ (1a zona) \n" +
            "(4) TFamiliar...............10.00€ (1a zona) \n" +
            "(5) TJove.....................80.00€ (1a zona)")
}

/**
 * Mostra el menú de selecció de zona on l'usuari pot escollir entre diverses opcions.
 *@author Anmolpreet Singh
 *
 * @param opcion1 L'opció de bitllet seleccionada prèviament.
 * @param opcion2 La zona seleccionada prèviament.
 */

fun menuSegui2(opcion1: Int, opcion2: Int){
    println("Escull en quina zona vols viatjar: \n(1) Zona 1 \n(2) Zona 2 \n(3) Zona 3")
}

/**
 * Gestiona el pagament del bitllet, sol·licitant a l'usuari l'ingrés de monedes o bitllets fins a cobrir el total.
 *@author Anmolpreet Singh
 *
 * @param preuFinal El preu total que l'usuari ha de pagar per la seva compra.
 */


fun compra(preuFinal:Double, compra: MutableList<String>){
    println("El preu final de la compra és ${"%.2f".format(preuFinal)}€")
    var monedes = 0.0
    var totalPagat = 0.0
    while (totalPagat < preuFinal) {
        println("Introdueix monedes o billets valids d'EURO:")
        val input = readLine()?.toDoubleOrNull()
        if (input != null) {
            monedes += input
            totalPagat = monedes
            println("Has introduït ${"%.2f".format(input)}€, et resta per pagar ${"%.2f".format(preuFinal - totalPagat)}€")
        } else {
            println("Entrada no vàlida, si us plau introdueix un valor numèric.")
        }
    }
    val canvi = totalPagat - preuFinal
    println("Reculli el seu bitllet i el seu canvi: ${"%.2f".format(canvi)}€")
    println("Vols el tiquet [S,N]?")
    val tiquet = readLine()?.uppercase()
    if (tiquet == "S") {
        mostrarTiquet(compra, preuFinal)
    } else {
        println("Adeu!!")
    }
}

/**
 * Mostra el tiquet final amb les compres realitzades i el preu total.
 * @author Anmolpreet Singh
 *
 * @param compra La llista de compres realitzades per l'usuari.
 * @param preuFinal El preu total de la compra.
 */

fun mostrarTiquet(compra: MutableList<String>, preuFinal: Double) {
    println("-----TIQUET-----")
    for (item in compra) {
        println(item) // Imprime todas las compras realizadas
    }
    println("-----------------")
    println("El preu total és ${"%.2f".format(preuFinal)}€")
    println("Recull el teu tiquet.")
    println("Adeu!!")
}