package aoc

import java.io.File

class Day1 {
    companion object {
        private fun getInput(): CharArray = File("input/day1.txt").readLines()[0].toCharArray()

        fun part1() {
            val matchedDigitsSum = findSumOfMatchingDigitsWithIndexOffset(getInput(), 1)

            println("$matchedDigitsSum is the sum of digits that matched.")
        }

        fun part2() {
            val input = getInput()
            val halfListLength = input.size / 2
            val matchedDigitsSum = findSumOfMatchingDigitsWithIndexOffset(input, halfListLength)

            println("$matchedDigitsSum is the sum of digits that matched.")
        }

        private fun findSumOfMatchingDigitsWithIndexOffset(input: CharArray, offset: Int): Int {
            var matchedDigitsSum = 0

            input.forEachIndexed { index, i ->
                if (i == input[(index + offset) % input.size]) {
                    matchedDigitsSum += (i.toInt() - '0'.toInt())
                }
            }

            return matchedDigitsSum
        }
    }
}
