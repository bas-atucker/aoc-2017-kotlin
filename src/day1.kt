package aoc

import java.io.File

class Day1 {
    companion object {
        private fun getInput(): CharArray = File("input/day1.txt").readLines()[0].toCharArray()

        fun part1() {
            val matchedDigitsSum = findSumOfMatchingDigitsWithIndexOffset(getInput(), 1)

            println("$matchedDigitsSum is the sum of digits that matched the next digit.")
        }

        fun part2() {
            val input = getInput()
            val halfListLength = input.size / 2
            val matchedDigitsSum = findSumOfMatchingDigitsWithIndexOffset(input, halfListLength)

            println("$matchedDigitsSum is the sum of digits that matched the digit halfway around the circular list.")
        }

        private fun findSumOfMatchingDigitsWithIndexOffset(input: CharArray, offset: Int): Int {
            return input.foldIndexed(0) { index, sum, digit ->
                if (digit == input[(index + offset) % input.size]) {
                    sum + digit.toString().toInt()
                } else {
                    sum
                }
            }
        }
    }
}
