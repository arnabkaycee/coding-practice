data class Account(val accountId: String, val balance: Int, val totalWithdrawn: Int) : Comparable<Account> {
    override fun compareTo(other: Account): Int {
        return if (this.totalWithdrawn == other.totalWithdrawn)
            this.accountId.compareTo(other.accountId)
        else other.totalWithdrawn.compareTo(this.totalWithdrawn)
    }

    override fun toString(): String {
        return "${accountId}($totalWithdrawn)"
    }

}


val k = sortedSetOf<Account>()

fun main() {
    val accs = listOf(
        Account("acc31", 200, 20),
        Account("acc21", 344, 300),
        Account("acc87", 344, 300),
        Account("acc85", 344, 33),
        Account("acc79", 344, 33),
        Account("acc74", 344, 33)
    )

    k.addAll(accs)
    println(k)
}
