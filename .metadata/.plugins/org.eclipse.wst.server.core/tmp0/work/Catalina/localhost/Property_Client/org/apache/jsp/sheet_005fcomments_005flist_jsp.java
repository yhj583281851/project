/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2018-12-07 08:52:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sheet_005fcomments_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

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

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>歌单评论管理</title>\r\n");
      out.write("<meta name=\"description\" content=\"用户列表\">\r\n");
      out.write("    <meta name=\"keywords\" content=\"index\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("    <meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\r\n");
      out.write("    <link href=\"static/bootstrap-3.3.7-dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" href=\"assets/i/favicon.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" href=\"assets/i/app-icon72x72@2x.png\">\r\n");
      out.write("    <meta name=\"apple-mobile-web-app-title\" content=\"Amaze UI\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/amazeui.min.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/admin.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/app.css\">\r\n");
      out.write("    <link href=\"static/bootstrap-3.3.7-dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"static/js/jquery-1.12.4.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"static/bootstrap-3.3.7-dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("            <div class=\"tpl-content-page-title\">\r\n");
      out.write("                \t所有用户\r\n");
      out.write("            </div>\r\n");
      out.write("            <ol class=\"am-breadcrumb\">\r\n");
      out.write("                <li><a href=\"#\" class=\"am-icon-home\">首页</a></li>\r\n");
      out.write("                <li><a href=\"#\">评论</a></li>\r\n");
      out.write("                <li class=\"am-active\">歌单评论</li>\r\n");
      out.write("            </ol>\r\n");
      out.write("            <div class=\"tpl-portlet-components\">\r\n");
      out.write("                <div class=\"portlet-title\">\r\n");
      out.write("                    <div class=\"caption font-green bold\">\r\n");
      out.write("                        <span class=\"am-icon-code\"></span> 歌单评论列表\r\n");
      out.write("                    </div>\r\n");
      out.write("                 \r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"tpl-block\">\r\n");
      out.write("                    <div class=\"am-g\">\r\n");
      out.write("                        <div class=\"am-u-sm-12 am-u-md-6\">\r\n");
      out.write("                            <div class=\"am-btn-toolbar\">\r\n");
      out.write("                                <div class=\"am-btn-group am-btn-group-xs\">\r\n");
      out.write("                                 \r\n");
      out.write("                                    <button id=\"sheet_comments_delete_all_btn\" type=\"button\" class=\"am-btn am-btn-default am-btn-danger\"><span class=\"am-icon-trash-o\"></span> 删除</button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        \r\n");
      out.write("                        \t<!-- 查询按钮 -->\r\n");
      out.write("                        <div class=\"am-u-sm-12 am-u-md-3\">\r\n");
      out.write("                            <div class=\"am-input-group am-input-group-sm\">\r\n");
      out.write("                                <input type=\"text\" placeholder=\"请输入歌单id\" id=\"sheet_comments_select\" class=\"am-form-field\">\r\n");
      out.write("                                <span class=\"am-input-group-btn\">\r\n");
      out.write("            <button id=\"sheet_comments_select_btn\" class=\"am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search\" type=\"button\"></button>\r\n");
      out.write("          </span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"am-g\">\r\n");
      out.write("                        <div class=\"am-u-sm-12\">\r\n");
      out.write("                            <form class=\"am-form\">\r\n");
      out.write("                                <table id=\"sheet_comments_table\" class=\"am-table am-table-striped am-table-hover table-main\">\r\n");
      out.write("                                    <thead>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <th class=\"table-check\">\r\n");
      out.write("                                            <input id=\"check_all\" type=\"checkbox\" class=\"tpl-table-fz-check\"></th>\r\n");
      out.write("                                            <th class=\"table-id\">ID</th>\r\n");
      out.write("                                            <th class=\"table-title\">评论内容</th>\r\n");
      out.write("                                            <th class=\"table-title\">发送者</th>\r\n");
      out.write("                                            <th class=\"table-title\">接受者</th>\r\n");
      out.write("                                            <th class=\"table-title\">评论时间</th>\r\n");
      out.write("                                            <th class=\"table-title\">歌单号</th>\r\n");
      out.write("                                            <th class=\"table-set\">操作</th>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                    </thead>\r\n");
      out.write("                                    <tbody>\r\n");
      out.write("                                       <!-- 在js中循环显示 -->\r\n");
      out.write("                                       \r\n");
      out.write("                                    </tbody>\r\n");
      out.write("                                </table>\r\n");
      out.write("                                \r\n");
      out.write("             \t\t\t\t\t      <!-- 分页 -->\r\n");
      out.write("                                <div class=\"am-cf\">\r\n");
      out.write("                                \t<div id=\"page_nav\" class=\"am-fr\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                \r\n");
      out.write("                                <hr>\r\n");
      out.write("\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"tpl-alert\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- <script src=\"assets/js/jquery.min.js\"></script> -->\r\n");
      out.write("    <!-- <script src=\"assets/js/amazeui2.min.js\"></script> -->\r\n");
      out.write("    <!-- <script src=\"assets/js/app.js\"></script> -->\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <!-- 加载static/js -->\r\n");
      out.write("        <script src=\"static/js/cookie.js\"></script>\r\n");
      out.write("    <script src=\"static/js/sheet_comments_list.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
