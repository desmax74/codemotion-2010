package org.desmax.event

import org.desmax.domain.BlogPost
import org.joda.time.DateTime

sealed trait BlogEvent

case class create(post: BlogPost) extends BlogEvent
case class readByDate(date: DateTime) extends BlogEvent
case class readByTitle(title: String) extends BlogEvent
case class update(post: BlogPost) extends BlogEvent
case class remove(post: BlogPost) extends BlogEvent