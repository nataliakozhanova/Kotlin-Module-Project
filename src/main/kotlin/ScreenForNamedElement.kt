import java.util.Scanner

open class ScreenForNamedElement<T : NamedElement>(
    var listOfElements: MutableList<T> = ArrayList(),
    var header: String = "h",
    var textForCommandReturn: String = "r",
    var textForCommandNew: String = "n",
    var textForCommandOpen: String = "o",
    var commandReturn: String = "r",
    var textForElementNotExist: String = "ne",
    var textForNewElement: String = "ne",
    var textForNewElementNameInput: String = "neni",
    var textForNewElementNameWarning: String = "nenw"
) {
    protected var scanner = Scanner(System.`in`)
    fun start() {
        while (true) {
            println(header)
            println(textForCommandNew)
            println(textForCommandReturn)
            if (!listOfElements.isEmpty()) {
                println(textForCommandOpen)
                for (i in listOfElements.indices) {
                    println("Номер $i - ${listOfElements[i].name}")
                }
            }
            val userInput: String = scanner.nextLine().uppercase()
            when (userInput) {
                commandReturn -> {
                    return
                }

                UILiterals.COMMAND_NEW -> createNew()
                else -> {
                    val elementNumber = userInput.toIntOrNull()
                    if (elementNumber == null || listOfElements.isEmpty()) {
                        println(UILiterals.TEXT_COMMAND_NOT_EXIST)
                    } else if ((elementNumber != null) && (elementNumber < 0 || elementNumber > listOfElements.size - 1) && (!listOfElements.isEmpty())) {
                        println(textForElementNotExist)
                    } else {
                        openElement(elementNumber)
                    }
                }
            }
        }

    }

    protected fun createNew() {
        while (true) {
            println(UILiterals.TEXT_BACK)
            println(textForNewElement)
            val userInput: String = scanner.nextLine().uppercase()
            when (userInput) {
                UILiterals.COMMAND_BACK -> {
                    return
                }

                UILiterals.COMMAND_NAME -> {
                    println(textForNewElementNameInput)
                    newElementName()
                }

                else -> println(UILiterals.TEXT_COMMAND_NOT_EXIST)
            }
        }
    }

    protected fun newElementName() {

        val userInput: String = scanner.nextLine()
        if (userInput == "") {
            println(textForNewElementNameWarning)
        } else {
            newElementWithProperties(userInput)
        }
    }


    protected open fun openElement(number: Int) {
        return
    }

    protected open fun newElementWithProperties(name : String) {
        return
    }
}