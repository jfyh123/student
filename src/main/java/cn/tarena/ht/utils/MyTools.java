package cn.tarena.ht.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map; 
import java.util.Random;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import jxl.Cell;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
public class MyTools {
	
	public static final String REG_HANZI = "^[a-zA-Z\\u4e00-\\u9fa5]+$";//匹配汉字和字母
	public static final String REG_DOUBLE = "^[0-9]+[\\.]?[0-9]*$";//匹配非负浮点数
	public static final String REG_ALLDOUBLE = "^[-]?[0-9]+[\\.]?[0-9]*$";//匹配所有浮点数
	public static final String REG_POSITIVEINT = "^[1-9][0-9]*$";//匹配正整数
	public static final String REG_INT = "^[0-9]+$";//匹配非负整数
	public static final String REG_ALLINT = "^[-]?[0-9]+$";//匹配所有整数
	public static final String REG_MULTIINT = "^[0-9,]+$";//匹配多个非负整数

	public static final String REG_PHONENUMBER = "^[1][3,4,5,7,8][0-9]{9}$";//匹配内地手机号
	public static final String REG_HONGKONGPHONENUMBER = "^[5,6,9][0-9]{7}$";//匹配香港手机号
	public static final String REG_HONGKONGPHONENUMBER2="^([6|9])\\d{7}$";//匹配香港手机号2
	public static final String REG_EMAIL= "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";//邮箱
	
	
//	public static final String regPassword = "^[0-9_a-zA-Z]{6,18}$";//"密码只能为字母、数字和下划线的组合，长度为6-18位"
	public static final String REG_PASSWORD = "^[0-9a-zA-Z]{6,18}$";//"密码只能为字母、数字，长度6-18位"
//	public static final String REG_PASSWORD2 = "^.*[A-Z].*$";//"密码必须包含至少一个大写字母"

	public static final String PASSWORD_ERROR = "密码只能为字母、数字的组合，长度8-16位，且必须包含至少一个大写字母";
	public static final String PASSWORD_NULL = "密码不能为空";
	
	
	public static final String REG_ACCOUNT = "^[0-9_a-zA-Z]{1,20}$";//"帐号只能为字母、数字和下划线的组合，长度不超过20"
//	public static final String REG_ACCOUNT = "^[0-9_a-zA-Z]+$";//"帐号只能为字母、数字和下划线的组合"

	
	public static final String DATEFORMAT_Y4_MM = "yyyy-MM";
	public static final String DATEFORMAT_Y4_MM_DD = "yyyy-MM-dd";
	public static final String DATEFORMAT_Y2_MM_DD = "yy-MM-dd";
	public static final String DATEFORMAT_Y4_MM_DD_HMS = "yyyy-MM-dd HH:mm:ss";
	public static final String DATEFORMAT_Y4_MM_DD_HM = "yyyy-MM-dd HH:mm";
	public static final String DATEFORMAT_HMS = "HH:mm:ss";
	public static final String DATEFORMAT_HM = "HH:mm";
	public static final String DATEFORMAT_Y4MMDD = "yyyyMMdd";
	public static final String DATEFORMAT_Y4MMDDHMS = "yyyyMMddHHmmss";
	
	
	/**
	 * 保留两位小数，四舍五入
	 * @param rate
	 * @param n
	 * @return
	 */
	public static Double myDoubleSetScale(Double rate,int n){
		return new BigDecimal(rate).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 生成随机字符串（不保证唯一）
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) { //length表示生成字符串的长度  
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	}     
	
	/**
     * 对字符串做解码处理
     * @param s	   需要解码的字符串
     * @param codeStyle    解码所用码表
     * @return    解码失败，返回""。解码成功，返回解码后得到的字符串。
     * @author:    	   ym
     * @date:          2015年10月23日 下午5:56:07
     */
    public static String decode(String s,String codeStyle){
    	String str = "";
    	try{
    		str = URLDecoder.decode(s,codeStyle);
    	}catch(Exception e){
    		e.printStackTrace();
    		str = "";
    	}
    	return str;
    }
    
	/** 
     * 字符串转换成十六进制字符串
     */  
    public static String str2HexStr(String str) {  
        char[] chars = "0123456789ABCDEF".toCharArray();  
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();  
        int bit;  
        for (int i = 0; i < bs.length; i++) {  
            bit = (bs[i] & 0x0f0) >> 4;  
            sb.append(chars[bit]);  
            bit = bs[i] & 0x0f;  
            sb.append(chars[bit]);  
        }  
        return sb.toString();  
    } 
    
    
    /** 
     * byte数组转换成16进制字符串 
     * @param src 
     * @return 
     */  
    public static String bytesToHexString(byte[] src){       
           StringBuilder stringBuilder = new StringBuilder();       
           if (src == null || src.length <= 0) {       
               return null;       
           }       
           for (int i = 0; i < src.length; i++) {       
               int v = src[i] & 0xFF;       
               String hv = Integer.toHexString(v);       
               if (hv.length() < 2) {       
                   stringBuilder.append(0);       
               }       
               stringBuilder.append(hv);       
           }       
           return stringBuilder.toString();       
       }
    
    private static byte charToByte(char c) {  
        return (byte) "0123456789ABCDEF".indexOf(c);  
    }  
    
    public static byte[] hexStringToBytes(String hexString) {  
        if (hexString == null || hexString.equals("")) {  
            return null;  
        }  
        hexString = hexString.toUpperCase();  
        int length = hexString.length() / 2;  
        char[] hexChars = hexString.toCharArray();  
        byte[] d = new byte[length];  
        for (int i = 0; i < length; i++) {  
            int pos = i * 2;  
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));  
        }  
        return d;  
    }  
    
    /**
     * yyMMddHHmm格式的时间字符串，转成timestamp
     * 
     * @param dateStr
     * @return
     */
    public static Timestamp myParseStringToTimestamp(String dateStr,String format){
    	SimpleDateFormat sdfOrd = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    	Date date = null;
    	try {
    		if(!isNullOrEmpty(format))
    			sdfOrd = new SimpleDateFormat(format);
    		if(!isNullOrEmpty(dateStr))
    			date = sdfOrd.parse(dateStr);
    	} catch (ParseException e) {
    		try {
    			sdfOrd = new SimpleDateFormat("yyMMddHHmm");
				date = sdfOrd.parse(dateStr);
			} catch (ParseException e1) {
				e1.printStackTrace();
				return null;
			}
    	}
    	return date!=null ? new Timestamp(date.getTime()) : null;
    }
    
    /**
     * yyyyMMddHHmm格式的时间字符串，转成Date
     * 
     * @param dateStr
     * @return
     */
    public static Date myParseStringToDate(String dateStr,String format){
    	SimpleDateFormat sdfOrd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = null;
    	try {
    		if(!isNullOrEmpty(format))
    			sdfOrd = new SimpleDateFormat(format);
    		if(!isNullOrEmpty(dateStr))
    			date = sdfOrd.parse(dateStr);
    	} catch (ParseException e) {
    		try {
    			sdfOrd = new SimpleDateFormat("yyyyMMddHHmm");
				date = sdfOrd.parse(dateStr);
			} catch (ParseException e1) {
				e1.printStackTrace();
				return null;
			}
    	}
    	return date;
    }
    
    /**
     * 将date类型转成字串
     * 
     * @param date
     * @return
     */
    public static String myParseDateToString(Date date,String formart){
    	String s = "";
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(formart!=null && !"".equals(formart.trim()))
				sdf1 = new SimpleDateFormat(formart);
			if(date!=null)
				s = sdf1.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			s = "";
		}
    	return s;
    }
    
    /**
	 * 判断字符串是否为null或无内容的空字符
	 * 
	 * @param str
	 * @return  是返回true，不是返回false
	 */
	public static boolean isNullOrEmpty(String str){
		return str==null || "".equals(str.trim()) || "null".equals(str.trim());
	}

//	public static boolean isNotNullOrEmpty(String str){
//		return str!=null && !"".equals(str.trim()) && !"null".equals(str.trim());
//	}
	
	/**
	 * 判断字符串是否能强转为正整数
	 * 
	 * @param cmid
	 * @return
	 */
	public static boolean isRegPositiveInt(String str) {
		return !MyTools.isNullOrEmpty(str) && str.matches(REG_POSITIVEINT);
	}
	
	/**
	 * 判断字符串是否为非负整数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isRegInt(String str) {
		return !MyTools.isNullOrEmpty(str) && str.matches(REG_INT);
	}
	
	/**
	 * 判断字符串是否是整数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isRegAllInt(String str) {
		return !MyTools.isNullOrEmpty(str) && str.matches(REG_ALLINT);
	}

	/**
	 * 判断字符串是否是非负浮点数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isRegDouble(String str) {
		return !MyTools.isNullOrEmpty(str) && str.matches(REG_DOUBLE);
	}
	
	/**
	 * 判断字符串是否是浮点数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isRegAllDouble(String str) {
		return !MyTools.isNullOrEmpty(str) && str.matches(REG_ALLDOUBLE);
	}
	
	/**
	 * 判断字符串是否是汉字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isRegHanZi(String str){
		return !MyTools.isNullOrEmpty(str) && str.matches(REG_HANZI);
	}
	
	/**
	 * 判断字符串是否是手机号
	 * @param str
	 * @return
	 */
	public static boolean isRegPhoneNumber(String str){
		if(!MyTools.isNullOrEmpty(str)){
			if(str.matches(REG_PHONENUMBER)||str.matches(REG_HONGKONGPHONENUMBER)){
				return true;
			}
		}
		return false;		
//		return !MyTools.isNullOrEmpty(str) && str.matches(REG_PHONENUMBER);
	}
	public static boolean isRegEmail(String str){
		return !MyTools.isNullOrEmpty(str) && str.matches(REG_EMAIL);
	}
	public static boolean isRegMultiInt(String chbid) {
		return !MyTools.isNullOrEmpty(chbid) && chbid.matches(REG_MULTIINT);
	}
//	public static boolean isNotRegMultiInt(String chbid) {
//		return MyTools.isNullOrEmpty(chbid) || !chbid.matches(regMultiInt);
//	}
	
	/**
	 * 密码匹配
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isRegPassword(String str){
		return !isNullOrEmpty(str) && str.matches(REG_PASSWORD);
//		return !isNullOrEmpty(str) && str.matches(REG_PASSWORD) && str.matches(REG_PASSWORD2);
	}
	
	public static boolean isRegAccount(String str){
		return !isNullOrEmpty(str) && str.matches(REG_ACCOUNT);
	}

	public static boolean isRegHongKongPhoneNumber(String str) {
		return !isNullOrEmpty(str) && str.matches(REG_HONGKONGPHONENUMBER);
	}

	public static Date parseTimestampStrToDate(String signup_cutoff_time){
		return new Date(Long.parseLong(signup_cutoff_time)*1000);
	}

	/**
	 * 日期文件夹
	 * 
	 * @return
	 */
	public static String getDateFolder() {
		return myParseDateToString(new Date(), MyTools.DATEFORMAT_Y4MMDD);
	}

	/**
	 * 获取当前月份的第一天
	 * 
	 * @return
	 */
	public static String getDateStr_FirstDayOfMonth(int year,int month) {
		Calendar cl_st = Calendar.getInstance();
		if(year>0)
			cl_st.set(Calendar.YEAR, year);
		if(month>0)
			cl_st.set(Calendar.MONTH, month-1);
		cl_st.set(Calendar.DAY_OF_MONTH, 1);
		String start_date = MyTools.myParseDateToString(cl_st.getTime(), MyTools.DATEFORMAT_Y4_MM_DD) ;
		return start_date;
	}
	
	/**
	 * 获取当前月份的最后一天
	 * @return
	 */
	public static String getDateStr_LastDayOfMonth(int year,int month) {
		Calendar cl_end = Calendar.getInstance();
		if(year>0)
			cl_end.set(Calendar.YEAR, year);
		if(month>0)
			cl_end.set(Calendar.MONTH, month-1);
		cl_end.set(Calendar.DAY_OF_MONTH, cl_end.getActualMaximum(Calendar.DAY_OF_MONTH));  
		String date_str = MyTools.myParseDateToString(cl_end.getTime(), MyTools.DATEFORMAT_Y4_MM_DD) ;
		
		return date_str;
	}

	public static String myParseTimeStampToStr(String schoolStartTime,String format) {
		try {
			if(MyTools.isNullOrEmpty(format))
				format = "yyyy-MM-dd HH:mm:ss";
			long start_timestamp = new Long(schoolStartTime);
			//Unix时间戳是秒
			Date date = new Date(start_timestamp);//我们要的是毫秒
			
			SimpleDateFormat sdf1 = new SimpleDateFormat(format);
			String time = sdf1.format(date);
			
			return time;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static Date myParseTimeStampToDate(String schoolStartTime) {
		try {
			long start_timestamp = new Long(schoolStartTime);//时间戳是毫秒
			Date date = new Date(start_timestamp);
			
			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static String getNowDateTime() {
		String datetime = myParseDateToString(new Date(), DATEFORMAT_Y4_MM_DD_HMS);
		return datetime;
	}

	public static String getNowDate() {
		String datetime = myParseDateToString(new Date(), DATEFORMAT_Y4_MM_DD);
		return datetime;
	}

	public static String getTomorrow() {
		Calendar cl = Calendar.getInstance();
		cl.setTime(new Date());
		cl.add(Calendar.DAY_OF_YEAR, 1);
		
		String datetime = myParseDateToString(cl.getTime(), DATEFORMAT_Y4_MM_DD);
		return datetime;
	}

	/**
	 * 判断：list不是空吗
	 * 
	 * @param list
	 * @return true：不是空     false：是空
	 */
	public static boolean isNotNullOrEmpty(List<?> list) {
		return (list!=null && list.size()>0) ? true : false;
	}
	
	public static String getFullRequestUrl(HttpServletRequest request){
//		String requestUrl = request.getRequestURL().toString()+"?"+request.getQueryString();
		String requestUrl = "";  

		try {
			Map<String, String[]> params = request.getParameterMap(); 
			if(!params.isEmpty()){
			    for (String key : params.keySet()) {  
			        String[] values = params.get(key);  
			        for (int i = 0; i < values.length; i++) {  
			            String value = values[i];  
			            requestUrl += key + "=" + value + "&";  
			        }  
			    }  
			    
			    // 去掉最后一个空格  
			    if(requestUrl.length()>0)
			    	requestUrl = requestUrl.substring(0, requestUrl.length() - 1); 
			}
			
			return request.getRequestURL().toString()+"?"+requestUrl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return requestUrl;
	}
	
	public static String getFullRequestParameter(HttpServletRequest request){
//		String requestUrl = request.getRequestURL().toString()+"?"+request.getQueryString();
		String requestUrl = "";  
		
		try {
			Map<String, String[]> params = request.getParameterMap(); 
			if(!params.isEmpty()){
				for (String key : params.keySet()) {  
					String[] values = params.get(key);  
					for (int i = 0; i < values.length; i++) {  
						String value = values[i];  
						requestUrl += key + "=" + value + "&";  
					}  
				}  
				
				// 去掉最后一个空格  
				if(requestUrl.length()>0)
					requestUrl = requestUrl.substring(0, requestUrl.length() - 1); 
			}
			
			return requestUrl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return requestUrl;
	}
	
	public static String getParameterWithTrim(HttpServletRequest request, String key) {
		String value = request.getParameter(key);
		if(value!=null)
			value = value.trim();
		return value;
	}
	
	public static String getDateTimeStr(Date updatetime) {
		String updateStr = "未知时间";
		if(updatetime!=null){
			long now = System.currentTimeMillis();//现在
			long update = updatetime.getTime();//最后一次更新时间
			long onehour_before = now-3600*1000;//1小时前
			long oneday_before = now-3600*1000*24;//24小时前
			long twoday_before = now-3600*1000*48;//48小时前
			Calendar calendar = Calendar.getInstance();  
			int currentYear = calendar.get(Calendar.YEAR);  
			calendar.clear();  
			calendar.set(Calendar.YEAR, currentYear);  
			long year_start = calendar.getTime().getTime();//今年的起始时间

			if(update>=onehour_before)//一小时内
				updateStr =myParseDateToString(updatetime, "HH:mm");//"12:00";
			else if(update<onehour_before && update>=oneday_before)//24小时内
				updateStr = (now-update)/(3600*1000)+"小时前";
			else if(update<oneday_before && update>=twoday_before)//48小时内
				updateStr = "昨天";
			else if(update<twoday_before && update>=year_start)//超过48小时
				updateStr = myParseDateToString(updatetime, "yyyy-MM-dd HH:mm:ss");//"11-01";
			else if(update<year_start)//去年或更早
				updateStr = myParseDateToString(updatetime, "yyyy-MM-dd HH:mm:ss");//"16-11-01";
		}
		
		return updateStr;
	}
	
	/**
	 * 深度复制一个对象
	 * 
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")  
    public static <T> T deepCloneObject(T obj) {  
        try {  
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();  
            ObjectOutputStream out = new ObjectOutputStream(byteOut);  
            out.writeObject(obj);  
              
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());   
            ObjectInputStream in =new ObjectInputStream(byteIn);  
              
            return (T)in.readObject();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }

	/**
	 * 得到的结果，周日为第一天，值为1。（1到7）
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekDayByDateTime(Date date) {
		Calendar cl = Calendar.getInstance();
		//一周第一天是否为星期一
		boolean isFirstSunday = (cl.getFirstDayOfWeek() == Calendar.MONDAY); 
		cl.setTime(date);
		//获取周几  
		int weekDay = cl.get(Calendar.DAY_OF_WEEK);  
		//若一周第一天为星期一，则+1  
		if(isFirstSunday){  
		    weekDay = weekDay + 1;  
		    if(weekDay == 8){  
		        weekDay = 1;  
		    }  
		}  
		
		return weekDay;
	}  

	/**
	 * 得到的结果，周日为第一天，值为1。（1到7）
	 * 
	 * @param cl
	 * @return
	 */
	public static int getWeekDayByCalendar(Calendar cl) {
		//一周第一天是否为星期一
		boolean isFirstSunday = (cl.getFirstDayOfWeek() == Calendar.MONDAY); 
		//获取周几  
		int weekDay = cl.get(Calendar.DAY_OF_WEEK);  
		//若一周第一天为星期一，则+1  
		if(isFirstSunday){  
			weekDay = weekDay + 1;  
			if(weekDay == 8){  
				weekDay = 1;  
			}  
		}  
		
		return weekDay;
	}

	
	/**
	 * date1早于date2，返回小于0
	 * date1晚于date2，返回大于0
	 * 相等，返回0
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int myDateCompare(Date date1, Date date2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);
		
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date2);
		
		int cp = c1.compareTo(c2);
		return cp;
	}  


    /**
     * 将一个对象的值赋给另外一个有相同属性的对象
     * @author Xuchao
     * @param source
     * @param dest
     * @throws Exception
     */
    public static void CopyBean(Object source, Object dest) throws Exception {
        // 获取属性
        BeanInfo sourceBean = Introspector.getBeanInfo(source.getClass(),Object.class);
        PropertyDescriptor[] sourceProperty = sourceBean.getPropertyDescriptors();
        BeanInfo destBean = Introspector.getBeanInfo(dest.getClass(),Object.class);
        PropertyDescriptor[] destProperty = destBean.getPropertyDescriptors();
 
        try {
            for (int i = 0; i < sourceProperty.length; i++) {
                
                for (int j = 0; j < destProperty.length; j++) {
                    
                    if (sourceProperty[i].getName().equals(destProperty[j].getName())  && sourceProperty[i].getPropertyType() == destProperty[j].getPropertyType()) {
                        // 调用source的getter方法和dest的setter方法
                        destProperty[j].getWriteMethod().invoke(dest,sourceProperty[i].getReadMethod().invoke(source));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception("属性复制失败:" + e.getMessage());
        }
    }

	/**
	 * 生成麦盟的付款流水号
	 * @return
	 */
	public synchronized static String crateSerialNumber() {

		// 定义一个字符串（A-Z，a-z，0-9）即62位；
		String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		// 由Random生成随机数
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		// 长度为几就循环几次
		for (int i = 0; i < 3; ++i) {
			// 产生0-61的数字
			int number = random.nextInt(62);
			// 将产生的数字通过length次承载到sb中
			sb.append(str.charAt(number));
		}
		// 将承载的字符转换成字符串
		return "MF"+System.currentTimeMillis()+sb.toString().toUpperCase();
	}
	
	 /**
     * 导出Excel
     * @param sheetName sheet名称
     * @param title 标题
     * @param values 内容
     * @param wb HSSFWorkbook对象
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName,String []title,String [][]values, HSSFWorkbook wb){

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //创建内容
        for(int i=0;i<values.length;i++){
            row = sheet.createRow(i + 1);
            for(int j=0;j<values[i].length;j++){
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        return wb;
    }
    




}
