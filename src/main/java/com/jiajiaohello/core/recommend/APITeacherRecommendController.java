package com.jiajiaohello.core.recommend;

import com.jiajiaohello.core.account.model.RecommendType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: bohan
 * Date: 11/21/14
 * Time: 11:49 AM
 */
@RestController
@RequestMapping("/api/recommend/teachers")
public class APITeacherRecommendController {
    @Autowired
    private TeacherRecommendService recommendService;

    @RequestMapping(value = "/{typeId}")
    public List<RecommendItem> index(@PathVariable("typeId") Integer typeId) {
        return recommendService.getRecommendList(RecommendType.getInstance(typeId));
    }

    @RequestMapping(value = "/{typeId}", method = RequestMethod.POST)
    public RecommendItem create(@RequestBody RecommendItem item, @PathVariable("typeId") Integer typeId) {
        recommendService.save(RecommendType.getInstance(typeId), item);
        return item;
    }

    @RequestMapping(value = "/{typeId}/{id}", method = RequestMethod.PUT)
    public RecommendItem update(@RequestBody RecommendItem item, @PathVariable("typeId") Integer typeId) {
        recommendService.update(RecommendType.getInstance(typeId), item);
        return item;
    }

    @RequestMapping(value = "/{typeId}/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("typeId") Integer typeId, @PathVariable("id") Integer id) {
        recommendService.delete(id);
    }
}
