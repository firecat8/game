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
public class JoinGameResponse implements Serializable {

    private Player inviter;

    private List<Player> invited;

    private String joinedPlayerId;

    public JoinGameResponse() {
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

    public String getJoinedPlayerId() {
        return joinedPlayerId;
    }

    public void setJoinedPlayerId(String joinedPlayerId) {
        this.joinedPlayerId = joinedPlayerId;
    }

}
