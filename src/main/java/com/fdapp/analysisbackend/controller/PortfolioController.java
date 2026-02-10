// package com.fdapp.analysisbackend.controller;

// import org.springframework.web.bind.annotation.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import java.util.UUID;
// import java.util.List;

// import com.fdapp.analysisbackend.service.PortfolioAnalyticsService;
// import com.fdapp.analysisbackend.dto.*;


// @RestController
// @RequestMapping("/portfolio")
// public class PortfolioAnalyticsController {

//     @Autowired
//     private PortfolioAnalyticsService service;

//     @GetMapping("/summary/{userId}")
//     public PortfolioSummaryDTO summary(@PathVariable UUID userId) {
//         return service.getSummary(userId);
//     }

//     @GetMapping("/allocation/{userId}")
//     public List<AllocationDTO> allocation(@PathVariable UUID userId) {
//         return service.getAllocation(userId);
//     }

//     @GetMapping("/gains/{userId}")
//     public List<GainLossDTO> gains(@PathVariable UUID userId) {
//         return service.getGains(userId);
//     }
// }

package com.fdapp.analysisbackend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import com.fdapp.analysisbackend.service.PortfolioSummaryService;
import com.fdapp.analysisbackend.service.AllocationService;
import com.fdapp.analysisbackend.service.GainLossService;
import com.fdapp.analysisbackend.dto.PortfolioSummaryDTO;
import com.fdapp.analysisbackend.dto.AllocationDTO;
import com.fdapp.analysisbackend.dto.GainLossDTO;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioSummaryService summaryService;

    @Autowired
    private AllocationService allocationService;

    @Autowired
    private GainLossService gainLossService;

    @GetMapping("/summary/{userId}")
    public PortfolioSummaryDTO getSummary(@PathVariable UUID userId) {
        return summaryService.getSummary(userId);
    }

    @GetMapping("/allocation/{userId}")
    public List<AllocationDTO> getAllocation(@PathVariable UUID userId) {
        return allocationService.getAllocation(userId);
    }

    @GetMapping("/gains/{userId}")
    public List<GainLossDTO> getGains(@PathVariable UUID userId) {
        return gainLossService.getGains(userId);
    }
}
