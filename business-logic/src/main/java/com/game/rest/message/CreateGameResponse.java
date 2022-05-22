/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.rest.message;

import java.io.Serializable;

/**
 *
 * @author gdimitrova
 */
public class CreateGameResponse implements Serializable {

    private String inviterId;

    private String gameId;

    public CreateGameResponse() {
    }

    public String getInviterId() {
        return inviterId;
    }

    public void setInviterId(String inviterId) {
        this.inviterId = inviterId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
    
}
