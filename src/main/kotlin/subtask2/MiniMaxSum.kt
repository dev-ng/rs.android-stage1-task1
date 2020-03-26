package subtask2

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {
        val sum = input.sum()
        return intArrayOf(sum - input.max()!!, sum - input.min()!!)
    }
}
