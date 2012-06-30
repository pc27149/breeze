package breeze.linalg

import org.scalatest._
import org.scalatest.junit._
import org.scalatest.prop._
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class CSCMatrixTest extends FunSuite with Checkers {
  test("Multiply") {
    val a = CSCMatrix((1., 2., 3.),(4., 5., 6.))
    val b = CSCMatrix((7., -2., 8.),(-3., -3., 1.),(12., 0., 5.))
    val c = DenseVector(6.,2.,3.)
//    assert(a * b === DenseMatrix((37., -8., 25.), (85., -23., 67.)))
    assert(a * c === DenseVector(19.,52.))
    assert(b * c === DenseVector(62., -21., 87.))
//    assert(b.t * c === DenseVector(72., -18., 65.))
//    assert(a.t * DenseVector(4., 3.) === DenseVector(16., 23., 30.))

    // should be dense
//    val x = a * a.t
//    assert(x === DenseMatrix((14.,32.),(32.,77.)))

    // should be dense
//    val y = a.t * a
//    assert(y === DenseMatrix((17.,22.,27.),(22.,29.,36.),(27.,36.,45.)))

//    val z : DenseMatrix[Double] = b * (b + 1.0)
//    assert(z === DenseMatrix((164.,5.,107.),(-5.,10.,-27.),(161.,-7.,138.)))
  }

  test("Multiply Int") {
    val a = CSCMatrix((1, 2, 3),(4, 5, 6))
    val b = CSCMatrix((7, -2, 8),(-3, -3, 1),(12, 0, 5))
    val c = DenseVector(6,2,3)
//    assert(a * b === DenseMatrix((37, -8, 25), (85, -23, 67)))
    assert(a * c === DenseVector(19,52))
    assert(b * c === DenseVector(62, -21, 87))
//    assert(b.t * c === DenseVector(72, -18, 65))
//    assert(a.t * DenseVector(4, 3) === DenseVector(16, 23, 30))

    // should be dense
//    val x = a * a.t
//    assert(x === DenseMatrix((14,32),(32,77)))

    // should be dense
//    val y = a.t * a
//    assert(y === DenseMatrix((17,22,27),(22,29,36),(27,36,45)))

//    val z : DenseMatrix[Double] = b * (b + 1.0)
//    assert(z === DenseMatrix((164,5,107),(-5,10,-27),(161,-7,138)))
  }


  test("Generic CSC ops") {
    // mostly for coverage
    val a = CSCMatrix[String](1,1)(Array("SSS"))
    intercept[IndexOutOfBoundsException] {
      a(3,3) = ":("
      assert(false, "Shouldn't be here!")
    }
    assert(a(0,0) === "SSS")
    intercept[IndexOutOfBoundsException] {
      a(3,3)
      assert(false, "Shouldn't be here!")
    }
    a(0,0) = ":("
    assert(a(0,0) === ":(")


  }
}

