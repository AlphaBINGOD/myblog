package listener; /**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/10
 */

import daoImpl.ArticleDaoImpl;
import entity.Article;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.List;

@WebListener()
public class StartListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public StartListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {

    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
