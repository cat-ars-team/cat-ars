/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-04-15 09:22:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.page.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class xtgg_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/page/main/../common-inc.jsp", Long.valueOf(1520192829029L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ path + "/";	//设置系统入口
	/* request.setAttribute("webapp", path); */

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("  \t<!-- 设置页面编码 -->\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("    <!-- 访问者将无法脱机浏览 -->\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\" />\r\n");
      out.write("\t<!-- 网页的缓存方式, 每次刷新都重新载入 -->\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\" />\r\n");
      out.write("\t<!-- 用于设定网页的到期时间。一旦网页过期，必须到服务器上重新传输 -->\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\" />\r\n");
      out.write("\t<!-- 引入全局样式 -->\r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("res/css/global.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("res/jQuery/jquery-1.9.1.js\"></script>\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\t/* 公共CSS 实现table隔行换色*/\r\n");
      out.write("\t\ttable .tab-td01 td.tr_odd{ background-color:#C4C4C4;}\r\n");
      out.write("\t\ttable .tab-td01 td.tr_even{ background-color:#A9A9A9;}\r\n");
      out.write("\t</style>\r\n");
      out.write("\t<!-- 覆盖默认设置 -->\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\ttableColor();\r\n");
      out.write("\t    });\r\n");
      out.write("\t    function tableColor(){\r\n");
      out.write("\t    \t$('table tr:odd td').addClass('tr_odd'); //奇数行\r\n");
      out.write("\t        $('table tr:even td').addClass('tr_even'); //偶数行\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("  </head>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>ISF</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(basePath);
      out.write("res/css/bootstrap.css\"> \r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(basePath);
      out.write("res/css/MyGloable.css\">\r\n");
      out.write("<style>\r\n");
      out.write("\tlabel{\r\n");
      out.write("\t\tfont-size:15px;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  <center>\r\n");
      out.write("     <div id=\"cont-xtgg\">\r\n");
      out.write("    \t<div class=\"xt-header\">\r\n");
      out.write("        \t<ul class=\"gdxw\">\r\n");
      out.write("            \t<marquee scrollAmount=5 width=700px  direction=left >\r\n");
      out.write("                    <li class=\"one\"><a href=\"javascript:;\" id=\"showSYDay\">dsfafasdf</a></li>\r\n");
      out.write("            \t</marquee>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"xt-center\">\r\n");
      out.write("        \t<p style=\"text-align: center;vertical-align: middle;margin-top: 130px;margin-left:0px;padding-left: 0px;\">\r\n");
      out.write("\t\t\t\t <label style=\"font-size:32px;color: yellow;font-weight: bold;\">欢迎使用卡特代理商报销平台</label><br/><br/>\r\n");
      out.write("\t\t\t\t<!--<label style=\"font-size:24px;color: yellow;font-weight: bold;\">GCI ISF与Paving活动需分别进入相应版块进行报销</label> -->\r\n");
      out.write("            </p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("     <p  style=\"font-size:15px\">如您在使用平台中遇到任何问题，可发邮件至\t\t\r\n");
      out.write("    \t<a href=\"Mailto:eddy.jin@bintang.com.cn\">eddy.jin@bintang.com.cn</a>\r\n");
      out.write("    \t也可致电010-57077020<br/>\r\n");
      out.write("    \t（服务时间：周一至周五，10:30—13:00，14:00—18:30；周末及法定节假日休息）\r\n");
      out.write("\t</p>\r\n");
      out.write("    </center>\r\n");
      out.write("    \r\n");
      out.write("    <!-- \r\n");
      out.write("    <div class=\"customer-alert\" id=\"isf-modal\">\r\n");
      out.write("    \t<div class=\"c-container\">\r\n");
      out.write("    \t\t<div class=\"btn-line\">\r\n");
      out.write("\t    \t\t<div class=\"confirm\"></div>\r\n");
      out.write("\t    \t\t<div class=\"cancel\"></div>\r\n");
      out.write("    \t\t</div>\r\n");
      out.write("\t\t\t<img src=\"");
      out.print(basePath);
      out.write("res/images/close.jpg\" class=\"close-img\" />\r\n");
      out.write("    \t</div>\r\n");
      out.write("    </div>\r\n");
      out.write("    -->\r\n");
      out.write("    \r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("res/js/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("res/js/common.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("res/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("res/js/MyGloable.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("res/My97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("res/js/rollDatePrompt.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    \t");
      out.write("\r\n");
      out.write("    \tvar ss=\"\";\r\n");
      out.write("    \tif(ss==null || ss==\"\"){\r\n");
      out.write("\t    \twindow.onload=getSYDate;\r\n");
      out.write("    \t}else{\r\n");
      out.write("    \t\twindow.onload=getSYDate_en;\r\n");
      out.write("    \t}\r\n");
      out.write("\r\n");
      out.write("    \tfunction openWinForDownloadTemplate(){\r\n");
      out.write("\t\t\t$('#downLoadTemplateDIV').css('display', 'block');\r\n");
      out.write("        }\r\n");
      out.write("        function closeDIV(divId){\r\n");
      out.write("        \t$('#downLoadTemplateDIV').css('display', 'none');\r\n");
      out.write("        }\r\n");
      out.write("        function downloadTemplate(obj){\r\n");
      out.write("        \tvar url = encodeURI('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${webapp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/sys_checkFile.action?fileName=' + obj);\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : url,\r\n");
      out.write("\t\t\t\ttype : 'post',\r\n");
      out.write("\t\t\t\tcontentType: \"application/x-www-form-urlencoded; charset=utf-8\", \r\n");
      out.write("\t\t\t\tsuccess : function(data){\r\n");
      out.write("\t\t\t\t\tif(data == 0){\r\n");
      out.write("\t\t\t\t\t\talert('您下载的文件不存,请联系管理员!');\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\twindow.location.href = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${webapp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/downloadTemplate.action?fileName=' + obj;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        $('.xt-header').click(function(){\r\n");
      out.write("        \tcustomerAlert({\r\n");
      out.write("        \t\tele: $('#isf-modal'),\r\n");
      out.write("        \t\twidth: 514,\r\n");
      out.write("        \t\theight: 384,\r\n");
      out.write("        \t\tbackground: \"url(");
      out.print(basePath);
      out.write("res/images/alert-bg6.png) no-repeat center center\",\r\n");
      out.write("        \t\tbackgroundSize: '100%',\r\n");
      out.write("        \t\tconfirm: {\r\n");
      out.write("        \t\t\tbackground: \"url(");
      out.print(basePath);
      out.write("res/images/qr.jpg) no-repeat center center\",\r\n");
      out.write("        \t\t\tfun: function () {\r\n");
      out.write("        \t\t\t\talert('您点击了确定');\r\n");
      out.write("        \t\t\t}\r\n");
      out.write("        \t\t},\r\n");
      out.write("        \t\tcancel: {\r\n");
      out.write("        \t\t\tbackground: \"url(");
      out.print(basePath);
      out.write("res/images/qx.jpg) no-repeat center center\",\r\n");
      out.write("        \t\t\tfun: function () {\r\n");
      out.write("\t\t\t\t\t\t// do something\r\n");
      out.write("        \t\t\t}\r\n");
      out.write("        \t\t},\r\n");
      out.write("        \t\tbasePath: '");
      out.print(basePath);
      out.write("'\r\n");
      out.write("        \t})\r\n");
      out.write("        })\r\n");
      out.write("    </script>\r\n");
      out.write("    \r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
