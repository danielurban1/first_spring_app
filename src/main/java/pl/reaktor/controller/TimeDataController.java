package pl.reaktor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
 
import pl.reaktor.data.TimeDataRepository;
import pl.reaktor.model.TimeData;
 
@Controller
public class TimeDataController {
 
    private TimeDataRepository timeDataRepository;
 
    @Autowired
    public TimeDataController(TimeDataRepository timeDataRepository) {
        this.timeDataRepository = timeDataRepository;
    }
 
    @PostMapping("/save")
    public String saveTime(@ModelAttribute TimeData timeData) {
        timeDataRepository.save(timeData);
        return "redirect:/";
    }
 
    @GetMapping("/show")
    public String showAll(Model model) {
        List<TimeData> allTimes = timeDataRepository.findAll();
        model.addAttribute("allTimes", allTimes);
        return "showall";
    }
}