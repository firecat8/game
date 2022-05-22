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
public class StatusInvitationRequest extends GameRequest {

    private String gameId;

    private String invitedPlayerId;

    public StatusInvitationRequest() {
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getInvitedPlayerId() {
        return invitedPlayerId;
    }

    public void setInvitedPlayerId(String invitedPlayerId) {
        this.invitedPlayerId = invitedPlayerId;
    }

}
