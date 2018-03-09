package sunwou.wxpay;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class WXpayUtil {
	
		  private  final static String appid="wxf439c016bc50b342";//wx750e248ada94beee,wxa75115dccbe8ecec
		  private static final String  url="https://api.mch.weixin.qq.com/pay/unifiedorder";
		  private static final String mch_id="1495164382";
		  private static final String device_info="WEB";
		  private static String nonce_str="";
		  private static final String key="SHAOXINGKEQIAO88shaoxingkeqiao88"; //medusa18058505737medusa180585057
		  private static String sign="";
		  private static final String sign_type="MD5";
		  private static final String attach="皇卡";
		  private static final String fee_type="CNY";
		  private static String spbill_create_ip="";
		  private static String goods_tag="WXG";
		  private static String notify_url="https://www.tongzhuhe.com/HuangCardPingTuan/paySuccess.do";
		  private static String trade_type="JSAPI";
		  private static String limit_pay="no_credit";
		  
	   public static String payrequest(String body,String out_trade_no,String total_fee,String openid,String id,String addr){
		   nonce_str=getUUID();
		   /*String stringSignTemp="appid="+appid+"&body="+body+"&device_info="+device_info+"&mch_id="+mch_id+"&nonce_str="+nonce_str+"&key="+secert;
		   sign=getMD5(stringSignTemp).toUpperCase();*/
		   Map<String , String > params=new HashMap<String, String>();
		   params.put("appid", appid);
		   params.put("mch_id", mch_id);
		   params.put("nonce_str", nonce_str);
		   params.put("body", body);
		   params.put("out_trade_no", out_trade_no);
		   params.put("total_fee", total_fee);
		   params.put("spbill_create_ip",addr);
		   params.put("notify_url", notify_url);
		   params.put("trade_type", trade_type);
		   params.put("openid", openid);
		    params=PayUtil.paraFilter(params);
			String rs1=PayUtil.createLinkString(params);
			String rs2="&key="+key;
			sign=PayUtil.sign(rs1, rs2, "utf-8").toUpperCase();
			  params.put("sign", sign);
			PaymentEntity pay=new PaymentEntity(params);
			 String respXml = MessageUtil.messageToXML(pay);
			  respXml = respXml.replace("__", "_");
			  String result =PayUtil.httpRequest(url, "POST", respXml);
			  Map<String, String> map = new HashMap<String, String>();
		         InputStream in=new ByteArrayInputStream(result.getBytes());  
		        // 读取输入�?
		        SAXReader reader = new SAXReader();
		        reader.setEncoding("GBK");
		        org.dom4j.Document document = null;
				try {
					document = reader.read(in);
				} catch (DocumentException e) {				
					e.printStackTrace();
				}
		        // 得到xml根元�?
		        Element root = document.getRootElement();
		        // 得到根元素的�?有子节点
		        @SuppressWarnings("unchecked")
		        List<Element> elementList = root.elements();
		        for (Element element : elementList) {
		            map.put(element.getName(), element.getText());
		        }
		     // 返回信息
		        String return_code = map.get("return_code");//返回状�?�码
		        String return_msg = map.get("return_msg");//返回信息
		        Gson gson=new Gson();
		        if(return_code=="SUCCESS"||return_code.equals(return_code)){ 
		            // 业务结果 
		            String nonceStr=UUIDHexGenerator.generate(); 
		            map.put("nonceStr", nonceStr); 
		            Long timeStamp= System.currentTimeMillis()/1000; 
		            map.put("time", timeStamp+""); 
		            String stringSignTemp = "appId="+appid+"&nonceStr=" + nonceStr + "&package=prepay_id=" + map.get("prepay_id")+ "&signType=MD5&timeStamp=" + timeStamp; 
		            //再次签名 
		            String paySign=PayUtil.sign(stringSignTemp, "&key=SHAOXINGKEQIAO88shaoxingkeqiao88", "utf-8").toUpperCase(); 
		            map.put("paySign", paySign); 
		            map.put("oid", id); 
		        } 
		        
		        
		    return gson.toJson(map);
	   }
	   
	   /**
	    * 对字符串md5加密
	    *
	    * @param str
	    * @return
	    */
	   public static String getMD5(String str) {
	       try {
	           // 生成�?个MD5加密计算摘要
	           MessageDigest md = MessageDigest.getInstance("MD5");
	           // 计算md5函数
	           md.update(str.getBytes());
	           // digest()�?后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就�?8位的字符
	           // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash�?
	           return new BigInteger(1, md.digest()).toString(16);
	       } catch (Exception e) {
	       }
		return str;
	   }
	   
	   
	   /**  
	     * 生成32位编�?  
	     * @return string  
	     */    
	    public static String getUUID(){    
	        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");    
	        return uuid;    
	    } 
	    
	    
	    

}
