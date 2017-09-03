/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameRequest;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.serializer.EzspSerializer;

/**
 * Class to implement the Ember EZSP command <b>sendManyToOneRouteRequest</b>.
 * <p>
 * Sends a route request packet that creates routes from every node in the network back to this
 * node. This function should be called by an application that wishes to communicate with many
 * nodes, for example, a gateway, central monitor, or controller. A device using this function
 * was referred to as an 'aggregator' in EmberZNet 2.x and earlier, and is referred to as a
 * 'concentrator' in the ZigBee specification and EmberZNet 3. This function enables large
 * scale networks, because the other devices do not have to individually perform
 * bandwidth-intensive route discoveries. Instead, when a remote node sends an APS unicast to
 * a concentrator, its network layer automatically delivers a special route record packet
 * first, which lists the network ids of all the intermediate relays. The concentrator can then
 * use source routing to send outbound APS unicasts. (A source routed message is one in which the
 * entire route is listed in the network layer header.) This allows the concentrator to
 * communicate with thousands of devices without requiring large route tables on neighboring
 * nodes. This function is only available in ZigBee Pro (stack profile 2), and cannot be called
 * on end devices. Any router can be a concentrator (not just the coordinator), and there can be
 * multiple concentrators on a network. Note that a concentrator does not automatically
 * obtain routes to all network nodes after calling this function. Remote applications must
 * first initiate an inbound APS unicast. Many-to-one routes are not repaired automatically.
 * Instead, the concentrator application must call this function to rediscover the routes as
 * necessary, for example, upon failure of a retried APS message. The reason for this is that
 * there is no scalable one-size-fits-all route repair strategy. A common and recommended
 * strategy is for the concentrator application to refresh the routes by calling this function
 * periodically.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspSendManyToOneRouteRequestRequest extends EzspFrameRequest {
    public static int FRAME_ID = 0x41;

    /**
     * Must be either EMBER_HIGH_RAM_CONCENTRATOR or EMBER_LOW_RAM_CONCENTRATOR. The former
     * is used when the caller has enough memory to store source routes for the whole network. In that
     * case, remote nodes stop sending route records once the concentrator has successfully
     * received one. The latter is used when the concentrator has insufficient RAM to store all
     * outbound source routes. In that case, route records are sent to the concentrator prior to
     * every inbound APS unicast.
     * <p>
     * EZSP type is <i>uint16_t</i> - Java type is {@link int}
     */
    private int concentratorType;

    /**
     * The maximum number of hops the route request will be relayed. A radius of zero is converted to
     * EMBER_MAX_HOPS.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int radius;

    /**
     * Serialiser used to seialise to binary line data
     */
    private EzspSerializer serializer;

    /**
     * Request constructor
     */
    public EzspSendManyToOneRouteRequestRequest() {
        frameId = FRAME_ID;
        serializer = new EzspSerializer();
    }

    /**
     * Must be either EMBER_HIGH_RAM_CONCENTRATOR or EMBER_LOW_RAM_CONCENTRATOR. The former
     * is used when the caller has enough memory to store source routes for the whole network. In that
     * case, remote nodes stop sending route records once the concentrator has successfully
     * received one. The latter is used when the concentrator has insufficient RAM to store all
     * outbound source routes. In that case, route records are sent to the concentrator prior to
     * every inbound APS unicast.
     * <p>
     * EZSP type is <i>uint16_t</i> - Java type is {@link int}
     *
     * @return the current concentratorType as {@link int}
     */
    public int getConcentratorType() {
        return concentratorType;
    }

    /**
     * Must be either EMBER_HIGH_RAM_CONCENTRATOR or EMBER_LOW_RAM_CONCENTRATOR. The former
     * is used when the caller has enough memory to store source routes for the whole network. In that
     * case, remote nodes stop sending route records once the concentrator has successfully
     * received one. The latter is used when the concentrator has insufficient RAM to store all
     * outbound source routes. In that case, route records are sent to the concentrator prior to
     * every inbound APS unicast.
     *
     * @param concentratorType the concentratorType to set as {@link int}
     */
    public void setConcentratorType(int concentratorType) {
        this.concentratorType = concentratorType;
    }

    /**
     * The maximum number of hops the route request will be relayed. A radius of zero is converted to
     * EMBER_MAX_HOPS.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current radius as {@link int}
     */
    public int getRadius() {
        return radius;
    }

    /**
     * The maximum number of hops the route request will be relayed. A radius of zero is converted to
     * EMBER_MAX_HOPS.
     *
     * @param radius the radius to set as {@link int}
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(serializer);

        // Serialize the fields
        serializer.serializeUInt16(concentratorType);
        serializer.serializeUInt8(radius);
        return serializer.getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("EzspSendManyToOneRouteRequestRequest [concentratorType=");
        builder.append(concentratorType);
        builder.append(", radius=");
        builder.append(radius);
        builder.append("]");
        return builder.toString();
    }
}
