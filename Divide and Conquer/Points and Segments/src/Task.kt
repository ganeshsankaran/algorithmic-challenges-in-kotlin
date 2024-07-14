

fun countSegmentsForEach(points: IntArray, segments: Array<Pair<Int, Int>>): IntArray {
    val segmentsSortedByStart = segments.sortedBy { it.first }
    val segmentsSortedByEnd = segments.sortedBy { it.second }

    return points
        .map { point ->
            val positionByStart = segmentsSortedByStart
                .binarySearchBy(point + 0.1) { it.first.toDouble() } // find first index which starts after pt
            val positionByEnd = segmentsSortedByEnd
                .binarySearchBy(point - 0.1) { it.second.toDouble() } // find first index which ends before pt

            val segmentsBefore = -1 * (1 + positionByEnd)
            val segmentsAfter = segments.size - (-1 * (1 + positionByStart))

            segments.size - (segmentsBefore + segmentsAfter)
        }
        .toIntArray()
}