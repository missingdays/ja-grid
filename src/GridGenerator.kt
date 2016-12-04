/**
 * Created by missingdays on 04.12.16.
 */

package ja.grid

import ja.generator.*
import java.awt.Color
import java.util.*
import org.json.*

var emptyCellOption = CellOption(Color.white)
var occupiedCellOption = CellOption(Color.black)
var queueCellOption = CellOption(Color.orange)
var currentCellOption = CellOption(Color.green)
var visitedCellOption = CellOption(Color.pink)

class GridGenerator : VisualGenerator{
    val size : Size

    val log : HashMap<Long, Event> = HashMap()
    val currentGrid : Grid

    var currentTick : Long = 0

    constructor(size : Size){
        this.size = size

        currentGrid = Grid(size)
    }

    override fun toJSON() : JSONObject {
        val obj = JSONObject()

        val events = JSONArray()
        for((tick, event) in log){

            val currentCell: Cell = event.figure as Cell
            currentGrid[currentCell.xIndex, currentCell.yIndex] = currentCell

            val grid = currentGrid.toFlatList()

            for (cell in grid) {
                events.put(Event(tick, cell).toJSON())
            }
        }

        obj.put("data", events)

        return obj
    }

    fun addCell(cell : Cell){
        addEvent(Event(currentTick, cell))
    }

    fun fillCell(x : Int, y : Int, option : CellOption){
        addEvent(Event(currentTick, Cell(x, y, option)))
    }

    fun emptyCell(x : Int, y : Int){
        fillCell(x, y, emptyCellOption)
    }

    fun queueCell(x : Int, y : Int){
        fillCell(x, y, queueCellOption)
    }

    fun visitedCell(x : Int, y : Int){
        fillCell(x, y, visitedCellOption)
    }

    fun occupyCell(x : Int, y : Int){
        fillCell(x, y, occupiedCellOption)
    }

    fun currentCell(x : Int, y : Int){
        fillCell(x, y, currentCellOption)
    }

    private fun addEvent(e : Event){
        log.put(currentTick, e)
        currentTick++
    }

}