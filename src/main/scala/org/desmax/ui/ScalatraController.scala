package org.desmax.ui

import org.scalatra._
import scalate.ScalateSupport

class ScalatraController extends ScalatraServlet with ScalateSupport {

  before {
    contentType = "text/html"
  }

  get("/hello") {
    <html>
      <head>
        <title>Hello!</title>
      </head> <body>
      <h1>Hello {params("name")}!</h1>
    </body>
    </html>
  }

  get("/msgs") {
    <body>
      <form method="POST" action="/msgs">Author: <input type="text" name="author"/>
 Message: <input type="text" name="msg"/>
          <input type="submit"/>
      </form>
    </body>
  }

  get("/") {
    // templateEngine is defined for you by ScalateSupport and can be used to help render your index.scaml getContent.
    templateEngine.layout("/WEB-INF/index.scaml", Map("getContent" -> "Hello World"))
  }

  post("/") {
    // submit/create something
  }

  put("/") {
    // update something
  }

  delete("/") {
    // delete something
  }


  protected def contextPath = request.getContextPath
  //protected def appCtx = WebApplicationContextUtils.getContext(servletContext)

}