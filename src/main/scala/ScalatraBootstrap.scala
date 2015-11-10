import com.jonvallet.scalatra.angular._
import com.jonvallet.scalatra.angular.database.DatabaseInit
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle with DatabaseInit {
  override def init(context: ServletContext) {
    startup
    context.mount(new MyScalatraServlet, "/*")
  }
  override def destroy(context: ServletContext) {
    shutdown
  }
}
