package goods1.controller;

import goods1.model.Goods;
import goods1.repo.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class FindController {
    @Autowired
    GoodsRepo goodsRepo;

    @GetMapping("/find")
    public String find(Map<String,Object> model){
        return "find";
    }

    @PostMapping("/search")
    public String search(String value, Map<String,Object> model) {
        List<Goods> goods = goodsRepo.findAllByName(value);
        model.put("goods", goods);
        return "find";
    }
}
