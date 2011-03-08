package org.desmax

import com.mongodb.casbah.MongoConnection
import org.joda.time.DateTime

import org.scalatest.junit.AssertionsForJUnit
import com.mongodb.casbah.commons.conversions.scala.{RegisterJodaTimeConversionHelpers}
import org.junit.{Test, After}

import org.desmax.domain.BlogPost
import org.desmax.repository.impl.CasbahRepository
import java.text.SimpleDateFormat
import java.util.Date

class CasbahRepositoryTest extends AssertionsForJUnit {

  val mongoColl = MongoConnection()("codemotion")("test_data")
  val repo = new CasbahRepository
  //val testTime = new Date(2011, 3, 5, 9, 0, 0, 0)
  val testTime = new Date
  /*  val config = new TypedActorConfiguration
val repo = TypedActor.newInstance(classOf[BlogRepository], classOf[CasbahRepository],config)*/


  //DeRegisterJodaTimeConversionHelpers()

  @After
  def cleanDb() {
    mongoColl.drop
  }


  @Test
  def testCreate() {
    val post = BlogPost("attesa", "blsabla", testTime)
    assert(repo.create(post))
  }

  @Test
  def testRemove() {
    val post = BlogPost("attesa", "blsabla", testTime)
    assert(repo.create(post))
    val postFromDb = repo.readByTitle("attesa")
    assert(post.date.equals(postFromDb.date))
    assert(post.title.equals(postFromDb.title))
    assert(post.content.equals(postFromDb.content))
    assert(repo.remove(post))
  }

  @Test
  def testUpdate() {
    val post = BlogPost("attesa", "blsabla", testTime)
    assert(repo.create(post))
    val updated = BlogPost(post.title, "aiaaaa", testTime)
    assert(repo.update(updated))
    val retrieve = repo.readByTitle(post.title)
    assert(updated.date.equals(retrieve.date))
    assert(updated.title.equals(retrieve.title))
    assert(updated.content.equals(retrieve.content))
  }

  @Test
  def testReadByDate() {
    val post = BlogPost("attesa", "blsabla", testTime)
    assert(repo.create(post))
    val postList: List[BlogPost] = repo.readByDate(testTime)
    assert(postList.size == 1)
    val uniquePost = postList(0);
    assert(post.date.equals(uniquePost.date))
    assert(post.title.equals(uniquePost.title))
    assert(post.content.equals(uniquePost.content))
  }

  @Test
  def testReadByTitle() {
    val post = BlogPost("Big title", "blahblah", testTime)
    assert(repo.create(post))
    val dbPost = repo.readByTitle("Big title")
    assert(dbPost.date.equals(testTime))
    assert(dbPost.content.equals("blahblah"))
    assert(dbPost.title.equals("Big title"))
  }
}