package ru.rpuxa.strategy.core.implement.builders

import ru.rpuxa.core.implement.builders.FieldBuilder
import ru.rpuxa.strategy.core.implement.game.players.Human
import ru.rpuxa.strategy.core.implement.game.servers.InternalServer
import ru.rpuxa.strategy.core.interfaces.field.MutableField
import ru.rpuxa.strategy.core.interfaces.visual.FieldVisualizer
import ru.rpuxa.core.others.CYAN

/**
 *  Строитель игр. Создаёт сервер по определённому шаблону
 */
class ServerBuilder(private var visual: FieldVisualizer, private var board: MutableField? = null) {

    init {
        if (board == null)
            board = FieldBuilder.rectangle(10, 5)
    }

    /**
     * Шаблон для дебага. Никого нет кроме 1 человека
     */
    fun alone(): InternalServer {
        val game = InternalServer(board!!)
        val human = Human(game, game.field, CYAN, visual)
        game.players = arrayOf(human)
        visual.setControllingHuman(human)
        return game
    }
}
