package com.example.trainingmobiled20.data

data class Oder(
    val oderTime: String = "26 thg 3 2022, 18:10",
    val brand: String = "Brand${id++}",
    var rating: Double = (1..5).random().toDouble(),
    var note: String = "1 Nem Nướng Nha Trang, Size M, 1 Phở, 1 Nước Chấm",
    var sumMoney: Double = (20000..50000).random().toDouble(),
    var numberDish: Int = (1..10).random(),
    var savedMoney: Int = (10..30).random(),
    var canOder: Boolean = true,
) {
    companion object {
        private var id = 1
    }
}
