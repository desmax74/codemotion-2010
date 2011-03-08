package org.desmax.repository.impl

import scala.collection.mutable.ListBuffer
import com.mongodb.casbah.commons.{MongoDBObject}
import org.desmax.repository.BlogRepository
import org.desmax.domain.{BlogField, BlogPost}
import com.mongodb.casbah.MongoConnection
import com.novus.salat._
import com.novus.salat.global._
import java.util.Date
import com.mongodb.casbah.Imports._ //important don't remove it like idea suggests !

class CasbahRepository extends BlogRepository {

  val mongoColl = MongoConnection("localhost",27017)("codemotion")("test_data")

  def remove(post: BlogPost):Boolean = {
    val writeResult = mongoColl.remove(grater[BlogPost].asDBObject(post))
    writeResult.getField("ok").equals(1.0)
  }

  def create(post: BlogPost):Boolean = {
    val writeResult = mongoColl.insert(grater[BlogPost].asDBObject(post))
    writeResult.getField("ok").equals(1.0)
  }

  def update(post: BlogPost):Boolean = {
    // change only the content
    val query = MongoDBObject(BlogField.title -> post.title, BlogField.date -> post.date)
    val obj = grater[BlogPost].asDBObject(post)
    val writeResult = mongoColl.update(query, obj, true, false) //upsert
    writeResult.getField("ok").equals(1.0)
  }

  def readByDate(date: Date): List[BlogPost] = {
    val query = MongoDBObject(BlogField.date -> date)
    val list = new ListBuffer[BlogPost]
    mongoColl.find(query).foreach(o => list += grater[BlogPost].asObject(o))
    list.toList
  }

  def readByTitle(title: String):BlogPost = {
    val query = MongoDBObject(BlogField.title -> title)
    val obj = mongoColl.findOne(query).get
    grater[BlogPost].asObject(obj)
  }
}