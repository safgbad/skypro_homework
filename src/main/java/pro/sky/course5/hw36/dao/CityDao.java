package pro.sky.course5.hw36.dao;

import pro.sky.course5.hw36.model.City;

public interface CityDao {

  void create(City city);

  Integer getCityIdByCityName(String cityName);
}
