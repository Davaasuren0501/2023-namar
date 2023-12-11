package ch1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FormInitialized_jsp 
    extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory =
          JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(final HttpServletRequest request, 
                          final HttpServletResponse response)
        throws java.io.IOException, ServletException {

    final PageContext pageContext;
    HttpSession session = null;
    final ServletContext application;
    final ServletConfig config;
    JspWriter out = null;
    final Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(
          this, request, response,
      	  null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta charset='utf-8'>\n");
      out.write("    <title>Initialized JSP</title>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <form>\n");
      out.write("      <p>\n");
      out.write("        This is a simple HTML page that "
              + "has a form in it.\n");
      out.write("      <p>\n");
      out.write("        The hobby was received as: <strong>");
      out.write((String) org.apache.jasper.runtime.
          PageContextImpl.proprietaryEvaluate(
            "${param.hobby}", String.class, 
            (PageContext)_jspx_page_context, null, false));
      out.write("</strong>\n");
      out.write("      <p>\n");
      out.write("        Hobby: <input type='text' name='hobby' \n");
      out.write("                                  value='");
      out.write((String) org.apache.jasper.runtime.
          PageContextImpl.proprietaryEvaluate(
              "${param.hobby}", String.class, 
              (PageContext)_jspx_page_context, null, false));
      out.write("'>\n");
      out.write("        <input type='submit' name='confirmButton' \n");
      out.write("                             value='Confirm'>\n");
      out.write("    </form>\n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } 
          catch (java.io.IOException e) {}
        if (_jspx_page_context != null) 
            _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
