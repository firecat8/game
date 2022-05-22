/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.rest.message;

/**
 *
 * @author gdimitrova
 */
public class JoinGame extends GameRequest {

    private String gameId;

    private String invitedPlayerName;

    public JoinGame() {
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getInvitedPlayerName() {
        return invitedPlayerName;
    }

    public void setInvitedPlayerName(String invitedPlayerName) {
        this.invitedPlayerName = invitedPlayerName;
    }


}
