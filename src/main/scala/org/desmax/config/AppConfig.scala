package org.desmax.config

import org.springframework.context.annotation._
import org.fusesource.scalate.spring.view.ScalateViewResolver
import org.desmax.ui.{ScalaFormController, ScalaFrontController}
import org.desmax.repository.impl.CasbahRepository

class AppConfig {

  @Bean
  def indexController = new ScalaFrontController(repo)

  @Bean
  def formController = new ScalaFormController

  @Bean
  def viewResolver = new ScalateViewResolver

  @Bean
  def repo = new CasbahRepository

}