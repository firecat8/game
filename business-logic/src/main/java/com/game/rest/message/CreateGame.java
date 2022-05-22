/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.rest.message;

import com.game.domain.Games;

/**
 *
 * @author gdimitrova
 */
public class CreateGame extends GameRequest {

    private Games game;
    private String inviterPlayerName;

    public CreateGame() {
    }

    public CreateGame(Games game, String inviterPlayerName) {
        this.game = game;
        this.inviterPlayerName = inviterPlayerName;
    }

    public Games getGame() {
        return game;
    }

    public void setGame(Games game) {
        this.game = game;
    }

    public String getInviterPlayerName() {
        return inviterPlayerName;
    }

    public void setInviterPlayerName(String inviterPlayerName) {
        this.inviterPlayerName = inviterPlayerName;
    }

    
}
