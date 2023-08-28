fun solution(names: List<String>) =
    names.filterIndexed { i, _ -> i % 2 == 1 }
        .indexOfFirst { it.startsWith("T") } * 2 + 1