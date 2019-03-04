package be.objectify.deadbolt.scala.test.controllers.composed

import javax.inject.Inject
import be.objectify.deadbolt.scala.DeadboltActions
import be.objectify.deadbolt.scala.test.security.MyCompositeConstraints
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * @author Steve Chaloner (steve@objectify.be)
  */
class Composite @Inject()(deadbolt: DeadboltActions,
                          compositeConstraints: MyCompositeConstraints, components: ControllerComponents) extends AbstractController(components) {


  def subjectNotPresent =
    deadbolt.Composite(constraint = compositeConstraints.zombieKillerOrNoSubjectPresent())() { authRequest =>
      Future {
               Ok("Content accessible")
             }
                                                                                             }

  def subjectHasPermission =
    deadbolt.Composite(constraint = compositeConstraints.zombieKillerOrNoSubjectPresent())() { authRequest =>
      Future {
               Ok("Content accessible")
             }
                                                                                             }

  def subjectDoesNotHavePermission =
    deadbolt.Composite(constraint = compositeConstraints.zombieKillerOrNoSubjectPresent())() { authRequest =>
      Future {
               Ok("Content accessible")
             }
                                                                                             }

  def hasRoleFooAndDoesNotPassDynamic(meta: String) = deadbolt.Composite(constraint = compositeConstraints.hasRoleFooAndPassesDynamic(Some(meta)))() { authRequest =>
    Future {
             Ok(
               "Content accessible")
           }
                                                                                                                                                     }

  def doesNothaveRoleFooAndPassesDynamic(meta: String) = deadbolt.Composite(constraint = compositeConstraints.hasRoleFooAndPassesDynamic(Some(meta)))() { authRequest =>
    Future {
             Ok(
               "Content accessible")
           }
                                                                                                                                                        }

  def hasRoleFooAndPassesDynamic(meta: String) = deadbolt.Composite(constraint = compositeConstraints.hasRoleFooAndPassesDynamic(Some(meta)))() { authRequest =>
    Future {
             Ok(
               "Content accessible")
           }
                                                                                                                                                }
}
