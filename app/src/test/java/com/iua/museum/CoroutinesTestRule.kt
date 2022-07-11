package com.iua.museum

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

// https://www.youtube.com/watch?v=kqX0WT_k0-o

class CoroutinesTestRule: TestWatcher() {

    val testDispatchers = TestCoroutineDispatcher()

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDispatchers)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
        testDispatchers.cleanupTestCoroutines()
    }
}