package test.task.cft.focus.start.com.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = BinSW.TABLE_NAME
)
data class BinSW(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0,
    @ColumnInfo(name = "number_card")
    val numberCard: String,
    @ColumnInfo(name = "number_card_length")
    val numberCardLength: Int,
    @ColumnInfo(name = "number_card_luhn")
    val numberCardLuhn: Boolean,
    @ColumnInfo(name = "general_scheme")
    val generalScheme: String,
    @ColumnInfo(name = "general_type")
    val generalType: String,
    @ColumnInfo(name = "general_brand")
    val generalBrand: String,
    @ColumnInfo(name = "general_prepaid")
    val generalPrepaid: Boolean,
    @ColumnInfo(name = "country_numeric")
    val countryNumeric: String,
    @ColumnInfo(name = "country_alpha2")
    val countryAlpha2: String,
    @ColumnInfo(name = "country_name")
    val countryName: String,
    @ColumnInfo(name = "country_emoji")
    val countryEmoji: String,
    @ColumnInfo(name = "country_currency")
    val countryCurrency: String,
    @ColumnInfo(name = "country_latitude")
    val countryLatitude: Int,
    @ColumnInfo(name = "country_longitude")
    val countryLongitude: Int,
    @ColumnInfo(name = "bank_name")
    val bankName: String,
    @ColumnInfo(name = "bank_url")
    val bankUrl: String,
    @ColumnInfo(name = "bank_phone")
    val bankPhone: String,
    @ColumnInfo(name = "bank_city")
    val bankCity: String,
) {
    companion object {
        const val TABLE_NAME = "bin"
    }
}