package com.CovidShark.Controller;

import com.CovidShark.SeatingPlan;
import com.CovidShark.VisitedRoom;
import com.CovidShark.service.RoomHistoryService;
import com.CovidShark.service.SeatingPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

import static com.CovidShark.service.RoomHistoryService.getRoomDetails;

public class SeatingPlanController {

    @GetMapping("/getSeatingPLan")
    public SeatingPlan getSeatHistory(@RequestHeader SeatingPlan plan)throws InterruptedException, ExecutionException {

        return SeatingPlanService.getSeatDetails(plan);
    }

    @PostMapping("/createSeatingPlan")
    public String postRoomHistory(@RequestBody SeatingPlan plan )throws InterruptedException, ExecutionException{
        return SeatingPlanService.saveSeatPlan(plan);
    }

    @PutMapping("/updateSeatingPlan")
    public String updateSeatDetails(@RequestBody SeatingPlan plan ) throws ExecutionException, InterruptedException {
        return SeatingPlanService.updateSeatDetails(plan);
    }

    @DeleteMapping("/deleteSeatingPlan")
    public String deleteSeatPlan(@RequestHeader int id)throws InterruptedException, ExecutionException{
        return SeatingPlanService.deleteSeatPlan(id);
    }

}
