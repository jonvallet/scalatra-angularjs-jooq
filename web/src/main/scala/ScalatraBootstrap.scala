import com.jonvallet.scalatra.angular._
import com.jonvallet.scalatra.angular.database.{DatabaseContext, Database}
import com.jonvallet.scalatra.angular.rest.{RestauranResource, TodoResource}
import com.mchange.v2.c3p0.ComboPooledDataSource
import org.jooq.SQLDialect
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  val cpds = new ComboPooledDataSource

  override def init(context: ServletContext) {
    Database.startup
    context.mount(new MyScalatraServlet, "/info/*")
    context.mount(new TodoResource(new DatabaseContext(cpds.getConnection, SQLDialect.H2)), "/api/todo/*")
    context.mount(new RestauranResource(new DatabaseContext(cpds.getConnection, SQLDialect.H2)), "/api/todo/*")
  }
  override def destroy(context: ServletContext) {
    cpds.close()
    Database.shutdown
  }
}
