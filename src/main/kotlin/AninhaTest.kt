fun main() {
    println("Olá Aninha. Tudo Bem?")

    println("Quantos anos você tem?")
    var anos = readLine()

    println("Você tem $anos")
    println("Eu tmb tenho $anos anos, a mesma idade que vc!")

    println("Até que número vc sabe contar?")
    var n = readLine()

    (1..n!!.toInt()).forEach {
        println(it)
    }
}