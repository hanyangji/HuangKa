package sunwou.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


public class ResultUtil {

	
	private ResponseObject rep;
	
	public static DecimalFormat df = new DecimalFormat("0.00");
	public static Gson gson = new Gson();
	
	public void success(HttpServletResponse response, HttpServletRequest request,String msg) {
		rep=new ResponseObject(true, msg);
		out(response, request);
	}
	
	public ResultUtil push(String key,Object o){
		if(rep==null){
			rep=new ResponseObject(true, "ok");
		}
		rep.push(key, o);
		return this;
	}
	
	public void success(HttpServletResponse response, HttpServletRequest request,String msg,Map<String,Object> params) {
		rep=new ResponseObject(true, msg,params);
		out(response, request);
	}
	
	public void error(HttpServletResponse response, HttpServletRequest request,String msg) {
		rep=new ResponseObject(false, msg);
		out(response, request);
	}



	/**
	 * 异步返回数据
	 * @param response
	 * @param obj
	 */
	public void out(HttpServletResponse response, HttpServletRequest request) {
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
		response.setContentType("text/xml;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			String array = gson.toJson(this.rep);
			System.out.println(array);
			System.out.println("返回结果大小" + df.format((array.getBytes().length) / 1024.00) + "KB");
			out.print(array);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
