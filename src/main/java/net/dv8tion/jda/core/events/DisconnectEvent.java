/*
 *     Copyright 2015-2016 Austin Keener & Michael Ritter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package net.dv8tion.jda.core.events;

import com.neovisionaries.ws.client.WebSocketFrame;
import net.dv8tion.jda.core.JDA;

import java.time.OffsetDateTime;

/**
 * <b><u>DisconnectEvent</u></b><br>
 * Fired if our connection to the WebSocket was disrupted.<br>
 * <br>
 * Use: Reconnect manually or stop background threads that need fired events to function properly.
 */
public class DisconnectEvent extends Event
{
    protected final WebSocketFrame serverCloseFrame;
    protected final WebSocketFrame clientCloseFrame;
    protected final boolean closedByServer;
    protected final OffsetDateTime disconnectTime;

    public DisconnectEvent(JDA api, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer,
                           OffsetDateTime disconnectTime)
    {
        super(api, -1);
        this.serverCloseFrame = serverCloseFrame;
        this.clientCloseFrame = clientCloseFrame;
        this.closedByServer = closedByServer;
        this.disconnectTime = disconnectTime;
    }

    public WebSocketFrame getServiceCloseFrame()
    {
        return serverCloseFrame;
    }

    public WebSocketFrame getClientCloseFrame()
    {
        return clientCloseFrame;
    }

    public boolean isClosedByServer()
    {
        return closedByServer;
    }

    public OffsetDateTime getDisconnectTime()
    {
        return disconnectTime;
    }
}
