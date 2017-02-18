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

package net.dv8tion.jda.core.requests.restaction;

import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.requests.Route;
import org.apache.http.util.Args;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collection;

public class ChannelOrderAction<T extends Channel> extends OrderAction<T, ChannelOrderAction>
{
    protected final Guild guild;

    public ChannelOrderAction(Guild guild, boolean textChannels)
    {
        super(guild.getJDA(), Route.Guilds.MODIFY_CHANNELS.compile(guild.getId()));
        this.guild = guild;

        Collection chans = textChannels ? guild.getTextChannels() : guild.getVoiceChannels();
        this.orderList.addAll(chans);
    }

    public Guild getGuild()
    {
        return guild;
    }

    @Override
    protected void finalizeData()
    {
        JSONArray array = new JSONArray();
        for (int i = 0; i < orderList.size(); i++)
        {
            Channel chan = orderList.get(i);
            array.put(new JSONObject()
                    .put("id", chan.getId())
                    .put("position", i));
        }

        this.data = array;
    }

    @Override
    protected void validateInput(T entity)
    {
        Args.check(entity.getGuild().equals(guild), "Provided channel is not from this Guild!");
        Args.check(orderList.contains(entity), "Provided channel is not in the list of orderable channels!");
    }
}
