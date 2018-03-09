package sunwou.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;



public class TimeUtil {
	
	
	public static boolean isBelong(String statr,String end) throws ParseException {
		SimpleDateFormat simpledf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now=simpledf.parse(simpledf.format(new Date()));
		Date st=simpledf.parse(statr);
		Date en=simpledf.parse(end);
		return now.getTime() >= st.getTime() && now.getTime() <= en.getTime();
	}
	
	/**
	 * 2周之后的时间
	 * @param week
	 * @return
	 */
    public static String getTimeByHour(int week) {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.WEEK_OF_MONTH, calendar.get(Calendar.WEEK_OF_MONTH) + week);

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

    }

	
	
	/**
	 * 返回两个string类型日期之间相差的天数
	 * @param endTime
	 * @return
	 */
	public static int daysBetween2(String endTime) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = sdf.format(new Date());
        Calendar cal = Calendar.getInstance();    
        long time1 = 0;
        long time2 = 0;
        try{
             cal.setTime(sdf.parse(nowDate));   
             time1 = cal.getTimeInMillis();    
             cal.setTime(sdf.parse(endTime)); 
             time2 = cal.getTimeInMillis();  
        }catch(Exception e){
            e.printStackTrace();
        }
        long between_days=(time1-time2)/(1000*3600);
        System.out.println("between_days:"+between_days);
            
       return Integer.parseInt(String.valueOf(between_days));     
    }
	/**
	 * 判断当天是否是生日
	 * @param birthday 个人的生日
	 * @return
	 */
	public static boolean checkBirthday(String birthday){
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		StringBuilder stringBuilder = new StringBuilder("");
	 	String[] d = birthday.split("-");
	 	stringBuilder.append(d[1]);
	 	String[] f = d[2].split(" ");
	 	stringBuilder.append(f[0]);
	 	String bString = stringBuilder.toString();
	 	String cString = sdf.format(new Date());
		if(bString.equals(cString)){
		    return true;
		}else{
		    return false;
		}
	}

	
	/**
	 * 获取本月的第一天  
	 * @return
	 */
	public static String getFirstOfThisMonth(){
		Calendar cale = Calendar.getInstance();  
        cale.add(Calendar.MONTH, 0);  
        cale.set(Calendar.DAY_OF_MONTH, 1);  
        return new SimpleDateFormat("yyyy-MM-dd").format(cale.getTime()); 
	}
	
	/**
	 * 获取本月的最后一天  
	 * @return
	 */
	public static String getLastOfThisMonth(){
		Calendar cale = Calendar.getInstance();  
        cale.add(Calendar.MONTH, 1);  
        cale.set(Calendar.DAY_OF_MONTH, 0);  
        return new SimpleDateFormat("yyyy-MM-dd").format(cale.getTime()); 
	}
	
	
	/**
	  * 得到本周周一
	  * 
	  * @return yyyy-MM-dd
	  */
	 public static String getMondayOfThisWeek() {
	  Calendar c = Calendar.getInstance();
	  int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
	  if (day_of_week == 0)
	   day_of_week = 7;
	  c.add(Calendar.DATE, -day_of_week + 1);
	  return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());
	 }
	 

	 
	 /**
	  * 得到本周周日
	  * 
	  * @return yyyy-MM-dd
	  */
	 public static String getSundayOfThisWeek() {
	  Calendar c = Calendar.getInstance();
	  int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
	  if (day_of_week == 0)
	   day_of_week = 7;
	  c.add(Calendar.DATE, -day_of_week + 7);
	  return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());
	 }
	 
	 
	 public static String getMonthOfFirst(){
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		 Calendar c = Calendar.getInstance();    
	        c.add(Calendar.MONTH, 0);
	        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
	        String first = format.format(c.getTime());
	       return first;
	 }
	 
	 public static String getMonthOfFirst2(){
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		 Calendar c = Calendar.getInstance();    
	        c.add(Calendar.MONTH, -1);
	        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
	        String first = format.format(c.getTime());
	       return first;
	 }
	 
	 public static String getMonthOfLast(){
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
	     Calendar ca = Calendar.getInstance();    
	        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
	        String last = format.format(ca.getTime());
	        return last;
	 }
	 public static String getMonthOfLast2(){
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		   Calendar calendar2 = Calendar.getInstance();
	        calendar2.set(Calendar.DAY_OF_MONTH, 0);
	        String lastDay = format.format(calendar2.getTime());
	        return lastDay;
	 }
	
	
	/**
     * 获取当前日期是星期几<br>
     * 
     * @param dt
     * @return 当前日期是星期几
     */
    public static int getWeekOfDate(Date dt) {
        Integer[] weekDays = {7,1,2,3,4,5,6};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    
    
//    public static String pinkbox(List<Orders> rs) throws ParseException{
//    	
//    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    	SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
//    	for(int i=0;i<rs.size();i++)
//    	{
//    		if(rs.get(i).getType()==Result.SUCCESS)
//    		{
//    			String time=rs.get(i).getTime();
//    			long st=sdf.parse(time).getTime();
//    			long now=System.currentTimeMillis();
//    			long cha=now-st;
//    			long rstime=(24*60*60*1000)-cha;
//    			if(rstime>0)
//    			{
//    				rs.get(i).setTime(sdf2.format(new Date(rstime)));
//    			}
//    			else
//    			{
//    				rs.get(i).setTime("0");
//    			}
//    		}
//    	}
//    	return "";
//    }
    /**
     * 将数组里面的时间转化
     * @param list
     */
    //将时间转换的方法
/*    public static void settime(List<Article> list){
    	SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	for(int i=0;i<list.size();i++)
    	{
    		try {
    			long now=new Date().getTime();
				long fb=sf.parse(list.get(i).getTime()).getTime();
				long cha=now-fb;
				double c=(double) (cha/1000);
				if(c<60)
				{
					list.get(i).setTime(c+"秒前");
				}else
				{
					c=(c/60)/60;
					if(c<24&&c>1)
					{
						list.get(i).setTime((int)c+"小时前");
					}else if(c>=24)
					{
						int day=(int) (c/24);
						list.get(i).setTime((int)++day+"天前");
					}else if(c<1&&c>0){
						int m=(int) (c*60);
						list.get(i).setTime(++m+"分钟前");				
					}
					
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	}
    	
    }*/
	
	 /**
	  * 生成随机颜色值
	  * @return
	  */
	  public static String getRandColorCode(){  
    	  String r,g,b;  
    	  Random random = new Random();  
    	  r = Integer.toHexString(random.nextInt(256)).toUpperCase();  
    	  g = Integer.toHexString(random.nextInt(256)).toUpperCase();  
    	  b = Integer.toHexString(random.nextInt(256)).toUpperCase();  
    	     
    	  r = r.length()==1 ? "0" + r : r ;  
    	  g = g.length()==1 ? "0" + g : g ;  
    	  b = b.length()==1 ? "0" + b : b ;  
    	     
    	  return r+g+b;  
    	 }
	/** 
	* 获得指定日期的前一天 
	* @param specifiedDay 
	* @return 
	* @throws Exception 
	*/ 
	public static String getSpecifiedDayBefore(String specifiedDay){ 
	//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	Calendar c = Calendar.getInstance(); 
	Date date=null; 
	try { 
	date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay); 
	} catch (ParseException e) { 
	e.printStackTrace(); 
	} 
	c.setTime(date); 
	int day=c.get(Calendar.DATE); 
	c.set(Calendar.DATE,day-1); 

	String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
	return dayBefore; 
	} 
	/** 
	* 获得指定日期的后一天 
	* @param specifiedDay 
	* @return 
	*/ 
	public static String getSpecifiedDayAfter(String specifiedDay){ 
	Calendar c = Calendar.getInstance(); 
	Date date=null; 
	try { 
	date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay); 
	} catch (ParseException e) { 
	e.printStackTrace(); 
	} 
	c.setTime(date); 
	int day=c.get(Calendar.DATE); 
	c.set(Calendar.DATE,day+1); 

	String dayAfter=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
	return dayAfter; 
	} 

}
