package com.tecno_moviles.museum.list.datasource.repository

import com.tecno_moviles.museum.list.datasource.service.IItemListService
import com.tecno_moviles.museum.list.usecase.ItemListUseCaseModel
import com.tecno_moviles.museum.list.usecase.MuseumItemList
import com.tecno_moviles.museum.list.usecase.toUserModel

class ItemListRepository(private val service: IItemListService): IItemListRepository {

    /**
    override suspend fun callGetAllItems(): ItemListUseCaseModel =
    service.getItemList().toUserModel()
     **/

    override suspend fun callGetAllItems(): ItemListUseCaseModel {
        return ItemListUseCaseModel(mutableListOf<MuseumItemList>(
            MuseumItemList(1, "Malvinas", "Mirage IIICJ", "Esta aeronave (matricula C-709) llegó al país a partir de 1983, provenientes de Israel, donde originalmente operaron en la Fuerza Aérea Israelí bajo la denominación “Shahak” (MIIICJ). La mayoría de estas aeronaves intervinieron en el conflicto o guerra de Yom Kipur, también conocida como guerra del Ramadán o guerra de Octubre. Posteriormente operaron por un tiempo en la X Brigada Aérea con asiento en Rio Gallegos, donde nació el Escuadrón ”Guerreros del Hielo”. Poco tiempo después fueron reemplazados en esta misma Unidad por los aviones que nuestro País había adquirido a la República del Perú en 1982, los MIRAGE-VP. De esta forma todos los MIRAGE III CJ, pasaron a prestar servicios en la IV Brigada Aérea con asiento en MENDOZA, Cuna de la Aviación de CAZA.", "image"),
            MuseumItemList(2, "Malvinas", "Avion Pampa", "introduccion del avion", "image"),
            MuseumItemList(3, "Malvinas", "Avion Pampa", "introduccion del avion", "image"),
            MuseumItemList(4, "Malvinas", "Avion Pampa", "introduccion del avion", "image"),
            MuseumItemList(5, "Malvinas", "Avion Pampa", "introduccion del avion", "image")
        ))
    }

}