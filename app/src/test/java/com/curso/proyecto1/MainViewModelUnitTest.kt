package com.curso.proyecto1

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.proyecto1.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value = viewModel.resultado.value?.resul
        Assert.assertEquals(false, value)
    }

    @Test
    fun mainViewModel_CheckMismoValue() = runTest {
        val texto1 = "mama"
        val texto2 = "mama"
        if (texto1 == texto2) {
            launch {
                viewModel.compararTexto(texto1,texto2)
            }
            advanceUntilIdle()
        }
        val value = viewModel.resultado.value?.resul
        Assert.assertEquals(true, value)
    }
    @Test
    fun mainViewModel_CheckDistintoValue() = runTest {
        val texto1 = "mama"
        val texto2 = "papa"
        if (texto1 != texto2) {
            launch {
                viewModel.compararTexto(texto1,texto2)
            }
            advanceUntilIdle()
        }
        val value = viewModel.resultado.value?.resul
        Assert.assertEquals(false, value)
    }
}
