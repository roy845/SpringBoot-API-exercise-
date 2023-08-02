package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ArrayInput;

@RestController
public class ArrayController {
	
	@PostMapping("/ispermuted")
	public <T> boolean arePermutations(@RequestBody ArrayInput<T> input) {
		
        List<T> list1 = input.getList1();
        List<T> list2 = input.getList2();

        if (list1.size() != list2.size()) {
            return false;
        }

        Map<T, Integer> countMap1 = countOccurrences(list1);
        Map<T, Integer> countMap2 = countOccurrences(list2);

        return countMap1.equals(countMap2);
    }

    private <T> Map<T, Integer> countOccurrences(List<T> list) {
        Map<T, Integer> countMap = new HashMap<>();
        for (T element : list) {
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);
        }
        return countMap;
    }
	

}
