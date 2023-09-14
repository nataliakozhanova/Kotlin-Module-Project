class ScreenArchive(
    listOfElements: MutableList<Note> = ArrayList(),
    header: String = ""
) : ScreenForNamedElement<Note> (
    listOfElements = listOfElements,
    header = header,
    textForCommandReturn = UILiterals.TEXT_BACK,
    textForCommandNew = UILiterals.TEXT_NEW_NOTE,
    textForCommandOpen = UILiterals.TEXT_OPEN_NOTE,
    commandReturn = UILiterals.COMMAND_BACK,
    textForElementNotExist = UILiterals.TEXT_NOTE_NOT_EXIST,
    textForNewElement = UILiterals.TEXT_NEW_NOTE_NAME,
    textForNewElementNameInput = UILiterals.TEXT_NEW_NOTE_NAME_INPUT,
    textForNewElementNameWarning = UILiterals.TEXT_NEW_NOTE_NAME_WARNING
        )
{
    override fun newElementWithProperties(name: String) {
            val nameNew: String = name
            println(UILiterals.TEXT_NEW_NOTE_TEXT_INPUT)
            val userInput: String = scanner.nextLine()
            if (userInput == "") {
                println(UILiterals.TEXT_NEW_NOTE_TEXT_WARNING)
            } else {
                val textNew: String = userInput
                val newNote = Note(name = nameNew, text = textNew)
                listOfElements.add(newNote)
            }
        }



    override fun openElement(number: Int) {
        for (i in listOfElements.indices) if (i == number) {
            println("Просмотр заметки \"${listOfElements[i].name}\":")
            println(listOfElements[i].text)
            println(UILiterals.TEXT_BACK)
            scanner.nextLine()
            return
        }
    }
}
