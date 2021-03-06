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
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dv8tion.jda.core.managers;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

/**
 * The Presence associated with the provided JDA instance
 */
public interface Presence
{

    /**
     * The JDA instance of this Presence
     *
     * @return
     *      The current JDA instance
     */
    JDA getJDA();

    /**
     * The current OnlineStatus for this session.<br>
     * This might not be what the Discord Client displays due to session clashing!
     *
     * @return
     *      The {@link net.dv8tion.jda.core.OnlineStatus OnlineStatus} of the current session
     */
    OnlineStatus getStatus();

    /**
     * The current Game for this session.<br>
     * This might not be what the Discord Client displays due to session clashing!
     *
     * @return
     *      The {@link net.dv8tion.jda.core.entities.Game Game} of the current session
     */
    Game getGame();

    /**
     * Whether the current session is marked as afk or not
     *
     * @return
     *      true if this session is marked as afk
     */
    boolean isIdle();

    /**
     * Sets the {@link net.dv8tion.jda.core.OnlineStatus OnlineStatus} for this session
     *
     * @param status
     *      the {@link net.dv8tion.jda.core.OnlineStatus OnlineStatus} to be used (OFFLINE/null {@literal ->} INVISIBLE)
     * @throws IllegalArgumentException
     *      if the provided OnlineStatus is {@link net.dv8tion.jda.core.OnlineStatus#UNKNOWN UNKNOWN}
     */
    void setStatus(OnlineStatus status);

    /**
     * Sets the {@link net.dv8tion.jda.core.entities.Game Game} for this session
     *
     * @param game
     *      A {@link net.dv8tion.jda.core.entities.Game Game} instance or null to reset
     * @see net.dv8tion.jda.core.entities.Game#of(String)
     * @see net.dv8tion.jda.core.entities.Game#of(String, String)
     */
    void setGame(Game game);

    /**
     * Sets whether this session should be marked as afk or not
     *
     * @param idle
     *      boolean
     */
    void setIdle(boolean idle);

}
