package com.iua.museum

import android.app.Application
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
abstract class BaseUnitTest: KoinTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Mock
    protected lateinit var mockAplication: Application

    @Before
    open fun setup() {
        MockitoAnnotations.initMocks(this)
    }
}