/*
Copyright (c) Microsoft Open Technologies, Inc.
All Rights Reserved
See License.txt in the project root for license information.
*/

package microsoft.aspnet.signalr.client.hubs;

import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

import microsoft.aspnet.signalr.client.Action;

/**
 * Represents a subscription to a message
 */
public class Subscription {
    private final List<Action<JsonElement[]>> mReceived = new ArrayList<Action<JsonElement[]>>();

    /**
     * Triggers the "Received" event
     *
     * @param data Event data
     * @throws Exception
     */
    void onReceived(JsonElement[] data) throws Exception {
        for (Action<JsonElement[]> handler : mReceived) {
            handler.run(data);
        }
    }

    /**
     * Add a handler to the "Received" event
     *
     * @param received Event handler
     */
    public void addReceivedHandler(Action<JsonElement[]> received) {
        mReceived.add(received);
    }
}
