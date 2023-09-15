package com.example.demo.controller;

import com.example.demo.entity.CharacterFrequency;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class FrequencyController {

    @PostMapping("/api/frequency")
    public ResponseEntity<List<CharacterFrequency>> calculateFrequency(@RequestBody String input) {
        Map<Character, Integer> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));

        List<CharacterFrequency> frequencyList = frequencyMap.entrySet().stream()
                .map(entry -> new CharacterFrequency(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(CharacterFrequency::getCount).reversed())
                .collect(Collectors.toList());

        return new ResponseEntity<>(frequencyList, HttpStatus.OK);
    }
}