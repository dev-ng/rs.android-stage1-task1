package subtask5

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val array = Array(digitString.length) {digitString[it].toString().toInt()}
        var operationsLeft = k
        var operationsPending = 0

        for (i in 0..n/2 - 1) {
            if (array[i] != array[n - i - 1]) {
                if (9 == array[i] || 9 == array[n - i - 1]) {
                    operationsLeft--
                    array[i] = 9
                    array[n - i - 1] = 9
                } else {
                    operationsPending++
                }
            }
        }

        if (operationsPending > operationsLeft) {
            return "-1"
        }

        for (i in 0..n/2 - 1) {
            if (9 == array[i]) {
                continue
            }

            val delta = operationsLeft - operationsPending

            if (array[i] == array[n - i - 1]) {
                if (delta > 1) {
                    array[i] = 9
                    array[n - i - 1] = 9
                    operationsLeft--
                    operationsLeft--
                }
            } else {
                if (delta > 0) {
                    array[i] = 9
                    array[n - i - 1] = 9
                    operationsLeft--
                    operationsLeft--
                    operationsPending--
                } else {
                    if (array[i] < array[n - i - 1]) {
                        array[i] = array[n - i - 1]
                    } else {
                        array[n - i - 1] = array[i]
                    }
                    operationsLeft--
                    operationsPending--
                }
            }
        }

        if (operationsLeft > 0 && 1 == n % 2) {
            array[n/2] = 9
        }

        return array.joinToString(separator = "")
    }
}
