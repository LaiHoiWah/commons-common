package com.meowu.commons.common.commons.utils;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.net.*;
import java.util.Enumeration;
import java.util.List;

public class IPUtils{

    private IPUtils(){
        throw new IllegalStateException("Instantiation is not allowed");
    }

    public static String getHostAddress() throws UnknownHostException{
        return InetAddress.getLocalHost().getHostAddress();
    }

    public static String getIpAddress() throws SocketException{
        List<String> ips = findIpAddresses();

        return CollectionUtils.isNotEmpty(ips) ? ips.get(0) : null;
    }

    public static List<String> findIpAddresses() throws SocketException{
        // result list
        List<String> ips = Lists.newArrayList();

        // get network interface list
        Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
        while(networks.hasMoreElements()){
            NetworkInterface network = networks.nextElement();

            if(network != null && !network.isVirtual() && !network.isLoopback() && network.isUp()){
                // get addresses
                Enumeration<InetAddress> addresses = network.getInetAddresses();

                while(addresses.hasMoreElements()){
                    InetAddress ip = addresses.nextElement();

                    if(ip instanceof Inet4Address || ip instanceof Inet6Address){
                        ips.add(ip.getHostAddress());
                    }
                }
            }
        }

        return ips;
    }
}
