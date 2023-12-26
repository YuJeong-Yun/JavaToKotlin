package ch02.코드제어방법

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.NumberFormatException

class K_예외 {

    //////////////////// try catch finally 구문
    fun parseIntOrThorws(str: String): Int? {
        try {
            return str.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("주어진 ${str}은 숫자가 아닙니다")
        }
        // try-catch문도 코틀린에서 Expression으로 간주됨
        return try {
            str.toInt()
        } catch (e: NumberFormatException) {
            return null
        }
    }

    //////////////////// Checked Exception과 Unchecked Exception
    // 코틀린에서는 Checked Exception과 Unchecked Exception을 구분하지 않는다
    // 모두 Unchecked Exception라서 사실상 throws를 쓸 일이 없음
    // 자바라면 아래에서 IOException을 처리해야했지만 코틀린에서는 필요 없음
    fun readFile() {
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }


    //////////////////// try with resources
    // 코틀린에서는 try with resources가 없고 use를 사용함
    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }
}