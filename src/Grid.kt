/**
 * Created by missingdays on 04.12.16.
 */

package ja.grid

import ja.generator.Figure
import ja.generator.Size

import java.util.*

val cellSize = 40
val cellOffset = 60

class Grid {

    val cells : MutableList<MutableList<Figure>>

    constructor(size : Size){
        cells = ArrayList()

        for(i in 0..size.height){
            cells.add(ArrayList())

            for(j in 0..size.width){
                val c = Cell(i, j)

                c.size = Size(cellSize, cellSize)

                cells[i].add(c)
            }
        }
    }

    operator fun get(i : Int, j : Int) : Figure {
        return cells[i][j]
    }

    operator fun set(i : Int, j : Int, fig: Figure){
        cells[i][j] = fig
    }

    fun toFlatList() : MutableList<Figure>{
        val l = ArrayList<Figure>()

        for(column in cells){
            for(cell in column){
                l.add(cell)
            }
        }

        return l
    }
}