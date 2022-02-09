package ru.eexxyyq.taskmanager.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component
import ru.eexxyyq.taskmanager.log
import java.util.*


@Aspect
@Component
class AspectLogger {

    @Before(value = "execution(* ru.eexxyyq.taskmanager.controller.*.*(..))")
    fun beforeLogRest(joinPoint: JoinPoint) {
        println(
            "Выполнился метод:" + joinPoint.target.javaClass.simpleName.toString() + " "
                    + joinPoint.signature.name
        )
        val args: String = joinPoint.args
            .filter(Objects::nonNull)
            .joinToString(",") { obj: Any -> obj.toString() }
        joinPoint.log("Входящие параметры: ")
        args.log("args: ")
    }

    @AfterReturning(pointcut = "execution(* ru.eexxyyq.taskmanager.controller.*.*(..))", returning = "ret")
    private fun afterLogRest(ret: Any) {
        ret.log("Возвращаемое значение: ")
    }
}