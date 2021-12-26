package com.CovidShark.Controller;

import com.CovidShark.BaseUser;
import com.CovidShark.VisitedRoom;
import com.CovidShark.service.RoomHistoryService;
import com.CovidShark.service.UserSignupService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

public class RoomHistoryController {

    @GetMapping("/getRoomHistoryDetails")
    public VisitedRoom getSeatDetails(@RequestHeader VisitedRoom room)throws InterruptedException, ExecutionException {

        return RoomHistoryService.getRoomDetails(room);
    }

    @PostMapping("/createRoomHistory")
    public String saveRoomDetails(@RequestBody VisitedRoom room)throws InterruptedException, ExecutionException{
        return RoomHistoryService.saveRoomDetails(room);
    }

    @PutMapping("/updateRoomHistory")
    public String updateRoomDetails(@RequestBody VisitedRoom room ) throws ExecutionException, InterruptedException {
        return RoomHistoryService.updateRoomDetails(room);
    }

    @DeleteMapping("/deleteRoomHistory")
    public String deleteRoomHistory(@RequestHeader String roomName)throws InterruptedException, ExecutionException{
        return RoomHistoryService.deleteRoom(roomName);
    }

}
