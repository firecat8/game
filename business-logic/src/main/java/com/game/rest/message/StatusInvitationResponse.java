/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.rest.message;

import com.game.domain.Player;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gdimitrova
 */
public class StatusInvitationResponse implements Serializable {

    private Player inviter;

    private List<Player> invited;

    private Boolean isStartedGame;

    public StatusInvitationResponse() {
    }

    public Player getInviter() {
        return inviter;
    }

    public void setInviter(Player inviter) {
        this.inviter = inviter;
    }

    public List<Player> getInvited() {
        return invited;
    }

    public void setInvited(List<Player> invited) {
        this.invited = invited;
    }

    public Boolean getIsStartedGame() {
        return isStartedGame;
    }

    public void setIsStartedGame(Boolean isStartedGame) {
        this.isStartedGame = isStartedGame;
    }


}
