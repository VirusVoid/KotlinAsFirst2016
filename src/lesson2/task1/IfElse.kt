@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.discriminant
import lesson4.task1.abs
import java.lang.Math.*

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {

return when {
    (age%10==1)&&(age!=111)&&(age!=11) ->"$age год"
    (age!=12)&&(age!=112)&&(age%10==2) ->"$age года"
    (age!=13)&&(age!=113)&&(age%10==3) ->"$age года"
    (age!=14)&&(age!=114)&&(age%10==4) ->"$age года"
    else ->"$age лет"
}
}

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 *
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    val s1 = v1 * t1
    val s2 = v2 * t2
    val s3 = v3 * t3
    val s123 = (s1 + s2 + s3) / 2.0
    if (s123 != 0.0) {

            if (s1 >= s123) return s123 / v1
            if((s1<123)&&(s1!=0.0)) return t1 + (s123 - s1) / v2
            if (s1 + s2 < s123) return t1 + t2 + (s123 - s1 - s2) / v3

    }
    return Double.NaN
}



/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    return if (((kingY == rookY1)||(kingX == rookX1))&&((kingY == rookY2)||(kingX == rookX2))) 3
    else if ((kingX == rookX1)||(kingY == rookY1)&&(kingX != rookX2)&&(kingY != rookY2)) 1
    else if ((kingX == rookX2)||(kingY == rookY2)&&(kingX != rookX1)&&(kingY != rookY1)) 2
    else 0
}
/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    return if (((kingY == rookY) || (kingX == rookX)) && (abs(bishopX - kingX)) != (abs(bishopY - kingY))) 1
    else if (((kingY != rookY) && (kingX != rookX)) && (abs(bishopX - kingX)) == (abs(bishopY - kingY))) 2
    else if (((kingY == rookY) || (kingX == rookX)) && (abs(bishopX - kingX)) == (abs(bishopY - kingY))) 3
    else 0
}


/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int = TODO()
/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
        if ((c>=a)&&(c<=b)&&(d>=b)) return Math.abs(b-c)
        if ((c>=a)&&(d<=b)) return Math.abs(d-c)
        if ((a>=c)&&(a<=d)&&(d<=b)) return Math.abs(d-a)
        if ((a>=c)&&(b<=d)) return Math.abs(b-a)
            else return -1
}