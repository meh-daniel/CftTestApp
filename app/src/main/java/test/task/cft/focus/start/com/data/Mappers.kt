package test.task.cft.focus.start.com.data

import test.task.cft.focus.start.com.data.db.model.BinSW
import test.task.cft.focus.start.com.data.nw.model.BinNW
import test.task.cft.focus.start.com.domain.model.Bank
import test.task.cft.focus.start.com.domain.model.Bin
import test.task.cft.focus.start.com.domain.model.Country
import test.task.cft.focus.start.com.domain.model.NumberCard

internal  fun BinNW.toDomain(bin: String): Bin {
    return Bin(
        bank = Bank(
            city = bank?.city ?: "-",
            name = bank?.name ?: "-",
            phone = bank?.phone ?: "-",
            url = bank?.url ?: "-",
        ),
        brand = brand ?: "-",
        country = Country(
            alpha2 = country?.alpha2 ?: "-",
            currency = country?.currency ?: "-",
            emoji = country?.emoji ?: "-",
            latitude = country?.latitude ?: 0,
            longitude = country?.longitude ?: 0,
            name = country?.name ?: "-",
            numeric = country?.numeric ?: "-",
        ),
        number = NumberCard(
            length = number?.length ?: 0,
            luhn = number?.luhn ?: false,
            numberCard = bin
        ),
        prepaid = prepaid ?: false,
        scheme = scheme ?: "-",
        type = type ?: "-",
    )
}

internal fun List<BinSW>.toDomain(): List<Bin> {
    return map {
        Bin(
            bank = Bank(
                city = it.bankCity,
                name = it.bankName,
                phone = it.bankPhone,
                url = it.bankUrl
            ),
            brand = it.generalBrand,
            country = Country(
                alpha2 = it.countryAlpha2,
                currency = it.countryCurrency,
                emoji = it.countryEmoji,
                latitude = it.countryLatitude,
                longitude = it.countryLongitude,
                name = it.countryName,
                numeric = it.countryNumeric
            ),
            number = NumberCard(
                length = it.numberCardLength,
                luhn = it.numberCardLuhn,
                numberCard = it.numberCard
            ),
            prepaid = it.generalPrepaid,
            scheme = it.generalScheme,
            type = it.generalType,
        )
    }
}


internal fun Bin.toSW(numberCard: String): BinSW {
    return BinSW(
        bankCity = bank.city,
        bankName = bank.name,
        bankPhone = bank.phone,
        bankUrl = bank.url,
        generalBrand = brand,
        countryAlpha2 = country.alpha2,
        countryCurrency = country.currency,
        countryEmoji = country.emoji,
        countryLatitude = country.latitude,
        countryLongitude = country.longitude,
        countryName = country.name,
        countryNumeric = country.numeric,
        numberCardLength = number.length,
        numberCardLuhn = number.luhn,
        numberCard = numberCard,
        generalPrepaid = prepaid,
        generalScheme = scheme,
        generalType = type,
    )
}