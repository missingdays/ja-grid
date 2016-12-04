/**
 * Created by missingdays on 02.12.16.
 */

package ja.grid

import java.io.File
import ja.generator.*

fun main(args : Array<String>){
    val g = GridGenerator(Size(10, 10))

    for(i in 1..100) {
        g.currentCell(0, 0)
    }

    val j = g.toJSON().toString()

    File("example/simple.json").printWriter().use {
        it.print(j)
    }
}


