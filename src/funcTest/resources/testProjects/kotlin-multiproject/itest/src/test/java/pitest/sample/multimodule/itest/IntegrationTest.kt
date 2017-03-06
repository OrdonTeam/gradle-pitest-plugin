package pitest.sample.multimodule.itest

import pitest.sample.multimodule.shared.Shared
import org.junit.Test

import org.junit.Assert.assertEquals

class IntegrationTest {

    @Test
    fun shouldGenerateMutationInLocalClass() {
        val result = IntegrationUtil().multiplyBy2(5)
        assertEquals(10, result.toLong())
    }

    @Test
    fun shouldGenerateMutationInSharedClass() {
        val shared = Shared("testname1")
        assertEquals("testname1", shared.getName())
        shared.setName("testname2")
        assertEquals("testname2", shared.getName())
    }
}
