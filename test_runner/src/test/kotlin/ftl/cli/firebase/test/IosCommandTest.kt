package ftl.cli.firebase.test

import com.google.common.truth.Truth
import ftl.test.util.FlankTestRunner
import org.junit.Rule
import org.junit.Test
import org.junit.contrib.java.lang.system.SystemOutRule
import org.junit.runner.RunWith

@RunWith(FlankTestRunner::class)
class IosCommandTest {
    @Rule
    @JvmField
    val systemOutRule: SystemOutRule = SystemOutRule().enableLog().muteForSuccessfulTests()

    @Test
    fun androidCommandPrintsHelp() {
        IosCommand().run()
        val output = systemOutRule.log
        Truth.assertThat(output).startsWith(
            "ios [COMMAND]\n" +
                "Commands:\n" +
                "  run      Run tests on Firebase Test Lab\n" +
                "  refresh  Downloads results for the last Firebase Test Lab run\n" +
                "  doctor   Verifies flank firebase is setup correctly\n"
        )
    }
}
