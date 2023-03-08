package com.kk.commons.utils;

import org.apache.commons.lang3.math.NumberUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.List;

/**
 * ComparatorUtil
 *
 * @author juejin
 * @datetime 2023/3/3
 */
public class ComparatorUtil {


    public static boolean compareGt(Object actualValue, String dataFormat, List<String> expectList) {
        String actual = actualValue.toString();
        String expectValue = expectList.get(0);
        switch (dataFormat) {
            case "int":
                Number actualInt = NumberUtils.createNumber(actual);
                Number requiredInt = NumberUtils.createNumber(expectValue);
                return actualInt.intValue() > requiredInt.intValue();
            case "double":
                Number actualDouble = NumberUtils.createNumber(actual);
                Number requiredDouble = NumberUtils.createNumber(expectValue);
                return actualDouble.doubleValue() > requiredDouble.doubleValue();
            case "float":
                Number actualFloat = NumberUtils.createNumber(actual);
                Number requiredFloat = NumberUtils.createNumber(expectValue);
                return actualFloat.floatValue() > requiredFloat.floatValue();
            case "long":
                Number actualLong = NumberUtils.createNumber(actual);
                Number requiredLong = NumberUtils.createNumber(expectValue);
                return actualLong.longValue() > requiredLong.longValue();
            default:
                break;
        }
        return false;
    }

    public static boolean compareGtOrEq(Object actualValue, String dataFormat, List<String> expectList) {
        String actual = actualValue.toString();
        String expectValue = expectList.get(0);
        switch (dataFormat) {
            case "int":
                Number actualInt = NumberUtils.createNumber(actual);
                Number requiredInt = NumberUtils.createNumber(expectValue);
                return actualInt.intValue() >= requiredInt.intValue();
            case "double":
                Number actualDouble = NumberUtils.createNumber(actual);
                Number requiredDouble = NumberUtils.createNumber(expectValue);
                return actualDouble.doubleValue() >= requiredDouble.doubleValue();
            case "float":
                Number actualFloat = NumberUtils.createNumber(actual);
                Number requiredFloat = NumberUtils.createNumber(expectValue);
                return actualFloat.floatValue() >= requiredFloat.floatValue();
            case "long":
                Number actualLong = NumberUtils.createNumber(actual);
                Number requiredLong = NumberUtils.createNumber(expectValue);
                return actualLong.longValue() >= requiredLong.longValue();
            default:
                break;
        }
        return false;
    }

    public static boolean compareLt(Object actualValue, String dataFormat, List<String> expectList) {
        String actual = actualValue.toString();
        String expectValue = expectList.get(0);
        switch (dataFormat) {
            case "int":
                Number actualInt = NumberUtils.createNumber(actual);
                Number requiredInt = NumberUtils.createNumber(expectValue);
                return actualInt.intValue() < requiredInt.intValue();
            case "double":
                Number actualDouble = NumberUtils.createNumber(actual);
                Number requiredDouble = NumberUtils.createNumber(expectValue);
                return actualDouble.doubleValue() < requiredDouble.doubleValue();
            case "float":
                Number actualFloat = NumberUtils.createNumber(actual);
                Number requiredFloat = NumberUtils.createNumber(expectValue);
                return actualFloat.floatValue() < requiredFloat.floatValue();
            case "long":
                Number actualLong = NumberUtils.createNumber(actual);
                Number requiredLong = NumberUtils.createNumber(expectValue);
                return actualLong.longValue() < requiredLong.longValue();
            default:
                break;
        }
        return false;
    }

    public static boolean compareLtOrEq(Object actualValue, String dataFormat, List<String> expectList) {
        String actual = actualValue.toString();
        String expectValue = expectList.get(0);
        switch (dataFormat) {
            case "int":
                Number actualInt = NumberUtils.createNumber(actual);
                Number requiredInt = NumberUtils.createNumber(expectValue);
                return actualInt.intValue() <= requiredInt.intValue();
            case "double":
                Number actualDouble = NumberUtils.createNumber(actual);
                Number requiredDouble = NumberUtils.createNumber(expectValue);
                return actualDouble.doubleValue() <= requiredDouble.doubleValue();
            case "float":
                Number actualFloat = NumberUtils.createNumber(actual);
                Number requiredFloat = NumberUtils.createNumber(expectValue);
                return actualFloat.floatValue() <= requiredFloat.floatValue();
            case "long":
                Number actualLong = NumberUtils.createNumber(actual);
                Number requiredLong = NumberUtils.createNumber(expectValue);
                return actualLong.longValue() <= requiredLong.longValue();
            default:
                break;
        }
        return false;
    }

    public static boolean compareBetween(Object actualValue, String dataFormat, List<String> expectList) {
        String actual = actualValue.toString();
        String expectMinValue = expectList.get(0);
        String expectMaxValue = expectList.get(1);
        Number requiredMin = NumberUtils.createNumber(expectMinValue);
        Number requiredMax = NumberUtils.createNumber(expectMaxValue);
        switch (dataFormat) {
            case "int":
                Number actualInt = NumberUtils.createNumber(actual);
                return actualInt.intValue() <= requiredMax.intValue() && actualInt.intValue() >= requiredMin.intValue();
            case "double":
                Number actualDouble = NumberUtils.createNumber(actual);
                return actualDouble.doubleValue() <= requiredMax.doubleValue() && actualDouble.doubleValue() >= requiredMin.doubleValue();
            case "float":
                Number actualFloat = NumberUtils.createNumber(actual);
                return actualFloat.floatValue() <= requiredMax.floatValue() && actualFloat.floatValue() >= requiredMin.floatValue();
            case "long":
                Number actualLong = NumberUtils.createNumber(actual);
                return actualLong.longValue() <= requiredMax.longValue() && actualLong.longValue() >= requiredMin.longValue();
            case "string":
                int length = actual.length();
                return length <= requiredMax.intValue() && length >= requiredMin.intValue();
            default:
                break;
        }

        return false;
    }

    public static boolean compareImgWidthHeight(Object actualValue, List<String> expectList) {
        String imageUrl = actualValue.toString();
        int width = NumberUtils.createInteger(expectList.get(0));
        int height = NumberUtils.createInteger(expectList.get(1));

        try {
            BufferedImage image = ImageIO.read(new URL(imageUrl).openStream());
            int actualWidth = image.getWidth();
            int actualHeight = image.getHeight();

            return (actualWidth == width && actualHeight == height);

        } catch (Exception e) {
            //
        }

        return false;
    }
}