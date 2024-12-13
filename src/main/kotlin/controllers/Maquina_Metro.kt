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
    cerrarScanner(scanner)
}
/**
 * Abre un nuevo objeto Scanner para leer la entrada estándar.
 *
 * @return Un nuevo objeto Scanner.
 */
fun abrirScanner(): Scanner {
    return Scanner(System.`in`)
}

/**
 * Cierra el objeto Scanner proporcionado.
 *
 * @param scanner El objeto Scanner a cerrar.
 */

fun cerrarScanner(scanner: Scanner) {
    scanner.close()
}


fun menu1(msg: String, scanner: Scanner):Int{
    println(msg)
    val opcion = scanner.nextInt()
    return opcion
}

fun menu2(opcion1:Int, msg:String, scanner:Scanner){
    println(msg)

}
