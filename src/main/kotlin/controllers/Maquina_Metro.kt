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

    menu3(opcion1, opcion2, scanner)

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
fun menu3(opcion1: Int, opcion2: Int, scanner: Scanner){
    var intento = 0
    var seguir = true
    var opcionOriginal = opcion1
    if(intento in 0..3) {
        while (seguir) {
            when (opcionOriginal) {
                1 -> billetSenzill(opcion1, opcion2, "Has escollit la opcio: billet Senzill, zona $opcion2")
                2 -> billetCasual(opcion1, opcion2, "Has escollit la opcio: TCasual, zona $opcion2 ")
                3 -> billetUsual(opcion1, opcion2, "Has escollit la opcio: TUsual, zona $opcion2 ")
                4 -> billetFamiliar(opcion1, opcion2, "Has escollit la opcio: TFamiliar, zona $opcion2 ")
                5 -> billetJove(opcion1, opcion2, "Has escollit la opcio: TJove, zona $opcion2")
            }
            println("Vols seguir comprant? [S,N]")
            val opcion3 = scanner.nextLine()
            if (opcion3 == "S") {
                menuSeguir(opcion1, opcion2)
                opcionOriginal = scanner.nextInt()
                intento++
                seguir = true
            } else {
                seguir = false
            }
        }
    }
}

fun menuSeguir(opcion1: Int, opcion2: Int){
    println("Escull quin títol vols comprar: \n" +
            "(1) Bitllet senzill............2.40€ (1a zona) \n" +
            "(2) TCasual.................11.35€ (1a zona) \n" +
            "(3) TUsual...................40.00€ (1a zona) \n" +
            "(4) TFamiliar...............10.00€ (1a zona) \n" +
            "(5) TJove.....................80.00€ (1a zona)")
}

fun billetSenzill(opcion1: Int, opcion2: Int, msgS:String):Double{
    println(msgS)
    var preuS = 0.0
    if(opcion2 == 1){
        preuS += 2.40
    } else if(opcion2 == 2){
        preuS += (2.40*1.3125)
    } else if(opcion2 == 3){
        preuS += (2.40*1.8443)
    }
    println("El preu del billet es $preuS €")
    return preuS
}

fun billetCasual(opcion1: Int, opcion2: Int, msgC:String):Double{
    println(msgC)
    var preuC = 0.0
    if(opcion2 == 1){
        preuC += 11.35
    } else if(opcion2 == 2){
        preuC += (11.35*1.3125)
    } else if(opcion2 == 3){
        preuC += (11.35*1.8443)
    }
    println(preuC)
    return preuC
}

fun billetUsual(opcion1: Int, opcion2: Int, msgU:String):Double{
    println(msgU)
    var preuU = 0.0
    if(opcion2 == 1){
        preuU += 40.00
    } else if(opcion2 == 2){
        preuU += (40*1.3125)
    } else if(opcion2 == 3){
        preuU += (40*1.8443)
    }
    println(preuU)
    return preuU
}
fun billetFamiliar(opcion1: Int, opcion2: Int, msgF:String):Double{
    println(msgF)
    var preuF = 0.0
    if(opcion2 == 1){
        preuF += 10.00
    } else if(opcion2 == 2){
        preuF += (10*1.3125)
    } else if(opcion2 == 3){
        preuF += (10*1.8443)
    }
    println(preuF)
    return preuF
}
fun billetJove(opcion1: Int, opcion2: Int, msgJ:String):Double{
    println(msgJ)
    var preuJ = 0.0
    if(opcion2 == 1){
        preuJ += 80.00
    } else if(opcion2 == 2){
        preuJ += (80*1.3125)
    } else if(opcion2 == 3){
        preuJ += (80*1.8443)
    }
    println(preuJ)
    return preuJ
}