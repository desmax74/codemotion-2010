package org.desmax.ui

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import sample.SomeClass

import org.desmax.repository.impl.CasbahRepository
import java.util.Date

@Controller
class ScalaFrontController(repo: CasbahRepository) {

  @RequestMapping(Array("/layout"))
  def layout = "/index.scaml"

  @RequestMapping(Array("/hello"))
  def view: ModelAndView = {
    val mav = new ModelAndView("/views/scalate/two.scaml")
    mav.addObject("it", repo.readByDate(new Date))
    return mav
  }

  @RequestMapping(Array("/", "/render"))
  def render = "/index.scaml"

  @RequestMapping(Array("/ciao"))
  def renderTwo = "/views/scalate/two.scaml"

}