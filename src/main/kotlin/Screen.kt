class Screen(
    listOfElements: MutableList<Archive> = ArrayList()
) : ScreenForNamedElement<Archive>(
    listOfElements = listOfElements,
    header = UILiterals.TEXT_HELLO,
    textForCommandReturn = UILiterals.TEXT_EXIT,
    textForCommandNew = UILiterals.TEXT_NEW_ARCHIVE,
    textForCommandOpen = UILiterals.TEXT_OPEN_ARCHIVE,
    commandReturn = UILiterals.COMMAND_EXIT,
    textForElementNotExist = UILiterals.TEXT_ARCHIVE_NOT_EXIST,
    textForNewElement = UILiterals.TEXT_NEW_ARCHIVE_NAME,
    textForNewElementNameInput = UILiterals.TEXT_NEW_ARCHIVE_NAME_INPUT,
    textForNewElementNameWarning = UILiterals.TEXT_NEW_ARCHIVE_NAME_WARNING
) {
    override fun newElementWithProperties(name: String) {

        val newArchive = Archive(name = name, notes = ArrayList())
        listOfElements.add(newArchive)
        return
    }


    override fun openElement(number: Int) {
        for (i in listOfElements.indices) if (i == number) {
            val textForScreenArchive = "Просмотр архива \"${listOfElements[i].name}\":"
            val newList: MutableList<Note> = listOfElements[i].notes
            val newScreenArchive = ScreenArchive(newList, textForScreenArchive)
            newScreenArchive.start()
        }
    }
}
