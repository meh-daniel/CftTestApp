package test.task.cft.focus.start.com.domain.model

data class Bin(
    val bank: Bank,
    val brand: String,
    val country: Country,
    val number: NumberCard,
    val prepaid: Boolean,
    val scheme: String,
    val type: String,
)