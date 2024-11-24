package anuar.shop_spring.controller;

import anuar.shop_spring.entity.Value;
import anuar.shop_spring.service.ValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ValueController {

    private final ValueService valueService;

    @GetMapping(path = "/values")
    public String showAllValues(Model model) {
        List<Value> values = valueService.getAllValues();
        model.addAttribute("values", values);
        return "values";
    }

    @GetMapping(path = "/value-create")
    public String createValueForm(Value value, Model model) {
        model.addAttribute("value", value);
        return "value-update";
    }

    @PostMapping(path = "/value-create")
    public String createValue(Value value) {
        valueService.saveValue(value);
        return "redirect:/values";
    }

    @GetMapping(path = "/products/value-delete/{id}")
    public String deleteValue(@PathVariable("id") Long id) {
        Long productId = valueService.getValueById(id).getProduct().getId();
        valueService.deleteValueById(id);
        return "redirect:/products/" + productId;
    }

    @GetMapping(path = "/products/value-update/{id}")
    public String updateValueForm(@PathVariable("id") Long id, Model model) {
        Value value = valueService.getValueById(id);
        model.addAttribute("value", value);
        return "value-update";
    }

    @PostMapping(path = "/products/value-update/{id}")
    public String updateValue(@PathVariable("id") Long id, Value value) {
        Long productId = valueService.getValueById(id).getProduct().getId();
        valueService.saveValue(value);
        return "redirect:/products/"+ productId;
    }
}
