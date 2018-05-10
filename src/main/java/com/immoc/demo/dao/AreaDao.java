package com.immoc.demo.dao;

import com.immoc.demo.entity.Area;

import java.util.List;

public interface AreaDao {
    List<Area> queryArea();

    Area querAreaById(int areaId);

    int insertArea(Area area);

    int updateArea(Area area);

    int deleteArea(Area area);
}
