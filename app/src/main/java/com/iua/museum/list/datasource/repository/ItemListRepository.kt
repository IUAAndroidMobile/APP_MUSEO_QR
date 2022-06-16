package com.iua.museum.list.datasource.repository

import com.iua.museum.list.datasource.service.IItemListService
import com.iua.museum.list.usecase.ItemListUseCaseModel
import com.iua.museum.list.usecase.toUserModel

class ItemListRepository(private val service: IItemListService): IItemListRepository {

    @Throws(Exception::class)
    override suspend fun callGetAllItems(): ItemListUseCaseModel = service.getItemList().toUserModel()

    /**override suspend fun callGetAllItems(): ItemListUseCaseModel {
        return ItemListUseCaseModel(mutableListOf<MuseumItemList>(
            MuseumItemList(1, "Malvinas", "Mirage IIICJ", "Esta aeronave (matricula C-709) llegó al país a partir de 1983, provenientes de Israel, donde originalmente operaron en la Fuerza Aérea Israelí bajo la denominación “Shahak” (MIIICJ). La mayoría de estas aeronaves intervinieron en el conflicto o guerra de Yom Kipur, también conocida como guerra del Ramadán o guerra de Octubre. Posteriormente operaron por un tiempo en la X Brigada Aérea con asiento en Rio Gallegos, donde nació el Escuadrón ”Guerreros del Hielo”. Poco tiempo después fueron reemplazados en esta misma Unidad por los aviones que nuestro País había adquirido a la República del Perú en 1982, los MIRAGE-VP. De esta forma todos los MIRAGE III CJ, pasaron a prestar servicios en la IV Brigada Aérea con asiento en MENDOZA, Cuna de la Aviación de CAZA.", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/Dassault_Mirage_IIICJ_%28468968546%29.jpg/1600px-Dassault_Mirage_IIICJ_%28468968546%29.jpg"),
            MuseumItemList(2, "Malvinas", "Avion Pampa", "introduccion del avion", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/IA-63_Pampa_Ejercicio_Integrador_2018.jpg/600px-IA-63_Pampa_Ejercicio_Integrador_2018.jpg"),
            MuseumItemList(3, "Malvinas", "Avion Pampa", "introduccion del avion", "image"),
            MuseumItemList(4, "Malvinas", "Avion Pampa", "introduccion del avion", "image"),
            MuseumItemList(5, "Malvinas", "Avion Pampa", "introduccion del avion", "image"),
            MuseumItemList(6, "Malvinas", "Avion Pampa", "introduccion del avion", "image"),
            MuseumItemList(7, "Malvinas", "Avion Pampa", "introduccion del avion", "image"),
            MuseumItemList(8, "Malvinas", "Avion Pampa", "introduccion del avion", "image"),
            MuseumItemList(9, "Malvinas", "Avion Pampa", "introduccion del avion", "image"),
            MuseumItemList(10, "Malvinas", "Mirage IIICJ", "Esta aeronave (matricula C-709) llegó al país a partir de 1983, provenientes de Israel, donde originalmente operaron en la Fuerza Aérea Israelí bajo la denominación “Shahak” (MIIICJ). La mayoría de estas aeronaves intervinieron en el conflicto o guerra de Yom Kipur, también conocida como guerra del Ramadán o guerra de Octubre. Posteriormente operaron por un tiempo en la X Brigada Aérea con asiento en Rio Gallegos, donde nació el Escuadrón ”Guerreros del Hielo”. Poco tiempo después fueron reemplazados en esta misma Unidad por los aviones que nuestro País había adquirido a la República del Perú en 1982, los MIRAGE-VP. De esta forma todos los MIRAGE III CJ, pasaron a prestar servicios en la IV Brigada Aérea con asiento en MENDOZA, Cuna de la Aviación de CAZA.", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/Dassault_Mirage_IIICJ_%28468968546%29.jpg/1600px-Dassault_Mirage_IIICJ_%28468968546%29.jpg"),
            ))
    }**/

}