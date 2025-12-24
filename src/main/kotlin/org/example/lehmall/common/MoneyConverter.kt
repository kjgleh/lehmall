package org.example.lehmall.common

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import java.math.BigDecimal

@Converter(autoApply = false)
class MoneyConverter : AttributeConverter<Money, BigDecimal> {

    override fun convertToDatabaseColumn(attribute: Money?): BigDecimal? {
        return attribute?.amount
    }

    override fun convertToEntityAttribute(dbData: BigDecimal?): Money? {
        return dbData?.let { Money(it) }
    }
}
