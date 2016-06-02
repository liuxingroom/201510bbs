package cn.xing.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodeFilter implements Filter{
	private FilterConfig config = null;
	private ServletContext context = null; 
	private String encode=null;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
		this.context = filterConfig.getServletContext();
		this.encode=context.getInitParameter("encode")==null ? "utf-8" :context.getInitParameter("encode");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//--response响应乱码解决
		response.setCharacterEncoding(encode);
		
		response.setContentType("text/html;charset="+encode);
		//--利用装饰设计模式改变request对象和获取请求参数相关的方法，从而解决请求参数乱码的问题
		chain.doFilter(new MyHttpServletRequest((HttpServletRequest)request), response);
	}

	@Override
	public void destroy() {
		
		
	}
	class MyHttpServletRequest extends HttpServletRequestWrapper{

		private HttpServletRequest request=null;
		private boolean isNotEncode=true;
		public MyHttpServletRequest(HttpServletRequest request) {
			super(request);
			this.request=request;
			
		}
		
		@Override
		public Map<String, String[]> getParameterMap() {
			try {//判断是否是post提交
				if(request.getMethod().equalsIgnoreCase("post")){
					request.setCharacterEncoding(encode);
					return request.getParameterMap();
					//判断是否是get提交
				}else if(request.getMethod().equalsIgnoreCase("get")){
					Map<String,String[]> map=request.getParameterMap();
					if(isNotEncode){
						for(Map.Entry<String, String[]> entry:map.entrySet()){
							String[] vs=entry.getValue();
							for(int i=0;i<vs.length;i++){
								vs[i]=new String(vs[i].getBytes("iso8859-1"),encode);
							}
						}
						isNotEncode=false;
					}
					return map;
					
				}else{
					return request.getParameterMap();
				}
				}catch(Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			
		}

		@Override
		public String[] getParameterValues(String name) {
			
			return getParameterMap().get(name);
		}
		
		@Override
		public String getParameter(String name) {
			
			return getParameterValues(name)==null ? null :getParameterValues(name)[0];
		}

		
		
		
	}
}
