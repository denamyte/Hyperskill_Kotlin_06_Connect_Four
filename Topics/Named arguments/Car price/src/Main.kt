const val INIT_PRICE = 20000
const val DEFAULT_OLD = 5
const val DEFAULT_KM = 100_000
const val DEFAULT_SPEED = 120
const val DEFAULT_AUTO = false

const val YEAR_DECREASE = 2000
const val SPEED_PRICE = 100
const val KM_AMOUNT = 10_000
const val KM_AMOUNT_PRICE = 200
const val AUTOMATIC_PRICE = 1500

fun carPrice(
    old: Int = DEFAULT_OLD,
    kilometers: Int = DEFAULT_KM,
    maximumSpeed: Int = DEFAULT_SPEED,
    automatic: Boolean = DEFAULT_AUTO
) {
    print(
        INIT_PRICE -
            old * YEAR_DECREASE +
            (maximumSpeed - DEFAULT_SPEED) * SPEED_PRICE -
            kilometers / KM_AMOUNT * KM_AMOUNT_PRICE +
            if (automatic) AUTOMATIC_PRICE else 0
    )
}
