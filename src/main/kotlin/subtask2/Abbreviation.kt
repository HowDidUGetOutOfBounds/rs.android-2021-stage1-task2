package subtask2

import kotlin.reflect.KClass

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {

        val inputInUpper = a.toUpperCase()
        var inputCN = 0
        var outputCN = 0
        var next = false

        for (i in 1..b.length) {
            next = false
            while (!next) {
                if ((inputCN < inputInUpper.length) && (outputCN < b.length)) {

                    if (inputInUpper.get(inputCN) == b.get(outputCN)) {
                        outputCN++
                        inputCN++
                        next = true
                    } else {
                        inputCN++
                    }

                } else {
                    return "NO"
                }
            }
        }
        return "YES"
    }

}
