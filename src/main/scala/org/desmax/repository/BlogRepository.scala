package org.desmax.repository

import org.desmax.domain.BlogPost
import java.util.Date

trait BlogRepository {

  def create(post:BlogPost):Boolean
  def update(post:BlogPost):Boolean
  def remove(post:BlogPost):Boolean
  def readByTitle(title:String) : BlogPost
  def readByDate(date:Date) : List[BlogPost]
}