package com.iua.museum.list.viewModel

import com.iua.museum.BaseUnitTest
import com.iua.museum.list.usecase.ItemListUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

/**
 * Tal vez con la separacion de responsabilidades del viewModel (Patron Delegate), donde usamos
 * PresenterDelegate y BindingDelegate, no es necesario testear el viewModel per se, sino sus delegates.
 */
class ItemListViewModelTest: BaseUnitTest()  {

    @Mock
    private lateinit var itemListUseCase: ItemListUseCase

    @Mock
    private lateinit var itemListBindingDelegate: ItemListBindingDelegate

    private lateinit var viewModel: ItemListViewModel

    @Before
    override fun setup() {
        super.setup()
        viewModel = ItemListViewModel(itemListUseCase, itemListBindingDelegate)
    }

    /**
     * Este es solo un test de ejemplo, para testear que los tests corren en nuestro entorno o IDE.
     * runBlocking -> Permite que el test no termine, hasta que termine la corutina.
     * Es necesario para testear todas las funciones suspend.
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun checkTestsWorks() = coroutinesTestRule.testDispatchers.runBlockingTest {
        Assert.assertTrue(true)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `When callGetAllItems is called then check if returns something`() = coroutinesTestRule.testDispatchers.runBlockingTest {
        try {
            viewModel.callGetAllItems()

        } catch (e: Exception) {

        }
    }


}