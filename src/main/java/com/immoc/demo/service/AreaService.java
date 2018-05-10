package com.immoc.demo.service;

import com.immoc.demo.entity.Area;

import java.util.List;

public interface AreaService {

    List<Area> queryArea();

    Area querAreaById(int areaId);

    int insertArea(Area area);

    int updateArea(Area area);

    int deleteArea(Area area);

}
