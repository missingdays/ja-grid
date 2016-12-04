
package ja.grid

import ja.generator.Rectangle
import ja.generator.Size
import org.json.JSONObject
import java.awt.Color

class Cell : Rectangle{
    val option : CellOption

    val xIndex : Int
    val yIndex : Int

    constructor(xIndex : Int, yIndex : Int, option : CellOption = emptyCellOption){
        this.option = option

        this.xIndex = xIndex
        this.yIndex = yIndex

        this.x = xIndex * cellSize + cellOffset
        this.y = yIndex * cellSize + cellOffset

        this.fillColor = option.color

        this.size = Size(cellSize, cellSize)
    }

    override fun toJSON() : JSONObject{
        val obj = super.toJSON()

        obj.put("fillColor", option.color.rgb)
        obj.put("type", "rectangle")

        return obj
    }
}