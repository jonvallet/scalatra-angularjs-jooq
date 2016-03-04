import com.jonvallet.scalatra.angular._
import com.jonvallet.scalatra.angular.database.{DatabaseContext, Database}
import com.jonvallet.scalatra.angular.rest.TodoResource
import com.mchange.v2.c3p0.ComboPooledDataSource
import org.jooq.SQLDialect
import org.scalatra._
import javax.servlet.ServletContext
import org.flywaydb.core.Flyway

class ScalatraBootstrap extends LifeCycle {
  val cpds = new ComboPooledDataSource

  override def init(context: ServletContext) {
    Database.startup
    val flyway = new Flyway()
    flyway.setDataSource(cpds)
    flyway.migrate()
    context.mount(new MyScalatraServlet, "/info/*")
    context.mount(new TodoResource(new DatabaseContext(cpds.getConnection, SQLDialect.H2)), "/api/todo/*")
  }
  override def destroy(context: ServletContext) {
    cpds.close()
    Database.shutdown
  }
}
