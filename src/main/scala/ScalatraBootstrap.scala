import com.jonvallet.scalatra.angular._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle with DabaseInit {
  override def init(context: ServletContext) {
    context.mount(new MyScalatraServlet, "/*")
  }
}
