package goods1.controller;

import goods1.model.Goods;
import goods1.repo.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Controller
public class ChangeController {
    @Autowired
    GoodsRepo goodsRepo;

    @GetMapping("/change" )
    public String change(Map<String,Object> model, @RequestParam("id") String id){
        if(id != null){
            List<Goods> result = goodsRepo.findAllById(Integer.valueOf(id));
            model.put("result",result);
        }
        model.put("error", "");
        return "change";
    }

    @PostMapping("/found")
    public String found(Map<String,Object> model, String id){
        return "redirect:/change?id="+id;
    }

    @PostMapping("/change")
    public String change(String id, String name, String price, String description,Map<String,Object> model) {
       goodsRepo.changeGoods(description,Integer.valueOf(id));
        return "redirect:/";
    }
}
