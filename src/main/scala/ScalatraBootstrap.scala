import com.jonvallet.scalatra.angular._
import com.jonvallet.scalatra.angular.database.Database
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    Database.startup
    context.mount(new MyScalatraServlet, "/*")
  }
  override def destroy(context: ServletContext) {
    Database.shutdown
  }
}
