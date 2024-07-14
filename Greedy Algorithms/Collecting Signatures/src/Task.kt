import jdk.jfr.Event
import java.util.*

enum class EventType {START, END}

data class Segment(val l: Int, val r: Int)

fun segmentsCover(segments: List<Segment>): List<Int> {
    val cover = mutableListOf<Int>()
    val eq = segments
        .sortedBy { it.r } // sort by end time
        .toMutableList()

    // sort by end time
    while (eq.isNotEmpty()) {
        val segment = eq.removeFirst()
        // remove all segments that are covered
        eq.removeAll { segment.r in it.l..it.r }
        // add end time to cover
        cover.add(segment.r)
    }

    return cover
}
