/**
 *   Games development project.
 *
 *   Creator: Gergana Kuleva Dimitrova
 *
 */
package com.game.rest;

import com.game.domain.GameContextFactory;
import com.game.domain.Player;
import com.game.domain.GameContext;
import com.game.domain.GameStatus;
import com.game.rest.message.CreateGame;
import com.game.rest.message.CreateGameResponse;
import com.game.rest.message.StatusInvitationResponse;
import com.game.rest.message.JoinGame;
import com.game.rest.message.JoinGameResponse;
import com.game.rest.message.StatusInvitationRequest;
import java.util.ArrayList;
import java.util.UUID;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author gdimitrova
 */
@Path("/game/invitation")
public class GameInvitationService extends AbstractRestService {
    
    @POST
    @Path("/create")
    public Response create(CreateGame req) {
        String playerId = UUID.randomUUID().toString();
        GameContext ctx = GameContextFactory.INSTANCE.make(playerId, new Player(req.getInviterPlayerName()));
        String id = UUID.randomUUID().toString();
        getGameContextsCtx().put(id, ctx);
        CreateGameResponse rsp = new CreateGameResponse();
        rsp.setGameId(id);
        rsp.setInviterId(playerId);
        return Response.ok(rsp).build();
    }
    
    @POST
    @Path("/join")
    public Response join(JoinGame req) {
        GameContext ctx = getGameContextsCtx().get(req.getGameId());
        String id = UUID.randomUUID().toString();
        ctx.addPlayer(id, new Player(req.getInvitedPlayerName()));
        JoinGameResponse rsp = new JoinGameResponse();
        rsp.setInviter(ctx.getInviter());
       // rsp.setInvited(new ArrayList<>(ctx.getInvited()));
        return Response.ok(rsp).build();
    }
    
    @POST
    @Path("/status")
    public Response getStatus(StatusInvitationRequest req) {
        GameContext ctx = getGameContextsCtx().get(req.getGameId());
        StatusInvitationResponse rsp = new StatusInvitationResponse();
        rsp.setInviter(ctx.getInviter());
       // rsp.setInvited(new ArrayList<>(ctx.getInvited()));
        rsp.setIsStartedGame(ctx.status == GameStatus.ACTIVE);
        return Response.ok(rsp).build();
    }
}
