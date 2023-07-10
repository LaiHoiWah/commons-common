package com.meowu.commons.common.commons.utils;

public class VersionUtils{

    private VersionUtils(){
        throw new IllegalStateException("Instantiation is not allowed");
    }

    public static int compare(String version, String compareTo){
        AssertUtils.isNotBlank(version, "Version must not be null");
        AssertUtils.isNotBlank(compareTo, "Version compare to must not be null");

        if(version.equals(compareTo)){
            return 0;
        }

        String[] versionArrays   = version.split("\\.");
        String[] compareToArrays = compareTo.split("\\.");

        int minLength = Math.min(versionArrays.length, compareToArrays.length);

        for(int i = 0; i < minLength; i++){
            String versionBit   = versionArrays[i];
            String compareToBit = compareToArrays[i];

            int compare = versionBit.compareTo(compareToBit);

            if(compare < 0){
                return -1;
            }else if(compare > 0){
                return 1;
            }
        }

        return versionArrays.length - compareToArrays.length > 0 ? 1 : -1;
    }

    public static String max(String version1, String version2){
        return compare(version1, version2) >= 0 ? version1 : version2;
    }

    public static String min(String version1, String version2){
        return compare(version1, version2) <= 0 ? version1 : version2;
    }
}
