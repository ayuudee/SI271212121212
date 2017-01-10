import cats._
import cats.data.{Kleisli, XorT}
import cats.implicits._
import scala.concurrent.{ExecutionContext, Future}


object Example {

  import ExecutionContext.Implicits.global

  trait Error
  trait In
  type Result[E, A] = XorT[Future, E, A]

  // --------------------------------------------------------------------------
  // Without type-alias. This compiles.

  type ErrorResult[A] = Result[Error, A]
  type KleisliNoTA[A] = Kleisli[ErrorResult, In, A]
  implicitly[Applicative[KleisliNoTA]]

  // --------------------------------------------------------------------------
  // With type-alias. This does not compile.

  type KleisliTA[E, A, R] = Kleisli[({ type l[o] = Result[E, o] })#l, R, A]
  type Foo[A] = KleisliTA[Error, A, In]
  implicitly[Applicative[Foo]]

}
