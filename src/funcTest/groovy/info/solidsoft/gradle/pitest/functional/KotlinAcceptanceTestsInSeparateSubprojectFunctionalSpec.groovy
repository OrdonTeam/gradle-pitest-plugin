package info.solidsoft.gradle.pitest.functional

class KotlinAcceptanceTestsInSeparateSubprojectFunctionalSpec extends AbstractPitestFunctionalSpec {

    def "should mutate production code in another subproject"() {
        given:
            buildFile << """
                apply plugin: 'com.android.library'
                apply plugin: 'pl.droidsonroids.pitest'

                android {
                    buildToolsVersion '25.0.2'
                    compileSdkVersion 25
                    defaultConfig {
                        minSdkVersion 10
                        targetSdkVersion 25
                    }
                }
                buildscript {
                    repositories { mavenCentral() }
                }
                pitest {
                    targetClasses = ['**']
                }
            """
            copyResources("testProjects/kotlin-multiproject", "")
        when:
            def result = runTasksSuccessfully('pitestRelease')
        then:
            result.wasExecuted(':itest:pitestRelease')
            result.getStandardOutput().contains('Generated 2 mutations Killed 2 (100%)')
            result.getStandardOutput().contains('Generated 2 mutations Killed 1 (50%)')
    }
}
