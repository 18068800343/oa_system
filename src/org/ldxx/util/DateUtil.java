package org.ldxx.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	 // 除法运算默认精度
    private static final int DEF_DIV_SCALE = 10;
    
	public static String getDateStrByPattern(String pattern,Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String string = simpleDateFormat.format(date);
		return string;
	}
	
    /**
     * 精确加法
     */
    public static BigDecimal add(BigDecimal value1, BigDecimal value2) {
        BigDecimal b1 = value1;
        BigDecimal b2 = value2;
        return b1.add(b2);
    }

    /**
     * 精确加法
     */
    public static BigDecimal add(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.add(b2);
    }

    /**
     * 精确减法
     */
    public static BigDecimal sub(BigDecimal value1, BigDecimal value2) {
        BigDecimal b1 = value1;
        BigDecimal b2 =value2;
        return b1.subtract(b2);
    }

    /**
     * 精确减法
     */
    public static BigDecimal sub(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.subtract(b2);
    }

    /**
     * 精确乘法
     */
    public static BigDecimal mul(BigDecimal value1, BigDecimal value2) {
        BigDecimal b1 = value1;
        BigDecimal b2 = value2;
        return b1.multiply(b2);
    }

    /**
     * 精确乘法
     */
    public static BigDecimal mul(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.multiply(b2);
    }

    /**
     * 精确除法 使用默认精度
     */
    public static BigDecimal div(BigDecimal value1, BigDecimal value2) throws IllegalAccessException {
        return div(value1, value2, DEF_DIV_SCALE);
    }

    /**
     * 精确除法 使用默认精度
     */
    public static BigDecimal div(String value1, String value2) throws IllegalAccessException {
        return div(value1, value2, DEF_DIV_SCALE);
    }

    /**
     * 精确除法
     * 
     * @param scale
     *            精度
     */
    public static BigDecimal div(BigDecimal value1, BigDecimal value2, int scale) throws IllegalAccessException {
        if (scale < 0) {
            throw new IllegalAccessException("精确度不能小于0");
        }
        BigDecimal b1 = value1;
        BigDecimal b2 = value2;
        // return b1.divide(b2, scale).doubleValue();
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 精确除法
     * 
     * @param scale
     *            精度
     */
    public static BigDecimal div(String value1, String value2, int scale) throws IllegalAccessException {
        if (scale < 0) {
            throw new IllegalAccessException("精确度不能小于0");
        }
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        // return b1.divide(b2, scale).doubleValue();
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 四舍五入
     * 
     * @param scale
     *            小数点后保留几位
     */
    public static BigDecimal round(BigDecimal v, int scale) throws IllegalAccessException {
        return div(v, new BigDecimal(1), scale);
    }

    /**
     * 四舍五入
     * 
     * @param scale
     *            小数点后保留几位
     */
    public static BigDecimal round(String v, int scale) throws IllegalAccessException {
        return div(v, "1", scale);
    }

    /**
     * 比较大小
     */
    public static boolean equalTo(BigDecimal b1, BigDecimal b2) {
        if (b1 == null || b2 == null) {
            return false;
        }
        return 0 == b1.compareTo(b2);
    }
    
    
	public static void main(String[] args) {
		
	}
}
