package subtask3

class BillCounter {

    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val annaToPay = (bill.sum() - bill[k]) / 2
        val brianOwes = b - annaToPay
        if(0 == brianOwes){
            return "Bon Appetit"
        }
        return brianOwes.toString()
    }
}
