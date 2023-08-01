package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ArrayInput;

@RestController
public class ArrayController {
	
	@PostMapping("/ispermuted")
	public boolean arePermutations(@RequestBody ArrayInput input) {
		System.out.println(input);
        List<Character> list1 = input.getList1();
        List<Character> list2 = input.getList2();

        if (list1.size() != list2.size()) {
            return false;
        }

        Map<Character, Integer> countMap1 = countOccurrences(list1);
        Map<Character, Integer> countMap2 = countOccurrences(list2);

        return countMap1.equals(countMap2);
    }

    private Map<Character, Integer> countOccurrences(List<Character> list) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char num : list) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        return countMap;
    }
	

}
