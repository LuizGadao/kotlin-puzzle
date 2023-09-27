package algoExpert

fun main() {
    val competitions = listOf(
        listOf("HTML", "C#"),
        listOf("C#", "PYTHON"),
        listOf("PYTHON", "HTML")
    )

    val results = listOf(0, 0, 1)

    println(
        tournamentWinner(competitions, results)
    )

    val myHash = hashSetOf(2, 3, 5, 6, 3, 2)
    myHash.add(9)
    println("hash: ${myHash}")
}


fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    val teamsAndPoints = mutableMapOf<String, Int>()
    competitions.forEachIndexed { index, battle ->
        val homeTeam = battle[0]
        val awayTeam = battle[1]

        val resultBattle = results[index]

        if (teamsAndPoints.containsKey(homeTeam).not()) teamsAndPoints[homeTeam] = 0
        if (teamsAndPoints.containsKey(awayTeam).not()) teamsAndPoints[awayTeam] = 0


        val homePoints = teamsAndPoints[homeTeam]
        val awayPoints = teamsAndPoints[awayTeam]

        if (resultBattle == 0) {
            teamsAndPoints[awayTeam] = awayPoints!! + 3
        } else {
            teamsAndPoints[homeTeam] = homePoints!! + 3
        }
    }

    var max = 0
    var champion = ""
    teamsAndPoints.forEach { (key, value) ->
        if (value > max) {
            max = value
            champion = key
        }
    }

    return champion
}