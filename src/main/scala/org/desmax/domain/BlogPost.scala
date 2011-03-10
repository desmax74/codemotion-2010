package org.desmax.domain

import org.joda.time.DateTime
import org.desmax.util.BlogPostBean
import java.util.Date

case class BlogPost(title: String, content: String, date: Date) {

  /* auxiliary constructors */
  def this(doc: Map[String, AnyRef]) =
    this (
      doc.get(BlogField.title).getOrElse("No getTitle").toString,
      doc.get(BlogField.content).getOrElse("No Content").toString,
      doc.get(BlogField.date).getOrElse(new DateTime).asInstanceOf[Date]
    )

  def this(bean: BlogPostBean) = this (bean.title, bean.content, new Date())

  /* Utilities*/
  override def toString() : String = {
    new StringBuilder().
      append("Title:").append(this.title).append("\n").
      append("Content:").append(this.content).append("\n").
      append("Date:").append(this.date).append("\n").toString
  }
}

//companion object
object BlogPost {}

object BlogField extends Enumeration {
    val title = Value("title").toString
    val content = Value("content").toString
    val date = Value("date").toString
}