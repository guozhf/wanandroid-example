package com.zephyr.wanandroid_z

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        println("ddddd")
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testCoroutines1() {
        GlobalScope.launch {
            delay(2000) //  这是一个挂起函数，会挂起2000毫秒
            println("World")
        }
        println("Hello")
        Thread.sleep(3000) // 阻塞线程，保证jvm存活
    }

    @Test
    fun testCoroutines2() {
        runBlocking {
            repeat(10_000) {
                delay(1)
                println(".")
            }
        }
    }

    @Test
    fun testCoroutines3() = runBlocking {
        val job = launch {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancel() // cancels the job
        job.join() // waits for job's completion
        println("main: Now I can quit.")
    }

    @Test
    fun testFlow1() {
        val flow = flow<Int> {
            for (i in 1..3) {
                delay(100)
                emit(i)
            }
        }

        runBlocking {
            // 启动并发的协程以验证主线程并未阻塞
            launch {
                for (k in 1..3) {
                    println("I'm not blocked $k")
                    delay(100)
                }
            }
            // 收集这个流
            flow.collect { value -> println(value) }
        }
    }

}