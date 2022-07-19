import java.lang.NumberFormatException

fun main() {

}

fun squareAndDouble(x: Int) = double(square(x))

fun square(x: Int) = x * x

fun double(x: Int) = x * 2

fun addOneAndLong(x: Int): Pair<Int, String> {
    val result = x + 1
    return result to "my result is: $result"
}

fun strToInt(str: String) = str.toInt()

fun strToIntOrNull(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

fun strToIntResult(str: String): Result<Int> {
    return try {
        Result.success(str.toInt())
    } catch (e: NumberFormatException) {
        Result.failure(e)
    }
}