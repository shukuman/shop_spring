package anuar.shop_spring.controller;

import anuar.shop_spring.entity.Specification;
import anuar.shop_spring.service.SpecificationService;
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
public class SpecificationController {

    private final SpecificationService specificationService;

    @GetMapping(path = "/specifications")
    public String showAllSpecifications(Model model) {
        List<Specification> specifications = specificationService.getAllSpecifications();
        model.addAttribute("specifications", specifications);
        return "specifications";
    }

    @GetMapping(path = "/specification-create")
    public String createSpecificationForm(Specification specification, Model model) {
        model.addAttribute("specification", specification);
        return "specification-create";
    }

    @PostMapping(path = "/specification-create")
    public String createSpecification(Specification specification) {
        specificationService.saveSpecification(specification);
        return "redirect:/specifications";
    }

    @GetMapping(path = "/specification-delete/{id}")
    public String deleteSpecification(@PathVariable("id") Long id) {
        specificationService.deleteSpecificationById(id);
        return "redirect:/specifications";
    }

    @GetMapping(path = "/specification-update/{id}")
    public String updateSpecificationForm(@PathVariable("id") Long id, Model model) {
        Specification specification = specificationService.getSpecificationById(id);
        model.addAttribute("specification", specification);
        return "specification-update";
    }

    @PostMapping(path = "/specification-update")
    public String updateSpecification(Specification specification) {
        specificationService.saveSpecification(specification);
        return "redirect:/specifications";
    }
}
