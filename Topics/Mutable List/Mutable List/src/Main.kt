fun names(namesList: List<String>) =
    namesList.groupBy { it }.entries
        .map { "The name ${it.key} is repeated ${it.value.size} times" }