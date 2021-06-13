package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        val onlyRequredData = getRequredData(blockA, blockB)
        var resultInt: Int = 0
        var resultString: String = ""
        var resultDate: LocalDate


        val name = blockB.simpleName

        if (name == "String")
        {
            for(elem in onlyRequredData)
            {
                resultString += elem as String

            }
            return resultString
        }
        else if(name == "Int")
        {
            for(elem in onlyRequredData)
            {
                resultInt += elem as Int
            }
            return resultInt
        }
        else
        {
            var bufferDate: LocalDate
            bufferDate = onlyRequredData.get(0) as LocalDate
            for(elem in onlyRequredData)
            {
                if(elem as LocalDate > bufferDate)
                {
                    bufferDate = elem as LocalDate
                }
            }
            val simpleDateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy")
            return bufferDate.format(simpleDateFormat)
        }
    }

    fun getRequredData(blockA: Array<*>, blockB: KClass<*>): ArrayList<Any>{

        var data = ArrayList<Any>(blockA.size)

        for (elem in blockA)
        {
            if(blockB.isInstance(elem))
            {
                data.add(elem!!)
            }
        }

        return data
    }
}
