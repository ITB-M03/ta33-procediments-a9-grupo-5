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
    billetSenzill(opcion1, opcion2)
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

fun menu2(opcion1:Int, msg:String, scanner:Scanner): Int{
    println(msg)
    val opcionZona = scanner.nextInt()
    return opcionZona
}

fun billetSenzill(opcion1: Int, opcion2: Int):Double{
    var preuS = 0.0
    if(opcion1 == 1 && opcion2 == 1){
        preuS += 2.40
    } else if(opcion1 == 1 && opcion2 == 2){
        preuS += (2.40*1.3125)
    } else if(opcion1 == 1 && opcion2 == 3){
        preuS += (2.40*1.8443)
    }
    println(preuS)
    return preuS
}

fun billetCasual(opcion1: Int, opcion2: Int):Double{
    var preuC = 0.0
    if(opcion1 == 1 && opcion2 == 1){
        preuC += 11.35
    } else if(opcion1 == 1 && opcion2 == 2){
        preuC += (11.35*1.3125)
    } else if(opcion1 == 1 && opcion2 == 3){
        preuC += (11.35*1.8443)
    }
    println(preuC)
    return preuC
}

fun billetUsual(opcion1: Int, opcion2: Int):Double{
    var preuU = 0.0
    if(opcion1 == 1 && opcion2 == 1){
        preuU += 40.00
    } else if(opcion1 == 1 && opcion2 == 2){
        preuU += (40*1.3125)
    } else if(opcion1 == 1 && opcion2 == 3){
        preuU += (40*1.8443)
    }
    println(preuU)
    return preuU
}
fun billetFamiliar(opcion1: Int, opcion2: Int):Double{
    var preuF = 0.0
    if(opcion1 == 1 && opcion2 == 1){
        preuF += 10.00
    } else if(opcion1 == 1 && opcion2 == 2){
        preuF += (10*1.3125)
    } else if(opcion1 == 1 && opcion2 == 3){
        preuF += (10*1.8443)
    }
    println(preuF)
    return preuF
}
fun billetJove(opcion1: Int, opcion2: Int):Double{
    var preuJ = 0.0
    if(opcion1 == 1 && opcion2 == 1){
        preuJ += 80.00
    } else if(opcion1 == 1 && opcion2 == 2){
        preuJ += (80*1.3125)
    } else if(opcion1 == 1 && opcion2 == 3){
        preuJ += (80*1.8443)
    }
    println(preuJ)
    return preuJ
}