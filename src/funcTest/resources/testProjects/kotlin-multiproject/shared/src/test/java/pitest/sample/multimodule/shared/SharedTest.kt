package pitest.sample.multimodule.shared

import org.junit.Test

import org.junit.Assert.assertEquals

class SharedTest {
    @Test
    fun testName() {
        val shared = Shared("testname1")
        assertEquals("testname1", shared.getName())
        shared.setName("testname2")
        assertEquals("testname2", shared.getName())
    }

    @Test
    fun testCallLogger() {
        Shared("P").readProperty()
    }
}
