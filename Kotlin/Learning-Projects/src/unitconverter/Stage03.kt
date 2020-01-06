package unitconverter

import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter a number and a measure of length: ")
    val input = scanner.nextLine()
    val number = input.split(" ")[0].toDouble()
    val measure = input.split(" ")[1]

    val measurementType = MeasurementType.of(measure)
    val displayType = if(number == 1.0) measurementType.displayType.dropLast(1) else measurementType.displayType
    val result = number.times(measurementType.conversion)
    val resultMeasure = if (result == 1.0) "meter" else "meters"
    print("$number $displayType is $result $resultMeasure")
}

enum class MeasurementType(val types: List<String>, val conversion: Double, val displayType: String) {
    Meter(arrayListOf("m", "meter", "meters"), 1.0, "meters"),
    KM(arrayListOf("km", "kilometer", "kilometers"), 1000.0, "kilometers"),
    CM(arrayListOf("cm", "centimeter", "centimeters"), 0.01, "centimeters"),
    MM(arrayListOf("mm", "millimeter", "millimeters"), 0.001, "millimeters"),
    MI(arrayListOf("mi", "mile", "miles"), 1609.35, "miles"),
    YD(arrayListOf("yd", "yard", "yards"), 0.9144, "yards"),
    FT(arrayListOf("ft", "foot", "feet"), 0.3048, "feet"),
    IN(arrayListOf("in", "inch", "inches"), 0.0254, "inches");

    companion object {
        fun of(type: String): MeasurementType {
            return values().find { it.types.contains(type) } ?: throw IllegalArgumentException("Not Match")
        }
    }
}