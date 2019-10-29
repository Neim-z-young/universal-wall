package com.freeLearn.wall.util;

import org.springframework.stereotype.Component;

/**
 * ip地址转化工具
 * Create by oyoungy on 2019/10/28
 */
@Component
public class IPAddressUtil {

    private final long IPV4_MASK = 0b1_0000_0000_0000_0000_0000_0000_0000_0000L;
    private final long IPV4_BITS_MASK = 0b11111111;
    private final int IPV4_LEN = 4;
    private final int IPV4_BIT = 8;

    /**
     * 将String型的ip地址转化为Long型
     * @param ipAddress
     * @return
     */
    public Long ipString2Long(String ipAddress){
        String[] ipAddresses = ipAddress.split("\\.");
        long address = 0;
        if(ipAddresses.length==IPV4_LEN){
            for(int i=0; i<IPV4_LEN; i++){
                address<<=IPV4_BIT;
                address|=Long.parseLong(ipAddresses[i]);
            }
        }
        return address;
    }

    /**
     * 将Long型的ip地址转化为String型
     * @param ipAddress
     * @return
     */
    public String ipLong2String(Long ipAddress){
        StringBuilder sb = new StringBuilder();
        long temp = ipAddress;
        if((ipAddress&IPV4_MASK)==0){
            String ss[] = new String[IPV4_LEN];
            for(int i=IPV4_LEN-1; i>=0; i--){
                long t = temp&IPV4_BITS_MASK;
                ss[i] = Long.toString(t);
                temp>>=IPV4_BIT;
            }
            for (int i=0; i<ss.length; i++){
                sb.append(ss[i]);
                if(i!=IPV4_LEN-1){
                    sb.append('.');
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IPAddressUtil ipAddressUtil = new IPAddressUtil();
        System.out.println(ipAddressUtil.ipString2Long("192.168.33.123"));
        System.out.println(Long.toBinaryString(3232244091L));
        System.out.println(ipAddressUtil.ipLong2String(3232244091L));
    }
}
