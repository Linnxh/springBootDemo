package com.immoc.demo.web;

import com.immoc.demo.entity.Area;
import com.immoc.demo.service.AreaService;
import org.apache.ibatis.annotations.Arg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    private Map<String, Object> listArea() {
        Map<String, Object> map = new HashMap<>();
        List<Area> areas = areaService.queryArea();
        map.put("areas", areas);
        return map;
    }

    @RequestMapping(value = "querareabyid", method = RequestMethod.GET)
    private Map<String, Object> querAreaById(Integer areaId) {
        Map<String, Object> map = new HashMap<>();
        Area areas = areaService.querAreaById(areaId);
        map.put("areas", areas);
        return map;
    }

    @RequestMapping(value = "insertarea", method = RequestMethod.POST)
    private Map<String, Object> insertArea(@RequestBody Area area) {
        Map<String, Object> map = new HashMap<>();
        int i = areaService.insertArea(area);
        map.put("success", i == 1 ? true : false);
        return map;
    }

    @RequestMapping(value = "updatearea", method = RequestMethod.POST)
    private Map<String, Object> updateArea(@RequestBody Area area) {
        Map<String, Object> map = new HashMap<>();
        int i = areaService.updateArea(area);
        map.put("success", i == 1 ? true : false);
        return map;
    }

    @RequestMapping(value = "deletearea", method = RequestMethod.GET)
    private Map<String, Object> deleteArea(Integer areaId) {
        Map<String, Object> map = new HashMap<>();
        Area area = new Area();
        area.setAreaId(areaId);
        int i = areaService.deleteArea(area);
        map.put("success", i == 1 ? true : false);
        return map;
    }

}
