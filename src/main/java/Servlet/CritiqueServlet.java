package Servlet;

import daoImpl.CritiqueDaoImpl;
import entity.Critique;
import utils.DateUtils;
import utils.StringUtils;
import utils.TokenUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/11
 */
@WebServlet(urlPatterns = "/pages/critique", loadOnStartup = 1)
public class CritiqueServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "critique";
        int critiqueNum = 5;
//数据获取请求数据---------------------------------------------------------------------------
        //评论输入框数据获取
        String name = req.getParameter("name");
        String content = req.getParameter("content");
        //如果获取到了评论人名称和评论内容则认为是添加评论操作,需要验证令牌,防止重复提交
//token数据及表单提交------------------------------------------------------------------------
        //如果session里没有token,则生成一个,通常是第一次访问时需要,此后session内都会保存着一个token,每次表单成功更新,token也会更新
        String sessionToken = (String)req.getSession().getAttribute("token");
        if(sessionToken == null){
            String token = TokenUtils.getToken();  //获得一个token
            //将令牌传入目标页面,作为一个隐藏域数据,注意的是,存储在Session域中,通过el表达式获取session域中的token
            req.getSession().setAttribute("token",token);
        } else {
            String  jspToken= req.getParameter("token");  //获取表单提交的token
            //System.out.println("获得的隐藏域中token值: " + jspToken);
            //System.out.println("Session域中的token值: " + sessionToken);
            if(jspToken != null){  //只需验证jsp获得的token不为null即可
                if(sessionToken.equals(sessionToken)){     //若两个token相同,则令牌验证通过
                    //System.out.println("令牌验证通过");
                    if(StringUtils.strNotEmptyNotNull(name) && StringUtils.strNotEmptyNotNull(content)){
                        Critique newCritique = new Critique();
                        newCritique.setName(name);
                        newCritique.setContent(content);
                        newCritique.setTime(DateUtils.now());
                        CritiqueDaoImpl.getInstance().addCritique(newCritique);
                        String token = TokenUtils.getToken(); //获得一个令牌
                        //将令牌传入目标页面,作为一个隐藏域数据,注意的是,存储在Session域中,通过el表达式获取session域中的token
                        req.getSession().setAttribute("token",token);
                        //System.out.println("CritiqueAddServlet中最新创建的token: " + token);
                    }
                } else{
                    System.out.println("当前jspToken: "+ jspToken + "当前SessionToken: " + sessionToken +"不要重复提交表单");
                }
            }
        }
//其他页面数据获取------------------------------------------------------------------------------
        //获得页面传入的页码,根据这个页码才能查询对应的评论,如果获取不到传入的currentPage则设为默认值1
        int currentPage = req.getParameter("currentPage")!=null ? Integer.parseInt(req.getParameter("currentPage")) : 1;
        //页码合法性检查
        currentPage = CritiqueDaoImpl.getInstance().checkPaginationLimit(currentPage,critiqueNum);
//评论数据获取----------------------------------------------------------------------------------
        List<Critique> pageCritiqueList = CritiqueDaoImpl.getInstance().queryPageCritiques(currentPage, critiqueNum);
        int totalPage = CritiqueDaoImpl.getInstance().getTotalPage(critiqueNum);
//向request域中传入数据--------------------------------------------------------------------------
        req.setAttribute("currentPage",currentPage);
        req.setAttribute("totalPage",totalPage);
        req.setAttribute("pageCritiqueList",pageCritiqueList);
        req.setAttribute("url",url);
//转发到评论页面---------------------------------------------------------------------------------
        req.getRequestDispatcher("/pages/critique.jsp").forward(req,resp);
        //对于重定向来说,/是指相对于根目录,所有不会有项目名,不写/则是相对于web应用目录
        //resp.sendRedirect("critique.jsp");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
